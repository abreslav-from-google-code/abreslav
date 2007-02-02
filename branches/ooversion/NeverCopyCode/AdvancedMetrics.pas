unit AdvancedMetrics;

interface

uses
  PascalLexer, MetricUnit;

type
  TTokenCounts = array[TPascalToken] of Integer;
  TPrunedResult = record
    sizeRatio : Real;
    prunedBySize : Boolean;
    commonTokens : Integer;
    pruned : Boolean;
    metric : Integer;
  end;

function tokenCountPrunedMetric(sizeThresold : Real; const aTokenCounts, bTokenCounts : TTokenCounts; threshold : Integer; metric : TMetric; a : PBytes; asize : Integer; b : PBytes; bsize : Integer) : TPrunedResult;
implementation

uses
  Math;

function commonTokens(const a, b : TTokenCounts) : Integer;
var
  i : TPascalToken;
begin
  Result := 0;
  for i := Low(TTokenCounts) to High(TTokenCounts) do
    Result := Result + Min(a[i], b[i]);
end;

function tokenCountPrunedMetric(sizeThresold : Real; const aTokenCounts, bTokenCounts : TTokenCounts; threshold : Integer; metric : TMetric; a : PBytes; asize : Integer; b : PBytes; bsize : Integer) : TPrunedResult;
begin
  Result.commonTokens := Round(commonTokens(aTokenCounts, bTokenCounts) / Min(asize, bsize) * 100);
  Result.sizeRatio := Max(asize, bsize) / Min(asize, bsize);
  Result.prunedBySize := Result.sizeRatio >= sizeThresold;
  Result.pruned := Result.prunedBySize or (Result.commonTokens < threshold);
  if Result.pruned then begin
    Result.metric := Result.commonTokens;
    Exit;
  end;
  Result.metric := metric.calculate(a, asize, b, bsize).AbsoluteValue;
end;

end.
