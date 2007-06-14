unit DelphiGraph;

interface

uses
  Windows, Graphics, SysUtils;

type
  TPenStyle = Graphics.TPenStyle;
const
  psSolid = Graphics.psSolid;
  psDash = Graphics.psDash;
  psDot = Graphics.psDot;
  psDashDot = Graphics.psDashDot;
  psDashDotDot = Graphics.psDashDotDot;
  psClear = Graphics.psClear;
  psInsideFrame = Graphics.psInsideFrame;

type
  TPenMode = Graphics.TPenMode;
const
  pmBlack = Graphics.pmBlack;
  pmWhite = Graphics.pmWhite;
  pmNop = Graphics.pmNop;
  pmNot = Graphics.pmNot;
  pmCopy = Graphics.pmCopy;
  pmNotCopy = Graphics.pmNotCopy;
  pmMergePenNot = Graphics.pmMergePenNot;
  pmMaskPenNot = Graphics.pmMaskPenNot;
  pmMergeNotPen = Graphics.pmMergeNotPen;
  pmMaskNotPen = Graphics.pmMaskNotPen;
  pmMerge = Graphics.pmMerge;
  pmNotMerge = Graphics.pmNotMerge;
  pmMask = Graphics.pmMask;
  pmNotMask = Graphics.pmNotMask;
  pmXor = Graphics.pmXor;
  pmNotXor = Graphics.pmNotXor;
  
type
  TBrushStyle = Graphics.TBrushStyle;
const
  bsSolid = Graphics.bsSolid;
  bsClear = Graphics.bsClear;
  bsHorizontal = Graphics.bsHorizontal;
  bsVertical = Graphics.bsVertical;
  bsFDiagonal = Graphics.bsFDiagonal;
  bsBDiagonal = Graphics.bsBDiagonal;
  bsCross = Graphics.bsCross;
  bsDiagCross = Graphics.bsDiagCross;

type
  TFontStyle = Graphics.TFontStyle;
  TFontStyles = Graphics.TFontStyles;
const
  fsBold = Graphics.fsBold;
  fsItalic = Graphics.fsItalic;
  fsUnderline = Graphics.fsUnderline;
  fsStrikeOut = Graphics.fsStrikeOut;
  
type
  TColor = Graphics.TColor;
const
  clBlack = Graphics.clBlack;
  clMaroon = Graphics.clMaroon;
  clGreen = Graphics.clGreen;
  clOlive = Graphics.clOlive;
  clNavy = Graphics.clNavy;
  clPurple = Graphics.clPurple;
  clTeal = Graphics.clTeal;
  clGray = Graphics.clGray;
  clSilver = Graphics.clSilver;
  clRed = Graphics.clRed;
  clLime = Graphics.clLime;
  clYellow = Graphics.clYellow;
  clBlue = Graphics.clBlue;
  clFuchsia = Graphics.clFuchsia;
  clAqua = Graphics.clAqua;
  clLtGray = Graphics.clLtGray;
  clDkGray = Graphics.clDkGray;
  clWhite = Graphics.clWhite;
  clNone = Graphics.clNone;
  clDefault = Graphics.clDefault;

