unit FigureFile;

interface

uses
  Figures;

procedure Reset(var fFile : File);
function GetNextFigureType(var fFile : File) : TFigureType;
function HasMoreFigures(var fFile : File) : Boolean;

procedure ReadSegment(var fFile : File; var segment : TSegment);
procedure ReadCircle(var fFile : File; var circle : TCircle);
procedure ReadPolygon(var fFile : File; var polygon : TPolygon);

procedure WriteSegment(var fFile : File; const segment : TSegment);
procedure WriteCircle(var fFile : File; const circle : TCircle);
procedure WritePolygon(var fFile : File; const polygon : TPolygon);

implementation

uses
  SysUtils;

procedure Reset(var fFile : File);
begin
  System.Reset(FFile, 1);
end;

function GetNextFigureType(var fFile : File) : TFigureType;
begin
  BlockRead(FFile, Result, SizeOf(Result));
end;

function HasMoreFigures(var fFile : File) : Boolean;
begin
  Result := not EOF(FFile);
end;

procedure AssertFigureType(var fFile : File; figureType : TFigureType);
begin
  if GetNextFigureType(fFile) <> figureType then
    raise Exception.Create('Types do not match');
end;

procedure Read(var fFile : File; figureType : TFigureType; var figure; size : Integer);
begin
  BlockRead(FFile, figure, size);
end;

procedure ReadSegment(var fFile : File; var segment : TSegment);
begin
  Read(fFile, ftSegment, segment, SizeOf(segment));
end;

procedure ReadCircle(var fFile : File; var circle : TCircle);
begin
  Read(fFile, ftCircle, circle, SizeOf(circle));
end;

procedure ReadPolygon(var fFile : File; var polygon : TPolygon);
begin
  Read(fFile, ftPolygon, polygon, SizeOf(polygon));
end;

procedure Write(var fFile : File; figureType : TFigureType; const figure; size : Integer);
begin
  if HasMoreFigures(fFile) then begin
    AssertFigureType(fFile, figureType);
  end else begin
    BlockWrite(FFile, figureType, SizeOf(figureType));
  end;
  BlockWrite(FFile, figure, size);
end;

procedure WriteSegment(var fFile : File; const segment : TSegment);
begin
  Write(fFile, ftSegment, segment, SizeOf(segment));
end;

procedure WriteCircle(var fFile : File; const circle : TCircle);
begin
  Write(fFile, ftCircle, circle, SizeOf(circle));
end;

procedure WritePolygon(var fFile : File; const polygon : TPolygon);
begin
  Write(fFile, ftPolygon, polygon, SizeOf(polygon));
end;

end.
