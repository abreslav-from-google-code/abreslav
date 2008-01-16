unit Robot;

interface

uses
  Field, SysUtils;

type
  TMovingDirection = (mdNorth, mdWest, mdSouth, mdEast);
  TRobot = class;
  TRobotListener = class
  public
    procedure OnMove(robot : TRobot; dir : TMovingDirection); virtual; abstract;
    procedure OnChangeMark(robot : TRobot); virtual; abstract;
  end;
  TRobot = class
  private
    FYPosition: Integer;
    FXPosition: Integer;

    FField : TField;

    FRobotListener : TRobotListener;
  public
    constructor Create(Field : TField; X, Y : Integer; robotListener : TRobotListener = nil);

    property XPosition : Integer read FXPosition;
    property YPosition : Integer read FYPosition;

    procedure Move(dir : TMovingDirection);
    function CanMove(dir : TMovingDirection) : Boolean;
    procedure ChangeMark;
    function IsMarked : Boolean;
  end;

  EInvalidPositionException = class(Exception)
  private
    FX, FY : Integer;
  public
    constructor Create(X, Y : Integer);
  end;

function Opposite(dir : TMovingDirection) : TMovingDirection;

implementation

function Opposite(dir : TMovingDirection) : TMovingDirection;
begin
  case dir of
    mdNorth : Result := mdSouth;
    mdWest : Result := mdEast;
    mdSouth : Result := mdNorth;
    else Result := mdWest;
  end;
end;

type
  TDefaultRobotListener = class(TRobotListener)
  public
    procedure OnMove(robot : TRobot; dir : TMovingDirection); override;
    procedure OnChangeMark(robot : TRobot); override;
  end;

{ TDefaultRobotListener }

procedure TDefaultRobotListener.OnChangeMark(robot: TRobot);
begin
end;

procedure TDefaultRobotListener.OnMove(robot: TRobot;
  dir: TMovingDirection);
begin
end;

{ TRobot }

constructor TRobot.Create(Field: TField; X, Y: Integer; robotListener : TRobotListener = nil);
begin
  if Field[X, Y] = csWall then
    raise EInvalidPositionException.Create(X, Y);

  if robotListener = nil then
    robotListener := TDefaultRobotListener.Create;
  FRobotListener := robotListener;

  FField := Field;
  FXPosition := X;
  FYPosition := Y;
end;

const
  dir2x : array[TMovingDirection] of Integer = (0, -1, 0, 1);
  dir2y : array[TMovingDirection] of Integer = (-1, 0, 1, 0);

function TRobot.CanMove(dir: TMovingDirection): Boolean;
begin
  Result := FField.XYInside(XPosition + dir2x[dir], YPosition + dir2y[dir])
              and (FField[XPosition + dir2x[dir], YPosition + dir2y[dir]] <> csWall);
end;

procedure TRobot.ChangeMark;
begin
  if IsMarked then
    FField[XPosition, YPosition] := csEmpty
  else FField[XPosition, YPosition] := csMarked;
  FRobotListener.OnChangeMark(Self);
end;

function TRobot.IsMarked: Boolean;
begin
  Result := FField[XPosition, YPosition] = csMarked;
end;

procedure TRobot.Move(dir: TMovingDirection);
begin
  if CanMove(dir) then begin
    FXPosition := FXPosition + dir2x[dir];
    FYPosition := FYPosition + dir2y[dir];
    FRobotListener.OnMove(Self, dir); 
  end;
end;

{ EInvalidPositionException }

constructor EInvalidPositionException.Create(X, Y: Integer);
begin
  FX := X;
  FY := Y;
end;

end.
