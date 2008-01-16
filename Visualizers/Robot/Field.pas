unit Field;

interface

uses
  SysUtils;

type
  TCellState = (csEmpty, csWall, csMarked);
  TCellTable = array[0..1000000000] of TCellState;

  TField = class;

  TStateChangeStrategy = class
  public
    procedure ChangeCellState(Field : TField; X, Y : Integer; State : TCellState); virtual; abstract;
  end;

  TField = class
  private
    FHeight : Integer;
    FWidth : Integer;

    FSCStrategy : TStateChangeStrategy;

    FCells : ^TCellTable;

    function GetCells(X, Y: Integer): TCellState;
    function Index(X, Y : Integer) : Integer;
  protected
    procedure SetCells(X, Y: Integer; const Value: TCellState);
  public
    constructor Create(W, H : Integer; CS : TStateChangeStrategy = nil);
    destructor Destroy; override;

    property Width : Integer read FWidth;
    property Height : Integer read FHeight;
    property Cells[X, Y : Integer] : TCellState read GetCells write SetCells; default;

    function XInside(X : Integer) : Boolean;
    function YInside(Y : Integer) : Boolean;
    function XYInside(X, Y : Integer) : Boolean;
    procedure CheckXY(X, Y : Integer);
  end;

  EIndexOutOfBounds = class(Exception)
  public
    constructor Create(Value : Integer);
  end;

implementation

type
  TDefaultStateChangeStrategy = class(TStateChangeStrategy)
  public
    procedure ChangeCellState(Field : TField; X, Y : Integer; State : TCellState); override;
  end;

{ TDefaultStateChangeStrategy }

procedure TDefaultStateChangeStrategy.ChangeCellState(Field: TField; X,
  Y: Integer; State: TCellState);
begin
  Field.CheckXY(X, Y);
  Field.FCells[Field.Index(X, Y)] := State;
end;

{ EIndexOutOfBouds }

constructor EIndexOutOfBounds.Create(Value: Integer);
begin
  inherited Create(IntToStr(Value));
end;

{ TField }

constructor TField.Create(W, H: Integer; CS : TStateChangeStrategy);
begin
  GetMem(FCells, W * H * SizeOf(TCellState));
  if CS <> nil then
    FSCStrategy := CS
  else
    FSCStrategy := TDefaultStateChangeStrategy.Create;
  FWidth := W;
  FHeight := H;
end;

destructor TField.Destroy;
begin
  FreeMem(FCells);
  inherited;
end;

procedure TField.CheckXY(X, Y: Integer);
begin
  if not XInside(X) then
    raise EIndexOutOfBounds.Create(X);
  if not YInside(Y) then
    raise EIndexOutOfBounds.Create(Y);
end;

function TField.GetCells(X, Y: Integer): TCellState;
begin
  CheckXY(X, Y);
  Result := FCells^[Index(X, Y)];
end;

procedure TField.SetCells(X, Y: Integer; const Value: TCellState);
begin
  FSCStrategy.ChangeCellState(Self, X, Y, Value);
end;

function TField.XInside(X: Integer): Boolean;
begin
  Result := (X >= 0) and (X < Width);
end;

function TField.XYInside(X, Y: Integer): Boolean;
begin
  Result := XInside(X) and YInside(Y);
end;

function TField.YInside(Y: Integer): Boolean;
begin
  Result := (Y >= 0) and (Y < FHeight);
end;

function TField.Index(X, Y: Integer): Integer;
begin
  Result := Y * Width + X; 
end;

end.
