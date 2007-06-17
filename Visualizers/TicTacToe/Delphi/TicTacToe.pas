unit TicTacToe;

interface

type
  TPlayer = (Cross, Circle);
  TTurn = packed record
    x, y : Word;
  end;

function Me : TPlayer;
function He : TPlayer;
function FieldHeight : Word;
function FieldWidth : Word;
procedure WaitForGameStart(name : String = '<noname>');

function CrossFirstTurn : TTurn;
function MakeTurn(x, y : Word) : TTurn;

implementation

uses
  SysUtils, Winsock;

type
  TByteArray = array[0..(1 shl 30)] of Byte;
  PByteArray = ^TByteArray;

var
  ConnectSocket : TSocket;
  Player : TPlayer;
  Other : TPlayer;
  Width, Height : Word;
  XFirstTurn : TTurn;


function ReadTurnData(s : TSocket) : TTurn; forward;

function Me : TPlayer;
begin
  Result := Player;
end;

function He : TPlayer;
begin
  Result := Other;
end;

function FieldHeight : Word;
begin
  Result := Height;
end;

function FieldWidth : Word;
begin
  Result := Width;
end;

function CrossFirstTurn : TTurn;
begin
  Result := XFirstTurn;
end;

function MakeTurn(x, y : Word) : TTurn;
begin
  send(ConnectSocket, x, sizeof(x), 0);
  send(ConnectSocket, y, sizeof(y), 0);
  Result := ReadTurnData(ConnectSocket);
end;

///////////////////////////////////////////////////////////////////////////////

procedure read(s : TSocket; var buf; count : Integer);
var
  rd, r : Integer;
begin
  rd := 0;
  while (rd < count) do begin
    r := recv(s, TByteArray(buf)[rd], count - rd, 0);
    if ((r = 0) or (WSAGetLastError() = WSAECONNRESET)) then begin
      raise Exception.Create('Connection closed');
      break;
    end;
    if (r <> SOCKET_ERROR) then
      rd := rd + r
    else
      raise Exception.Create('ERROR reading data');
  end;
end;

const
  YOU_ARE_X = 100;
  YOU_ARE_Y = 101;
  YOUR_TURN = 102;
  OTHERS_DATA = 103;
  NAME = 104;

function ReadTurnData(s : TSocket) : TTurn;
var
  command : Byte;
begin
  read(s, command, sizeof(Command));
  if (command <> OTHERS_DATA) then
    raise Exception.Create('Expectations broken');
  read(s, Result, sizeof(Result));
end;

procedure WaitForGameStart(name : String);
var
  command : Byte;
  int : Integer;
  nameString : String;
begin
  nameString := name + '@Delphi SC v. 1.0';
  // Send name
  command := TicTacToe.NAME;
  send(ConnectSocket, command, sizeof(command), 0);
  int := Length(nameString);
  send(ConnectSocket, int, sizeof(int), 0);
  send(ConnectSocket, PChar(nameString)^, Length(nameString), 0);
  // Wait for partner's name
  read(ConnectSocket, command, sizeof(command));
  if (command <> NAME) then
    raise Exception.Create('X expectation broken!');
  read(ConnectSocket, int, sizeof(int));
  SetLength(nameString, int);
  read(ConnectSocket, PChar(nameString)^, int);
  // Wait for turn notification
  if (Player = Cross) then begin
    read(ConnectSocket, command, 1);
    if (command <> YOUR_TURN) then
      raise Exception.Create('X expectation broken!');
  end else begin
    XFirstTurn := ReadTurnData(ConnectSocket);
  end;
end;

var
  wsaData : TWSAData;
  clientService : sockaddr_in;
  role : Byte;
  res : Integer;
initialization
  res := WSAStartup($0202, wsaData);
  if (res <> 0) then
    raise Exception.Create('Error at WSAStartup()');

  ConnectSocket := socket(AF_INET, SOCK_STREAM, IPPROTO_TCP);
  if (ConnectSocket = INVALID_SOCKET) then begin
    raise Exception.Create('Error at socket(): '{, WSAGetLastError()});
  end;

  //----------------------
  // The sockaddr_in structure specifies the address family,
  // IP address, and port of the server to be connected to.

  clientService.sin_family := AF_INET;
  clientService.sin_addr.s_addr := inet_addr( '127.0.0.1' );
  clientService.sin_port := htons( 10000 );

  //----------------------
  // Connect to server.
  if ( connect( ConnectSocket, clientService, sizeof(clientService) ) = SOCKET_ERROR) then begin
    raise Exception.Create( 'Failed to connect.' );
  end;

  read(ConnectSocket, role, 1);
  read(ConnectSocket, Width, sizeof(Width));
  read(ConnectSocket, Height, sizeof(Height));

  if (role = YOU_ARE_X) then begin
    Player := Cross;
    Other := Circle;
  end else begin
    Player := Circle;
    Other := Cross;
  end;

finalization
  WSACleanup();
end.
