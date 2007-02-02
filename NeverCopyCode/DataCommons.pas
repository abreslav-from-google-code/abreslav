unit DataCommons;

interface

uses
  MetricUnit, AdvancedMetrics, Classes;

const
  DATA_DIR = '.data';
  DATA_EXTENSION = '.dat';

type
  TMetadataRecord = packed record
    authorId : Integer;
    lastWrite : TDateTime;
    fileName : String[255];
  end;
  TMetadataEntry = record
    id : Integer;
    data : TMetadataRecord;
  end;

{
   negative result means empty database
}
function FindClosestMatching(input : TStream; authorId: Integer; metric: TMetric; out entry : TMetadataEntry; threshold : Integer; sizeThreshold : Real) : IMetricResult;
function AddSample(const metadata : TMetadataRecord; pascalCode, tokenStream : TStream) : Integer;
procedure EnsureDataExists;
function GetPascalFileName(sId : Integer) : String;
function GetTokenFileName(sId : Integer) : String;
function GetFileName(sId : Integer) : String;

implementation

uses
  SysUtils, TokenCounts;

const
  METADATA_FILE_NAME = DATA_DIR + '\.metadata';

function GetFileName(sId : Integer) : String;
begin
  Result := DATA_DIR + '\' + IntToHex(sId, 8);
end;

function GetTokenFileName(sId : Integer) : String;
begin
  Result := GetFileName(sId) + DATA_EXTENSION;
end;

function GetPascalFileName(sId : Integer) : String;
begin
  Result := GetFileName(sId) + '.pas';
end;

function AddSample(const metadata : TMetadataRecord; pascalCode, tokenStream : TStream) : Integer;
var
  tokenCounts : TTokenCounts;
  mf : file of TMetadataRecord;
  pasFile, tokenFile, tokenCountsFile : TFileStream;
begin
  AssignFile(mf, METADATA_FILE_NAME);
  Reset(mf);
  pasFile := nil;
  tokenFile := nil;
  tokenCountsFile := nil;
  try
    Result := FileSize(mf);
    pasFile := TFileStream.Create(GetPascalFileName(Result), fmCreate);
    pascalCode.Seek(0, soFromBeginning);
    pasFile.CopyFrom(pascalCode, pascalCode.Size);
    tokenFile := TFileStream.Create(GetTokenFileName(Result), fmCreate);
    tokenStream.Seek(0, soFromBeginning);
    tokenFile.CopyFrom(tokenStream, tokenStream.Size);
    countTokens(tokenStream, tokenCounts);
    tokenCountsFile := TFileStream.Create(GetTokenCountsFileName(Result), fmCreate);
    tokenCountsFile.Write(tokenCounts, sizeOf(tokenCounts));
    Seek(mf, Result);
    Write(mf, metadata);
  finally
    pasFile.Free;
    tokenFile.Free;
    tokenCountsFile.Free;
    CloseFile(mf);
  end;
end;

function GetTokenData(var buffer : PBytes; var bufsize : Integer; sId : Integer) : Integer;
var
  s : TFileStream;
begin
  s := nil;
  try
    s := TFileStream.Create(GetTokenFileName(sId), fmOpenRead or fmShareDenyWrite);
    if s.Size > bufsize then begin
      bufsize := s.Size;
      FreeMem(buffer);
      GetMem(buffer, bufsize);
    end;
    Result := s.Read(buffer^, s.Size);
  finally
    s.Free;
  end;
end;

function FindClosestMatching(input : TStream; authorId: Integer; metric: TMetric; out entry : TMetadataEntry; threshold : Integer; sizeThreshold : Real) : IMetricResult;
var
  mf : file of TMetadataRecord;
  rec : TMetadataRecord;
  idata : PBytes;
//  itc, stc : TTokenCounts;
//  tcFile : TStream;
  buffer : PBytes;
  bufsize : Integer;
  sId : Integer;
  tokensLength : Integer;
  r : IMetricResult;
begin
  Result := nil;
  
  AssignFile(mf, METADATA_FILE_NAME);
  Reset(mf);
  GetMem(idata, input.Size);
  input.Seek(0, soFromBeginning);
//  countTokens(input, itc);
  try
    bufsize := 4096;
    GetMem(buffer, bufsize);
    try
      input.Seek(0, soFromBeginning);
      input.Read(idata^, input.Size);
      try
        sId := 0;
        while not Eof(mf) do begin
          Read(mf, rec);
          if rec.authorId <> authorId then begin

            tokensLength := GetTokenData(buffer, bufsize, sId);
{            tcFile := nil;
            try
              tcFile := TFileStream.Create(GetTokenCountsFileName(sId), fmOpenRead or fmShareDenyWrite);
//              tcFile.Read(stc, sizeOf(stc));
            finally
              tcFile.Free;
            end;}

            r := metric.calculate(idata, input.Size, buffer, tokensLength);

            if (Result = nil) or metric.isMoreClose(r.AbsoluteValue, Result.AbsoluteValue) then begin
              Result := r;
              entry.id := sId;
              entry.data := rec;
            end;

          end;
          inc(sId);
        end;
      finally
        CloseFile(mf);
      end;
    finally
      FreeMem(buffer);
    end;
  finally
    FreeMem(idata);
  end;
end;

procedure EnsureDataExists;
begin
  CreateDir(DATA_DIR);
  if not FileExists(METADATA_FILE_NAME) then
    TFileStream.Create(METADATA_FILE_NAME, fmCreate).Free;
end;

end.
