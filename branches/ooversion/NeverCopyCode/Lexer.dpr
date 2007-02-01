program Lexer;
{$APPTYPE CONSOLE}
uses
  SysUtils,
  Classes,
  PascalLexer in 'PascalLexer.pas';

var
  input : TStream;
  output : TStream;
  r : TTokenizeResult;
begin
  if ParamCount < 2 then begin
    WriteLn('Usage:');
    WriteLn('lexer <in.pas> <out.dat>');
    Exit;
  end;

  try
    input := TFileStream.Create(ParamStr(1), fmOpenRead or fmShareDenyWrite);
    output := TFileStream.Create(ParamStr(2), fmCreate);

    r := tokenize(input, output);

    WriteLn('Found tokens: ', r.tokens);
    WriteLn('Errors: ', r.errors);
  except
    on e : Exception do
      WriteLn('Fatal error: ', e.Message);
  end;
end.
