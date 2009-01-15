unit FigureFile;

interface

uses
  Figures;

{
  Переместить указатель чтения/записи на первую фигуру
}
procedure Reset(var fFile : File);

{
  Закрыть файл
}
procedure CloseFile(var fFile : File);

{
  Прочитать из файла тип следующей фигуры
}
function GetNextFigureType(var fFile : File) : TFigureType;

{
  Возвращает true, если в файле есть еще фигуры
    и false -- в противном случае
}
function HasMoreFigures(var fFile : File) : Boolean;

{
   Прочесть отрезок из файла (не включая тип фигуры)
}
procedure ReadSegment(var fFile : File; var segment : TSegment);

{
  Прочесть круг из файла (не включая тип фигуры)
}
procedure ReadCircle(var fFile : File; var circle : TCircle);

{
  Прочесть многоугольник из файла (не включая тип фигуры)
}
procedure ReadPolygon(var fFile : File; var polygon : TPolygon);

{
  Записать отрезок в файл (ВКЛЮЧАЯ тип фигуры)
}
procedure WriteSegment(var fFile : File; const segment : TSegment);

{
  Записать круг в файл (ВКЛЮЧАЯ тип фигуры)
}
procedure WriteCircle(var fFile : File; const circle : TCircle);

{
  Записать многоугольник в файл (ВКЛЮЧАЯ тип фигуры)
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
