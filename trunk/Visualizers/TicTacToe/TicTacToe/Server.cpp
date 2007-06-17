#include "stdafx.h"
#include "Server.h"
#include "Game.h"

#define HOST "127.0.0.1"
#define PORT 10000

SOCKET ListenSocket;

ServerResult setupServer()
{
	//----------------------
	// Initialize Winsock
	WSADATA wsaData;
	int iResult = WSAStartup(MAKEWORD(2,2), &wsaData);
	if (iResult != NO_ERROR)
	{
		return SERVER_ERROR;
	}

	//----------------------
	// Create a SOCKET for listening for 
	// incoming connection requests
	ListenSocket = socket(AF_INET, SOCK_STREAM, IPPROTO_TCP);
	if (ListenSocket == INVALID_SOCKET) 
	{
		WSACleanup();
		return SERVER_ERROR;
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
	if (bind( ListenSocket, 
		(SOCKADDR*) &service, 
		sizeof(service)) == SOCKET_ERROR) 
	{
			closesocket(ListenSocket);
			return SERVER_ERROR;
	}

	//----------------------
	// Listen for incoming connection requests 
	// on the created socket
	if (listen( ListenSocket, 2 ) == SOCKET_ERROR)
	{
		return SERVER_ERROR;
	}

	return SERVER_OK;
}

ServerResult startServer(HWND hWnd)
{
	if (WSAAsyncSelect(ListenSocket, 
		hWnd, SOCKET_EVENT, 
		FD_READ | FD_WRITE | FD_ACCEPT | FD_CLOSE) != 0)
	{
		return SERVER_ERROR;
	}
	return SERVER_OK;
}

void socketEventHandler(HWND hWnd, SOCKET s, int _event, int error)
{
	game.processEvent(_event, s);
}

void stopListening()
{
	closesocket(ListenSocket);
}

void shutdownServer(HWND hWnd)
{
	WSACleanup();
}