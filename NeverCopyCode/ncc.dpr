program ncc;
{$APPTYPE CONSOLE}

uses
  SysUtils,
  Math,
  Classes,
  DataCommons,
  UsersUnit,
  PascalLexer,
  MetricUnit;

procedure ShowUsage;
begin
  WriteLn('Finds similarity metric of two byte files');
  WriteLn('Usage:');
  WriteLn('ncc <option> [metric] <author_name> <file_name> <threshold>');
  WriteLn('Options:');
  WriteLn('  -? - show this screen.');
  WriteLn('  -a - add a file.');
  WriteLn('       Checks up whether this file has close matching with aonther author');
  WriteLn('       and if so informs user about it and does not add');
  WriteLn('  -r - replace a file.');
  WriteLn('       Does the same checks as -a');
  WriteLn('Metrics:');
  WriteLn('  -c - maximum common subsequence.');
  WriteLn('       Ratio of mcs length to the length of shortest sample.');
  WriteLn('       Threshold is a minimum value treated as close matching');
  WriteLn('  -e - editing distance. Used by deafult.');
  WriteLn('       Ratio of editing distance to the length of shortest sample.');
  WriteLn('       Threshold is a maximum value treated as close matching');
  WriteLn('<threshold> - an integer number of percents.');
  Halt;
end;

var
  mode : (modeAdd, modeReplace);
  metric : (metricMCS, metricED) = metricED;
  authorName : String;
  fileName : String;
  threshold : Integer = 0;
  uf : TUserFile = nil;
  c : Integer;
  input : TFileStream = nil;
  tokenStream : TStream = nil;
  authorId : Integer;
  metricFn : PMetricFunction;
  match : Integer;
  entry : TMetadataEntry;
  metadata : TMetadataRecord;
  underThreshold : Boolean;
  tr : TTokenizeResult;
  respond : Char;
begin
  if ParamCount < 4 then
    ShowUsage;

  if ParamStr(1) = '-?' then
    ShowUsage;
  if ParamStr(1) = '-a' then
    mode := modeAdd
  else if ParamStr(1) = '-r' then begin
    mode := modeReplace;
  end else begin
    WriteLn('Unknown mode: ', ParamStr(1));
    ShowUsage;
  end;

  c := 2;
  if ParamCount = 5 then begin
    if ParamStr(2) = '-c' then
      metric := metricMCS
    else if ParamStr(2) = '-e' then
      metric := metricED
    else begin
      WriteLn('Unknown metric: ', ParamStr(1));
      ShowUsage;
    end;
    c := 3;
  end;

  if metric = metricEd then
    WriteLn('Using ED metric')
  else WriteLn('Using MCS metric');

  authorName := ParamStr(c);
  fileName := ParamStr(c + 1);

  try
    threshold := StrToInt(ParamStr(c + 2));
  except
    WriteLn('Invalid threshold: ', ParamStr(c + 2));
    ShowUsage;
  end;

  try
    input := TFileStream.Create(fileName, fmOpenRead or fmShareDenyWrite);
  except
    on e : Exception do begin
      WriteLn(e.Message);
      Exit;
    end;
  end;

  try
    try
      tokenStream := TMemoryStream.Create;
      tr := tokenize(input, tokenStream);
      WriteLn('Lexer: ', tr.tokens, ' tokens, ', tr.errors, ' errors');

      uf := TUserFile.Create(USERS_FILE);
      authorId := uf.IndexOf(authorName);
      if authorId < 0 then begin
        Write('User ', authorName, ' does not exist. Add (y/n)? ');
        ReadLn(respond);
        if respond in ['y', 'Y'] then
          authorId := uf.AddUser(authorName);
      end;

      case metric of
        metricMCS: metricFn := mcs;
        metricED: metricFn := editingDistance;
        else metricFn := nil;
      end;
      match := FindClosestMatching(tokenStream, authorId, metricFn, metric = metricMCS, entry);

      WriteLn('Closest match found: ', match, '%');

      if metric = metricMCS then
        underThreshold := match < threshold
      else underThreshold := match > threshold;

      if (match >= 0) and not underThreshold then begin
        WriteLn('Close match found:');
        WriteLn('Author: ', uf.UserNames[entry.data.authorId]);
        WriteLn('Date: ', DateTimeToStr(entry.data.lastWrite));
        WriteLn('File name: ', entry.data.fileName);
        WriteLn('Metric: ', match, '%');
      end else begin
        WriteLn('No close match found');
        if authorId < 0 then
          WriteLn('User does not exist: cannot add')
        else begin
          WriteLn('Adding...');
          metadata.authorId := authorId;
          metadata.lastWrite := Now();
          metadata.fileName := ExpandFileName(fileName);
          AddSample(metadata, input, tokenStream);
          WriteLn('Done');
        end;
      end;

    except
      on e : Exception do
        WriteLn('Fatal error: ', e.Message);
    end;
  finally
    uf.Free;
    tokenStream.Free;
    input.Free;
  end;
end.
