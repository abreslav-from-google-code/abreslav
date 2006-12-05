unit UsersUnit;

interface

uses
  Classes, DataCommons;

const
  USER_NAME_LENGTH = 100;
  USERS_FILE = DATA_DIR + '\' + '.users';

type
  TUserName = String[USER_NAME_LENGTH];
  TUserData = packed record
    name : TUserName;
  end;
  PUserData = ^TUserData;
  TUserFile = class(TObject)
  private
    myFile : file of TUserData;
    myCache : TList;
    function GetSize: Integer;
    function GetUserNames(Index: Integer): TUserName;
    procedure SetUserNames(Index: Integer; const Value: TUserName);

    procedure CheckBounds(Index : Integer);
    function ReadFromFile(Index : Integer) : String;
    procedure WriteToFile(Index : Integer; Value : String);
  public
    constructor Create(fileName : String);
    destructor Destroy; override;

    function AddUser(name : String) : Integer;
    function IndexOf(name : String) : Integer;

    property Size : Integer read GetSize;
    property UserNames[Index : Integer] : TUserName read GetUserNames write SetUserNames;
  end;

implementation

uses
  SysUtils;

{ TUserFile }

function TUserFile.AddUser(name: String): Integer;
begin
  Result := IndexOf(name);
  if Result >= 0 then
    Exit;
  WriteToFile(Size, name);
  myCache.Count := Size;
  Result := Size - 1;
end;

procedure TUserFile.CheckBounds(Index : Integer);
begin
  if (Index < 0) or (Index >= Size) then
    raise Exception.Create('No such user');
end;

constructor TUserFile.Create(fileName: String);
begin
  AssignFile(myFile, fileName);
  Reset(myFile);
  myCache := TList.Create;
  myCache.Count := Size;
end;

destructor TUserFile.Destroy;
var
  i : Integer;
begin
  inherited;
  CloseFile(myFile);
  for i := 0 to myCache.Count - 1 do
    if myCache[i] <> nil then
      Dispose(myCache[i]);
  myCache.Free;
end;

function TUserFile.GetSize: Integer;
begin
  Result := FileSize(myFile);
end;

function TUserFile.GetUserNames(Index: Integer): TUserName;
var
  pud : PUserData;
begin
  CheckBounds(Index);
  if myCache[Index] = nil then begin
    Result := ReadFromFile(Index);
    New(pud);
    pud.name := Result;
    myCache[Index] := pud;
  end else Result := PUserData(myCache[Index])^.name;
end;

function TUserFile.IndexOf(name: String): Integer;
var
  i : Integer;
begin
  for i := 0 to Size - 1 do
    if name = UserNames[i] then begin
      Result := i;
      Exit;
    end;
  Result := -1;
end;

function TUserFile.ReadFromFile(Index: Integer): String;
var
  data : TUserData;
begin
  CheckBounds(Index);
  Seek(myFile, Index);
  Read(myFile, data);
  Result := data.name;
end;

procedure TUserFile.SetUserNames(Index: Integer; const Value: TUserName);
begin
  CheckBounds(Index);
  WriteToFile(Index, Value);
  if myCache[Index] <> nil then begin
    PUserData(myCache[Index]).name := Value;
  end;
end;

procedure TUserFile.WriteToFile(Index: Integer; Value: String);
var
  data : TUserData;
begin
  Seek(myFile, Index);
  data.name := Value;
  Write(myFile, data);
end;

end.
