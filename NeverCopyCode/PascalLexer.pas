unit PascalLexer;

interface

uses
  Classes;

var
  _DEBUG : Boolean = false;

procedure tokenize(input, output : TStream);
function byteToTokenName(b : Byte) : String;
function byteToTokenPresentation(b : Byte) : String;

implementation

uses
  SysUtils;

type
  TLexerState = (
    lsStart, lsEnd, lsError,
    lsCurlyComment, lsBraceComment, lsBraceCommentEndOrAsterisk, lsInlineComment,
    lsId,
    lsNumber, lsHex, lsReal, lsRealExponent, lsRealExponentTag, lsString, lsChar,
    lsSlashOrInlineComment, // / or //
    lsLBraceOrComment, // ( or (*
    lsDotOrTwoDots, // . or ..
    lsColonOrAssignment, // : or :=
    lsLessNotEqualOrLessOrEqual, // < or <> or <=
    lsGreaterOrGreaterOrEqual // > or >=
  );
  TStateHandler = function(c : Char) : TLexerState;
  TPascalToken = (
    ptAND, ptARRAY, ptAS, ptASM, ptBEGIN, ptCASE, ptCLASS, ptCONST, ptCONSTRUCTOR,
    ptDESTRUCTOR, ptDISPINTERFACE, ptDIV, ptDO, ptDOWNTO, ptELSE, ptEND, ptEXCEPT,
    ptEXPORTS, ptFILE, ptFINALIZATION, ptFINALLY, ptFOR, ptFUNCTION, ptGOTO, ptIF,
    ptIMPLEMENTATION, ptIN, ptINHERITED, ptINITIALIZATION, ptINLINE, ptINTERFACE,
    ptIS, ptLABEL, ptLIBRARY, ptMOD, ptNIL, ptNOT, ptOBJECT, ptOF, ptOR, ptOUT,
    ptPACKED, ptPROCEDURE, ptPROGRAM, ptPROPERTY, ptRAISE, ptRECORD, ptREPEAT,
    ptRESOURCESTRING, ptSET, ptSHL, ptSHR, ptSTRING, ptTHEN, ptTHREADVAR, ptTO,
    ptTRY, ptTYPE, ptUNIT, ptUNTIL, ptUSES, ptVAR, ptWHILE, ptWITH, ptXOR,
    ptERROR,
    ptID,
    ptINT, ptREAL, ptSTRINGLITERAL, ptCHAR,
    ptDOT, ptCOLON, ptCOMMA, ptSEMICOLON, ptSLASH, ptPLUS, ptMINUS, ptTIMES, ptAT, ptCARET,
    ptLBRACKET, ptRBRACKET, ptLBRACE, ptRBRACE,
    ptTWO_DOTS, ptASSIGN,
    ptLT, ptGT, ptLE, ptGE, ptEQ, ptNE
  );

