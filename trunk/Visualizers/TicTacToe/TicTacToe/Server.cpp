#include "stdafx.h"
#include "Server.h"

#define HOST "127.0.0.1"
#define PORT 10000

GameServer::Result GameServer::setup()
{
	//----------------------
	// Initialize Winsock
	WSADATA wsaData;
	int iResult = WSAStartup(MAKEWORD(2,2), &wsaData);
	if (iResult != NO_ERROR)
	{
		return RESULT_ERROR;
	}

	//----------------------
	// Create a SOCKET for listening for 
	// incoming connection requests
	listenSocket = socket(AF_INET, SOCK_STREAM, IPPROTO_TCP);
	if (listenSocket == INVALID_SOCKET) 
	{
		WSACleanup();
		return RESULT_ERROR;
	}
	//----------------------
	// The sockaddr_in structure specifies the address family,
	// IP address, and port for the socket that is being bound.
	sockaddr_in service;
	service.sin_family = AF_INET;
	service.sin_addr.s_addr = inet_addr(HOST);
	service.sin_port = htons(PORT);

	//----------------------
	// Bind the socket.
	if (bind( listenSocket, 
		(SOCKADDR*) &service, 
		sizeof(service)) == SOCKET_ERROR) 
	{
			closesocket(listenSocket);
			return RESULT_ERROR;
	}

	return RESULT_OK;
}

GameServer::Result GameServer::start(HWND hWnd)
{
	//----------------------
	// Listen for incoming connection requests 
	// on the created socket
	if (listen( listenSocket, 2 ) == SOCKET_ERROR)
	{
		return RESULT_ERROR;
	}

	if (WSAAsyncSelect(listenSocket, 
		hWnd, SOCKET_EVENT, 
		FD_READ | FD_WRITE | FD_ACCEPT | FD_CLOSE) != 0)
	{
		return RESULT_ERROR;
	}
	return RESULT_OK;
}

void GameServer::handleEvent(HWND hWnd, SOCKET s, int _event, int error)
{
	processEvent(_event, s);
}

void GameServer::stopListening()
{
	WSAAsyncSelect(listenSocket, 0, 0, 0);
	ioctlsocket(listenSocket, FIONBIO, 0);
	closesocket(listenSocket);
}

void GameServer::initPlayer(Player& p, BufferedSocket& bs, SOCKET s)
{
	bs.setSocket(s);
	p.setFieldSize(H_CELLS, V_CELLS);
}

void GameServer::processEvent(int _event, SOCKET s)
{
	switch (_event)
	{
	case FD_ACCEPT:
		switch (*state)
		{
		case WAITING_FOR_X:
			initPlayer(x, xSocket, accept(listenSocket, NULL, NULL));
			state = WAITING_FOR_Y;
			break;
		case WAITING_FOR_Y:
			initPlayer(y, ySocket, accept(listenSocket, NULL, NULL));
			stopListening();
			y.setOther(&x);
			x.setOther(&y);
			state = X_TURN;
			break;
		default:
			throw "Impossible state";
		}
		break;
	case FD_READ:
	case FD_WRITE:
	case FD_CLOSE:
		if (xSocket.isMine(s))
		{
			processEvent(_event, x, xSocket);
		}
		if (ySocket.isMine(s))
		{
			processEvent(_event, y, ySocket);
		}
		break;
	default:
		throw "Unexpected event";
	}
}

void GameServer::processEvent(int _event, Player& p, BufferedSocket& bs)
{
	switch (_event)
	{
	case FD_READ:
		bs.receiveAll();
		p.step();
		break;
	case FD_WRITE:
		bs.writeToSocket();
		p.step();
		break;
	case FD_CLOSE:
//		delete playerSockets[player];
//		playerSockets[player] = NULL;
		break;
	default:
		throw "Unexpected event";
	}
}