unit Serializable;

interface

uses
  Dialogs, SysUtils, typinfo, Classes;

type
  TSerializable = class(TObject)
  private
    Props : array[0..1000] of PPropInfo;
    Count : Integer;
    TInfo : PTypeInfo;
    function GetInfo(Name : String) : PPropInfo;
  public
    constructor Create(ti : PTypeInfo);
    procedure SaveToStrings(SL : TStrings);
    procedure LoadFromStrings(SL : TStrings);
    procedure SaveToFile(FName : String);
    procedure LoadFromFile(FName : String);
  end;

implementation

{ TSerializable }

constructor TSerializable.Create(ti: PTypeInfo);
begin
  if ti.Kind <> tkClass then
    raise Exception.Create('Class type required');
  Count := GetPropList(ti, [tkFloat, tkLString, tkInteger, tkWString, tkString, tkEnumeration], @Props);
  TInfo := ti;
end;

function TSerializable.GetInfo(Name: String): PPropInfo;
var
  i : Integer;
begin
  Result := nil;
  for i := 0 to Count - 1 do
    if Props[i].Name = Name then begin
      Result := Props[i];
      Exit;
    end;
end;

procedure TSerializable.LoadFromFile(FName: String);
var
  SL : TStringList;
begin
  SL := TStringList.Create;
  try
    SL.LoadFromFile(FName);
    LoadFromStrings(SL);
  except

  end;
  SL.Free;
end;

procedure TSerializable.SaveToStrings(SL: TStrings);
var
  i : Integer;
begin
  if Self.ClassName <> TInfo.Name then
    raise Exception.Create('Wrong class');
  SL.Clear;
  for i := 0 to Count - 1 do
    case Props[i].PropType^.Kind of
      tkInteger: SL.Add(Format('%s=%d', [Props[i].Name, GetOrdProp(Self, Props[i])]));
      tkString, tkLString : SL.Add(Format('%s=%s', [Props[i].Name, GetStrProp(Self, Props[i])]));
      tkEnumeration: SL.Add(Format('%s=%s', [Props[i].Name, GetEnumProp(Self, Props[i])]));
      tkFloat : SL.Add(Format('%s=%s', [Props[i].Name, FloatToStr(GetFloatProp(Self, Props[i]))]));
    end;
end;

procedure TSerializable.SaveToFile(FName: String);
var
  SL : TStringList;
begin
  SL := TStringList.Create;
  try
    SaveToStrings(SL);
    SL.SaveToFile(FName);
  except

  end;
  SL.Free;
end;

procedure TSerializable.LoadFromStrings(SL: TStrings);
var
  i : Integer;
  p : PPropInfo;
begin
  if Self.ClassName <> TInfo.Name then
    raise Exception.Create('Wrong class');
  for i := 0 to SL.Count - 1 do begin
    p := GetInfo(SL.Names[i]);
    if p = nil then
      continue;
    try
      case p.PropType^.Kind of
        tkInteger: SetOrdProp(Self, p, StrToInt(SL.Values[SL.Names[i]]));
        tkString,
        tkLString : SetStrProp(Self, p, SL.Values[SL.Names[i]]);
        tkEnumeration: SetEnumProp(Self, p, SL.Values[SL.Names[i]]);
        tkFloat : SetFloatProp(Self, p, StrToFloat(SL.Values[SL.Names[i]]));
      end;
    except

    end;
  end;
end;


end.
