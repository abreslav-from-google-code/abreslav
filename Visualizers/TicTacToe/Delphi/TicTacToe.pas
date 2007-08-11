unit TicTacToe;

interface

type
  TPlayer = (Cross, Circle);
  TPlayerStatus = (YourTurn, YouHaveWon, YouHaveLost, YourMistake);

type
  TTurn = packed record
    x, y : Word;
    status : TPlayerStatus;
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
      raise Exception.Create('ERROR reading data: ' + IntToStr(WSAGetLastError()));
  end;
end;

const
  HELLO = 99;
  YOU_ARE_X = 100;
  YOU_ARE_Y = 101;
  YOUR_TURN = 102;
  OTHERS_DATA = 103;

const
  PLAY = 1;
  YOU_WIN = 2;
  YOU_LOOSE = 3;
  YOUR_ERROR = 4;
  int2ps : array[1..4] of TPlayerStatus = (YourTurn, YouHaveWon, YouHaveLost, YourMistake);

function ReadTurnData(s : TSocket) : TTurn;
var
  status : Integer;
begin
  read(s, Result, sizeof(Result.x) + sizeof(Result.y));
  read(s, status, sizeof(status));
  Result.status := int2ps[status];
end;

procedure WaitForGameStart(name : String);
var
  size : Integer;
  nameString : String;
begin
  nameString := name + '@DSC1.0';
  // Send name
  size := Length(nameString);
  send(ConnectSocket, size, sizeof(size), 0);
  send(ConnectSocket, PChar(nameString)^, size, 0);
  // Wait for partner's name
  read(ConnectSocket, size, sizeof(size));
  SetLength(nameString, size);
  read(ConnectSocket, PChar(nameString)^, size);
  // Wait for turn notification
  if (Player = Circle) then begin
    XFirstTurn := ReadTurnData(ConnectSocket);
  end;
end;

var
  wsaData : TWSAData;
  clientService : sockaddr_in;
  command : Integer;
  res : Integer;
initialization
  res := WSAStartup($0202, wsaData);
  if (res <> 0) then
    raise Exception.Create('Error at WSAStartup()');

  ConnectSocket := socket(AF_INET, SOCK_STREAM, IPPROTO_TCP);
  if (ConnectSocket = INVALID_SOCKET) then begin
    WSACleanup();
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
    closesocket(ConnectSocket);
    WSACleanup();
    raise Exception.Create( 'Failed to connect: ' + IntToStr(WSAGetLastError()) );
  end;

  command := HELLO;
  send(ConnectSocket, command, sizeof(command), 0);

  read(ConnectSocket, command, sizeof(command));
  read(ConnectSocket, Width, sizeof(Width));
  read(ConnectSocket, Height, sizeof(Height));

  if (command = YOU_ARE_X) then begin
    Player := Cross;
    Other := Circle;
  end else begin
    Player := Circle;
    Other := Cross;
  end;

finalization
  shutdown(ConnectSocket, FD_WRITE);
  closesocket(ConnectSocket);
  WSACleanup();
end.
