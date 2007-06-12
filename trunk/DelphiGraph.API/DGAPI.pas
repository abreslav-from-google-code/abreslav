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
  Windows, Messages, Classes, Syncobjs;

var
  wndClass : TWndClassEx;
  hWnd: THandle = 0;
  eventThread : THandle = 0;
  bufferBMP : HBITMAP = 0;
  buffer : HDC = 0;
  WindowRect : TRect;
  WindowWidth : Integer = -1;
  WindowHeight : Integer = -1;
  cs : TCriticalSection = nil;
  event : TEvent = nil;
  Frozen : Boolean = false;

function WindowProc(wnd: THandle; msg: Integer; wparam: WPARAM; lparam: LPARAM) : LRESULT; stdcall;
var
  dc : HDC;
  ps : PAINTSTRUCT;
begin
  case msg of
    WM_DESTROY: begin
      Result := 0;
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
        BitBlt(dc, 0, 0, WindowWidth, WindowHeight, buffer, 0, 0, SRCCOPY);
      finally
        cs.Leave;
//        event.SetEvent;
        EndPaint(hWnd, ps);
      end;
      Result := 0;
    end;
    WM_LBUTTONDOWN: begin
      SetWindowText(wnd, 'asdfas');
      Result := 0;
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
  
  CreateWindow;

  DestroyWindow(hWnd);
  hWnd := 0;
  DeleteDC(buffer);
  buffer := 0;
  DeleteObject(bufferBMP);
  bufferBMP := 0;

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
  cs := TCriticalSection.Create;
  event := TEvent.Create(nil, true, false, 'DelphiGraphWindowInitialized');
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

procedure Repaint;
begin
  if not Frozen then
    InvalidateRect(hWnd, nil, false);
end;

procedure FreezeScreen;
begin
  Frozen := true;
end;

procedure UnFreezeScreen;
begin
  Frozen := false;
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
end;
procedure RoundRect(x1, y1, x2, y2, a, b : Integer);
begin
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

end.
