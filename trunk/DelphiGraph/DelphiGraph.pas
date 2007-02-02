{
   Version 1.2.1

   Change history:
   01.12.2006        Sleep(1) replaced with Sleep(0) in Dispatch 
}

unit DelphiGraph;

interface

uses
  Windows, Messages, SysUtils, Classes, Graphics, Controls, Forms, Dialogs,
  ExtCtrls, contnrs, StdCtrls;

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
  
type
  TGForm = class(TForm)
    procedure FormPaint(Sender: TObject);
    procedure FormCreate(Sender: TObject);
    procedure FormClose(Sender: TObject; var Action: TCloseAction);
    procedure FormMouseDown(Sender: TObject; Button: TMouseButton;
      Shift: TShiftState; X, Y: Integer);
    procedure FormMouseMove(Sender: TObject; Shift: TShiftState; X,
      Y: Integer);
    procedure FormMouseUp(Sender: TObject; Button: TMouseButton;
      Shift: TShiftState; X, Y: Integer);
  private
    procedure WMKeyDown(var Message: TWMKeyDown); message WM_KEYDOWN;
  public
    { Public declarations }
  end;

procedure SetTitle(title : String);
function GetTitle : String;

function KeyPressed : Boolean;
function CharPressed : Boolean;
function ReadKey : Word;
function ReadChar : Char;

function MousePressed : Boolean;
function GetMouseX : Integer;
function GetMouseY : Integer;

procedure InitGraph(Width, Height : Integer);
function GetScreenMaxX : Integer;
function GetScreenMaxY : Integer;
function GetMaxX : Integer;
function GetMaxY : Integer;

procedure FreezeScreen;
procedure UnFreezeScreen;

function TextWidth(S : String) : Integer;
function TextHeight(S : String) : Integer;
procedure TextOut(X, Y : Integer; S : String);

procedure ClrScr;
procedure Rectangle(x1, y1, x2, y2 : Integer);
procedure Ellipse(x1, y1, x2, y2 : Integer);
procedure RoundRect(x1, y1, x2, y2, a, b : Integer);
procedure MoveTo(x, y : Integer);
procedure LineTo(x, y : Integer);
procedure Polygon(points : array of TPoint);

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

procedure Sleep(ms : Cardinal);

function GetReadWidth : Integer;
procedure SetReadWidth(w : Integer);

function GRead(var S : String) : Boolean; overload;
function GRead(var I : Integer) : Boolean; overload;
function GRead(var R : Real) : Boolean; overload;
function GRead(var D : Double) : Boolean; overload;

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
  ReaderUnit;

{$R *.DFM}

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

var
  GForm: TGForm = nil;
  KeyQueue : TObjectQueue;
  Buffer : TBitmap = nil;
  ReadWidth : Integer = 150;
  Frozen : Boolean = false;
  MouseX : Integer = 0;
  MouseY : Integer = 0;
  IsMouseDown : Boolean = false;
  MESSAGE : TMessage;

procedure Dispatch;
begin
  GForm.Dispatch(MESSAGE);
  Sleep(0); // Time to receive messages
//  Application.ProcessMessages; - not needed as Sleep calls it
end;

procedure Repaint;
begin
  if not Frozen then
    GForm.Repaint;
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

procedure SetTitle(title : String);
begin
  GForm.Caption := title;
end;

function GetTitle : String;
begin
  Result := GForm.Caption;
end;

////////////////////////////////////////////////////////////////////////////////

procedure ReadKeyOnly;
begin
  while not KeyPressed do;
  if not CharPressed then begin
    TKeyEvent(KeyQueue.Pop).GetVirtualKey;
  end;
end;

function KeyPressed : Boolean;
begin
  Dispatch;
  Result := KeyQueue.Count > 0;
end;

function CharPressed : Boolean;
begin
  Result := KeyPressed and TKeyEvent(KeyQueue.Peek).isChar;
end;

function ReadChar : Char;
begin
  while not CharPressed do
    ReadKeyOnly;
  Result := TKeyEvent(KeyQueue.Pop).GetChar;
end;

function ReadKey : Word;
begin
  while not KeyPressed do;
  Result := TKeyEvent(KeyQueue.Pop).GetVirtualKey;
end;

////////////////////////////////////////////////////////////////////////////////

function MousePressed : Boolean;
begin
  Dispatch;
  Result := IsMouseDown;
end;

function GetMouseX : Integer;
begin
  Dispatch;
  Result := MouseX;
