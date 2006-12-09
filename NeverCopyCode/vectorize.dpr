program vectoriz;
{$APPTYPE CONSOLE}

uses
  SysUtils,
  Math,
  Classes,
  PascalLexer,
  DataCommons in 'DataCommons.pas';

procedure ShowUsage;
begin
  WriteLn('Recalculates all token number vectors in the database');
  WriteLn('Usage:');
  WriteLn('vectorize [-?]');
  WriteLn('Options:');
  WriteLn('  -? - show this screen');
  Halt(0);
end;

procedure vectorize(fileNum : String);
var
  tokens : TStream;
  numbers : array[TPascalToken] of Integer;
  numFile : TStream;
  t : TPascalToken;
begin
  for t := Low(numbers) to High(numbers) do
    numbers[t] := 0;

  tokens := nil;
  try
    tokens := TFileStream.Create(DATA_DIR + '\' + fileNum + DATA_EXTENSION, fmOpenRead or fmShareDenyWrite);
    while tokens.Read(t, sizeOf(t)) <> 0 do
      inc(numbers[t]);
  finally
    tokens.Free;
  end;

  numFile := nil;
  try
    numFile := TFileStream.Create(DATA_DIR + '\' + fileNum + '.num', fmCreate);
    numFile.Write(numbers, sizeOf(numbers));
  finally
    numFile.Free;
  end;

  WriteLn(fileNum);
end;

procedure vectorizeDir(dir : String);
var
  SR : TSearchRec;
begin
  if FindFirst(dir + '\*' + DATA_EXTENSION, faAnyFile and not faDirectory, SR) = 0 then
    repeat
      vectorize(Copy(ExtractFileName(SR.Name), 1, 8));
    until FindNext(SR) <> 0;
end;

begin
  if (ParamCount >= 1) then begin
    if (ParamStr(1) <> '-?') then
      WriteLn('Unknown option: ', ParamStr(1));
    ShowUsage;
  end;

  try
    vectorizeDir(DATA_DIR);
  except
    on e : Exception do
      WriteLn('Fatal error: ', e.Message);
  end;
end.
