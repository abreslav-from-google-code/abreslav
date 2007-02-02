unit MetricUnit;

interface

type
  TBytes = array[0..(1 shl 30)] of Byte;
  PBytes = ^TBytes;
  TInts = array[0..(1 shl 30)] of Integer;
  PInts = ^TInts;
  PMetricFunction = function (a : PBytes; asize : Integer; b : PBytes; bsize : Integer) : Integer;

  TMetric = class;

  IMetricResult = interface(IUnknown)
    function AbsoluteValue : Integer;
    function NormalizedValue : Integer;
    function Metric : TMetric;
  end;

  TMetric = class
  private
    function dynamicTemplate(a : PBytes; asize : Integer; b : PBytes; bsize : Integer) : Integer;
  protected
    procedure dynamicStep(i, bsize : Integer; a, b: PBytes; l1, l2 : PInts); virtual; abstract;
  public
    function calculate(a : PBytes; asize : Integer; b : PBytes; bsize : Integer) : IMetricResult;
    // Whether metric1 is more close then metric2
    function isMoreClose(metric1, metric2 : Integer) : Boolean; virtual; abstract;
    // Converts a metric value to 100% scale
    function normalize(metric : Integer; asize : Integer; bsize : Integer) : Integer;  virtual; abstract;
  end;

  TAscendingMetric = class(TMetric)
  public
    // the more the closer
    function isMoreClose(metric1, metric2 : Integer) : Boolean; override;
  end;

  TDescendingMetric = class(TMetric)
  public
    // the less the closer
    function isMoreClose(metric1, metric2 : Integer) : Boolean; override;
  end;

  TGCSMetric = class(TAscendingMetric)
  protected
    procedure dynamicStep(i, bsize : Integer; a, b: PBytes; l1, l2 : PInts); override;
  public
    class function INSTANCE : TGCSMetric;
    function normalize(metric : Integer; asize : Integer; bsize : Integer) : Integer; override;
  end;

  TEditDistanceMetric = class(TDescendingMetric)
  protected
    procedure dynamicStep(i, bsize : Integer; a, b: PBytes; l1, l2 : PInts); override;
  public
    class function INSTANCE : TEditDistanceMetric;
    function normalize(metric : Integer; asize : Integer; bsize : Integer) : Integer; override;
  end;

function mcs(a : PBytes; asize : Integer; b : PBytes; bsize : Integer) : IMetricResult;
function editingDistance(a : PBytes; asize : Integer; b : PBytes; bsize : Integer) : IMetricResult;

implementation

uses
  Math;

type
  TMetricResult = class(TInterfacedObject, IMetricResult)
  private
    FAbsoluteValue: Integer;
    FMetric: TMetric;
    FNormalizedValue: Integer;
  protected
    constructor Create(metric : TMetric);
    procedure SetAbsoluteValue(value : Integer);
    procedure CalculateNormalizedValue(asize, bsize : Integer);
  public
    function AbsoluteValue : Integer;
    function NormalizedValue : Integer;
    function Metric : TMetric;
  end;


function mcs(a : PBytes; asize : Integer; b : PBytes; bsize : Integer) : IMetricResult;
begin
  Result := TGCSMetric.INSTANCE.calculate(a, asize, b, bsize);
end;

function editingDistance(a : PBytes; asize : Integer; b : PBytes; bsize : Integer) : IMetricResult;
begin
  Result := TEditDistanceMetric.INSTANCE.calculate(a, asize, b, bsize);
end;

{ TAscendingMetric }

function TAscendingMetric.isMoreClose(metric1, metric2: Integer): Boolean;
begin
  Result := metric1 > metric2;
end;

{ TDescendingMetric }

function TDescendingMetric.isMoreClose(metric1, metric2: Integer): Boolean;
begin
  Result := metric1 < metric2;
end;

{ TGCSMetric }

procedure TGCSMetric.dynamicStep(i, bsize: Integer; a, b: PBytes; l1,
  l2: PInts);
var
  j : Integer;
