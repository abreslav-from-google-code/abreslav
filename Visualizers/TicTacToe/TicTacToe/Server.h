#pragma once
#include "Winsock2.h"

typedef enum
{
	SERVER_ERROR,
	SERVER_OK
} ServerResult;

#define SOCKET_EVENT WM_USER + 1

ServerResult setupServer();
ServerResult startServer(HWND hWnd);
void socketEventHandler(HWND hWnd, SOCKET s, int _event, int error);
void shutdownServer(HWND hWnd);