const
  { Virtual Keys, Standard Set }
  VK_LBUTTON = Windows.VK_LBUTTON;
  VK_RBUTTON = Windows.VK_RBUTTON;
  VK_CANCEL = Windows.VK_CANCEL;
  VK_MBUTTON = Windows.VK_MBUTTON;  { NOT contiguous with L & RBUTTON }
  VK_BACK = Windows.VK_BACK;
  VK_TAB = Windows.VK_TAB;
  VK_CLEAR = Windows.VK_CLEAR;
  VK_RETURN = Windows.VK_RETURN;
  VK_SHIFT = Windows.VK_SHIFT;
  VK_CONTROL = Windows.VK_CONTROL;
  VK_MENU = Windows.VK_MENU;
  VK_PAUSE = Windows.VK_PAUSE;
  VK_CAPITAL = Windows.VK_CAPITAL;
  VK_KANA = Windows.VK_KANA;
  VK_HANGUL = Windows.VK_HANGUL;
  VK_JUNJA = Windows.VK_JUNJA;
  VK_FINAL = Windows.VK_FINAL;
  VK_HANJA = Windows.VK_HANJA;
  VK_KANJI = Windows.VK_KANJI;
  VK_CONVERT = Windows.VK_CONVERT;
  VK_NONCONVERT = Windows.VK_NONCONVERT;
  VK_ACCEPT = Windows.VK_ACCEPT;
  VK_MODECHANGE = Windows.VK_MODECHANGE;
  VK_ESCAPE = Windows.VK_ESCAPE;
  VK_SPACE = Windows.VK_SPACE;
  VK_PRIOR = Windows.VK_PRIOR;
  VK_NEXT = Windows.VK_NEXT;
  VK_END = Windows.VK_END;
  VK_HOME = Windows.VK_HOME;
  VK_LEFT = Windows.VK_LEFT;
  VK_UP = Windows.VK_UP;
  VK_RIGHT = Windows.VK_RIGHT;
  VK_DOWN = Windows.VK_DOWN;
  VK_SELECT = Windows.VK_SELECT;
  VK_PRINT = Windows.VK_PRINT;
  VK_EXECUTE = Windows.VK_EXECUTE;
  VK_SNAPSHOT = Windows.VK_SNAPSHOT;
  VK_INSERT = Windows.VK_INSERT;
  VK_DELETE = Windows.VK_DELETE;
  VK_HELP = Windows.VK_HELP;
{ VK_0 thru VK_9 are the same as ASCII '0' thru '9' ($30 - $39) }
{ VK_A thru VK_Z are the same as ASCII 'A' thru 'Z' ($41 - $5A) }
  VK_LWIN = Windows.VK_LWIN;
  VK_RWIN = Windows.VK_RWIN;
  VK_APPS = Windows.VK_APPS;
  VK_NUMPAD0 = Windows.VK_NUMPAD0;
  VK_NUMPAD1 = Windows.VK_NUMPAD1;
  VK_NUMPAD2 = Windows.VK_NUMPAD2;
  VK_NUMPAD3 = Windows.VK_NUMPAD3;
  VK_NUMPAD4 = Windows.VK_NUMPAD4;
  VK_NUMPAD5 = Windows.VK_NUMPAD5;
  VK_NUMPAD6 = Windows.VK_NUMPAD6;
  VK_NUMPAD7 = Windows.VK_NUMPAD7;
  VK_NUMPAD8 = Windows.VK_NUMPAD8;
  VK_NUMPAD9 = Windows.VK_NUMPAD9;
  VK_MULTIPLY = Windows.VK_MULTIPLY;
  VK_ADD = Windows.VK_ADD;
  VK_SEPARATOR = Windows.VK_SEPARATOR;
  VK_SUBTRACT = Windows.VK_SUBTRACT;
  VK_DECIMAL = Windows.VK_DECIMAL;
  VK_DIVIDE = Windows.VK_DIVIDE;
  VK_F1 = Windows.VK_F1;
  VK_F2 = Windows.VK_F2;
  VK_F3 = Windows.VK_F3;
  VK_F4 = Windows.VK_F4;
  VK_F5 = Windows.VK_F5;
  VK_F6 = Windows.VK_F6;
  VK_F7 = Windows.VK_F7;
  VK_F8 = Windows.VK_F8;
  VK_F9 = Windows.VK_F9;
  VK_F10 = Windows.VK_F10;
  VK_F11 = Windows.VK_F11;
  VK_F12 = Windows.VK_F12;
  VK_F13 = Windows.VK_F13;
  VK_F14 = Windows.VK_F14;
  VK_F15 = Windows.VK_F15;
  VK_F16 = Windows.VK_F16;
  VK_F17 = Windows.VK_F17;
  VK_F18 = Windows.VK_F18;
  VK_F19 = Windows.VK_F19;
  VK_F20 = Windows.VK_F20;
  VK_F21 = Windows.VK_F21;
  VK_F22 = Windows.VK_F22;
  VK_F23 = Windows.VK_F23;
  VK_F24 = Windows.VK_F24;
  VK_NUMLOCK = Windows.VK_NUMLOCK;
  VK_SCROLL = Windows.VK_SCROLL;
{ VK_L & VK_R - left and right Alt, Ctrl and Shift virtual keys.
  Used only as parameters to GetAsyncKeyState() and GetKeyState().
  No other API or message will distinguish left and right keys in this way. }
  VK_LSHIFT = Windows.VK_LSHIFT;
  VK_RSHIFT = Windows.VK_RSHIFT;
  VK_LCONTROL = Windows.VK_LCONTROL;
  VK_RCONTROL = Windows.VK_RCONTROL;
  VK_LMENU = Windows.VK_LMENU;
  VK_RMENU = Windows.VK_RMENU;
  VK_PROCESSKEY = Windows.VK_PROCESSKEY;
  VK_ATTN = Windows.VK_ATTN;
  VK_CRSEL = Windows.VK_CRSEL;
  VK_EXSEL = Windows.VK_EXSEL;
  VK_EREOF = Windows.VK_EREOF;
  VK_PLAY = Windows.VK_PLAY;
  VK_ZOOM = Windows.VK_ZOOM;
  VK_NONAME = Windows.VK_NONAME;
  VK_PA1 = Windows.VK_PA1;
  VK_OEM_CLEAR = Windows.VK_OEM_CLEAR;

