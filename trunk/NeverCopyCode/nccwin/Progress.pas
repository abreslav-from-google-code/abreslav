unit Progress;

interface

uses
  Windows, Messages, SysUtils, Classes, Graphics, Controls, Forms, Dialogs,
  StdCtrls, ComCtrls;

type
  TProgressForm = class(TForm)
    ProgressBar: TProgressBar;
    CurrentFileST: TStaticText;
    CancelBtn: TButton;
    procedure CancelBtnClick(Sender: TObject);
  private
    { Private declarations }
    FCancelled : Boolean;
  public
    procedure Show(FileCount : Integer);
    procedure StartFile(fileName : String);
    procedure SetCount(FileCount : Integer);
    property Cancelled : Boolean read FCancelled;
  end;

var
  ProgressForm: TProgressForm;

implementation

{$R *.DFM}

{ TProgressForm }

procedure TProgressForm.Show(FileCount: Integer);
begin
  FCancelled := false;
  SetCount(FileCount);
  inherited Show;
  Update;
end;

procedure TProgressForm.StartFile(fileName: String);
begin
  CurrentFileST.Caption := fileName;
  CurrentFileST.Update;
  ProgressBar.Position := ProgressBar.Position + 1;
  ProgressBar.Update;
end;

procedure TProgressForm.CancelBtnClick(Sender: TObject);
begin
  FCancelled := true;
end;

procedure TProgressForm.SetCount(FileCount: Integer);
begin
  ProgressBar.Max := FileCount;
  ProgressBar.Update;
end;

end.
