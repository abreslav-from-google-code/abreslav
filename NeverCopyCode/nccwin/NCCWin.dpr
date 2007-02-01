program NCCWin;

uses
  Forms,
  NCCMain in 'NCCMain.pas' {MainForm},
  Utils in 'Utils.pas',
  Progress in 'Progress.pas' {ProgressForm},
  SourceFile in 'SourceFile.pas',
  UsersUnit in '..\UsersUnit.pas',
  DataCommons in '..\DataCommons.pas',
  PascalLexer in '..\PascalLexer.pas',
  MetricUnit in '..\MetricUnit.pas',
  AuthorsDialogUnit in 'AuthorsDialogUnit.pas' {AuthorsDialog},
  AdvancedMetrics in '..\AdvancedMetrics.pas',
  TokenCounts in '..\TokenCounts.pas',
  Serializable in 'Serializable.pas',
  Configuration in 'Configuration.pas';

{$R *.RES}

begin
  Application.Initialize;
  Application.Title := 'Never Copy Code';
  Application.CreateForm(TMainForm, MainForm);
  Application.CreateForm(TProgressForm, ProgressForm);
  Application.CreateForm(TAuthorsDialog, AuthorsDialog);
  Application.Run;
end.
