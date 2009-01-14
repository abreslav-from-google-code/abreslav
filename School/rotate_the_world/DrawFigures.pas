unit DrawFigures;

interface

uses
  Figures;

procedure drawPoint(const p : TPoint);
procedure DrawAllFigures;

implementation

uses
  FigureList, DelphiGraph;

procedure drawPoint(const p : Figures.TPoint);
const
  R = 4;
begin
  Ellipse(Round(p.x - R), Round(p.y - R), Round(p.x + R), Round(p.y + R));
end;

procedure drawLine(const p1, p2 : Figures.TPoint);
begin
  MoveTo(Round(p1.x), Round(p1.y));
  LineTo(Round(p2.x), Round(p2.y));
end;

procedure drawSegment(const segment : TSegment);
begin
  drawLine(segment.a, segment.b);
end;

procedure drawCircle(const circle : TCircle);
begin
  Ellipse(
    Round(circle.center.x - circle.radius),
    Round(circle.center.y - circle.radius),
    Round(circle.center.x + circle.radius),
    Round(circle.center.y + circle.radius));
end;

procedure drawPolygon(const polygon : TPolygon);
var
  i : Integer;
begin
  for i := 1 to polygon.size - 1 do
    drawLine(polygon.points[i], polygon.points[i + 1]);
  drawLine(polygon.points[polygon.size], polygon.points[1]);
end;

procedure DrawAllFigures;
var
  segment : TSegment;
  circle : TCircle;
  polygon : TPolygon;
begin
  Reset;
  while HasMoreFigures do begin
    case GetNextFigureType of
      ftSegment : begin
        readSegment(segment);
        drawSegment(segment);
      end;
      ftCircle : begin
        readCircle(circle);
        drawCircle(circle);
      end;
      ftPolygon : begin
        readPolygon(polygon);
        drawPolygon(polygon);
      end;
    end;
  end;
end;

end.
