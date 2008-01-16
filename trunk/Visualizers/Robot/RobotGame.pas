unit RobotGame;

interface

uses
  Robot;

const
  Delay = 100;

type
  TStepProcedure = procedure(robot : TRobot);

procedure Start(steps : TStepProcedure; fileName : String = 'field.txt'; CellWidth : Integer = 0; CellHeight : Integer = 0);

implementation

uses
  Field, DelphiGraph, VisualField, FieldLoader;

procedure Redraw(field : TField; robot : TRobot);
begin
  Draw(field, robot);
  Sleep(Delay);
end;

type
  TDrawingRobotListener = class (TRobotListener)
  private
    FField : TField;
  public
    procedure SetField(field : TField);
    procedure OnMove(robot : TRobot; dir : TMovingDirection); override;
    procedure OnChangeMark(robot : TRobot); override;
    procedure OnMessageChanged(robot : TRobot); override;
  end;

{ TDrawingRobotListener }

procedure TDrawingRobotListener.OnChangeMark(robot: TRobot);
begin
  Redraw(FField, robot);
end;

procedure TDrawingRobotListener.OnMessageChanged(robot: TRobot);
begin
  Draw(FField, robot);
end;

procedure TDrawingRobotListener.OnMove(robot: TRobot;
  dir: TMovingDirection);
begin
  Redraw(FField, robot);
end;

procedure TDrawingRobotListener.SetField(field: TField);
begin
  FField := field;
end;

procedure Start(steps : TStepProcedure; fileName : String = 'field.txt'; CellWidth : Integer = 0; CellHeight : Integer = 0);
var
  field : TField;
  robot : TRobot;
  robotListener : TDrawingRobotListener;
begin
  if CellWidth = 0 then
    CellWidth := 40;
  if CellHeight = 0 then
    CellHeight := 40;
  robotListener := TDrawingRobotListener.Create;
  LoadField(Field, Robot, fileName, robotListener);
  robotListener.setField(field);
  Init(Field.Width * CellWidth, Field.Height * CellHeight);
  InitGraph(Field.Width * CellWidth, Field.Height * CellHeight);
  Redraw(field, robot);
  steps(robot);

  SetBrushStyle(bsClear);
  TextOut(0, 0, 'End');
  WaitForGraph;
end;

end.
