program DFS;
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

procedure Mark(robot : TRobot);
begin
  if not robot.IsMarked then
    robot.ChangeMark;
end;

procedure doit(robot : TRobot; depth : Integer; back : TMovingDirection);
var
  dir : TMovingDirection;
begin
  robot.IntMessage := robot.IntMessage + 1;
  robot.ChangeMark;
  for dir := mdNorth to mdEast do begin
    if (dir <> back) and robot.CanMove(dir) then begin
      robot.Move(dir);
      if not robot.IsMarked then
        doit(robot, depth + 1, Opposite(dir));
//      robot.Message := IntToStr(depth);
      robot.Move(Opposite(dir));
    end;
  end;
end;

procedure steps(robot : TRobot);
begin
  robot.IntMessage := 0;
  doit(robot, 0, mdNorth);
end;

begin
  Start(steps);
end.