end;

function GetMouseY : Integer;
begin
  Dispatch;
  Result := MouseY;
end;

////////////////////////////////////////////////////////////////////////////////

procedure InitGraph(Width, Height : Integer);
begin
  if GForm = nil then
    GForm := TGForm.Create(nil);
  if Buffer = nil then begin
    Buffer := TBitmap.Create;
    Buffer.Width := GetScreenMaxX;
    Buffer.Height := GetScreenMaxX;
  end;
  GForm.ClientWidth := Width;
  GForm.ClientHeight := Height;
  GForm.Show;
end;

function GetScreenMaxX : Integer;
begin
  Result := Screen.Width;
end;

function GetScreenMaxY : Integer;
begin
  Result := Screen.Height;
end;

function GetMaxX : Integer;
begin
  Result := GForm.ClientWidth;
end;

function GetMaxY : Integer;
begin
  Result := GForm.ClientHeight;
end;

////////////////////////////////////////////////////////////////////////////////

function TextWidth(S : String) : Integer;
begin
  Result := Buffer.Canvas.TextWidth(S);
end;

function TextHeight(S : String) : Integer;
begin
  Result := Buffer.Canvas.TextHeight(S);
end;

procedure TextOut(X, Y : Integer; S : String);
begin
  Buffer.Canvas.TextOut(X, Y, S);
  Repaint;
end;

////////////////////////////////////////////////////////////////////////////////

procedure ClrScr;
begin
  with Buffer.Canvas do begin
    FillRect(Rect(0, 0, Buffer.Width, Buffer.Height));
  end;
  Repaint;
end;

procedure Rectangle(x1, y1, x2, y2 : Integer);
begin
  Buffer.Canvas.Rectangle(x1, y1, x2, y2);
  Repaint;
end;

procedure Ellipse(x1, y1, x2, y2 : Integer);
begin
  Buffer.Canvas.Ellipse(x1, y1, x2, y2);
  Repaint;
end;

procedure RoundRect(x1, y1, x2, y2, a, b : Integer);
begin
  Buffer.Canvas.RoundRect(x1, y1, x2, y2, a, b);
  Repaint;
end;

procedure MoveTo(x, y : Integer);
begin
  Buffer.Canvas.MoveTo(x, y);
end;

procedure LineTo(x, y : Integer);
begin
  Buffer.Canvas.LineTo(x, y);
  Repaint;
end;

procedure Polygon(points : array of TPoint);
begin
  Buffer.Canvas.Polygon(points);
  Repaint;
end;

////////////////////////////////////////////////////////////////////////////////

procedure SetPenColor(c : TColor);
begin
  Buffer.Canvas.Pen.Color := c;
end;

procedure SetPenWidth(w : Integer);
begin
  Buffer.Canvas.Pen.Width := w;
end;

procedure SetPenStyle(s : TPenStyle);
begin
  Buffer.Canvas.Pen.Style := s;
end;

procedure SetGraphicMode(m : TPenMode);
begin
  Buffer.Canvas.Pen.Mode := m;
end;

procedure SetBrushColor(c : TColor);
begin
  Buffer.Canvas.Brush.Color := c;
end;

procedure SetBrushStyle(s : TBrushStyle);
begin
  Buffer.Canvas.Brush.Style := s;
end;

procedure SetFontColor(c : TColor);
begin
  Buffer.Canvas.Font.Color := c;
end;

procedure SetFontSize(s : Integer);
begin
  Buffer.Canvas.Font.Size := s;
end;

procedure SetFontName(n : String);
begin
  Buffer.Canvas.Font.Name := n;
end;

procedure SetFontStyle(s : TFontStyles);
begin
  Buffer.Canvas.Font.Style := s;
end;

function GetPenColor : TColor;
begin
  Result := Buffer.Canvas.Pen.Color;
end;

function GetPenWidth : Integer;
begin
  Result := Buffer.Canvas.Pen.Width;
end;

function GetPenStyle : TPenStyle;
begin
  Result := Buffer.Canvas.Pen.Style;
end;

function GetGraphicMode : TPenMode;
begin
  Result := Buffer.Canvas.Pen.Mode;
end;

function GetBrushColor : TColor;
begin
  Result := Buffer.Canvas.Brush.Color;
end;

function GetBrushStyle : TBrushStyle;
begin
  Result := Buffer.Canvas.Brush.Style;
end;

