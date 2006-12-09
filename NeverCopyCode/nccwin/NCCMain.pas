unit NCCMain;

interface

uses
  Windows, Messages, SysUtils, Classes, Graphics, Controls, Forms, Dialogs,
  StdCtrls, DragDrop, DropTarget, DragDropFile, ExtCtrls, ComCtrls, ImgList,
  Gauges, ToolWin, UsersUnit, ActnList, SourceFile, Menus;

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
    ToolButton2: TToolButton;
    ToolButton3: TToolButton;
    ToolButton4: TToolButton;
    Compare: TAction;
    ToolButton6: TToolButton;
    ToolButton7: TToolButton;
    ProcessOnDropCB: TCheckBox;
    ClearOnDropCB: TCheckBox;
    Remove: TAction;
    ToolButton8: TToolButton;
    Reprocess: TAction;
    ToolButton9: TToolButton;
    ToolButton5: TToolButton;
    SelectAll: TAction;
    ToolButton10: TToolButton;
    MainMenu1: TMainMenu;
    File1: TMenuItem;
    Edit1: TMenuItem;
    Help1: TMenuItem;
    Exit1: TMenuItem;
    Selectall1: TMenuItem;
    About1: TMenuItem;
    PopupMenu: TPopupMenu;
    Comparewithbestmatch1: TMenuItem;
    N1: TMenuItem;
    Trytoadd1: TMenuItem;
    Forceadd1: TMenuItem;
    Process1: TMenuItem;
    Reprocessall1: TMenuItem;
    N2: TMenuItem;
    Remove1: TMenuItem;
    Remove2: TMenuItem;
    N3: TMenuItem;
    N4: TMenuItem;
    Process2: TMenuItem;
    Reprocess1: TMenuItem;
    Trytoadd2: TMenuItem;
    Forceadd2: TMenuItem;
    N5: TMenuItem;
    Comparewithbestmatch2: TMenuItem;
    ProcessSubdirsCB: TCheckBox;
    FindAuthorsAutoCB: TCheckBox;
    SkipNoAuthorCB: TCheckBox;
    Button1: TButton;
    CompareEditorCLPathED: TEdit;
    Label1: TLabel;
    CompareEditorCLArgsED: TEdit;
    IgnoreED: TEdit;
    Label2: TLabel;
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
    procedure RemoveExecute(Sender: TObject);
    procedure ProcessAllExecute(Sender: TObject);
    procedure ReprocessExecute(Sender: TObject);
    procedure SelectAllExecute(Sender: TObject);
    procedure Exit1Click(Sender: TObject);
    procedure FileListInfoTip(Sender: TObject; Item: TListItem;
      var InfoTip: String);
    procedure FormShow(Sender: TObject);
    procedure FindAuthorsAutoCBClick(Sender: TObject);
    procedure Button1Click(Sender: TObject);
    procedure FileListEnter(Sender: TObject);
    procedure FileListClick(Sender: TObject);
    procedure FileListContextPopup(Sender: TObject; MousePos: TPoint;
      var Handled: Boolean);
    procedure FileListDblClick(Sender: TObject);
    procedure About1Click(Sender: TObject);
  private
    uf : TUserFile;
    buf : TBitmap;
    fList : TList;
    usermap : TStringList;
    TryToAddStrategy : TTryToAddStrategy;
    ForceAddStrategy : TForceAddStrategy;
    ProcessStrategy : TFindMatchStrategy;
    ReProcessStrategy : TForceFindMatchStrategy;
    procedure ClearList;
    procedure SetStatusMessage(msg : String);
    procedure SetStatusFile(fname : String);
    procedure SetStatusTh(th : Integer);
    procedure ApplyStrategy(str: TSourceFileStrategy; SelectedOnly : Boolean = true);
    function findAuthorId(path : String) : Integer;
    function AddFiles(processSubdirs : Boolean) : Integer;
    procedure LoadUsermap;
    function SkipNoAuthor : Boolean;
    procedure CalcCompareEnabled;
  public
  end;

var
  MainForm: TMainForm;

implementation

uses
  Utils, Progress, DataCommons, FileCtrl, AuthorsDialogUnit, ShellAPI;

{$R *.DFM}


procedure TMainForm.FormCreate(Sender: TObject);
begin
  buf := TBitmap.Create;
  buf.Width := Screen.Width;
  buf.Height := Screen.Height;
  fList := TList.Create;

  usermap := TStringList.Create;
  LoadUsermap;

  TryToAddStrategy := TTryToAddStrategy.Create;
  ForceAddStrategy := TForceAddStrategy.Create;
  ProcessStrategy := TFindMatchStrategy.Create;
  ReProcessStrategy := TForceFindMatchStrategy.Create;
  
  DropFileTarget.Target := Self;

  EnsureDataExists;

  uf := TUserFile.Create(USERS_FILE);
  SetStatusTh(ThresholdTB.Position);
end;

procedure TMainForm.DropFileTargetDrop(Sender: TObject;
  ShiftState: TShiftState; APoint: TPoint; var Effect: Integer);
