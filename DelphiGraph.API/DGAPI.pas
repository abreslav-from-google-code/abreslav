unit DGAPI;

interface

uses
  Graphics;

procedure Sleep(ms : Cardinal);

var
  HaltOnWindowClose : Boolean = true;

procedure InitGraph(Width, Height : Integer);
procedure CloseGraph;
procedure WaitForGraph;

function KeyPressed : Boolean;
function CharPressed : Boolean;
function ReadKey : Word;
function ReadChar : Char;

function MousePressed : Boolean;
function GetMouseX : Integer;
function GetMouseY : Integer;

procedure FreezeScreen;
procedure UnFreezeScreen;

procedure ClrScr;
procedure Rectangle(x1, y1, x2, y2 : Integer);
procedure Ellipse(x1, y1, x2, y2 : Integer);
procedure RoundRect(x1, y1, x2, y2, a, b : Integer);
procedure MoveTo(x, y : Integer);
procedure LineTo(x, y : Integer);

procedure SetBrushColor(c : TColor);

implementation

uses
  Windows, Messages, Classes, Syncobjs, Contnrs;

var
  wndClass : TWndClassEx;
  hWnd: THandle = 0;
  eventThread : THandle = 0;
  bufferBMP : HBITMAP = 0;
  buffer : HDC = 0;
  freezeBufferBMP : HBITMAP = 0;
  freezeBuffer : HDC = 0;
  WindowRect : TRect;
  WindowWidth : Integer = -1;
  WindowHeight : Integer = -1;
  cs : TCriticalSection = nil;
  event : TEvent = nil;
  keyPressEvent : TEvent = nil;
  Frozen : Boolean = false;
  ks : TKeyboardState;
  KeyQueue : TObjectQueue;
  IsLButtonDown : Boolean = false;
  MouseX : Integer = 0;
  MouseY : Integer = 0;

type
  TKeyEvent = class
  private
    myVirtualKey : Word;
    myShiftState : TShiftState;
    myChar : Char;
    myIsChar : Boolean;
  public
    function GetChar : Char;
    function GetVirtualKey : Word;
    function GetShiftState : TShiftState;
    function isChar : Boolean;
    constructor Create(vk : Word; c : Char; ic : Boolean; shift : TShiftState);
  end;

{ TKeyEvent }

constructor TKeyEvent.Create(vk: Word; c : Char; ic : Boolean; shift: TShiftState);
begin
  myVirtualKey := vk;
  myChar := c;
  myShiftState := shift;
  myIsChar := ic;
end;

function TKeyEvent.GetChar: Char;
begin
  Result := myChar;
end;

function TKeyEvent.GetShiftState: TShiftState;
begin
  Result := myShiftState;
end;

function TKeyEvent.GetVirtualKey: Word;
begin
  Result := myVirtualKey;
end;

function TKeyEvent.isChar: Boolean;
begin
  Result := myIsChar;
end;

function WindowProc(wnd: THandle; msg: Integer; wparam: WPARAM; lparam: LPARAM) : LRESULT; stdcall;
var
  dc : HDC;
  ps : PAINTSTRUCT;
  c : array[1..2] of Char;
  Shift : TShiftState;
  r : Integer;
