program ReadTokens;
{$APPTYPE CONSOLE}
uses
  SysUtils,
  Classes,
  PascalLexer in 'PascalLexer.pas';

var
  input : TStream;
  output : TextFile;
  b : Byte;
begin
  if ParamCount < 2 then begin
    WriteLn('Usage:');
    WriteLn('readtokens <in.dat> <out.tok>');
    Exit;
  end;

  try
    input := TFileStream.Create(ParamStr(1), fmOpenRead or fmShareDenyWrite);
    Rewrite(output, ParamStr(2));

    while input.Read(b, 1) <> 0 do begin
      WriteLn(output, byteToTokenName(b));
    end;

    CloseFile(output);

  except
    on e : Exception do
      WriteLn('Fatal error: ', e.Message);
  end;
end.