var
  count : Integer;
begin
  if ClearOnDropCB.Checked then
    ClearList;
  count := AddFiles(ProcessSubdirsCB.Checked);
  SetStatusMessage(Format('%d files added', [count]));
  if ProcessOnDropCB.Checked then begin
    SelectAll.Execute;
    Process.Execute;
  end;
end;

procedure TMainForm.SetStatusMessage(msg: String);
begin
  StatusBar.Panels[0].Text := msg;
end;

procedure TMainForm.ApplyStrategy(str: TSourceFileStrategy; SelectedOnly : Boolean = true);
var
  i : Integer;
  sf : TSourceFile;
begin
  ProgressForm.Show(fList.Count);
  for i := 0 to fList.Count - 1 do begin
    sf := TSourceFile(fList[i]);
    if SelectedOnly and not sf.Item.Selected then
      continue;
    ProgressForm.StartFile(sf.path);
    sf.Accept(str);
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
  usermap.Free;
end;

function TMainForm.findAuthorId(path: String): Integer;
var
  i : Integer;
  name : String;
begin
  name := '';
  for i := 0 to usermap.Count - 1 do begin
    if pos(usermap.Values[usermap.Names[i]], path) > 0 then begin
      name := usermap.Names[i];
      break;
    end;
  end;
  Result := uf.IndexOf(name);
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
        if Sender.Focused then begin
          Brush.Color := clHighlight;
          tc := clHighlightText;
        end else begin
          Brush.Color := clInactiveBorder;
          tc := clWindowText;
        end;
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
  SetStatusTh(ThresholdTB.Position);
end;

procedure TMainForm.FileListSelectItem(Sender: TObject; Item: TListItem;
  Selected: Boolean);
var
  sf : TSourceFile;
begin
  TryToAdd.Enabled := FileList.SelCount > 0;
  ForceAdd.Enabled := TryToAdd.Enabled;
  Process.Enabled := TryToAdd.Enabled;
  ReProcess.Enabled := TryToAdd.Enabled;
  Remove.Enabled := TryToAdd.Enabled;
  CalcCompareEnabled;
  if FileList.SelCount = 1 then begin
    sf := TSourceFile(FileList.Selected.Data);
    if sf.State = fsNone then
      SetStatusFile(sf.Path)
    else SetStatusFile('Closest match: ' + sf.ClosestMatch.data.fileName);
  end else SetStatusFile(Format('%d files selected', [FileList.SelCount]));
end;

procedure TMainForm.TryToAddExecute(Sender: TObject);
begin
  ApplyStrategy(TryToAddStrategy);
end;

procedure TMainForm.ForceAddExecute(Sender: TObject);
begin
  ApplyStrategy(ForceAddStrategy);
end;

procedure TMainForm.ProcessExecute(Sender: TObject);
begin
  ApplyStrategy(ProcessStrategy);
end;

procedure TMainForm.CompareExecute(Sender: TObject);
const
  THIS_STR = ':this:';
  SAMPLE_STR = ':sample:';

procedure replace(const pat : String; var dest : String; const repl : String);
var
  p : Integer;
begin
  p := pos(pat, dest);
  if p > 0 then begin
    Delete(dest, p, length(pat));
    Insert(repl, dest, p);
  end;
end;

var
  params : String;
  sf : TSourceFile;
