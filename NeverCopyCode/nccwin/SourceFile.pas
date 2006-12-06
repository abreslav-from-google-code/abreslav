unit SourceFile;

interface

uses
  ComCtrls, DataCommons, UsersUnit;

type
  TSourceFileState = (fsNone, fsMatchUnderThreshold, fsCloseMatch, fsAdded, fsForcedAdded);
  TSourceFile = class
  private
    FItem : TListItem;
    FAuthorId: Integer;
    FPath: String;
    FAuthorName: String;
    FState: TSourceFileState;
    FClosestMatch : TMetadataEntry;
    FMatch : Integer;
    FThreshold: Integer;
    FUserFile : TUserFile;
    procedure SetState(s : TSourceFileState);
    function GetClosestMatch: TMetadataEntry;
    function GetMatch: Integer;
    procedure SetThreshold(const Value: Integer);
    procedure CalcMatchState;
  public
    constructor Create(authorId : Integer; uf : TUserFile; path : String; threshold : Integer; li : TListItem);
    procedure TryToAdd;
    procedure ForceAdd;
    procedure FindMatch;

    property Path : String read FPath;
    property AuthorId : Integer read FAuthorId;
    property AuthorName : String read FAuthorName;
    property Item : TListItem read FItem;
    property State : TSourceFileState read FState;
    property ClosestMatch : TMetadataEntry read GetClosestMatch;
    property Match : Integer read GetMatch;
    property Threshold : Integer read FThreshold write SetThreshold;
  end;

implementation

uses
  SysUtils, MetricUnit, Classes;

const
  AUTHOR_NAME = 1;
  STATUS = 1;
  MATCH_VALUE = 2;
  SAMPLE_AUTHOR = 3;
  FILE_NAME = 4;
  DATE = 5;

{ TSourceFile }

constructor TSourceFile.Create(authorId : Integer; uf : TUserFile; path : String; threshold : Integer; li : TListItem);
begin
  FPath := path;
  FAuthorId := authorId;
  FThreshold := threshold;
  FUserFile := uf;
  FItem := li;
  FItem.Caption := ExtractFileName(path);
  FItem.SubItems.Add(uf.UserNames[authorId]);
  FItem.SubItems.Add('<status>');
  FItem.SubItems.Add('<match>');
  FItem.SubItems.Add('<sample author>');
  FItem.SubItems.Add('<file>');
  FItem.SubItems.Add('<date>');
  FItem.ImageIndex := 0;
  FItem.Data := Self;
  SetState(fsNone);
end;

procedure TSourceFile.SetState(s: TSourceFileState);
const
  stateNames : array[TSourceFileState] of String = (
    'Not processed', 'Under threshold', 'Close match', 'Added', 'Forced to add'
  );
begin
  FState := s;
  FItem.ImageIndex := ord(FState);
  FItem.SubItems[STATUS] := stateNames[s];
end;

procedure TSourceFile.ForceAdd;
begin
  TryToAdd;
  if State in [fsForcedAdded, fsAdded] then
    Exit;
  
  SetState(fsForcedAdded);
end;

procedure TSourceFile.TryToAdd;
begin
  FindMatch;
  if State in [fsCloseMatch, fsForcedAdded, fsAdded] then
    Exit;
  SetState(fsAdded);
end;

procedure TSourceFile.FindMatch;
var
  fs : TFileStream;
begin
  if FState <> fsNone then
    Exit;
  fs := nil;
  try
    fs := TFileStream.Create(path, fmOpenRead or fmShareDenyWrite);
    FMatch := FindClosestMatching(fs, AuthorId, editingDistanceMetric, FClosestMatch);
    CalcMatchState;
    FItem.SubItems[SAMPLE_AUTHOR] := FUserFile.UserNames[FClosestMatch.data.authorId];
    FItem.SubItems[FILE_NAME] := FClosestMatch.data.fileName;
    FItem.SubItems[DATE] := DateTimeToStr(FClosestMatch.data.lastWrite);
  finally
    fs.Free;
  end;
end;

function TSourceFile.GetClosestMatch: TMetadataEntry;
begin
  FindMatch;
  Result := FClosestMatch;
end;

function TSourceFile.GetMatch: Integer;
begin
  Result := FMatch;
end;

procedure TSourceFile.SetThreshold(const Value: Integer);
begin
  FThreshold := Value;
  CalcMatchState;
end;

procedure TSourceFile.CalcMatchState;
begin
  if State in [fsAdded, fsForcedAdded] then
    Exit;
  if FMatch < FThreshold then
    SetState(fsMatchUnderThreshold)
  else SetState(fsCloseMatch);
end;

end.
