program Lexer;
{$APPTYPE CONSOLE}
uses
  SysUtils,
  Classes,
  PascalLexer in 'PascalLexer.pas';

var
  input : TStream;
  output : TStream;
  b : Byte;
  S : String;
begin
  rewrite(System.output, 'out.txt');

  input := TFileStream.Create('PascalLexer.pas', fmOpenRead);
  output := TStringStream.Create('');

  tokenize(input, output);

  output.Seek(0, soFromBeginning);
  while output.Read(b, 1) <> 0 do begin
    S := byteToTokenPresentation(b);
    Write(S, ' ');
    if (S = ';') then
      WriteLn;
  end;
  output.Free;

  ReadLn;
end.