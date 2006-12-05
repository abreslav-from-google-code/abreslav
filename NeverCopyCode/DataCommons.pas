unit DataCommons;

interface

uses
  MetricUnit, Classes;

const
  DATA_DIR = '.data';

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
function FindClosestMatching(input : TStream; authorId: Integer; metric: PMetricFunction; asc : Boolean; out entry : TMetadataEntry) : Integer;
function AddSample(const metadata : TMetadataRecord; pascalCode, tokenStream : TStream) : Integer;
 
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
  Result := GetFileName(sId) + '.dat';
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

function FindClosestMatching(input : TStream; authorId: Integer; metric: PMetricFunction; asc : Boolean; out entry : TMetadataEntry) : Integer;
var
  mf : file of TMetadataRecord;
  rec : TMetadataRecord;
  idata : PBytes;
  buffer : PBytes;
  bufsize : Integer;
  sId : Integer;
  tokensLength, m : Integer;
  b : Boolean;
  resultAssigned : Boolean;
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
        resultAssigned := false;
        sId := 0;
        while not Eof(mf) do begin
          Read(mf, rec);
          if rec.authorId <> authorId then begin

            tokensLength := GetTokenData(buffer, bufsize, sId);

            m := metric(idata, input.Size, buffer, tokensLength);

            if resultAssigned then
              if asc then
                b := Result < m
              else b := Result > m
            else b := true;
            if b then begin
              Result := m;
              entry.id := sId;
              entry.data := rec;
              resultAssigned := true;
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

end.
