unit FileConvertor;

interface

procedure Convert;

implementation

uses
  Figures, FigureFile;

procedure Convert;
var
  segment : TSegment;
  circle : TCircle;
  polygon : TPolygon;
  ft : TFigureType;
  fFile, outf : File;
begin
  AssignFile(fFile, 'figures.dat');
  FigureFile.Reset(fFile);

  AssignFile(outf, 'figures.res');
  Rewrite(outf, 1);

  while FigureFile.HasMoreFigures(fFile) do begin
    case FigureFile.GetNextFigureType(fFile) of
      ftSegment : begin
        FigureFile.readSegment(fFile, segment);
        FigureFile.writeSegment(outf, segment);
      end;
      ftCircle : begin
        FigureFile.readCircle(fFile, circle);
        FigureFile.writeCircle(outf, circle);
      end;
      ftPolygon : begin
        BlockRead(fFile, polygon, SizeOf(polygon));
        ft := ftPolygon;
        BlockWrite(outf, ft, SizeOf(ft));
        BlockWrite(outf, polygon.size, SizeOf(integer));
        BlockWrite(outf, polygon.points, SizeOf(TPoint) * polygon.size);
      end;
    end;
  end;

  CloseFile(outf);
end;

end.
