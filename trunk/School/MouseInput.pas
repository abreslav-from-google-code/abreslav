unit MouseInput;

interface

uses
  Figures;

procedure getPoint(var p : TPoint);
procedure mousePoint(var p : TPoint);

implementation

uses
  DelphiGraph;

procedure mousePoint(var p : Figures.TPoint);
begin
  p.x := GetMouseX;
  p.y := GetMouseY;
end;

procedure getPoint(var p : Figures.TPoint);
begin
  while true do begin
    WaitForMouseEvent;
    if MousePressed then begin
      mousePoint(p);
      while MousePressed do
        WaitForMouseEvent;
      Exit;
    end;
  end;
end;

end.
