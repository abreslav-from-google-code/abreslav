unit FigureRotater;

interface

uses
  Figures;

{
  ��������� ���� ����� ��������� �� ����� center � ����� p1 � p2
  ��������, ���� center = (0; 0), p1 = (0; 1), p2 = (1; 0)
    ������� ������ ��������� -pi/2
}
function angleBetween(const center, p1, p2 : TPoint) : Real;

{
  ������������ ��� ������ �� ������, ��������� ������� FigureList
    �� ���� angle ������������ ����� center

  �� �������� �������� ��������� ������� � ������
}
procedure rotateAllFigures(const center : TPoint; angle : Real);

implementation

function angleBetween(const center, p1, p2 : TPoint) : Real;
begin
  Result := 0;
end;

procedure rotateAllFigures(const center : TPoint; angle : Real);
begin

end;

end.