type
  TPoint = Windows.TPoint;

procedure Sleep(ms : Cardinal);

var
  HaltOnWindowClose : Boolean = true;
  ExceptionHandler : procedure(E : Exception);

procedure DefaultExceptionHandler(E : Exception);

procedure InitGraph(Width, Height : Integer);
procedure CloseGraph;
procedure WaitForGraph;

function GetScreenMaxX : Integer;
function GetScreenMaxY : Integer;
function GetMaxX : Integer;
function GetMaxY : Integer;

procedure SetTitle(const title : String);
function GetTitle : String;

function KeyPressed : Boolean;
function CharPressed : Boolean;
function ReadKey : Word;
function ReadChar : Char;

procedure WaitForMouseEvent;
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
procedure Polygon(points : array of TPoint);

function TextWidth(const Text : String) : Integer;
function TextHeight(const Text : String) : Integer;
procedure TextOut(X, Y : Integer; const S : String);

procedure SetPenColor(c : TColor);
procedure SetPenWidth(w : Integer);
procedure SetPenStyle(s : TPenStyle);
procedure SetGraphicMode(m : TPenMode);

procedure SetBrushColor(c : TColor);
procedure SetBrushStyle(s : TBrushStyle);

procedure SetFontColor(c : TColor);
procedure SetFontSize(s : Integer);
procedure SetFontName(n : String);
procedure SetFontStyle(s : TFontStyles);

function GetPenColor : TColor;
function GetPenWidth : Integer;
function GetPenStyle : TPenStyle;
function GetGraphicMode : TPenMode;

function GetBrushColor : TColor;
function GetBrushStyle : TBrushStyle;

function GetFontColor : TColor;
function GetFontSize : Integer;
function GetFontName : String;
function GetFontStyle : TFontStyles;

procedure SaveScreen;
procedure LoadScreen;

type
  TBuffer = type Integer;

function GetNewBuffer : TBuffer;
procedure DeleteBuffer(var buf : TBuffer);
procedure SaveScreenToBuffer(buf : TBuffer);
procedure LoadScreenFromBuffer(buf : TBuffer);

type
  TPicture = type Integer;

function LoadPicture(fileName : String) : TPicture;
procedure UnLoadPicture(p : TPicture);
procedure DrawPicture(x, y : Integer; p : TPicture);
function GetPictureWidth(p : TPicture) : Integer;
function GetPictureHeight(p : TPicture) : Integer;

implementation

uses
  Messages, Classes, Syncobjs, Contnrs;

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
  mouseEvent : TEvent = nil;
  Frozen : Boolean = false;
  ks : TKeyboardState;
  KeyQueue : TObjectQueue;
  IsLButtonDown : Boolean = false;
  MouseX : Integer = 0;
  MouseY : Integer = 0;
  penWidth : Integer = 1;
  penColor : TColor = clBlack;
  penStyle : TPenStyle = psSolid;
  brushColor : TColor = clWhite;
  brushStyle : TBrushStyle = bsSolid;
  font : TFont = nil;
  graphicMode : TPenMode = pmCopy;
  
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
          EndPaint(hWnd, ps);
        end;
    end;
    WM_LBUTTONDOWN: begin
      IsLButtonDown := true;
      mouseEvent.SetEvent;
    end;
    WM_LBUTTONUP: begin
      IsLButtonDown := false;
      mouseEvent.SetEvent;
    end;
    WM_MOUSEMOVE: begin
      MouseX := LoWord(lParam);
      MouseY := HiWord(lParam);
      mouseEvent.SetEvent;
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

procedure SetClientAreaSize(w, h : Integer);
var
  client, window : TRect;
  diff : TPoint;
begin
  GetClientRect(hWnd, client);
  GetWindowRect(hWnd, window);
  diff.x := (window.Right - window.Left) - client.Right;
  diff.y := (window.Bottom - window.Top) - client.Bottom;
  MoveWindow(hWnd,
    window.Left, window.Top,
    w + diff.x,
    h + diff.y, true);
