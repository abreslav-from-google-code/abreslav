unit FigureList;

interface

uses
  Figures;

procedure Reset;
function GetNextFigureType : TFigureType;
function HasMoreFigures : Boolean;
procedure StepBack;

procedure ReadSegment(var segment : TSegment);
procedure ReadCircle(var circle : TCircle);
procedure ReadPolygon(var polygon : TPolygon);

procedure WriteSegment(const segment : TSegment);
procedure WriteCircle(const circle : TCircle);
procedure WritePolygon(const polygon : TPolygon);

implementation

uses
  SysUtils;

type
  PFigureListItem = ^TFigureListItem;
  TFigureListItem = record
    Previous, Next : PFigureListItem;
    FigureType : TFigureType;
    Data : Byte;
  end;
  EFigureListException = class(Exception)
  end;

const
  ITEM_PREAMBLE_SIZE = 2 * SizeOf(PFigureListItem) + SizeOf(TFigureType);

var
  FLFirst : PFigureListItem = nil;
  FLLast : PFigureListItem = nil;
  FLCurrent : PFigureListItem = nil;

procedure StepBack;
begin
  if FLCurrent = nil then
    FLCurrent := FLLast
  else FLCurrent := FLCurrent^.Previous;
end;

procedure Reset;
begin
  FLCurrent := FLFirst;
end;

function GetNextFigureType : TFigureType;
begin
  if not HasMoreFigures then
    Result := ftError
  else Result := FLCurrent^.FigureType;
end;

function HasMoreFigures : Boolean;
begin
  Result := FLCurrent <> nil;
end;

procedure AssertMoreFigures;
begin
  if not HasMoreFigures then
    raise EFigureListException.Create('List is over');
end;

procedure Advance;
begin
  FLCurrent := FLCurrent^.Next;
end;

procedure AssertFigureType(figureType : TFigureType);
begin
  if FLCurrent^.FigureType <> figureType then
    raise EFigureListException.Create('Types do not match');
end;

procedure Read(figureType : TFigureType; var figure; size : Integer);
begin
  AssertMoreFigures;
  AssertFigureType(figureType);
  Move(FLCurrent^.Data, figure, size);
  Advance;
end;

procedure ReadSegment(var segment : TSegment);
begin
  Read(ftSegment, segment, SizeOf(segment));
end;

procedure ReadCircle(var circle : TCircle);
begin
  Read(ftCircle, circle, SizeOf(circle));
end;

procedure ReadPolygon(var polygon : TPolygon);
begin
  AssertMoreFigures;
  AssertFigureType(ftPolygon);
  Move(FLCurrent^.Data, polygon.size, SizeOf(polygon.size));
  Move(FLCurrent^.Data, polygon, SizeOf(polygon.size) + SizeOf(TPoint) * polygon.size);
  Advance;
end;

procedure Write(figureType : TFigureType; const figure; size : Integer);
var
  tmp : PFigureListItem;
begin
  if HasMoreFigures then begin
    AssertFigureType(figureType);
  end else begin
    GetMem(tmp, ITEM_PREAMBLE_SIZE + size);
    tmp^.Next := nil;
    tmp^.Previous := nil;
    tmp^.FigureType := figureType;
    tmp^.Previous := FLLast;
    if (FLLast = nil) then begin
      FLFirst := tmp;
    end else begin
      FLLast^.Next := tmp;
    end;
    FLLast := tmp;
    FLCurrent := tmp;
  end;
  Move(figure, FLCurrent^.Data, size);
  Advance;
end;

procedure WriteSegment(const segment : TSegment);
begin
  Write(ftSegment, segment, SizeOf(segment));
end;

procedure WriteCircle(const circle : TCircle);
begin
  Write(ftCircle, circle, SizeOf(circle));
end;

procedure WritePolygon(const polygon : TPolygon);
begin
  Write(ftPolygon, polygon, SizeOf(polygon.size) + SizeOf(TPoint) * polygon.size);
end;

end.