function GetFontColor : TColor;
begin
  Result := Buffer.Canvas.Font.Color;
end;

function GetFontSize : Integer;
begin
  Result := Buffer.Canvas.Font.Size;
end;

function GetFontName : String;
begin
  Result := Buffer.Canvas.Font.Name;
end;

function GetFontStyle : TFontStyles;
begin
  Result := Buffer.Canvas.Font.Style;
end;

////////////////////////////////////////////////////////////////////////////////

procedure Sleep(ms : Cardinal);
begin
  Windows.Sleep(ms);
  Application.ProcessMessages;
end;

////////////////////////////////////////////////////////////////////////////////

function GetReadWidth : Integer;
begin
  Result := ReadWidth;
end;

procedure SetReadWidth(w : Integer);
begin
  ReadWidth := w;
end;

function GRead(var S : String) : Boolean; overload;
var
  p : TPoint;
begin
  p := GForm.ClientToScreen(Buffer.Canvas.PenPos);
  Result := ReaderUnit.RRead(
              p.x,
              p.y,
              ReadWidth,
              TextHeight(S),
              Buffer.Canvas.Font,
              Buffer.Canvas.Brush.Color,
              false,
              S);
end;

function GRead(var I : Integer) : Boolean; overload;
var
  S : String;
begin
  S := IntToStr(I);
  Result := GRead(S);
  try
    I := StrToInt(S);
  except
    Result := true;
  end;
end;

function GRead(var R : Real) : Boolean; overload;
var
  d : Double;
begin
  d := R;
  Result := GRead(R);
  R := d;
end;

function GRead(var D : Double) : Boolean; overload;
var
  S : String;
begin
  S := FloatToStr(D);
  Result := GRead(S);
  try
    D := StrToFloat(S);
  except
    Result := true;
  end;
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
  Result := Buffers.Add(TBitmap.Create);
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
  TBitmap(Buffers[buf]).Width := Buffer.Width;
  TBitmap(Buffers[buf]).Height := Buffer.Height;
  TBitmap(Buffers[buf]).Canvas.Draw(0, 0, Buffer);
end;

procedure LoadScreenFromBuffer(buf : TBuffer);
begin
  if buf = NIL_BUFFER then begin
     raise Exception.Create('NIL Buffer used');
  end;
  Buffer.Canvas.Draw(0, 0, TBitmap(Buffers[buf]));
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
begin
  Buffer.Canvas.Draw(x, y, TBitmap(Pictures[p]));
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

////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////

procedure TGForm.FormPaint(Sender: TObject);
begin
  Canvas.Draw(0, 0, Buffer);
end;

procedure TGForm.FormCreate(Sender: TObject);
begin
  ControlStyle := ControlStyle + [csOpaque]; 
end;

procedure TGForm.FormClose(Sender: TObject; var Action: TCloseAction);
begin
  Halt;
end;

var
  ks : TKeyboardState;

procedure TGForm.WMKeyDown(var Message: TWMKeyDown);
var
  c : array[1..2] of Char;
  Shift : TShiftState;
  r : Integer;
begin
  Shift := KeyDataToShiftState(Message.KeyData);
  if ssShift in Shift then
    ks[VK_SHIFT] := $FF
  else ks[VK_SHIFT] := 0;
  if ssCtrl in Shift then
    ks[VK_CONTROL] := $FF
  else ks[VK_CONTROL] := 0;
  r := ToAscii(Message.CharCode, Message.KeyData shr 16, ks, @c, 0);

  KeyQueue.Push(TKeyEvent.Create(Message.CharCode, c[1], r <> 0, Shift));
end;

procedure TGForm.FormMouseDown(Sender: TObject; Button: TMouseButton;
  Shift: TShiftState; X, Y: Integer);
begin
  IsMouseDown := true;
end;

procedure TGForm.FormMouseMove(Sender: TObject; Shift: TShiftState; X,
  Y: Integer);
begin
  MouseX := X;
  MouseY := Y;
end;

procedure TGForm.FormMouseUp(Sender: TObject; Button: TMouseButton;
  Shift: TShiftState; X, Y: Integer);
begin
  IsMouseDown := false;
end;

initialization
  KeyQueue := TObjectQueue.Create;
  FillChar(MESSAGE, SizeOf(MESSAGE), 0);
  Buffers := TObjectList.Create;
  pictures := TObjectList.Create;
finalization
  KeyQueue.Free;
  Buffers.Free;
  Pictures.Free;
end.
