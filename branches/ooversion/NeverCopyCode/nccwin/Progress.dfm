object ProgressForm: TProgressForm
  Left = 192
  Top = 137
  BorderIcons = []
  BorderStyle = bsSingle
  Caption = 'Processing files...'
  ClientHeight = 141
  ClientWidth = 375
  Color = clBtnFace
  Font.Charset = DEFAULT_CHARSET
  Font.Color = clWindowText
  Font.Height = -11
  Font.Name = 'MS Sans Serif'
  Font.Style = []
  FormStyle = fsStayOnTop
  OldCreateOrder = False
  Position = poMainFormCenter
  PixelsPerInch = 96
  TextHeight = 13
  object ProgressBar: TProgressBar
    Left = 35
    Top = 18
    Width = 305
    Height = 30
    Min = 0
    Max = 100
    TabOrder = 0
  end
  object CurrentFileST: TStaticText
    Left = 35
    Top = 58
    Width = 305
    Height = 36
    AutoSize = False
    Caption = 'CurrentFileST'
    TabOrder = 1
  end
  object CancelBtn: TButton
    Left = 150
    Top = 102
    Width = 75
    Height = 25
    Cancel = True
    Caption = 'Cancel'
    TabOrder = 2
    OnClick = CancelBtnClick
  end
end
