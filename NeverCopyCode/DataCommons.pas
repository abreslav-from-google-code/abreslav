unit DataCommons;

interface

uses
  MetricUnit, Classes;

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
   if asc is true => the bigger is metric value the closer is match
   negative result means empty database
}
function FindClosestMatching(input : TStream; authorId: Integer; metric: PMetricFunction; out entry : TMetadataEntry) : Integer;
function AddSample(const metadata : TMetadataRecord; pascalCode, tokenStream : TStream) : Integer;
procedure EnsureDataExists;
function GetPascalFileName(sId : Integer) : String;
function GetTokenFileName(sId : Integer) : String;

implementation

uses
  SysUtils;

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
  mf : file of TMetadataRecord;
  pasFile, tokenFile : TFileStream;
begin
  AssignFile(mf, METADATA_FILE_NAME);
  Reset(mf);
  pasFile := nil;
  tokenFile := nil;
  try
    Result := FileSize(mf);
    pasFile := TFileStream.Create(GetPascalFileName(Result), fmCreate);
    pascalCode.Seek(0, soFromBeginning);
    pasFile.CopyFrom(pascalCode, pascalCode.Size);
    tokenFile := TFileStream.Create(GetTokenFileName(Result), fmCreate);
    tokenStream.Seek(0, soFromBeginning);
    tokenFile.CopyFrom(tokenStream, tokenStream.Size);
    Seek(mf, Result);
    Write(mf, metadata);
  finally
    pasFile.Free;
    tokenFile.Free;
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

function FindClosestMatching(input : TStream; authorId: Integer; metric: PMetricFunction; out entry : TMetadataEntry) : Integer;
var
  mf : file of TMetadataRecord;
  rec : TMetadataRecord;
  idata : PBytes;
  buffer : PBytes;
  bufsize : Integer;
  sId : Integer;
  tokensLength, m : Integer;
begin
  Result := -1;
  AssignFile(mf, METADATA_FILE_NAME);
  Reset(mf);
  GetMem(idata, input.Size);
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

            m := metric(idata, input.Size, buffer, tokensLength);
            if Result < m then begin
              Result := m;
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