end;

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
    '�������� ������������ ������',
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

    font.Handle := GetCurrentObject(buffer, OBJ_FONT);
    SetFontName('MS Sans Serif');
    SetFontStyle([]);
    SetFontSize(8);

  finally
    ReleaseDC(hWnd, hDC);
  end;

  SetClientAreaSize(WindowWidth, WindowHeight);
  
  event.SetEvent;

  while GetMessage(msg, 0, 0, 0) do begin
    TranslateMessage(msg);
    DispatchMessage(msg);
  end;
end;

procedure DefaultExceptionHandler(E : Exception);
begin
  WriteLn('-------------------------------------------------------------------');
  WriteLn('Exception in graphics thread: ');
  WriteLn('class: ', E.ClassName, '; message: ', E.Message);
  WriteLn('-------------------------------------------------------------------');
end;

function ThreadProc(param : Pointer) : Integer;
begin
  try
    try
      Frozen := false;
      KeyQueue := TObjectQueue.Create;

      CreateWindow;
    except
      on E : Exception do
        if Assigned(ExceptionHandler) then
          ExceptionHandler(E);
    end;
  finally
    while KeyQueue.Count > 0 do
      KeyQueue.Pop.Free;
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
    eventThread := 0;
  end;
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
  event.ResetEvent;
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

function GetMaxX : Integer;
begin
  Result := WindowWidth;
end;

function GetMaxY : Integer;
begin
  Result := WindowHeight;
end;

function GetScreenMaxX : Integer;
begin
  Result := GetSystemMetrics(SM_CXSCREEN);
end;

function GetScreenMaxY : Integer;
begin
  Result := GetSystemMetrics(SM_CYSCREEN);
end;

procedure SetTitle(const title : String);
begin
  SetWindowText(hWnd, PChar(title));
end;

function GetTitle : String;
begin
  SetLength(Result, GetWindowTextLength(hWnd) + 1);
  GetWindowText(hWnd, PChar(Result), Length(Result));
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
var
  ke : TKeyEvent;
begin
  while not CharPressed do begin
    WaitForKey;
    if not CharPressed then begin
      KeyQueue.Pop.Free;
    end;
  end;
  ke := TKeyEvent(KeyQueue.Pop);
  Result := ke.GetChar;
  ke.Free;
end;

function ReadKey : Word;
var
  ke : TKeyEvent;
begin
  WaitForKey;
  ke := TKeyEvent(KeyQueue.Pop);
  Result := ke.GetVirtualKey;
  ke.Free;
end;

///////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////

procedure WaitForMouseEvent;
begin
  mouseEvent.waitFor(INFINITE);
  mouseEvent.ResetEvent;
end;

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
  try
    BitBlt(freezeBuffer, 0, 0, WindowWidth, WindowHeight, buffer, 0, 0, SRCCOPY);
    Frozen := true;
  finally
    cs.Leave;
  end;
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

procedure Polygon(points : array of TPoint);
begin
  Assert(buffer <> 0);
  cs.Enter;
  try
    Windows.Polygon(buffer, points, High(points) + 1);
  finally
    cs.Leave;
  end;
  Repaint;
end;

procedure MoveTo(x, y : Integer);
begin
  Assert(buffer <> 0);
  cs.Enter;
  try
    Windows.MoveToEx(buffer, x, y, nil);
  finally
    cs.Leave;
  end;
  Repaint;
end;

procedure LineTo(x, y : Integer);
begin
  Assert(buffer <> 0);
  cs.Enter;
  try
    Windows.LineTo(buffer, x, y);
  finally
    cs.Leave;
  end;
  Repaint;
end;

function TextExtent(const Text: string) : TSize;
begin
  Assert(buffer <> 0);
  Result.cX := 0;
  Result.cY := 0;
  cs.Enter;
  try
    Windows.GetTextExtentPoint32(buffer, PChar(Text), Length(Text), Result);
  finally
    cs.Leave;
  end;
end;

function TextWidth(const Text : String) : Integer;
begin
  Result := TextExtent(Text).cX;
end;

function TextHeight(const Text : String) : Integer;
begin
  Result := TextExtent(Text).cY;
end;

