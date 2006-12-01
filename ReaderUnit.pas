unit ReaderUnit;

interface

uses
  Windows, Messages, SysUtils, Classes, Graphics, Controls, Forms, Dialogs,
  StdCtrls;

type
  TReaderForm = class(TForm)
    reader: TEdit;
    procedure FormKeyDown(Sender: TObject; var Key: Word;
      Shift: TShiftState);
    procedure FormKeyPress(Sender: TObject; var Key: Char);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

function RRead(X, Y, W, H : Integer; Font : TFont; Color : TColor; Border : Boolean; var S : String) : Boolean; overload;
function RRead(X, Y, W, H : Integer; Font : TFont; Color : TColor; Border : Boolean; var I : Integer) : Boolean; overload;
function RRead(X, Y, W, H : Integer; Font : TFont; Color : TColor; Border : Boolean; var D : Double) : Boolean; overload;
function RRead(X, Y, W, H : Integer; Font : TFont; Color : TColor; Border : Boolean; var R : Real) : Boolean; overload;

implementation

uses
  DelphiGraph;

{$R *.DFM}

var
  ReaderForm: TReaderForm;

function RRead(X, Y, W, H : Integer; Font : TFont; Color : TColor; Border : Boolean; var S : String) : Boolean; overload;
begin
  if ReaderForm = nil then
    ReaderForm := TReaderForm.Create(nil);
  ReaderForm.Left := X;
  ReaderForm.Top := Y;
  if Border then
    ReaderForm.BorderWidth := 1
  else ReaderForm.BorderWidth := 0;
  ReaderForm.reader.Width := W;
  ReaderForm.reader.Height := H;
  ReaderForm.reader.text := S;
  ReaderForm.reader.Color := Color;
  ReaderForm.reader.Font.Assign(Font);
  ReaderForm.Height := ReaderForm.reader.Height;
  ReaderForm.Width := ReaderForm.reader.Width;
  ReaderForm.reader.SelectAll;
  Result := ReaderForm.ShowModal = mrOk;
  if Result then
    S := ReaderForm.reader.text;
end;

function RRead(X, Y, W, H : Integer; Font : TFont; Color : TColor; Border : Boolean; var I : Integer) : Boolean; overload;
var
  S : String;
begin
  S := IntToStr(I);
  Result := RRead(X, Y, W, H, Font, Color, Border, S);
  try
    I := StrToInt(S);
  except
    Result := true;
  end;
end;

function RRead(X, Y, W, H : Integer; Font : TFont; Color : TColor; Border : Boolean; var R : Real) : Boolean; overload;
var
  d : Double;
begin
  d := R;
  Result := RRead(X, Y, W, H, Font, Color, Border, r);
  R := d;
end;

function RRead(X, Y, W, H : Integer; Font : TFont; Color : TColor; Border : Boolean; var D : Double) : Boolean; overload;
var
  S : String;
begin
  S := FloatToStr(D);
  Result := RRead(X, Y, W, H, Font, Color, Border, S);
  try
    D := StrToFloat(S);
  except
    Result := true;
  end;
end;

procedure TReaderForm.FormKeyDown(Sender: TObject; var Key: Word;
  Shift: TShiftState);
begin
  case Key of
    VK_RETURN : begin
      ModalResult := mrOk;
    end;
    VK_ESCAPE : begin
      ModalResult := mrCancel;
    end;
    VK_F4 : Key := VK_SHIFT;
  end;
end;

procedure TReaderForm.FormKeyPress(Sender: TObject; var Key: Char);
begin
  if Key in [#13, chr(VK_ESCAPE)] then
    Key := #0;
end;

end.
