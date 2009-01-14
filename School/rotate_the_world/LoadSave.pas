unit LoadSave;

interface

procedure FileToList(var fFile : File);
procedure ListToFile(var fFile : File);

implementation

uses
  Figures, FigureList, FigureFile;

procedure FileToList(var fFile : File);
var
  segment : TSegment;
  circle : TCircle;
  polygon : TPolygon;
begin
  FigureList.Reset;
  FigureFile.Reset(fFile);
  while FigureFile.HasMoreFigures(fFile) do begin
    case FigureFile.GetNextFigureType(fFile) of
      ftSegment : begin
        FigureFile.readSegment(fFile, segment);
        FigureList.writeSegment(segment);
      end;
      ftCircle : begin
        FigureFile.readCircle(fFile, circle);
        FigureList.writeCircle(circle);
      end;
      ftPolygon : begin
        FigureFile.readPolygon(fFile, polygon);
        FigureList.writePolygon(polygon);
      end;
    end;
  end;
end;

procedure ListToFile(var fFile : File);
var
  segment : TSegment;
  circle : TCircle;
  polygon : TPolygon;
begin
  FigureList.Reset;
  FigureFile.Reset(fFile);
  while FigureList.HasMoreFigures do begin
    case FigureList.GetNextFigureType of
      ftSegment : begin
        FigureList.readSegment(segment);
        FigureFile.writeSegment(fFile, segment);
      end;
      ftCircle : begin
        FigureList.readCircle(circle);
        FigureFile.writeCircle(fFile, circle);
      end;
      ftPolygon : begin
        FigureList.readPolygon(polygon);
        FigureFile.writePolygon(fFile, polygon);
      end;
    end;
  end;
  FigureFile.CloseFile(fFile);
end;

end.