begin
  Result := 0;
  case msg of
    WM_DESTROY: begin
      PostQuitMessage(0);
      if HaltOnWindowClose then
        Halt(0)
      else
        Exit;
    end;
    WM_PAINT: begin
        dc := BeginPaint(hWnd, ps);
        Assert(dc <> 0);
        try
          Assert(buffer <> 0);
          cs.Enter;
          if not Frozen then
            BitBlt(dc, 0, 0, WindowWidth, WindowHeight, buffer, 0, 0, SRCCOPY)
          else
            BitBlt(dc, 0, 0, WindowWidth, WindowHeight, freezeBuffer, 0, 0, SRCCOPY);
        finally
          cs.Leave;
  //        event.SetEvent;
          EndPaint(hWnd, ps);
        end;
    end;
    WM_LBUTTONDOWN:
      IsLButtonDown := true;
    WM_LBUTTONUP:
      IsLButtonDown := false;
    WM_MOUSEMOVE: begin
      MouseX := LoWord(lParam);
      MouseY := HiWord(lParam);
    end;
    WM_KEYDOWN: begin
      if GetKeyState(VK_SHIFT) < 0 then
        ks[VK_SHIFT] := $FF
      else ks[VK_SHIFT] := 0;
      if GetKeyState(VK_CONTROL) < 0 then
        ks[VK_CONTROL] := $FF
      else ks[VK_CONTROL] := 0;
      r := ToAscii(wParam, lParam shr 16, ks, @c, 0);

      KeyQueue.Push(TKeyEvent.Create(wParam, c[1], r <> 0, Shift));
      keyPressEvent.SetEvent;
    end;
    else
      Result := DefWindowProc(wnd, msg, wparam, lparam);
  end;
end;

const
  CLASS_NAME = 'DelphiGraph.API.MainWindow';

procedure CreateWindow;
var
  msg : tagMsg;
  hDC : Windows.HDC;
begin
  wndClass.cbSize := sizeof(wndClass);
  wndClass.style := 0;
  wndClass.lpfnWndProc := @WindowProc;
  wndClass.cbClsExtra := 0;
  wndClass.cbWndExtra := 0;
  wndClass.hInstance := HInstance;
  wndClass.hIcon := LoadIcon(0, IDI_APPLICATION);
  wndClass.hCursor := LoadCursor(0, IDC_ARROW);
  wndClass.hbrBackground := GetStockObject(WHITE_BRUSH);
  wndClass.lpszMenuName := nil;
  wndClass.lpszClassName := CLASS_NAME;
  RegisterClassEx(wndClass);
  hWnd := CreateWindowEx(
    0, // style
    CLASS_NAME,
    'Graphical Mode Emulation',
    WS_CAPTION or WS_SYSMENU or WS_DLGFRAME,
    Integer(CW_USEDEFAULT), 0, WindowWidth, WindowHeight, // size
    0, 0,
    HInstance,
    nil);
  ShowWindow(hWnd, SW_SHOW);

  WindowRect := Rect(0, 0, WindowWidth + 1, WindowHeight + 1);

  hDC := GetDC(hWnd);
  try
    Assert(hDC <> 0);
    bufferBMP := CreateCompatibleBitmap(hDC, WindowWidth, WindowHeight);
    Assert(bufferBMP <> 0);
    buffer := CreateCompatibleDC(hDC);
    Assert(buffer <> 0);
    SelectObject(buffer, bufferBMP);
    Windows.FillRect(buffer, WindowRect, GetStockObject(WHITE_BRUSH));

    freezeBufferBMP := CreateCompatibleBitmap(hDC, WindowWidth, WindowHeight);
    Assert(freezeBufferBMP <> 0);
    freezeBuffer := CreateCompatibleDC(hDC);
    Assert(freezeBuffer <> 0);
    SelectObject(freezeBuffer, freezeBufferBMP);

  finally
    ReleaseDC(hWnd, hDC);
  end;

  event.SetEvent;

  while GetMessage(msg, 0, 0, 0) do begin
    TranslateMessage(msg);
    DispatchMessage(msg);
  end;
end;

function ThreadProc(param : Pointer) : Integer;
begin
  Frozen := false;
  KeyQueue := TObjectQueue.Create;

  CreateWindow;

  KeyQueue.Free;
  KeyQueue := nil;
  DestroyWindow(hWnd);
  hWnd := 0;
  DeleteDC(buffer);
  buffer := 0;
  DeleteObject(bufferBMP);
  bufferBMP := 0;

  DeleteDC(freezeBuffer);
  freezeBuffer := 0;
  DeleteObject(freezeBufferBMP);
  freezeBufferBMP := 0;

  Result := 0;
end;

