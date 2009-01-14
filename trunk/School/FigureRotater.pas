unit FigureRotater;

interface

uses
  Figures;

function angleBetween(const center, p1, p2 : TPoint) : Real;
procedure rotateAllFigures(const center : TPoint; angle : Real);

implementation

uses
  FigureList, Math;

function angle(const center, p : TPoint) : Real;
begin
  Result := arctan2(p.y - center.y, p.x - center.x);
end;

function angleBetween(const center, p1, p2 : TPoint) : Real;
begin
  Result := angle(center, p2) - angle(center, p1);
end;

procedure rotatePoint(var p : TPoint; const center : TPoint; angle : Real);
var
  x, y : Real;
begin
  x := p.x - center.x;
  y := p.y - center.y;
  p.x := center.x + cos(angle) * x - sin(angle) * y;
  p.y := center.y + sin(angle) * x + cos(angle) * y;
end;

procedure rotateSegment(var segment : TSegment; const center : TPoint; angle : Real);
begin
  rotatePoint(segment.a, center, angle);
  rotatePoint(segment.b, center, angle);
end;

procedure rotateCircle(var circle : TCircle; const center : TPoint; angle : Real);
begin
  rotatePoint(circle.center, center, angle);
end;

procedure rotatePolygon(var polygon : TPolygon; const center : TPoint; angle : Real);
var
  i : Integer;
begin
  for i := 1 to polygon.size do
    rotatePoint(polygon.points[i], center, angle);
end;

procedure rotateAllFigures(const center : TPoint; angle : Real);
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
        rotateSegment(segment, center, angle);
        StepBack;
        writeSegment(segment);
      end;
      ftCircle : begin
        readCircle(circle);
        rotateCircle(circle, center, angle);
        StepBack;
        writeCircle(circle);
      end;
      ftPolygon : begin
        readPolygon(polygon);
        rotatePolygon(polygon, center, angle);
        StepBack;
        writePolygon(polygon);
      end;
    end;
  end;
end;

end.
