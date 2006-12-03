program Pseudocode;
{$APPTYPE CONSOLE}
uses
  SysUtils,
  Classes,
  PascalLexer in 'PascalLexer.pas';

var
  input : TStream;
  output : TextFile;
  t : TPascalToken;
begin
  if ParamCount < 2 then begin
    WriteLn('Usage:');
    WriteLn('pseudocode <in.dat> <out.pas>');
    Exit;
  end;

  try
    input := TFileStream.Create(ParamStr(1), fmOpenRead or fmShareDenyWrite);
    Rewrite(output, ParamStr(2));

    while input.Read(t, 1) <> 0 do begin
      Write(output, tokenPresentation(t), ' ');
    end;

    CloseFile(output);

  except
    on e : Exception do
      WriteLn('Fatal error: ', e.Message);
  end;
end.
