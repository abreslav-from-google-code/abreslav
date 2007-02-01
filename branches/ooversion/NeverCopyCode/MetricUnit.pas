unit MetricUnit;

interface

type
  TBytes = array[0..(1 shl 30)] of Byte;
  PBytes = ^TBytes;
  TInts = array[0..(1 shl 30)] of Integer;
  PInts = ^TInts;
  PMetricFunction = function (a : PBytes; asize : Integer; b : PBytes; bsize : Integer) : Integer;

function mcs(a : PBytes; asize : Integer; b : PBytes; bsize : Integer) : Integer;
{ Returns normalized metric in percents (100 - shortest/mcs * 100) }
function mcsMetric(a : PBytes; asize : Integer; b : PBytes; bsize : Integer) : Integer;

function editingDistance(a : PBytes; asize : Integer; b : PBytes; bsize : Integer) : Integer;
{ Returns normalized metric in percents (100 - shortest/Ed * 100) }
function editingDistanceMetric(a : PBytes; asize : Integer; b : PBytes; bsize : Integer) : Integer;

implementation

uses
  Math;

type
  TStep = procedure(i, bsize : Integer; a, b: PBytes; l1, l2 : PInts);

procedure mcsStep(i, bsize : Integer; a, b: PBytes; l1, l2 : PInts);
var
  j : Integer;
begin
  for j := 1 to bsize do begin
    if a[i - 1] = b[j - 1] then begin
      l2[j] := l1[j - 1] + 1;
    end else l2[j] := max(l2[j - 1], l1[j]);
  end;
end;

procedure edStep(i, bsize : Integer; a, b: PBytes; l1, l2 : PInts);
var
  j : Integer;
begin
  for j := 1 to bsize do begin
    if a[i - 1] = b[j - 1] then begin
      l2[j] := min(min(l2[j - 1] + 1, l1[j - 1]), l1[j] + 1);
    end else l2[j] := min(min(l2[j - 1], l1[j - 1]), l1[j]) + 1;
  end;
end;

function dynamicTemplate(step : TStep; a : PBytes; asize : Integer; b : PBytes; bsize : Integer) : Integer;
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
      step(i, bsize, a, b, l1, l2);
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

function mcs(a : PBytes; asize : Integer; b : PBytes; bsize : Integer) : Integer;
begin
  Result := dynamicTemplate(mcsStep, a, asize, b, bsize);
end;

function editingDistance(a : PBytes; asize : Integer; b : PBytes; bsize : Integer) : Integer;
begin
  Result := dynamicTemplate(edStep, a, asize, b, bsize);
end;

function editingDistanceMetric(a : PBytes; asize : Integer; b : PBytes; bsize : Integer) : Integer;
begin
  Result := Round((1 - editingDistance(a, asize, b, bsize) / Min(asize, bsize)) * 100);
end;

function mcsMetric(a : PBytes; asize : Integer; b : PBytes; bsize : Integer) : Integer;
begin
  Result := Round(mcs(a, asize, b, bsize) / Min(asize, bsize) * 100);
end;

end.
