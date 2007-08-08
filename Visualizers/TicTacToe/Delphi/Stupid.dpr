program Stupid;

uses
  SysUtils,
  DelphiGraph,
  Math,
  TicTacToe in 'TicTacToe.pas',
  StupidThinker in 'StupidThinker.pas';

var
  message : String;

procedure DrawField;
const
  S = 'I am Stupid!';
var
  h : Integer;
begin
  ClrScr;
  SetFontStyle([fsBold]);
  SetFontColor(clBlue);
  SetFontSize(50);
  SetFontName('Arial');
  TextOut((GetMaxX - TextWidth(S)) div 2, (GetMaxY - TextHeight(S)) div 2, S);
  h := TextHeight(S);
  SetFontSize(20);
  TextOut((GetMaxX - TextWidth(message)) div 2, (h + GetMaxY - TextHeight(message)) div 2, message);
end;

procedure PlayGame;
var
  hisTurn : TTurn;
  x, y : Integer;
begin
  DrawField;

  Randomize;
  x := Random(FieldWidth);
  y := Random(FieldHeight);

  while true do begin
    Decide(x, y);
    RecordAndCalculate(x, y, mine);
    hisTurn := makeTurn(x, y);
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

    RecordAndCalculate(hisTurn.x, hisTurn.y, his);
    DrawField;
  end;
end;

begin
  InitGraph(450, 150);

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