const
  StateNames : array[TLexerState] of String = (
    'Start', 'End', 'Error',
    'CurlyComment', 'BraceComment', 'BraceCommentEndOrAsterisk', 'InlineCOmment',
    'Id',
    'Number', 'Hex', 'Real', 'RealExponent', 'RealExponentTag', 'String', 'Char',
    'SlashOrInlineComment',
    'LBraceOrComment',
    'DotOrTwoDots',
    'ColonOrAssignment',
    'LessNotEqualOrLessOrEqual',
    'GreaterOrGreaterOrEqual'
  );
  TAB = #9;
  CR = #13;
  LF = #10;
  FIRST_KEY_WORD = ptAND;
  LAST_KEY_WORD = ptXOR;
  TokenNames : array[TPascalToken] of String = (
    'AND', 'ARRAY', 'AS', 'ASM', 'BEGIN', 'CASE', 'CLASS', 'CONST', 'CONSTRUCTOR',
    'DESTRUCTOR', 'DISPINTERFACE', 'DIV', 'DO', 'DOWNTO', 'ELSE', 'END', 'EXCEPT',
    'EXPORTS', 'FILE', 'FINALIZATION', 'FINALLY', 'FOR', 'FUNCTION', 'GOTO', 'IF',
    'IMPLEMENTATION', 'IN', 'INHERITED', 'INITIALIZATION', 'INLINE', 'INTERFACE',
    'IS', 'LABEL', 'LIBRARY', 'MOD', 'NIL', 'NOT', 'OBJECT', 'OF', 'OR', 'OUT',
    'PACKED', 'PROCEDURE', 'PROGRAM', 'PROPERTY', 'RAISE', 'RECORD', 'REPEAT',
    'RESOURCESTRING', 'SET', 'SHL', 'SHR', 'STRING', 'THEN', 'THREADVAR', 'TO',
    'TRY', 'TYPE', 'UNIT', 'UNTIL', 'USES', 'VAR', 'WHILE', 'WITH', 'XOR',
    'ERROR',
    'ID',
    'INT', 'REAL', 'STRING', 'CHAR',
    'DOT', 'COLON', 'COMMA', 'SEMICOLON', 'SLASH', 'PLUS', 'MINUS', 'TIMES', 'AT', 'CARET',
    'LBRACKET', 'RBRACKET', 'LBRACE', 'RBRACE',
    'TWO_DOTS', 'ASSIGN',
    'LT', 'GT', 'LE', 'GE', 'EQ', 'NE'
  );
  TokenPresentations : array[TPascalToken] of String = (
    'and', 'array', 'as', 'asm', 'begin', 'case', 'class', 'const', 'constructor',
    'destructor', 'dispinterface', 'div', 'do', 'downto', 'else', 'end', 'except',
    'exports', 'file', 'finalization', 'finally', 'for', 'function', 'goto', 'if',
    'implementation', 'in', 'inherited', 'initialization', 'inline', 'interface',
    'is', 'label', 'library', 'mod', 'nil', 'not', 'object', 'of', 'or', 'out',
    'packed', 'procedure', 'program', 'property', 'raise', 'record', 'repeat',
    'resourcestring', 'set', 'shl', 'shr', 'string', 'then', 'threadvar', 'to',
    'try', 'type', 'unit', 'until', 'uses', 'var', 'while', 'with', 'xor',
    'ERROR',
    'ID',
    '239', '23.9', '''string''', '#239',
    '.', ':', ',', ';', '/', '+', '-', '*', '@', '^',
    '[', ']', '(', ')',
    '..', ':=',
    '<', '>', '<=', '>=', '=', '<>'
  );
  END_STATES : set of TLexerState = [lsEnd, lsError];
var
  input : TStream;
  output : TStream;
  c : Char;
  eof : Boolean = false;
  currentId : String[255];
  handlers : array[TLexerState] of TStateHandler;

procedure next;
begin
  if input.read(c, 1) = 0 then begin
    eof := true;
    c := #0;
  end else if c = #0 then
    next();
end;

procedure addToken(t : TPascalToken);
begin
  if _DEBUG then
    WriteLn(TokenNames[t], ' ');
  output.Write(t, sizeOf(t));
end;

procedure addID(id : String);
var
  t : TPascalToken;
begin
  id := AnsiUpperCase(id);
  for t := FIRST_KEY_WORD to LAST_KEY_WORD do
    if TokenNames[t] = id then begin
      addToken(t);
      Exit;
    end;
  addToken(ptID);
end;