procedure TextOut(X, Y : Integer; const S : String);
begin
  Assert(buffer <> 0);
  cs.Enter;
  try
    Windows.TextOut(buffer, X, Y, PChar(S), Length(S));
    Windows.MoveToEx(buffer, X + TextWidth(S), Y, nil);
  finally
    cs.Leave;
  end;
  Repaint;
end;

///////////////////////////////////////////////////////////////////////////////

procedure SelectAndDelete(obj : THandle);
var
  old : THandle;
begin
  Assert(buffer <> 0);
  cs.Enter;
  try
    old := SelectObject(buffer, obj);
    DeleteObject(old);
  finally
    cs.Leave;
  end;
end;

const
  PenStyles: array[TPenStyle] of Word =
    (PS_SOLID, PS_DASH, PS_DOT, PS_DASHDOT, PS_DASHDOTDOT, PS_NULL,
     PS_INSIDEFRAME);
procedure SetPen;
begin
  SelectAndDelete(CreatePen(PenStyles[penStyle], penWidth, penColor));
end;

procedure SetPenColor(c : TColor);
begin
  if c <> penColor then begin
    penColor := c;
    SetPen;
  end;
end;

procedure SetPenWidth(w : Integer);
begin
  if w <> penWidth then begin
    penWidth := w;
    SetPen;
  end;
end;

procedure SetPenStyle(s : TPenStyle);
begin
  if s <> penStyle then begin
    penStyle := s;
    SetPen;
  end;
end;

const
  PenModes: array[TPenMode] of Word =
    (R2_BLACK, R2_WHITE, R2_NOP, R2_NOT, R2_COPYPEN, R2_NOTCOPYPEN, R2_MERGEPENNOT,
     R2_MASKPENNOT, R2_MERGENOTPEN, R2_MASKNOTPEN, R2_MERGEPEN, R2_NOTMERGEPEN,
     R2_MASKPEN, R2_NOTMASKPEN, R2_XORPEN, R2_NOTXORPEN);

procedure SetGraphicMode(m : TPenMode);
begin
  graphicMode := m;
  cs.Enter;
  try
    SetROP2(buffer, PenModes[m]);
  finally
    cs.Leave;
  end;
end;

const
  BrushStyles : array[bsHorizontal..bsDiagCross] of Integer = (
    HS_HORIZONTAL, HS_VERTICAL, HS_FDIAGONAL, HS_BDIAGONAL,
    HS_CROSS, HS_DIAGCROSS
  );

procedure SetBrush;
var
  brush : HBRUSH;
begin
  cs.Enter;
  try
    case brushStyle of
      bsSolid : begin
        SetBkColor(buffer, brushColor);
        SetBkMode(buffer, OPAQUE);
        brush := CreateSolidBrush(brushColor);
      end;
      bsClear : begin
        SetBkMode(buffer, TRANSPARENT);
        brush := GetStockObject(NULL_BRUSH);
      end;
      else begin
        brush := CreateHatchBrush(BrushStyles[brushStyle], brushColor);
        SetBkMode(buffer, TRANSPARENT);
      end;
    end;
  finally
    cs.Leave;
  end;
  SelectAndDelete(brush);
end;

procedure SetBrushColor(c : TColor);
begin
  if c <> brushColor then begin
    brushColor := c;
    if brushStyle = bsClear then
      brushStyle := bsSolid;
    SetBrush;
  end;
end;

procedure SetBrushStyle(s : TBrushStyle);
begin
  if s <> brushStyle then begin
    brushStyle := s;
    SetBrush;
  end;
end;

procedure SetFontColor(c : TColor);
begin
  if c <> font.Color then begin
    font.Color := c;
    cs.Enter;
    try
      SetTextColor(buffer, c);
    finally
      cs.Leave;
    end;
  end;
end;

procedure SetFontSize(s : Integer);
begin
  if s <> font.Size then begin
    font.Size := s;
    SelectAndDelete(font.Handle);
  end;
end;

procedure SetFontName(n : String);
begin
  if n <> font.Name then begin
    font.Name := n;
    SelectAndDelete(font.Handle);
  end;
end;

procedure SetFontStyle(s : TFontStyles);
begin
  if s <> font.Style then begin
    font.Style := s;
    SelectAndDelete(font.Handle);
  end;
end;

////////////////////////////////////////////////////////////////////////////////

function GetPenColor : TColor;
begin
  Result := penColor;
end;

function GetPenWidth : Integer;
begin
  Result := penWidth;
end;

function GetPenStyle : TPenStyle;
begin
  Result := penStyle;
end;

function GetGraphicMode : TPenMode;
begin
  Result := graphicMode;
