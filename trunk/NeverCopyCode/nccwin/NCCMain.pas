unit NCCMain;

interface

uses
  Windows, Messages, SysUtils, Classes, Graphics, Controls, Forms, Dialogs,
  StdCtrls, DragDrop, DropTarget, DragDropFile, ExtCtrls, ComCtrls, ImgList,
  Gauges, ToolWin, UsersUnit, ActnList;

type
  TMainForm = class(TForm)
    DropFileTarget: TDropFileTarget;
    pnBottom: TPanel;
    ImageList: TImageList;
    FileList: TListView;
    ToolBar1: TToolBar;
    StatusBar: TStatusBar;
    ThresholdTB: TTrackBar;
    ActionList: TActionList;
    TryToAdd: TAction;
    ToolButton1: TToolButton;
    ForceAdd: TAction;
    Process: TAction;
    ProcessAll: TAction;
    ToolButton2: TToolButton;
    ToolButton3: TToolButton;
    ToolButton4: TToolButton;
    ToolButton5: TToolButton;
    Compare: TAction;
    ToolButton6: TToolButton;
    ToolButton7: TToolButton;
    ProcessOnDropCB: TCheckBox;
    ClearOnDropCB: TCheckBox;
    procedure FormCreate(Sender: TObject);
    procedure DropFileTargetDrop(Sender: TObject; ShiftState: TShiftState;
      APoint: TPoint; var Effect: Integer);
    procedure FormClose(Sender: TObject; var Action: TCloseAction);
    procedure FileListCustomDrawSubItem(Sender: TCustomListView;
      Item: TListItem; SubItem: Integer; State: TCustomDrawState;
      var DefaultDraw: Boolean);
    procedure ThresholdTBChange(Sender: TObject);
    procedure TryToAddExecute(Sender: TObject);
    procedure FileListSelectItem(Sender: TObject; Item: TListItem;
      Selected: Boolean);
    procedure ForceAddExecute(Sender: TObject);
    procedure ProcessExecute(Sender: TObject);
    procedure CompareExecute(Sender: TObject);
  private
    uf : TUserFile;
    buf : TBitmap;
    fList : TList;
    procedure SetStatusMessage(msg : String);
    procedure ProcessFiles(fList : TList);
    function findAuthorId(path : String) : Integer;
    procedure ClearList;
  public
  end;

var
  MainForm: TMainForm;

implementation

uses
  Utils, Progress, SourceFile, DataCommons;

{$R *.DFM}


procedure TMainForm.FormCreate(Sender: TObject);
begin
  buf := TBitmap.Create;
  buf.Width := Screen.Width;
  buf.Height := Screen.Height;
  fList := TList.Create;

  DropFileTarget.Target := Self;

  EnsureDataExists;

  uf := TUserFile.Create(USERS_FILE);
end;

procedure TMainForm.DropFileTargetDrop(Sender: TObject;
  ShiftState: TShiftState; APoint: TPoint; var Effect: Integer);
var
  i : Integer;
  lf : TSourceFile;
  ai : Integer;
begin
  if ClearOnDropCB.Checked then
    ClearList;
  for i := 0 to DropFileTarget.Files.Count - 1 do
    if CheckFileExtension(DropFileTarget.Files[i]) then begin
      ai := findAuthorId(DropFileTarget.Files[i]);
      lf := TSourceFile.Create(ai, uf, DropFileTarget.Files[i], ThresholdTB.Position, FileList.Items.Add);
      fList.Add(lf);
    end;
  SetStatusMessage(Format('%d files added', [fList.Count]));
  if ProcessOnDropCB.Checked then
    ProcessFiles(fList);
end;

procedure TMainForm.SetStatusMessage(msg: String);
begin
  StatusBar.SimpleText := msg;
end;

procedure TMainForm.ProcessFiles(fList: TList);
var
  i : Integer;
  sf : TSourceFile;
begin
  ProgressForm.Show(fList.Count);
  for i := 0 to fList.Count - 1 do begin
    sf := TSourceFile(fList[i]);
    ProgressForm.StartFile(sf.path);
    sf.FindMatch;
    Update;
    Application.ProcessMessages;
    if ProgressForm.Cancelled then
      break;
  end;
  ProgressForm.Hide;
