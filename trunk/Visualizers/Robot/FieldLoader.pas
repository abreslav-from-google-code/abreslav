unit FieldLoader;

interface

uses
  Field, Robot, SysUtils;

procedure LoadField(out field : TField; out robot : TRobot; const fileName : String; robotListener : TRobotListener = nil; strategy : TStateChangeStrategy = nil);

type
  EInvalidFileFormat = class(Exception)

  end;

implementation

procedure LoadField;
var
  f : TextFile;
  w, h : Integer;
  x, y : Integer;
  c : Char;
begin
  AssignFile(f, fileName);
  Reset(f);
  ReadLn(f, w);
  ReadLn(f, h);
  field := TField.Create(w, h, strategy);
  x := 0;
  y := 0;
  while (not Eof(f)) and (y < h) do begin
    Read(f, c);
    case c of
      #13: ;
      #10 : begin
        x := -1;
        y := y + 1;
      end;
      ' ' : field[x, y] := csEmpty;
      'X' : field[x, y] := csWall;
      'M' : field[x, y] := csMarked;
      'R' : begin
        robot := TRobot.Create(field, x, y, robotListener);
        field[x, y] := csMarked;
      end;
      'r' : begin
        robot := TRobot.Create(field, x, y, robotListener);
      end;
      else raise EInvalidFileFormat.Create('Illegal character: ' + c);
    end;
    x := x + 1;
    if x >= w then begin
      y := y + 1;
      x := 0;
      ReadLn(f);
    end;
  end;
  CloseFile(f);
end;

end.
