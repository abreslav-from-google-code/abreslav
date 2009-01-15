unit FigureFile;

interface

uses
  Figures;

{
  ����������� ��������� ������/������ �� ������ ������
}
procedure Reset(var fFile : File);

{
  ������� ����
}
procedure CloseFile(var fFile : File);

{
  ��������� �� ����� ��� ��������� ������
}
function GetNextFigureType(var fFile : File) : TFigureType;

{
  ���������� true, ���� � ����� ���� ��� ������
    � false -- � ��������� ������
}
function HasMoreFigures(var fFile : File) : Boolean;

{
   �������� ������� �� ����� (�� ������� ��� ������)
}
procedure ReadSegment(var fFile : File; var segment : TSegment);

{
  �������� ���� �� ����� (�� ������� ��� ������)
}
procedure ReadCircle(var fFile : File; var circle : TCircle);

{
  �������� ������������� �� ����� (�� ������� ��� ������)
}
procedure ReadPolygon(var fFile : File; var polygon : TPolygon);

{
  �������� ������� � ���� (������� ��� ������)
}
procedure WriteSegment(var fFile : File; const segment : TSegment);

{
  �������� ���� � ���� (������� ��� ������)
}
procedure WriteCircle(var fFile : File; const circle : TCircle);

{
  �������� ������������� � ���� (������� ��� ������)
}
procedure WritePolygon(var fFile : File; const polygon : TPolygon);

implementation

procedure Reset(var fFile : File);
begin
  System.Reset(fFile, 1);
end;

procedure CloseFile(var fFile : File);
begin
  System.CloseFile(fFile);
end;

function GetNextFigureType(var fFile : File) : TFigureType;
begin
  BlockRead(fFile, Result, sizeOf(Result));
end;

function HasMoreFigures(var fFile : File) : Boolean;
begin
  Result := false;
end;

procedure ReadSegment(var fFile : File; var segment : TSegment);
begin

end;

procedure ReadCircle(var fFile : File; var circle : TCircle);
begin

end;

procedure ReadPolygon(var fFile : File; var polygon : TPolygon);
begin

end;

procedure WriteSegment(var fFile : File; const segment : TSegment);
begin
end;

procedure WriteCircle(var fFile : File; const circle : TCircle);
begin

end;

procedure WritePolygon(var fFile : File; const polygon : TPolygon);
begin

end;

end.
