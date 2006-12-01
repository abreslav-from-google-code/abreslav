object ReaderForm: TReaderForm
  Left = 213
  Top = 196
  ActiveControl = reader
  BorderIcons = []
  BorderStyle = bsNone
  BorderWidth = 1
  Caption = 'Input text'
  ClientHeight = 19
  ClientWidth = 119
  Color = clBlack
  Font.Charset = DEFAULT_CHARSET
  Font.Color = clWindowText
  Font.Height = -11
  Font.Name = 'MS Sans Serif'
  Font.Style = []
  FormStyle = fsStayOnTop
  KeyPreview = True
  OldCreateOrder = False
  Scaled = False
  OnKeyDown = FormKeyDown
  OnKeyPress = FormKeyPress
  PixelsPerInch = 96
  TextHeight = 13
  object reader: TEdit
    Left = 0
    Top = 0
    Width = 121
    Height = 21
    AutoSize = False
    BorderStyle = bsNone
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -11
    Font.Name = 'MS Sans Serif'
    Font.Style = []
    ParentFont = False
    TabOrder = 0
    Text = '5'
  end
end
