program Client;

uses
  SysUtils,
  DelphiGraph,
  TicTacToe in 'TicTacToe.pas';

type
  TCellState = (csEmpty, csCross, csCircle);

const
  CELL_SIZE = 16;
  CROSS_COLOR = clBlue;
  CIRCLE_COLOR = clRed;
  
var
  field : array[0..100, 0..100] of TCellState;
  topband : Integer;
  message : String;
  mColor : TColor;
  
procedure DrawField;
var
  l, t, r, b, x, y : Integer;
begin
  FreezeScreen;
  ClrScr;
  SetFontStyle([fsBold]);
  SetFontColor(mColor);
  TextOut((GetMaxX - TextWidth(message)) div 2, (topband - TextHeight(message)) div 2, message);
  SetPenWidth(1);
  SetPenColor(clBlack);
  for x := 0 to FieldWidth - 1 do begin
    MoveTo(x * CELL_SIZE, topband);
    LineTo(x * CELL_SIZE, topband + FieldHeight * CELL_SIZE);
  end;
  for y := 0 to FieldHeight - 1 do begin
    MoveTo(0, topband + y * CELL_SIZE);
    LineTo(FieldWidth * CELL_SIZE, topband + y * CELL_SIZE);
  end;
  SetPenWidth(2);
  for x := 0 to FieldWidth - 1 do begin
    l := x * CELL_SIZE;
    r := l + CELL_SIZE;
    for y := 0 to FieldHeight - 1 do begin
      t := topband + y * CELL_SIZE;
      b := t + CELL_SIZE;
      case field[x][y] of
        csCross : begin
          SetPenColor(CROSS_COLOR);
          MoveTo(l, t);
          LineTo(r, b);
          MoveTo(l, b);
          LineTo(r, t);
        end;
        csCircle : begin
          SetPenColor(CIRCLE_COLOR);
          Ellipse(l, t, r, b);
        end;
      end;
    end;
  end;
  UnFreezeScreen;
end;

var
  mx, my, x, y : Integer;
  mine, his : TCellState;
  myColor, hisColor : TColor;
  hisTurn : TTurn;
  name : String;
begin
  FillChar(field, SizeOf(field), csEmpty);
  topband := 20;

  InitGraph(FieldWidth * CELL_SIZE, FieldHeight * CELL_SIZE + topband);

  if Me = Cross then begin
    mine := csCross;
    myColor := CROSS_COLOR;
    hisColor := CIRCLE_COLOR;
    his := csCircle;
    message := 'You play for "X". Waiting for "O" to connect...';
  end else begin
    mine := csCircle;
    myColor := CIRCLE_COLOR;
    hisColor := CROSS_COLOR;
    his := csCross;
    message := 'You play for "O". Waiting for "X" to make the turn...';
  end;

  mColor := myColor;

  DrawField;

  name := ReadString('<noname>', 'Enter your name:');

  WaitForGameStart(name);
  if Me = Circle then begin
    field[CrossFirstTurn.x][CrossFirstTurn.y] := csCross;
  end;

  mColor := myColor;

  // In case the other has disconnected too early
  if CrossFirstTurn.status = YouHaveWon then begin
    message := 'You have won :)';
    DrawField;
    WaitForGraph;
    Exit;
  end;
  
  message := 'Your turn...';
  DrawField;

  while true do begin
    WaitForMouseEvent;
    if MousePressed then begin
      mx := GetMouseX;
      my := GetMouseY;
      x := mx div CELL_SIZE;
      y := (my - topband) div CELL_SIZE;
      if (x >= 0) and (x < FieldWidth) and (y >= 0) and (y < FieldHeight) and
         (field[x][y] = csEmpty) then begin
        field[x][y] := mine;
        mColor := hisColor;
        message := 'Waiting for partner''s turn...';
        DrawField;
        hisTurn := makeTurn(x, y);
        field[hisTurn.x][hisTurn.y] := his;
        mColor := myColor;
        case hisTurn.status of
          YourTurn: message := 'Your turn...';
          YouHaveWon: begin
            message := 'You have won :)';
            break;
          end;
          YouHaveLost : begin
            message := 'You have lost :(';
            break;
          end;
          YourMistake : begin
            message := 'You have made a mistake and lost :(';
            break;
          end;
        end;
        DrawField;
      end;
    end;
  end;

  DrawField;

  WaitForGraph;
end.