begin
  for j := 1 to bsize do begin
    if a[i - 1] = b[j - 1] then begin
      l2[j] := l1[j - 1] + 1;
    end else l2[j] := max(l2[j - 1], l1[j]);
  end;
end;

var
  TGCSMetric_INSTANCE : TGCSMetric = nil;

class function TGCSMetric.INSTANCE: TGCSMetric;
begin
  if TGCSMetric_INSTANCE = nil then
    TGCSMetric_INSTANCE := TGCSMetric.Create;
  Result := TGCSMetric_INSTANCE;
end;

function TGCSMetric.normalize(metric, asize, bsize: Integer): Integer;
begin
  Result := Round(metric / Max(asize, bsize) * 100);
end;

{ TEditDistanceMetric }

procedure TEditDistanceMetric.dynamicStep(i, bsize: Integer; a, b: PBytes;
  l1, l2: PInts);
var
  j : Integer;
begin
  for j := 1 to bsize do begin
    if a[i - 1] = b[j - 1] then begin
      l2[j] := min(min(l2[j - 1] + 1, l1[j - 1]), l1[j] + 1);
    end else l2[j] := min(min(l2[j - 1], l1[j - 1]), l1[j]) + 1;
  end;
end;

var
  TEditDistanceMetric_INSTANCE : TEditDistanceMetric = nil;

class function TEditDistanceMetric.INSTANCE: TEditDistanceMetric;
begin
  if TEditDistanceMetric_INSTANCE = nil then
    TEditDistanceMetric_INSTANCE := TEditDistanceMetric.Create;
  Result := TEditDistanceMetric_INSTANCE;
end;

function TEditDistanceMetric.normalize(metric, asize,
  bsize: Integer): Integer;
begin
  Result := Round((1 - metric / Min(asize, bsize)) * 100);
end;

{ TMetric }

function TMetric.calculate(a: PBytes; asize: Integer; b: PBytes;
  bsize: Integer): IMetricResult;
var
  r : TMetricResult;
begin
  r := TMetricResult.Create(Self);
  r.SetAbsoluteValue(dynamicTemplate(a, asize, b, bsize));
  r.CalculateNormalizedValue(asize, bsize);
  Result := r;
end;

function TMetric.dynamicTemplate(a: PBytes; asize: Integer;
  b: PBytes; bsize: Integer): Integer;
var
  l1, l2, t : PInts;
  size, i : Integer;
  tb : Pbytes;
begin
  if asize < bsize then begin
    i := asize;
    asize := bsize;
    bsize := i;

    tb := a;
    a := b;
    b := tb;
  end;

  Assert(asize >= bsize);

  l1 := nil;
  l2 := nil;
  try
    size := (bsize + 1) * sizeof(Integer);
    GetMem(l1, size);
    GetMem(l2, size);
    FillChar(l1^, size, 0);
    l2[0] := 0;

    for i := 1 to asize do begin
      dynamicStep(i, bsize, a, b, l1, l2);
      t := l1;
      l1 := l2;
      l2 := t;
    end;

    Result := l1[bsize];

  finally
    if l1 <> nil then
      FreeMem(l1);
    if l2 <> nil then
      FreeMem(l2);
  end;
end;

{ TMetricResult }

function TMetricResult.AbsoluteValue: Integer;
begin
  Result := FAbsoluteValue;
end;

procedure TMetricResult.CalculateNormalizedValue(asize, bsize: Integer);
begin
  FNormalizedValue := Metric.normalize(AbsoluteValue, asize, bsize);
end;

constructor TMetricResult.Create(metric: TMetric);
begin
  FMetric := metric;
end;

function TMetricResult.Metric: TMetric;
begin
  Result := FMetric;
end;

function TMetricResult.NormalizedValue: Integer;
begin
  Result := FNormalizedValue;
end;

procedure TMetricResult.SetAbsoluteValue(value: Integer);
begin
  FAbsoluteValue := value;
  FNormalizedValue := -1;
end;

end.
