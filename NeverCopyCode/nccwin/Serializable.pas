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
    procedure ObjectToStringList(o : TObject; SL : TStrings);
    procedure StringListToObject(o : TObject; SL : TStrings);
    procedure SaveToFile(o : TObject; FName : String);
    procedure LoadFromFile(o : TObject; FName : String);
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

procedure TSerializable.LoadFromFile(o : TObject; FName: String);
var
  SL : TStringList;
begin
  SL := TStringList.Create;
  try
    SL.LoadFromFile(FName);
    StringListToObject(o, SL);
  except

  end;
  SL.Free;
end;

procedure TSerializable.ObjectToStringList(o: TObject; SL: TStrings);
var
  i : Integer;
begin
  if o.ClassName <> TInfo.Name then
    raise Exception.Create('Wrong class');
  SL.Clear;
  for i := 0 to Count - 1 do
    case Props[i].PropType^.Kind of
      tkInteger: SL.Add(Format('%s=%d', [Props[i].Name, GetOrdProp(o, Props[i])]));
      tkString, tkLString : SL.Add(Format('%s=%s', [Props[i].Name, GetStrProp(o, Props[i])]));
      tkEnumeration: SL.Add(Format('%s=%s', [Props[i].Name, GetEnumProp(o, Props[i])]));
      tkFloat : SL.Add(Format('%s=%s', [Props[i].Name, FloatToStr(GetFloatProp(o, Props[i]))]));
    end;
end;

procedure TSerializable.SaveToFile(o : TObject; FName: String);
var
  SL : TStringList;
begin
  SL := TStringList.Create;
  try
    ObjectToStringList(o, SL);
    SL.SaveToFile(FName);
  except

  end;
  SL.Free;
end;

procedure TSerializable.StringListToObject(o: TObject; SL: TStrings);
var
  i : Integer;
  p : PPropInfo;
begin
  if o.ClassName <> TInfo.Name then
    raise Exception.Create('Wrong class');
  for i := 0 to SL.Count - 1 do begin
    p := GetInfo(SL.Names[i]);
    if p = nil then
      continue;
    try
      case p.PropType^.Kind of
        tkInteger: SetOrdProp(o, p, StrToInt(SL.Values[SL.Names[i]]));
        tkString,
        tkLString : SetStrProp(o, p, SL.Values[SL.Names[i]]);
        tkEnumeration: SetEnumProp(o, p, SL.Values[SL.Names[i]]);
        tkFloat : SetFloatProp(o, p, StrToFloat(SL.Values[SL.Names[i]]));
      end;
    except

    end;
  end;
end;


end.
