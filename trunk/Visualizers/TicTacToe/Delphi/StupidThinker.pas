unit StupidThinker;

interface

type
  TCellState = (csEmpty, csCross, csCircle);

var
  mine, his : TCellState;

procedure RecordAndCalculate(x, y : Integer; cell : TCellState);
procedure DecideRand(var x, y : Integer);
procedure Decide(var x, y : Integer);
function getCell(x, y : Integer) : TCellState;
function getCellPenalty(x, y : Integer) : Integer;

implementation

uses
  Math, TicTacToe;

const
  MAX_SIZE = 100;

var
  field : array[0..MAX_SIZE-1, 0..MAX_SIZE-1] of TCellState;
  penalties : array[0..MAX_SIZE-1, 0..MAX_SIZE-1] of Integer;

procedure Decide(var x, y : Integer);
var
  i, j : Integer;
begin
  x := 0;
  y := 0;
  for i := 0 to FieldWidth - 1 do
    for j := 0 to FieldHeight - 1 do
      if penalties[x, y] < penalties[i, j] then begin
        x := i;
        y := j;
      end;
end;

procedure DecideRand(var x, y : Integer);
var
  i, j : Integer;
  mx, my : array[0..MAX_SIZE-1] of Integer;
  max, c : Integer;
  overf : Boolean;
begin
  max := penalties[0, 0];
  mx[0] := 0;
  my[0] := 0;
  c := 1;
  overf := false;
  for i := 0 to FieldWidth - 1 do
    for j := 0 to FieldHeight - 1 do
      if max < penalties[i, j] then begin
        max := penalties[i, j];
        c := 1;
        overf := false;
        mx[0] := i;
        my[0] := j;
      end else if max = penalties[i, j] then begin
        mx[c] := i;
        my[c] := j;
        if c = High(mx) then begin
          overf := true;
        end;
        c := (c + 1) mod High(mx);
      end;
  if overf then
    c := High(mx) - Low(mx) + 1;
  Randomize;
  max := Random(c);
  x := mx[max];
  y := my[max];
end;

procedure FindAffectedLines(x, y, dx, dy : Integer); forward;

procedure RecordAndCalculate(x, y : Integer; cell : TCellState);
begin
  field[x, y] := cell;
  penalties[x, y] := -1;

  FindAffectedLines(x, y, 1, 1);
  FindAffectedLines(x, y, 1, -1);
  FindAffectedLines(x, y, 1, 0);
  FindAffectedLines(x, y, 0, 1);
end;

function PointInField(x, y : Integer) : Boolean;
begin
  Result := (x >= 0) and (x < FieldWidth)
            and (y >= 0) and (y < FieldHeight);
end;

function getCell(x, y : Integer) : TCellState;
begin
  if PointInField(x, y) then
    Result := field[x, y]
  else Result := csEmpty;
end;

function getCellPenalty(x, y : Integer) : Integer;
begin
  if PointInField(x, y) then
    Result := penalties[x, y]
  else Result := -2;
end;

function dist(sx, sy, ex, ey : Integer) : Integer;
begin
  Result := Max(abs(sx - ex), abs(sy - ey)) + 1;
end;

procedure incCellPenalty(x, y, p : Integer);
begin
  if PointInField(x, y) and (field[x, y] = csEmpty) then
    penalties[x, y] := penalties[x, y] + p;
end;

procedure FindClosedLine(x, y, dx, dy : Integer); forward;
procedure FindConnectedLine(x, y, dx, dy : Integer); forward;

procedure FindLine(sx, sy, dx, dy : Integer; var ex, ey : Integer);
begin
  ex := sx;
  ey := sy;
  while getCell(ex + dx, ey + dy) = getCell(sx, sy) do begin
    ex := ex + dx;
    ey := ey + dy;
  end;
  // starts with sx,sy end up with ex,ey
end;

