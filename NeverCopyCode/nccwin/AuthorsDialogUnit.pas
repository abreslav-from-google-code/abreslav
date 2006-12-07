unit AuthorsDialogUnit;

interface

uses
  Windows, Messages, SysUtils, Classes, Graphics, Controls, Forms, Dialogs,
  StdCtrls, UsersUnit;

const
  CANCEL = -1;
  SKIP = -2;
  ALL = -3;

type
  TAuthorsDialog = class(TForm)
    Label1: TLabel;
    FilterED: TEdit;
    UsersLB: TListBox;
    OKBtn: TButton;
    Button2: TButton;
    Button1: TButton;
    AllBtn: TButton;
    procedure UsersLBClick(Sender: TObject);
    procedure FilterEDChange(Sender: TObject);
    procedure UsersLBDblClick(Sender: TObject);
  private
    FAll: Boolean;
  public
    procedure LoadUsers(uf : TUserFile);
    function GetAuthorId : Integer;
    property All : Boolean read FAll write FAll;
  end;

var
  AuthorsDialog: TAuthorsDialog;

implementation

{$R *.DFM}

{ TAuthorsDialog }

function TAuthorsDialog.GetAuthorId: Integer;
var
  r : TModalResult;
begin
  All := false;
  r := ShowModal;
  case r of
    mrAll,
    mrOk : Result := Integer(UsersLB.Items.Objects[UsersLB.ItemIndex]);
    mrIgnore : Result := SKIP;
    else Result := CANCEL;
  end;
  if r = mrAll then
    All := true;
end;

procedure TAuthorsDialog.LoadUsers(uf: TUserFile);
var
  i : Integer;
begin
  UsersLB.Items.BeginUpdate;
  try
    UsersLB.Clear;
    for i := 0 to uf.Size - 1 do begin
      UsersLB.Items.AddObject(uf.UserNames[i], TObject(i));
    end;
    UsersLB.Sorted := true;
  finally
    UsersLB.Items.EndUpdate;
  end;
end;

procedure TAuthorsDialog.UsersLBClick(Sender: TObject);
begin
  OkBtn.Enabled := UsersLB.ItemIndex >= 0;
  AllBtn.Enabled := OkBtn.Enabled;
end;

procedure TAuthorsDialog.FilterEDChange(Sender: TObject);
var
  l, i : Integer;
  s : String;
begin
  s := AnsiLowerCase(FilterED.Text);
  l := Length(s);
  if l <> 0 then
    for i := 0 to UsersLB.Items.Count - 1 do begin
      if AnsiLowerCase(Copy(UsersLB.Items[i], 1, l)) = s then begin
        UsersLB.ItemIndex := i;
        break;
      end;
    end;
end;

procedure TAuthorsDialog.UsersLBDblClick(Sender: TObject);
begin
  OkBtn.Click;
end;

end.
