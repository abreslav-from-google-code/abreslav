object MainForm: TMainForm
  Left = 207
  Top = 142
  Width = 696
  Height = 480
  Caption = 'Never Copy Code'
  Color = clBtnFace
  Font.Charset = DEFAULT_CHARSET
  Font.Color = clWindowText
  Font.Height = -11
  Font.Name = 'MS Sans Serif'
  Font.Style = []
  OldCreateOrder = False
  Position = poDesktopCenter
  OnCreate = FormCreate
  PixelsPerInch = 96
  TextHeight = 13
  object pnBottom: TPanel
    Left = 0
    Top = 336
    Width = 688
    Height = 117
    Align = alBottom
    BevelOuter = bvNone
    TabOrder = 0
  end
  object DropFileTarget: TDropFileTarget
    Dragtypes = [dtCopy, dtLink]
    GetDataOnEnter = False
    OnDrop = DropFileTargetDrop
    ShowImage = True
    OptimizedMove = True
    AllowAsyncTransfer = False
    Left = 8
    Top = 8
  end
end
