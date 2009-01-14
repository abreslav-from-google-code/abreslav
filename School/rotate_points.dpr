program rotate_points;
{$APPTYPE CONSOLE}
uses
  SysUtils,
  DelphiGraph,
  Math,
  Figures in 'Figures.pas',
  FigureList in 'FigureList.pas',
  FigureFile in 'FigureFile.pas',
  DrawFigures in 'DrawFigures.pas',
  FigureRotater in 'FigureRotater.pas',
  MouseInput in 'MouseInput.pas';

const
  W = 600;
  H = 600;

procedure randomPoints(var a : array of TPoint);
var
  i : Integer;
begin
  Randomize;
  for i := Low(a) to High(a) do begin
    a[i].x := Random(600);
    a[i].y := Random(600);
  end;
end;

procedure drawPoint(const a : TPoint);
const
  R = 4;
begin
  SetBrushColor(clLime);
  Ellipse(Round(a.x - R), Round(a.y - R), Round(a.x + R), Round(a.y + R));
end;

procedure drawPoints(const a : array of TPoint);
var
  i : Integer;
begin
  for i := Low(a) to High(a) do
    drawPoint(a[i]);
end;

function angle(const p : TPoint) : Real;
begin
  Result := arctan2(p.y - H / 2, p.x - W / 2);
end;

function angleBetween(const p1, p2 : TPoint) : Real;
begin
  Result := angle(p2) - angle(p1);
end;

function rad(const p : TPoint) : Real;
begin
  Result := sqrt(sqr(p.x - W/2) + sqr(p.y - H/2));
end;

procedure rotatePoint(var p : TPoint; angl : Real);
var
  x, y : Real;
begin
  x := p.x - W / 2;
  y := p.y - H / 2;
  p.x := W / 2 + cos(angl) * x - sin(angl) * y;
  p.y := H / 2 + sin(angl) * x + cos(angl) * y;
end;

procedure rotatePoints(var a : array of TPoint; angle : Real);
var
  i : Integer;
begin
  for i := Low(a) to High(a) do
    rotatePoint(a[i], angle);
end;

procedure proc;
const
  N = 20;
var
  points : array[1..N] of TPoint;
  p1, p2 : Tpoint;
begin
  randomPoints(points);
  InitGraph(600, 600);
  drawPoints(points);
  while true do begin
    WaitForMouseEvent;
    if MousePressed then begin
      p1.x := GetMouseX;
      p1.y := GetMouseY;
      while MousePressed do begin
        WaitForMouseEvent;
        p2.x := getMouseX;
        p2.y := GetMouseY;
        rotatePoints(points, angleBetween(p1, p2));
        p1 := p2;
        SetBrushColor(clWhite);
        FreezeScreen;
        ClrScr;
        drawPoints(points);
        UnFreezeScreen;
      end;

    end;
  end;
  WaitForGraph;
end;

var
  i : Integer;
  segment : TSegment;
begin
  InitGraph(600, 600);
  FigureFile.SetFileName('figures.dat');
  while FigureFile.HasMoreFigures do begin
    case FigureFile.GetNextFigureType of
      ftSegment : begin
        FigureFile.readSegment(segment);
        FigureList.writeSegment(segment);
      end;
    end;
  end;
{  for i := 1 to 5 do begin
    getPoint(segment.a);
    getPoint(segment.b);
    FigureFile.WriteSegment(segment);
  end;}
  drawAllFigures;
  WaitForGraph;
end.
