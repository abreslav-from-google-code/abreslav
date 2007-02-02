unit SourceFile;

interface

uses
  ComCtrls, DataCommons, UsersUnit, Classes, AdvancedMetrics, MetricUnit;

type
  TSourceFileStrategy = class;
  TSourceFileState = (fsNone, fsMatchUnderThreshold, fsCloseMatch, fsAdded, fsForcedAdded);
  TSourceFile = class
  private
    FItem : TListItem;
    FAuthorId: Integer;
    FPath: String;
    FAuthorName: String;
    FState: TSourceFileState;
    FClosestMatch : TMetadataEntry;
    FTokens : TStream;
    FPascal : TStream;
    FMatch : IMetricResult;
    FThreshold: Integer;
    FUserFile : TUserFile;
    procedure SetState(s : TSourceFileState);
    function GetClosestMatch: TMetadataEntry;
    function GetNormalizedMatch: Integer;
    procedure SetThreshold(const Value: Integer);
    procedure CalcMatchState;
    procedure Add;
  public
    constructor Create(authorId : Integer; uf : TUserFile; path : String; threshold : Integer; li : TListItem);
    destructor Destroy; override;
    procedure TryToAdd;
    procedure ForceAdd;
    procedure FindMatch(force : Boolean = false);
    procedure Accept(strategy : TSourceFileStrategy);

    property Path : String read FPath;
    property AuthorId : Integer read FAuthorId;
    property AuthorName : String read FAuthorName;
    property Item : TListItem read FItem;
    property State : TSourceFileState read FState;
    property ClosestMatch : TMetadataEntry read GetClosestMatch;
    property NormalizedMatch : Integer read GetNormalizedMatch;
    property Threshold : Integer read FThreshold write SetThreshold;
  end;
  TSourceFileStrategy = class
  public
    procedure perform(sf : TSourceFile); virtual; abstract;
  end;
  TTryToAddStrategy = class(TSourceFileStrategy)
  public
    procedure perform(sf : TSourceFile); override;
  end;
  TForceAddStrategy = class(TSourceFileStrategy)
  public
    procedure perform(sf : TSourceFile); override;
  end;
  TFindMatchStrategy = class(TSourceFileStrategy)
  public
    procedure perform(sf : TSourceFile); override;
  end;
  TForceFindMatchStrategy = class(TSourceFileStrategy)
  public
    procedure perform(sf : TSourceFile); override;
  end;

implementation

uses
  SysUtils, PascalLexer, Dialogs;

const
  AUTHOR_NAME = 1;
  STATUS = 1;
  MATCH_VALUE = 2;
  SAMPLE_AUTHOR = 3;
  FILE_NAME = 4;
  DATE = 5;
var
  METRIC : TMetric = nil;

{ TSourceFile }

constructor TSourceFile.Create(authorId : Integer; uf : TUserFile; path : String; threshold : Integer; li : TListItem);
var
  temp : TStream;
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
  FPascal := TMemoryStream.Create;
  FTokens := TMemoryStream.Create;
  temp := nil;
  try
    temp := TFileStream.Create(path, fmOpenRead or fmShareDenyWrite);
    FPascal.CopyFrom(temp, temp.Size);
    FPascal.Size := FPascal.Size;
  finally
    temp.Free;
  end;
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
  Add;
  SetState(fsForcedAdded);
end;

procedure TSourceFile.TryToAdd;
begin
  FindMatch;
  if State in [fsCloseMatch, fsForcedAdded, fsAdded] then
    Exit;
  Add;
  SetState(fsAdded);
end;

procedure TSourceFile.FindMatch(force : Boolean = false);
begin
  if (FState <> fsNone) and (not force) then
    Exit;
  if FTokens.Size = 0 then begin
    FPascal.Seek(0, soFromBeginning);
    tokenize(FPascal, FTokens);
  end;
  FMatch := FindClosestMatching(FTokens, AuthorId, METRIC, FClosestMatch, Threshold, 1.85);
  CalcMatchState;
  FItem.SubItems[SAMPLE_AUTHOR] := FUserFile.UserNames[FClosestMatch.data.authorId];
  FItem.SubItems[FILE_NAME] := FClosestMatch.data.fileName;
  FItem.SubItems[DATE] := DateTimeToStr(FClosestMatch.data.lastWrite);
end;

function TSourceFile.GetClosestMatch: TMetadataEntry;
begin
  FindMatch;
  Result := FClosestMatch;
end;

function TSourceFile.GetNormalizedMatch: Integer;
begin
  if FMatch = nil then
    Result := 0
  else
    Result := FMatch.NormalizedValue;
end;

procedure TSourceFile.SetThreshold(const Value: Integer);
begin
  FThreshold := Value;
  CalcMatchState;
end;

procedure TSourceFile.CalcMatchState;
begin
  if State in [fsAdded, fsForcedAdded] then begin
    Item.Update;
    Exit;
  end;
  if NormalizedMatch < FThreshold then
    SetState(fsMatchUnderThreshold)
  else SetState(fsCloseMatch);
end;

procedure TSourceFile.Accept(strategy: TSourceFileStrategy);
begin
  strategy.perform(Self);
end;

procedure TSourceFile.Add;
var
  metadata : TMetadataRecord;
begin
  metadata.authorId := FAuthorId;
  metadata.lastWrite := Now;
  metadata.fileName := FPath;
  AddSample(metadata, FPascal, FTokens);
end;

destructor TSourceFile.Destroy;
begin
  inherited;
  FPascal.Free;
  FTokens.Free;
end;

{ TTryToAddStrategy }

procedure TTryToAddStrategy.perform(sf: TSourceFile);
begin
  sf.TryToAdd;
end;

{ TForceAddStrategy }

procedure TForceAddStrategy.perform(sf: TSourceFile);
begin
  sf.ForceAdd;
end;

{ TFindMatchStrategy }

procedure TFindMatchStrategy.perform(sf: TSourceFile);
begin
  sf.FindMatch;
end;

{ TForceFindMatchStrategy }

procedure TForceFindMatchStrategy.perform(sf: TSourceFile);
begin
  sf.FindMatch(true);
end;

initialization
  METRIC := TEditDistanceMetric.INSTANCE;
end.
