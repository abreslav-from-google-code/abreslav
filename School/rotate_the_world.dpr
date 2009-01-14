program rotate_the_world;
{$APPTYPE CONSOLE}
uses
  DelphiGraph,
  Figures in 'Figures.pas',
  FigureList in 'FigureList.pas',
  FigureFile in 'FigureFile.pas',
  DrawFigures in 'DrawFigures.pas',
  FigureRotater in 'FigureRotater.pas',
  MouseInput in 'MouseInput.pas',
  LoadSave in 'LoadSave.pas';

const
  W = 600;
  H = 600;

procedure drawAll(const c : TPoint);
begin
  FreezeScreen;
  SetBrushColor(clWhite);
  ClrScr;
  drawAllFigures;
  SetBrushColor(clLime);
  drawPoint(c);
  UnFreezeScreen;
end;

var
  c, p1, p2 : Tpoint;
  fFile : File;
begin
  AssignFile(fFile, 'figures.dat');
  FigureFile.Reset(fFile);
  InitGraph(H, W);
  FileToList(fFile);
  drawAllFigures;
  while true do begin
    getPoint(c);
    drawAll(c);
    while not MousePressed do
      WaitForMouseEvent;
    mousePoint(p1);
    while MousePressed do begin
      WaitForMouseEvent;
      mousePoint(p2);
      rotateAllFigures(c, angleBetween(c, p1, p2));
      ListToFile(fFile);
      p1 := p2;
      drawAll(c);
    end;
  end;
  WaitForGraph;
end.