///////////////////////////////////////////////////////////////////////////////

procedure Sleep(ms : Cardinal);
begin
  Windows.Sleep(ms);
end;

procedure InitGraph(Width, Height : Integer);
var
  id : Cardinal;
begin
  if eventThread <> 0 then
    Exit;
  WindowWidth := Width;
  WindowHeight := Height;
  eventThread := BeginThread(nil, 0, @ThreadProc, nil, 0, id);
  event.WaitFor(1000);
end;

procedure CloseGraph;
begin
  SendMessage(hWnd, WM_DESTROY, 0, 0);
end;

procedure WaitForGraph;
begin
  WaitForSingleObject(eventThread, INFINITE);
end;

///////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////
function KeyPressed : Boolean;
begin
  Result := KeyQueue.Count > 0;
end;

function CharPressed : Boolean;
begin
  Result := KeyPressed and TKeyEvent(KeyQueue.Peek).isChar;
end;

procedure WaitForKey;
begin
  while keyPressEvent.WaitFor(INFINITE) = wrTimeout do;
  keyPressEvent.ResetEvent;
end;

function ReadChar : Char;
begin
  while not CharPressed do begin
    WaitForKey;
    if not CharPressed then begin
      KeyQueue.Pop;
    end;
  end;
  Result := TKeyEvent(KeyQueue.Pop).GetChar;
end;

function ReadKey : Word;
begin
  WaitForKey;
  Result := TKeyEvent(KeyQueue.Pop).GetVirtualKey;
end;

///////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////

function MousePressed : Boolean;
begin
  Result := IsLButtonDown;
end;

function GetMouseX : Integer;
begin
  Result := MouseX;
end;

function GetMouseY : Integer;
begin
  Result := MouseY;
end;

///////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////

procedure Repaint;
begin
  if not Frozen then
    InvalidateRect(hWnd, nil, false);
end;

procedure FreezeScreen;
begin
  cs.Enter;
  BitBlt(freezeBuffer, 0, 0, WindowWidth, WindowHeight, buffer, 0, 0, SRCCOPY);
  Frozen := true;
  cs.Leave;
end;

procedure UnFreezeScreen;
begin
  cs.Enter;
  Frozen := false;
  cs.Leave;
  Repaint;
end;

procedure ClrScr;
begin
  Assert(buffer <> 0);
  cs.Enter;
  try
    Windows.FillRect(buffer, WindowRect, GetCurrentObject(buffer, OBJ_BRUSH));
  finally
    cs.Leave;
  end;
  Repaint;
end;

procedure Rectangle(x1, y1, x2, y2 : Integer);
begin
  Assert(buffer <> 0);
  cs.Enter;
  try
    Windows.Rectangle(buffer, x1, y1, x2, y2);
  finally
    cs.Leave;
  end;
  Repaint;
end;

procedure Ellipse(x1, y1, x2, y2 : Integer);
begin
  Assert(buffer <> 0);
  cs.Enter;
  try
    Windows.Ellipse(buffer, x1, y1, x2, y2);
  finally
    cs.Leave;
  end;
  Repaint;
end;

procedure RoundRect(x1, y1, x2, y2, a, b : Integer);
begin
  Assert(buffer <> 0);
  cs.Enter;
  try
    Windows.RoundRect(buffer, x1, y1, x2, y2, a, b);
  finally
    cs.Leave;
  end;
  Repaint;
end;

procedure MoveTo(x, y : Integer);
begin
end;
procedure LineTo(x, y : Integer);
begin
end;

procedure SetBrushColor(c : TColor);
var
  oldBrush : HBRUSH;
begin
  oldBrush := SelectObject(buffer, CreateSolidBrush(c));
  DeleteObject(oldBrush);
end;

begin
  cs := TCriticalSection.Create;
  event := TEvent.Create(nil, true, false, 'DelphiGraphWindowInitialized');
  keyPressEvent := TEvent.Create(nil, true, false, 'DelphiGraphKeyPressed');
end.
