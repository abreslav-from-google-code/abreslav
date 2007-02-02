unit OPConf;

interface

uses
  OPConfig;

type
  TOPConf = class(TConfig)
  private
    FIterCount: Integer;
    FSimpleStep: Extended;
    FUseSimpleStep: Boolean;
    FDrawConditions: Boolean;
    FDrawLevels: Boolean;
    FYScale: Integer;
    FXScale: Integer;
    FRho: Extended;
    FLambda: Extended;
    FDrawLagrange: Boolean;
    FInvalid: Boolean;
    FDrawBack: Boolean;
    FCalcLambda: Boolean;
    FValueMax: Extended;
    FValueMin: Extended;
    FEps: Extended;
    FCConstr: Integer;
    FRhoEps: Extended;
    procedure SetDrawLagrange(const Value: Boolean);
    procedure SetDrawConditions(const Value: Boolean);
    procedure SetDrawLevels(Value: Boolean);
    procedure SetLambda(const Value: Extended);
    procedure SetRho(const Value: Extended);
    procedure SetXScale(const Value: Integer);
    procedure SetYScale(const Value: Integer);
    procedure SetDrawBack(const Value: Boolean);
    procedure SetCalcLambda(const Value: Boolean);
    procedure SetValueMax(const Value: Extended);
    procedure SetValueMin(const Value: Extended);
    procedure SetEps(const Value: Extended);
    procedure SetCConstr(const Value: Integer);
    procedure SetRhoEps(const Value: Extended);
  public
    property Invalid : Boolean read FInvalid;
    procedure Invalidate;
    procedure Validate;

    constructor Create;
  published
    property IterCount : Integer read FIterCount write FIterCount;
    property SimpleStep : Extended read FSimpleStep write FSimpleStep;
    property UseSimpleStep : Boolean read FUseSimpleStep write FUseSimpleStep;
    { Graphical update needed }
    property XScale : Integer read FXScale write SetXScale;
    property YScale : Integer read FYScale write SetYScale;
    property Lambda0 : Extended read FLambda write SetLambda;
    property Rho : Extended read FRho write SetRho;
    property DrawLevels : Boolean read FDrawLevels write SetDrawLevels;
    property DrawConditions : Boolean read FDrawConditions write SetDrawConditions;
    property DrawLagrange : Boolean read FDrawLagrange write SetDrawLagrange;
    property DrawBack : Boolean read FDrawBack write SetDrawBack;
    property CalcLambda : Boolean read FCalcLambda write SetCalcLambda;
    property ValueMax : Extended read FValueMax write SetValueMax;
    property ValueMin : Extended read FValueMin write SetValueMin;
    property Eps : Extended read FEps write SetEps;
    property CConstr : Integer read FCConstr write SetCConstr;
    property RhoEps : Extended read FRhoEps write SetRhoEps;
  end;

implementation

{ TOPConf }

constructor TOPConf.Create;
begin
  inherited Create(TypeInfo(TOpConf));
  IterCount := 50;
  SimpleStep := 0.05;
  UseSimpleStep := false;
  DrawLevels := true;
  DrawConditions := true;
  DrawBack := true;
  XScale := 150;
  YScale := 150;
  Lambda0 := 0.01;
  CalcLambda := true;
  Rho := 100;
  ValueMin := 0;
  ValueMax := 30;
  Eps := 1e-9;
  CConstr := 30000;
  RhoEps := 1;
end;

procedure TOPConf.Invalidate;
begin
  FInvalid := true;
end;

procedure TOPConf.SetCalcLambda(const Value: Boolean);
begin
  FCalcLambda := Value;
end;

procedure TOPConf.SetCConstr(const Value: Integer);
begin
  FCConstr := Value;
end;

procedure TOPConf.SetDrawBack(const Value: Boolean);
begin
  if FDrawBack = Value then
    Exit;
  FDrawBack := Value;
  Invalidate;
end;

procedure TOPConf.SetDrawConditions(const Value: Boolean);
begin
  if FDrawConditions = Value then
    Exit;
  FDrawConditions := Value;
  Invalidate;
end;

procedure TOPConf.SetDrawLagrange(const Value: Boolean);
begin
  if FDrawLagrange = Value then
    Exit;
  FDrawLagrange := Value;
  Invalidate;
  DrawLevels := DrawLevels and FDrawLagrange;
  DrawBack := DrawBack or FDrawLagrange;
end;

procedure TOPConf.SetDrawLevels(Value: Boolean);
begin
  Value := Value and not DrawLagrange;
  if FDrawLevels = Value then
    Exit;
  FDrawLevels := Value;
  Invalidate;
end;

procedure TOPConf.SetEps(const Value: Extended);
begin
  FEps := Value;
end;

procedure TOPConf.SetLambda(const Value: Extended);
begin
  if FLambda = Value then
    Exit;
  FLambda := Value;
  Invalidate;
end;

procedure TOPConf.SetRho(const Value: Extended);
begin
  if FRho = abs(Value) then
    Exit;
  FRho := abs(Value);
  Invalidate;
end;

procedure TOPConf.SetRhoEps(const Value: Extended);
begin
  FRhoEps := Value;
end;

procedure TOPConf.SetValueMax(const Value: Extended);
begin
  if FValueMax = Value then
    Exit;
  FValueMax := Value;
  Invalidate;
end;

procedure TOPConf.SetValueMin(const Value: Extended);
begin
  if FValueMin = Value then
    Exit;
  FValueMin := Value;
  Invalidate;
end;

procedure TOPConf.SetXScale(const Value: Integer);
begin
  if FXScale = Value then
    Exit;
  FXScale := Value;
  Invalidate;
end;

procedure TOPConf.SetYScale(const Value: Integer);
begin
  if FYScale = Value then
    Exit;
  FYScale := Value;
  Invalidate;
end;

procedure TOPConf.Validate;
begin
  FInvalid := false;
end;

end.