end;

function GetBrushColor : TColor;
begin
  Result := brushColor;
end;

function GetBrushStyle : TBrushStyle;
begin
  Result := brushStyle;
end;

function GetFontColor : TColor;
begin
  Result := font.Color;
end;

function GetFontSize : Integer;
begin
  Result := font.Size;
end;

function GetFontName : String;
begin
  Result := font.Name;
end;

function GetFontStyle : TFontStyles;
begin
  Result := font.Style;
end;

////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
var
  Buffers : TObjectList;

const
  NIL_BUFFER = -1;

function GetNewBuffer : TBuffer;
begin
  Result := Buffers.Add(Graphics.TBitmap.Create);
end;

procedure DeleteBuffer(var buf : TBuffer);
begin
  Buffers[buf].Free;
  Buffers[buf] := nil;
  buf := NIL_BUFFER;
end;

procedure SaveScreenToBuffer(buf : TBuffer);
begin
  if buf = NIL_BUFFER then begin
     raise Exception.Create('NIL Buffer used');
  end;
  Graphics.TBitmap(Buffers[buf]).Width := WindowWidth;
  Graphics.TBitmap(Buffers[buf]).Height := WindowHeight;
  cs.Enter;
  try
    BitBlt(Graphics.TBitmap(Buffers[buf]).Canvas.Handle, 0, 0, WindowWidth, WindowHeight, buffer, 0, 0, SRCCOPY);
  finally
    cs.Leave;
  end;
end;

procedure LoadScreenFromBuffer(buf : TBuffer);
begin
  if buf = NIL_BUFFER then begin
     raise Exception.Create('NIL Buffer used');
  end;
  cs.Enter;
  try
    BitBlt(buffer, 0, 0, WindowWidth, WindowHeight, Graphics.TBitmap(Buffers[buf]).Canvas.Handle, 0, 0, SRCCOPY);
  finally
    cs.Leave;
  end;
  Repaint;
end;

var
  DefaultSaveBuffer : TBuffer = NIL_BUFFER;

procedure SaveScreen;
begin
  if DefaultSaveBuffer = NIL_BUFFER then
    DefaultSaveBuffer := GetNewBuffer;
  SaveScreenToBuffer(DefaultSaveBuffer);
end;

procedure LoadScreen;
begin
  if DefaultSaveBuffer = NIL_BUFFER then
    SaveScreen;
  LoadScreenFromBuffer(DefaultSaveBuffer);
end;

////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////

var
  Pictures : TObjectList;

function LoadPicture(fileName : String) : TPicture;
var
  bmp : TBitmap;
begin
  bmp := TBitmap.Create;
  bmp.LoadFromFile(fileName);
  Result := Pictures.Add(bmp);
end;

procedure UnLoadPicture(p : TPicture);
begin
  Pictures[p].Free;
  Pictures[p] := nil;
end;

procedure DrawPicture(x, y : Integer; p : TPicture);
var
  picture : TBitmap;
begin
  picture := TBitmap(Pictures[p]);
  cs.Enter;
  try
    BitBlt(buffer, x, y, picture.Width, picture.Height, picture.Canvas.Handle, 0, 0, SRCCOPY);
  finally
    cs.Leave;
  end;
  Repaint;
end;

function GetPictureWidth(p : TPicture) : Integer;
begin
  Result := TBitmap(Pictures[p]).Width;
end;

function GetPictureHeight(p : TPicture) : Integer;
begin
  Result := TBitmap(Pictures[p]).Height;
end;

////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////

procedure ClearListAndFree(l : TObjectList);
var
  i : Integer;
begin
  for i := 0 to l.Count - 1 do begin
    l[i].Free;
    l[i] := nil;
  end;
  l.Free;
end;

initialization
  ExceptionHandler := DefaultExceptionHandler;
  cs := TCriticalSection.Create;
  event := TEvent.Create(nil, true, false, 'DelphiGraphWindowInitialized');
  keyPressEvent := TEvent.Create(nil, true, false, 'DelphiGraphKeyPressed');
  mouseEvent := TEvent.Create(nil, true, false, 'DelphiGraphMouseEvent');
  font := TFont.Create;
  Buffers := TObjectList.Create;
  Pictures := TObjectList.Create;
finalization
  cs.Free;
  event.Free;
  keyPressEvent.Free;
  mouseEvent.Free;
  font.Free;
  ClearListAndFree(Buffers);
  ClearListAndFree(Pictures);
end.