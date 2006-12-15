program anim;
{$APPTYPE CONSOLE}

uses
  SysUtils, DelphiGraph, Math;

const
  N = 6;

procedure WaitFor(t : Integer);
var
  i : Integer;
begin
  for i := 1 to t div 100 do begin
    Sleep(100);
    if KeyPressed then
      if ReadKey = VK_ESCAPE then
        Halt;
  end;
end;


var
  i : Integer = 0;
  pics : array[0..N-1] of TPicture;
begin
  pics[0] := LoadPicture('1.bmp');
  pics[1] := LoadPicture('2.bmp');
  pics[2] := LoadPicture('3.bmp');
  pics[3] := pics[1];
  pics[4] := pics[0];
  pics[5] := LoadPicture('4.bmp');

  InitGraph(GetPictureWidth(pics[0]), GetPictureHeight(pics[0]));

  while true do begin
    DrawPicture(0, 0, pics[i mod N]);
    case i mod N of
      0, 4: WaitFor(2000);
      5: WaitFor(600);
    end;
    i := i + 1;
    Sleep(70);
  end;
end.
