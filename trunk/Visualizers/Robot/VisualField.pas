unit VisualField;

interface

uses
  Field, Robot;

procedure Init(W, H : Integer);
procedure Draw(Field : TField; Robot : TRobot);
  
implementation

uses
  DelphiGraph;

var
  Width : Integer;
  Height : Integer;
  pic : TPicture;

procedure Init(W, H : Integer);
begin
  Width := W;
  Height := H;
//  pic := LoadPicture('robot.bmp');
end;

procedure Draw(Field : TField; Robot : TRobot);
var
  x, y : Integer;
  w, h : Integer;
  l, t, r, b : Integer;
begin
  w := Width div Field.Width;
  h := Height div Field.Height;

  FreezeScreen;

  SetBrushStyle(bsSolid);
  SetBrushColor(clWhite);
  ClrScr;

//  DrawPicture(0, 0, pic);

  for y := 0 to Field.Height - 1 do begin
    for x := 0 to Field.Width - 1 do begin
      l := x * w;
      t := y * h;
      r := (x + 1) * w;
      b := (y + 1)* h;
      case Field[x, y] of
        csEmpty : begin
          SetBrushColor(clWhite);
          SetBrushStyle(bsClear);
        end;
        csWall : begin
          SetBrushColor(clOlive);
          SetBrushStyle(bsSolid);
        end;
        csMarked : begin
          SetBrushColor(clRed);
          SetBrushStyle(bsDiagCross);
        end;
      end;
      Rectangle(l, t, r, b);
      if (Field[x, y] = csWall) then begin
        SetBrushColor(clBlack);
        SetBrushStyle(bsFDiagonal);
      end;
      Rectangle(l, t, r, b);
    end;
  end;
  SetBrushStyle(bsSolid);
  SetBrushColor(clLime);
  l := Robot.XPosition * w;
  t := Robot.YPosition * h;
  r := Robot.XPosition * w + w;
  b := Robot.YPosition * h + h;
  Ellipse(l, t, r, b);
  UnFreezeScreen;
end;

end.
