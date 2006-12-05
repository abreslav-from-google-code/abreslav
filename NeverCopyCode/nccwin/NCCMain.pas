unit NCCMain;

interface

uses
  Windows, Messages, SysUtils, Classes, Graphics, Controls, Forms, Dialogs,
  StdCtrls, DragDrop, DropTarget, DragDropFile, ExtCtrls;

type
  TMainForm = class(TForm)
    DropFileTarget: TDropFileTarget;
    pnBottom: TPanel;
    procedure FormCreate(Sender: TObject);
    procedure DropFileTargetDrop(Sender: TObject; ShiftState: TShiftState;
      APoint: TPoint; var Effect: Integer);
  private
  public
  end;

var
  MainForm: TMainForm;

implementation

uses
  ShellAPI;

{$R *.DFM}

procedure TMainForm.FormCreate(Sender: TObject);
begin
  DropFileTarget.Target := Self;
end;

procedure TMainForm.DropFileTargetDrop(Sender: TObject;
  ShiftState: TShiftState; APoint: TPoint; var Effect: Integer);
begin
  ShowMessage(DropFileTarget.Files[0]);
end;

end.
