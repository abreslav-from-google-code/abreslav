unit Configuration;

interface

uses
  Serializable, typinfo;

const
  CONFIG_FILE_NAME = '.config';

type
  TNCCWinConfiguration = class(TSerializable)
  private
    FFindAuthorsAutomatically: Boolean;
    FClearOnDrop: Boolean;
    FSkipFilesWhenNoAuthorFound: Boolean;
    FProcessOnDrop: Boolean;
    FProcessSubdirectories: Boolean;
    FCEArguments: String;
    FCECommandLine: String;
    FFilesToIgnore: String;
    FThreshold: Integer;
    procedure SetCEArguments(const Value: String);
    procedure SetCECommandLine(const Value: String);
    procedure SetClearOnDrop(const Value: Boolean);
    procedure SetFilesToIgnore(const Value: String);
    procedure SetFindAuthorsAutomatically(const Value: Boolean);
    procedure SetProcessOnDrop(const Value: Boolean);
    procedure SetProcessSubdirectories(const Value: Boolean);
    procedure SetSkipFilesWhenNoAuthorFound(const Value: Boolean);
    function GetSkipFilesWhenNoAuthorFound: Boolean;
    procedure SetThreshold(const Value: Integer);
  public
    constructor Create;
  published
    property Threshold : Integer read FThreshold write SetThreshold;
    property ProcessOnDrop : Boolean read FProcessOnDrop write SetProcessOnDrop;
    property ClearOnDrop : Boolean read FClearOnDrop write SetClearOnDrop;
    property ProcessSubdirectories : Boolean read FProcessSubdirectories write SetProcessSubdirectories;
    property FindAuthorsAutomatically : Boolean read FFindAuthorsAutomatically write SetFindAuthorsAutomatically;
    property SkipFilesWhenNoAuthorFound : Boolean read GetSkipFilesWhenNoAuthorFound write SetSkipFilesWhenNoAuthorFound;
    property CECommandLine : String read FCECommandLine write SetCECommandLine;
    property CEArguments : String read FCEArguments write SetCEArguments;
    property FilesToIgnore : String read FFilesToIgnore write SetFilesToIgnore;
  end;

implementation

{ TNCCWinConfiguration }

constructor TNCCWinConfiguration.Create;
begin
  inherited Create(TypeInfo(TNCCWinConfiguration));
end;

function TNCCWinConfiguration.GetSkipFilesWhenNoAuthorFound: Boolean;
begin
  Result := FSkipFilesWhenNoAuthorFound and FindAuthorsAutomatically;
end;

procedure TNCCWinConfiguration.SetCEArguments(const Value: String);
begin
  FCEArguments := Value;
end;

procedure TNCCWinConfiguration.SetCECommandLine(const Value: String);
begin
  FCECommandLine := Value;
end;

procedure TNCCWinConfiguration.SetClearOnDrop(const Value: Boolean);
begin
  FClearOnDrop := Value;
end;

procedure TNCCWinConfiguration.SetFilesToIgnore(const Value: String);
begin
  FFilesToIgnore := Value;
end;

procedure TNCCWinConfiguration.SetFindAuthorsAutomatically(
  const Value: Boolean);
begin
  FFindAuthorsAutomatically := Value;
end;

procedure TNCCWinConfiguration.SetProcessOnDrop(const Value: Boolean);
begin
  FProcessOnDrop := Value;
end;

procedure TNCCWinConfiguration.SetProcessSubdirectories(
  const Value: Boolean);
begin
  FProcessSubdirectories := Value;
end;

procedure TNCCWinConfiguration.SetSkipFilesWhenNoAuthorFound(
  const Value: Boolean);
begin
  FSkipFilesWhenNoAuthorFound := Value;
end;

procedure TNCCWinConfiguration.SetThreshold(const Value: Integer);
begin
  FThreshold := Value;
end;

end.