function simpleToken(c : Char) : TPascalToken;
begin
  Result := ptError;
  case c of
    ',': Result := ptCOMMA;
    ';': Result := ptSEMICOLON;
    '+': Result := ptPLUS;
    '-': Result := ptMINUS;
    '*': Result := ptTIMES;
    '[': Result := ptLBRACKET;
    ']': Result := ptRBRACKET;
    ')': Result := ptRBRACE;
    '@': Result := ptAT;
    '^': Result := ptCARET;
    '=': Result := ptEQ;
    else Assert(false, 'Wrong character passed to simpleToken: ''' + c + '''');
  end;
end;

function processStart(c : Char) : TLexerState;
begin
  Result := lsStart;
  case c of
    ',', ';', '=', '+', '-', '*', '[', ']', ')', '@', '^': begin
      addToken(simpleToken(c));
    end;
    ' ', TAB, CR : ;
    LF :
      if _DEBUG then
        WriteLn;
    '.': Result := lsDotOrTwoDots;
    ':': Result := lsColonOrAssignment;
    '<': Result := lsLessNotEqualOrLessOrEqual;
    '>': Result := lsGreaterOrGreaterOrEqual;
    '/': Result := lsSlashOrInlineComment;
    '(': Result := lsLBraceOrComment;
    '_', 'a'..'z', 'A'..'Z': begin
       Result := lsId;
       currentId := c;
    end;
    '0'..'9': Result := lsNumber;
    '$': Result := lsHex;
    '{': Result := lsCurlyComment;
    '#': Result := lsChar;
    '''': Result := lsString;
    #0: Result := lsEnd;
    else begin
      if _DEBUG then
        WriteLn('Error on symbol: ', c);
      addToken(ptError);
    end;
  end;
  next();
end;

function processBinaryAlternative(c : Char; pat : Char; shortToken, longToken : TPascalToken) : TLexerState;
begin
  if c = pat then begin
    addToken(longToken);
    next();
  end else addToken(shortToken);
  Result := lsStart;
end;

function processDotOrTwoDots(c : Char) : TLexerState;
begin
  Result := processBinaryAlternative(c, '.', ptDOT, ptTWO_DOTS);
end;

function processColonOrAssignment(c : Char) : TLexerState;
begin
  Result := processBinaryAlternative(c, '=', ptCOLON, ptASSIGN);
end;

function processGreaterOrGreaterOrEqual(c : Char) : TLexerState;
begin
  Result := processBinaryAlternative(c, '=', ptGT, ptGE);
end;

function processLessNotEqualOrLessOrEqual(c : Char) : TLexerState;
begin
  Result := lsStart;
  case c of
    '=': begin
      addToken(ptLE);
      next();
    end;
    '>': begin
      addToken(ptNE);
      next();
    end;
    else addToken(ptLT);
  end;
end;

function processCurlyComment(c : Char) : TLexerState;
begin
  case c of
    '}': begin
      Result := lsStart;
    end;
    else Result := lsCurlyComment;
  end;
  next();
end;

function processSlashOrInlineComment(c : Char) : TLexerState;
begin
  case c of
    '/': begin
      Result := lsInlineComment;
    end;
    else begin
      addToken(ptSlash);
      Result := lsStart;
    end;
  end;
  next();
end;

function processInlineComment(c : Char) : TLexerState;
begin
  case c of
    CR, LF: begin
      Result := lsStart;
    end;
    else Result := lsInlineComment;;
  end;
  next();
end;

function processLBraceOrComment(c : Char) : TLexerState;
begin
  case c of
    '*': begin
      Result := lsBraceComment;
      next();
    end;
    else begin
      addToken(ptLBRACE);
      Result := lsStart;
    end;
  end;
end;

function processBraceComment(c : Char) : TLexerState;
begin
  case c of
    '*': begin
      Result := lsBraceCommentEndOrAsterisk;
    end;
    else begin
      Result := lsBraceComment;
    end;
  end;
  next();
end;

function processBraceCommentEndOrAsterisk(c : Char) : TLexerState;
begin
  case c of
    ')': begin
      Result := lsStart;
    end;
    else begin
      Result := lsBraceComment;
    end;
  end;
  next();
end;

function processId(c : Char) : TLexerState;
begin
  case c of
    '_', 'a'..'z', 'A'..'Z', '0'..'9': begin
      Result := lsId;
      if Length(currentId) >= 255 then begin
        addToken(ptError);
        Result := lsStart;
        Exit;
      end;
      currentId := currentId + c;
      next();
    end;
    else begin
      addID(currentId);
      Result := lsStart;
    end;
  end;
end;

function processChar(c : Char) : TLexerState;
begin
  case c of
    '0'..'9': begin
      Result := lsChar;
      next();
    end;
    else begin
      addToken(ptChar);
      Result := lsStart;
    end;
  end;
end;

function processString(c : Char) : TLexerState;
begin
  case c of
    '''': begin
      addToken(ptSTRINGLITERAL);
      Result := lsStart;
    end;
    else begin
      Result := lsString;
    end;
  end;
  next();
end;

function processHex(c : Char) : TLexerState;
begin
  case c of
    '0'..'9', 'A'..'F', 'a'..'f': begin
      Result := lsHex;
      next();
    end;
    else begin
      addToken(ptINT);
      Result := lsStart;
    end;
  end;
end;

function processNumber(c : Char) : TLexerState;
begin
  case c of
    '0'..'9': begin
      Result := lsNumber;
      next();
    end;
    '.' : begin
      Result := lsReal;
      next();
    end;
    'e', 'E' : begin
      Result := lsRealExponent;
      next();
    end;
    else begin
      addToken(ptINT);
      Result := lsStart;
    end;
  end;
end;

function processRealExponent(c : Char) : TLexerState;
begin
  case c of
    '+', '-', '0'..'9': begin
      Result := lsRealExponentTag;
      next();
    end;
    else begin
      addToken(ptREAL);
      Result := lsStart;
    end;
  end;
end;

function processRealExponentTag(c : Char) : TLexerState;
begin
  case c of
    '0'..'9': begin
      Result := lsRealExponentTag;
      next();
    end;
    else begin
      addToken(ptREAL);
      Result := lsStart;
    end;
  end;
end;

function processReal(c : Char) : TLexerState;
begin
  Result := processRealExponentTag(c);
end;

procedure tokenize(input, output : TStream);
var
  state : TLexerState;
begin
  PascalLexer.input := input;
  PascalLexer.output := output;
  state := lsStart;
  next();
  repeat
    Assert(@handlers[state] <> nil, 'No handler for state: ' + StateNames[state]);
    state := handlers[state](c);
  until (state in END_STATES);
end;

function byteToTokenName(b : Byte) : String;
begin
  Result := TokenNames[TPascalToken(b)];
end;

function byteToTokenPresentation(b : Byte) : String;
begin
  Result := TokenPresentations[TPascalToken(b)];
end;

initialization
  FillChar(handlers, sizeof(handlers), 0);
  handlers[lsStart] := processStart;
  handlers[lsDotOrTwoDots] := processDotOrTwoDots;
  handlers[lsColonOrAssignment] := processColonOrAssignment;
  handlers[lsGreaterOrGreaterOrEqual] := processGreaterOrGreaterOrEqual;
  handlers[lsLessNotEqualOrLessOrEqual] := processLessNotEqualOrLessOrEqual;
  handlers[lsCurlyComment] := processCurlyComment;
  handlers[lsSlashOrInlineComment] := processSlashOrInlineComment;
  handlers[lsInlineComment] := processInlineComment;
  handlers[lsLBraceOrComment] := processLBraceOrComment;
  handlers[lsBraceComment] := processBraceComment;
  handlers[lsBraceCommentEndOrAsterisk] := processBraceCommentEndOrAsterisk;
  handlers[lsId] := processId;
  handlers[lsChar] := processChar;
  handlers[lsHex] := processHex;
  handlers[lsString] := processString;
  handlers[lsNumber] := processNumber;
  handlers[lsRealExponent] := processRealExponent;
  handlers[lsRealExponentTag] := processRealExponentTag;
  handlers[lsReal] := processReal;
end.
