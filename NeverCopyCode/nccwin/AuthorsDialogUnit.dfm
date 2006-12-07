object AuthorsDialog: TAuthorsDialog
  Left = 192
  Top = 137
  Width = 373
  Height = 402
  ActiveControl = FilterED
  BorderIcons = [biSystemMenu]
  Caption = 'Choose the author...'
  Color = clBtnFace
  Font.Charset = DEFAULT_CHARSET
  Font.Color = clWindowText
  Font.Height = -11
  Font.Name = 'MS Sans Serif'
  Font.Style = []
  OldCreateOrder = False
  PixelsPerInch = 96
  TextHeight = 13
  object Label1: TLabel
    Left = 13
    Top = 13
    Width = 25
    Height = 13
    Caption = 'Filter:'
  end
  object FilterED: TEdit
    Left = 44
    Top = 9
    Width = 309
    Height = 21
    Anchors = [akLeft, akTop, akRight]
    TabOrder = 0
    OnChange = FilterEDChange
  end
  object UsersLB: TListBox
    Left = 13
    Top = 36
    Width = 341
    Height = 290
    Anchors = [akLeft, akTop, akRight, akBottom]
    ItemHeight = 13
    TabOrder = 1
    OnClick = UsersLBClick
    OnDblClick = UsersLBDblClick
  end
  object OKBtn: TButton
    Left = 20
    Top = 341
    Width = 75
    Height = 25
    Anchors = [akRight, akBottom]
    Caption = 'OK'
    Default = True
    Enabled = False
    ModalResult = 1
    TabOrder = 2
  end
  object Button2: TButton
    Left = 276
    Top = 341
    Width = 75
    Height = 25
    Anchors = [akRight, akBottom]
    Cancel = True
    Caption = 'Cancel'
    ModalResult = 2
    TabOrder = 3
  end
  object Button1: TButton
    Left = 191
    Top = 341
    Width = 75
    Height = 25
    Anchors = [akRight, akBottom]
    Caption = 'Skip'
    ModalResult = 5
    TabOrder = 4
  end
  object AllBtn: TButton
    Left = 105
    Top = 341
    Width = 75
    Height = 25
    Anchors = [akRight, akBottom]
    Caption = 'All'
    Enabled = False
    ModalResult = 8
    TabOrder = 5
  end
end
