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
  Delay : Integer = 500;

procedure DrawField;
var
  l, t, r, b, x, y : Integer;
  c : TColor;
  s : String;
begin
  FreezeScreen;
  SetBrushColor(clWhite);
  ClrScr;

  SetFontStyle([fsBold]);
  SetFontColor(clBlack);
  TextOut(
    (GetMaxX - TextWidth(message)) div 2,
    (topband - TextHeight(message)) div 2,
    message);
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
  SetFontStyle([]);
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
          SetBrushColor(clWhite);
          Ellipse(l, t, r, b);
        end;
        else begin
          SetPenStyle(psClear);
          c := Round(255 * getCellPenalty(x, y) / 50) mod 255;
          SetBrushColor(RGB(255, 255 - c, 255 - c));
          Rectangle(l + 1, t + 1, r + 1, b + 1);
          SetPenStyle(psSolid);
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
{    while true do begin
      WaitForMouseEvent;
      if MousePressed then
        break;
    end;}
   
    if first and (mine = csCross) then begin
      Randomize;
      x := Random(FieldWidth div 2) + FieldWidth div 4;
      y := Random(FieldHeight div 2) + FieldWidth div 4;
    end else begin
      DecideRand(x, y)
    end;
    first := false;
    RecordAndCalculate(x, y, mine);
    DrawField;

    hisTurn := makeTurn(x, y);

    RecordAndCalculate(hisTurn.x, hisTurn.y, his);
    DrawField;
    Sleep(Delay);

    case hisTurn.status of
      YourTurn: message := 'Playing...';
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
  if ParamCount > 0 then
    try
      Delay := StrToInt(ParamStr(1));
    except

    end;

  InitGraph(FieldWidth * CELL_SIZE, FieldHeight * CELL_SIZE + topband);
  SetTitle('Stupid :)');
  SetFontName('Arial');
  SetFontSize(8);

  if Me = csCross then begin
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
  if Me = csCircle then begin
    RecordAndCalculate(CrossFirstTurn.x, CrossFirstTurn.y, his);
  end;

  PlayGame;
  
  DrawField;

  WaitForGraph;
end.