end;

procedure TMainForm.FormClose(Sender: TObject; var Action: TCloseAction);
begin
  uf.Free;
  buf.Free;
  fList.Free;
end;

function TMainForm.findAuthorId(path: String): Integer;
begin
  Result := 0;
end;

procedure TMainForm.FileListCustomDrawSubItem(Sender: TCustomListView;
  Item: TListItem; SubItem: Integer; State: TCustomDrawState;
  var DefaultDraw: Boolean);
var
  cRect, pRect : TRect;
  i : Integer;
  S : String;
  tc : TColor;
  sf : TSourceFile;

procedure DrawText(c : TColor);
begin
  with buf.Canvas do begin
    Brush.Style := bsClear;
    Font.Color := c;
    TextOut((cRect.Left + cRect.Right - TextWidth(S)) div 2, (cRect.Top + cRect.Bottom - TextHeight(S)) div 2, S);
  end;
end;

begin
  if SubItem = 3 then begin
    cRect := Item.DisplayRect(drSelectBounds);
    for i := 0 to SubItem - 1 do
      cRect.Left := cRect.Left + Sender.Column[i].Width;
    cRect.Right := cRect.Left + Sender.Column[SubItem].Width;

    sf := TSourceFile(Item.Data);

    with buf.Canvas do begin
      if Item.Selected then begin
        Brush.Color := clHighlight;
        tc := clHighlightText;
      end else begin
        Brush.Color := clWindow;
        tc := clWindowText;
      end;
      FillRect(cRect);

      S := IntToStr(sf.Match) + '%';

      DrawText(tc);
      Sender.Canvas.CopyRect(cRect, buf.Canvas, cRect);

      pRect := cRect;
      pRect.Top := cRect.Top + 2;
      pRect.Bottom := cRect.Bottom - 3;
      pRect.Right := cRect.Left + (cRect.Right - cRect.Left + 1) * sf.Match div 100;

      if sf.Match < sf.Threshold then
        Brush.Color := clGreen
      else
        Brush.Color := clRed;
      FillRect(pRect);
      DrawText(clWindowText);
      Sender.Canvas.CopyRect(pRect, buf.Canvas, pRect);
    end;
  end;
  DefaultDraw := SubItem <> 3;
end;

procedure TMainForm.ThresholdTBChange(Sender: TObject);
var
  i : Integer;
begin
  for i := 0 to fList.Count - 1 do
    TSourceFile(fList[i]).Threshold := ThresholdTB.Position;
end;

procedure TMainForm.TryToAddExecute(Sender: TObject);
var
  i : Integer;
begin
  for i := 0 to fList.Count - 1 do
    if TSourceFile(fList[i]).Item.Selected then
      TSourceFile(fList[i]).TryToAdd;
end;

procedure TMainForm.FileListSelectItem(Sender: TObject; Item: TListItem;
  Selected: Boolean);
begin
  TryToAdd.Enabled := FileList.SelCount > 0;
  ForceAdd.Enabled := TryToAdd.Enabled;
  Process.Enabled := TryToAdd.Enabled;
  Compare.Enabled := FileList.SelCount = 1;
end;

procedure TMainForm.ForceAddExecute(Sender: TObject);
var
  i : Integer;
begin
  for i := 0 to fList.Count - 1 do
    if TSourceFile(fList[i]).Item.Selected then
      TSourceFile(fList[i]).ForceAdd;
end;

procedure TMainForm.ProcessExecute(Sender: TObject);
var
  i : Integer;
begin
  for i := 0 to fList.Count - 1 do
    if TSourceFile(fList[i]).Item.Selected then
      TSourceFile(fList[i]).FindMatch;
end;

procedure TMainForm.CompareExecute(Sender: TObject);
begin
  //
end;

procedure TMainForm.ClearList;
var
  i : Integer;
begin
  for i := 0 to fList.Count - 1 do
    TSourceFile(fList[i]).Free;
  fList.Clear;
  FileList.Items.Clear;
end;

end.