begin
  sf := TSourceFile(FileList.ItemFocused.Data);
  params := CompareEditorCLArgsED.Text;
  replace(THIS_STR, params, sf.Path);
  replace(SAMPLE_STR, params, GetCurrentDir + '\' + GetPascalFileName(sf.ClosestMatch.id));
  ShellExecute(0, 'open',
     PChar(CompareEditorCLPathED.Text),
     PChar(params),
     PChar(ExtractFilePath(CompareEditorCLPathED.Text)),
     SW_SHOWNORMAL);
end;

procedure TMainForm.RemoveExecute(Sender: TObject);
var
  i : Integer;
  sf : TSourceFile;
  all : Boolean;
begin
  all := false;
  for i := fList.Count - 1 downto 0 do begin
    sf := TSourceFile(fList[i]);
    if sf.Item.Selected then begin
      if not (sf.State in [fsAdded, fsCloseMatch]) and not all then
        case MessageDlg('The file'#13#10 + sf.path + #13#10'is not added. Do you want to remove it?',
           mtConfirmation, [mbYes, mbAll, mbNo, mbCancel], -1) of
          mrNo : continue;
          mrCancel : break;
          mrAll : all := true;
        end;
      FileList.Items.Delete(sf.Item.Index);
      sf.Free;
      fList.Delete(i);
    end;
  end;
end;

procedure TMainForm.ProcessAllExecute(Sender: TObject);
begin
  ApplyStrategy(ProcessStrategy, false);
end;

procedure TMainForm.ReprocessExecute(Sender: TObject);
begin
  ApplyStrategy(ReProcessStrategy);
end;

procedure TMainForm.ClearList;
begin
  SelectAll.Execute;
  Remove.Execute;
end;

procedure TMainForm.SelectAllExecute(Sender: TObject);
var
  i : Integer;
begin
  for i := 0 to FileList.Items.Count - 1 do
    FileList.Items[i].Selected := true;
end;

procedure TMainForm.Exit1Click(Sender: TObject);
begin
  Close;
end;

procedure TMainForm.SetStatusFile(fname: String);
begin
  StatusBar.Panels[2].Text := fname;
end;

procedure TMainForm.FileListInfoTip(Sender: TObject; Item: TListItem;
  var InfoTip: String);
begin
  InfoTip := TSourceFile(Item.Data).Path;
end;

procedure TMainForm.SetStatusTh(th: Integer);
begin
  StatusBar.Panels[1].Text := Format('Th.: %d%%', [th]);
end;

function TMainForm.AddFiles(processSubdirs: Boolean): Integer;

procedure AddDirContents(SL : TStringList; path : String);
var
  SR : TSearchRec;
begin
  try
    if FindFirst(path + '\*.*', faAnyFile or faDirectory, SR) = 0 then
      repeat
        if (SR.Name <> '.') and (SR.Name <> '..') then
          if (SR.Attr and faDirectory <> 0) or CheckFileExtension(SR.Name) then
            SL.Add(path + '\' + SR.Name);
      until FindNext(SR) <> 0;
  finally
    FindClose(SR);
  end;
end;

var
  path : String;
  SL : TStringList;
  defaultAuthor, ai, i : Integer;
  sf : TSourceFile;
begin
  ProgressForm.Show(DropFileTarget.Files.Count);
  SL := TStringList.Create;
  try
    SL.AddStrings(DropFileTarget.Files);
    defaultAuthor := -1;
    Result := 0;
    i := 0;
    while i < SL.Count do begin
      path := SL[i];
      inc(i);
      Application.ProcessMessages;
      if ProgressForm.Cancelled then
        break;
      ProgressForm.StartFile(path);
      if DirectoryExists(path) and processSubdirs then begin
        AddDirContents(SL, path);
        ProgressForm.SetCount(Sl.Count);
      end else if CheckFileExtension(path) and FileExists(path) then begin
        if pos(ExtractFileName(path), IgnoreED.Text) > 0 then
          continue;
        ai := findAuthorId(path);
        if ai < 0 then begin
          if SkipNoAuthor then
            continue;
          if defaultAuthor >= 0 then
            ai := defaultAuthor
          else begin
            ai := AuthorsDialog.GetAuthorId;
            case ai of
              SKIP: continue;
              CANCEL: break;
              else begin
                if AuthorsDialog.All then
                  defaultAuthor := ai;
              end;
            end;
          end;
        end;
        sf := TSourceFile.Create(ai, uf, path, ThresholdTB.Position, FileList.Items.Add);
        fList.Add(sf);
        inc(Result);
      end;
    end;
  finally
    SL.Free;
    ProgressForm.Hide;
  end;
end;

procedure TMainForm.LoadUsermap;
const
  USERMAP_FILE_NAME = '.usermap';
begin
  if FileExists(USERMAP_FILE_NAME) then
    try
      usermap.LoadFromFile(USERMAP_FILE_NAME);
    except
      on e : Exception do
        Application.MessageBox(PChar(e.Message), 'Error loading usermap', MB_OK or MB_APPLMODAL or MB_ICONERROR); 
    end;
end;

procedure TMainForm.FormShow(Sender: TObject);
begin
  AuthorsDialog.LoadUsers(uf);
end;

procedure TMainForm.FindAuthorsAutoCBClick(Sender: TObject);
begin
  SkipNoAuthorCB.Enabled := FindAuthorsAutoCB.Checked;
end;

function TMainForm.SkipNoAuthor: Boolean;
begin
  Result := SkipNoAuthorCB.Checked and SkipNoAuthorCB.Enabled;
end;

procedure TMainForm.Button1Click(Sender: TObject);
begin
  LoadUsermap;
end;

procedure TMainForm.FileListEnter(Sender: TObject);
begin
  CalcCompareEnabled;
end;

procedure TMainForm.CalcCompareEnabled;
begin
  Compare.Enabled := (FileList.ItemFocused <> nil) and (TSourceFile(FileList.ItemFocused.Data).State <> fsNone);
end;

procedure TMainForm.FileListClick(Sender: TObject);
begin
  CalcCompareEnabled;
end;

procedure TMainForm.FileListContextPopup(Sender: TObject; MousePos: TPoint;
  var Handled: Boolean);
begin
  CalcCompareEnabled;
end;

procedure TMainForm.FileListDblClick(Sender: TObject);
begin
  Compare.Execute;
end;

procedure TMainForm.About1Click(Sender: TObject);
begin
  ShowMessage('NeverCopyCode v 2.0'#13#10'Copyright(C) 2006 by Andrey Breslav'#13#10#13#10'Distributed as is');
end;

end.


