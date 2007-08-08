program Stupid;

uses
  SysUtils,
  DelphiGraph,
  Math,
  TicTacToe in 'TicTacToe.pas',
  StupidThinker in 'StupidThinker.pas';

const
  CELL_SIZE = 16;
  CROSS_COLOR = clBlue;
  CIRCLE_COLOR = clRed;
  topband = 20;

var
  message : String;

procedure DrawField;
var
  l, t, r, b, x, y : Integer;
  s : String;
begin
  FreezeScreen;
  ClrScr;
//  SetFontStyle([fsBold]);
//  SetFontColor(mColor);
//  TextOut((GetMaxX - TextWidth(message)) div 2, (topband - TextHeight(message)) div 2, message);
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
      case getCell(x, y) of
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
        else begin
          s := IntToStr(getCellPenalty(x, y));
          TextOut(
            l + (CELL_SIZE - TextWidth(s)) div 2,
            t + (CELL_SIZE - TextHeight(s)) div 2,
            s);
        end;
      end;
    end;
  end;
  UnFreezeScreen;
end;

procedure PlayGame;
var
  hisTurn : TTurn;
  x, y : Integer;
  first : Boolean;
begin
  DrawField;

  first := true;
  while true do begin
    while true do begin
      WaitForMouseEvent;
      if MousePressed then
        break;
    end;

    if first and (mine = csCross) then begin
      Randomize;
      x := Random(FieldWidth div 2) + FieldWidth div 4;
      y := Random(FieldHeight div 2) + FieldWidth div 4;
    end else begin
      Decide(x, y);
    end;
    first := false;
    RecordAndCalculate(x, y, mine);
    DrawField;

    hisTurn := makeTurn(x, y);

    RecordAndCalculate(hisTurn.x, hisTurn.y, his);
    DrawField;

    case hisTurn.status of
      YourTurn: message := 'Your turn...';
      YouHaveWon: begin
        message := 'I have won :)';
        break;
      end;
      YouHaveLost : begin
        message := 'I have lost :(';
        break;
      end;
      YourMistake : begin
        message := 'I''m too stupid to play this game!';
        break;
      end;
    end;
  end;
end;

begin
  InitGraph(FieldWidth * CELL_SIZE, FieldHeight * CELL_SIZE + topband);
  SetFontName('Arial');
  SetFontSize(8);

  if Me = Cross then begin
    mine := csCross;
    his := csCircle;
    message := 'I''m the first! My luck!';
  end else begin
    mine := csCircle;
    his := csCross;
    message := 'Go beat me!!!';
  end;

  DrawField;

  WaitForGameStart('Stupid');
  if Me = Circle then begin
    RecordAndCalculate(CrossFirstTurn.x, CrossFirstTurn.y, his);
  end;

  PlayGame;
  
  DrawField;

  WaitForGraph;
end.
