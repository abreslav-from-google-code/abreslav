unit FigureCreator;

interface

procedure addSegment;
procedure addPolygon(size : Integer);
procedure addCircle(radius : Integer);

implementation

uses
  Figures, MouseInput, FigureList; 

procedure addSegment;
var
  s : TSegment;
begin
  getPoint(s.a);
  getPoint(s.b);
  FigureList.WriteSegment(s);
end;

procedure addPolygon(size : Integer);
var
  p : TPolygon;
  i : Integer;
begin
  p.size := size;
  for i := 1 to size do
    getPoint(p.points[i]);
  FigureList.WritePolygon(p);
end;

procedure addCircle(radius : Integer);
var
  c : TCircle;
begin
  getPoint(c.center);
  c.radius := radius;
  FigureList.WriteCircle(c);
end;

end.