function getLinePenalty(state : TCellState; len : Integer; open : Boolean) : Integer;
begin
  if len = 0 then begin
    Result := 0;
    Exit;
  end;
  Result := 0;
  if state = mine then begin
    case len of
      1 : Result := 5;
      2 : Result := 11;
      3 : Result := 17 + ord(open) * 5;
      4 : Result := 100;
    end;
  end else begin
    case len of
      1 : Result := 3;
      2 : Result := 8;
      3 : Result := 11 + ord(open) * 10;
      4 : Result := 50;
    end;
  end;
end;

procedure FindAffectedLines(x, y, dx, dy : Integer);
var
  m, l, r : TCellState;
begin
  m := field[x, y];
  l := getCell(x - dx, y - dy);
  r := getCell(x + dx, y + dy);

  if (m = l) or (m = r) then
    FindConnectedLine(x, y, dx, dy);
  if (m <> l) and (l <> csEmpty) then
    FindClosedLine(x, y, -dx, -dy);
  if (m <> r) and (r <> csEmpty) then
    FindClosedLine(x, y, dx, dy);
  if (l = csEmpty) and (r = csEmpty) then begin
    FindConnectedLine(x, y, dx, dy);
//    incCellPenalty(x - dx, y - dy, getLinePenalty(m, 1, true));
//    incCellPenalty(x + dx, y + dy, getLinePenalty(m, 1, true));
  end;
end;

procedure FindConnectedLine(x, y, dx, dy : Integer);
var
  sx, sy, ex, ey : Integer;
  lx, ly, rx, ry : Integer;
  l, r : TCellState;
  len : Integer;
  loop : Boolean;
begin
  sx := x;
  sy := y;
  ex := x;
  ey := y;

  while true do begin
    loop := true;
    if getCell(sx - dx, sy - dy) = field[x, y] then begin
      sx := sx - dx;
      sy := sy - dy;
    end else loop := false;

    if getCell(ex + dx, ey + dy) = field[x, y] then begin
      ex := ex + dx;
      ey := ey + dy;
    end else if not loop then
      break;
  end;

  // starts with sx,sy ends up with ex,ey
  lx := sx - dx;
  ly := sy - dy;
  l := getCell(lx, ly);
  rx := ex + dx;
  ry := ey + dy;
  r := getCell(rx, ry);

  len := dist(sx, sy, ex, ey);

  if l = csEmpty then begin
    if (x <> sx) or (y <> sy) then
      incCellPenalty(lx, ly,
        - getLinePenalty(field[x, y], dist(x, y, sx, sy) - 1, true));
    incCellPenalty(lx, ly,
       getLinePenalty(field[x, y], len, r = csEmpty));
  end;

  if r = csEmpty then begin
    if (x <> ex) or (y <> ey) then
      incCellPenalty(rx, ry,
        - getLinePenalty(field[x, y], dist(x, y, ex, ey) - 1, true));
    incCellPenalty(rx, ry,
       getLinePenalty(field[x, y], len, l = csEmpty));
    end;
end;

procedure FindClosedLine(x, y, dx, dy : Integer);
var
  ex, ey : Integer;
begin
  FindLine(x + dx, y + dy, dx, dy, ex, ey);
  Assert((x <> ex) or (y <> ey));

  // closed by x,y; starts with x+dx,y+dy end up with ex,ey
  incCellPenalty(x - dx, y - dy,
    getLinePenalty(field[x, y],
        1,
        (getCell(x - 2*dx, y - 2*dy) = csEmpty)
        and PointInField(x - 2*dx, y - 2*dy)));

  incCellPenalty(ex + dx, ey + dy,
    - getLinePenalty(field[ex, ey], dist(x, y, ex, ey) - 1, true)
    + getLinePenalty(field[ex, ey], dist(x, y, ex, ey) - 1, false));
end;

initialization
  FillChar(field, SizeOf(field), csEmpty);
  FillChar(penalties, SizeOf(penalties), 0);
end.
