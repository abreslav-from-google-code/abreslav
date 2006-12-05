program NCCWin;

uses
  Forms,
  NCCMain in 'NCCMain.pas' {MainForm};

{$R *.RES}

begin
  Application.Initialize;
  Application.Title := 'Never Copy Code';
  Application.CreateForm(TMainForm, MainForm);
  Application.Run;
end.
