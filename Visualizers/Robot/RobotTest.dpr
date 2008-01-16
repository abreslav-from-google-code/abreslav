program RobotTest;
{$APPTYPE CONSOLE}

uses
  SysUtils,
  DelphiGraph,
  Field in 'Field.pas',
  Robot in 'Robot.pas',
  VisualField in 'VisualField.pas',
  FieldLoader in 'FieldLoader.pas',
  RobotGame in 'RobotGame.pas';


procedure MoveWhilePossible(robot : TRobot; dir : TMovingDirection);
begin
  while robot.CanMove(dir) do
    robot.Move(dir);
end;

procedure MoveAndPaint(robot : TRobot; dir : TMovingDirection);
begin
  while robot.CanMove(dir) do begin
    robot.Move(dir);
    robot.ChangeMark;
    robot.Move(dir);
  end;
end;

procedure steps(robot : TRobot);
var
  d : TMovingDirection;
begin
  MoveWhilePossible(robot, mdNorth);
  MoveWhilePossible(robot, mdWest);
  d := mdEast;
  repeat
    while robot.CanMove(d) do begin
      MoveAndPaint(robot, d);
      if not robot.CanMove(mdSouth) then
        break;
      robot.Move(mdSouth);
      d := Opposite(d);
    end;
    if robot.CanMove(mdSouth) then begin
      robot.Move(mdSouth);
      MoveWhilePossible(robot, mdEast);
      d := mdWest;
    end else
      break;
  until false;
end;

begin
  Start(steps);
end.
