program twoballs;

uses
  DelphiGraph;

const
  F_COLOR = clRed;
  F_UP = 'W';
  F_DOWN = 'S';
  F_LEFT = 'A';
  F_RIGHT = 'D';

  S_COLOR = clBlue;
  S_UP = 'I';
  S_DOWN = 'K';
  S_LEFT = 'J';
  S_RIGHT = 'L';

  RAD = 50;

procedure DrawBall(c : TColor; u, d, l, r : Char; x, y : Integer);
var
  w, h, rr : Integer;
begin
  w := TextWidth('A') div 2;
  h := TextHeight('A') div 2;
  rr := RAD - 10;
  SetBrushColor(c);
  Ellipse(x - RAD, y - RAD, x + RAD, y + RAD);
  SetBrushStyle(bsClear);
  TextOut(x - rr, y - h, l);
  TextOut(x + rr - 2 * w, y - h, r);
  TextOut(x - w, y - rr, u);
  TextOut(x - w, y + rr - 2*h, d);
end;

procedure MoveBall(u, d, l, r : Char; var x, y : Integer);
begin
  if CheckKeyState(ord(u)) then
    dec(y);
  if CheckKeyState(ord(l)) then
    dec(x);
  if CheckKeyState(ord(d)) then
    inc(y);
  if CheckKeyState(ord(r)) then
    inc(x);
end;

var
  fx, fy, sx, sy : Integer;
begin
  InitGraph(400, 400);
  fx := RAD;
  fy := RAD;
  sx := GetMaxX - RAD;
  sy := GetMaxY - RAD;
  while true do begin
    FreezeScreen;
    SetBrushColor(clWhite);
    ClrScr;
    DrawBall(F_COLOR, F_UP, F_DOWN, F_LEFT, F_RIGHT, fx, fy);
    DrawBall(S_COLOR, S_UP, S_DOWN, S_LEFT, S_RIGHT, sx, sy);
    UnFreezeScreen;

    MoveBall(F_UP, F_DOWN, F_LEFT, F_RIGHT, fx, fy);
    MoveBall(S_UP, S_DOWN, S_LEFT, S_RIGHT, sx, sy);
    WaitForKey;
    Sleep(15);
  end;
end.