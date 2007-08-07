program Stupid;

uses
  SysUtils,
  DelphiGraph,
  TicTacToe in 'TicTacToe.pas';

type
  TCellState = (csEmpty, csCross, csCircle);

var
  field : array[0..100, 0..100] of TCellState;
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

var
  mine, his : TCellState;
  hisTurn : TTurn;
begin
  FillChar(field, SizeOf(field), csEmpty);

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
    field[CrossFirstTurn.x][CrossFirstTurn.y] := csCross;
  end;

  DrawField;

  while true do begin
    hisTurn := makeTurn(0, 0);
    field[hisTurn.x][hisTurn.y] := his;
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
    DrawField;
  end;

  DrawField;

  WaitForGraph;
end.
