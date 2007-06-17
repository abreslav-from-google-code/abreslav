#pragma once

#include "Winsock2.h"

#define BUFSIZE 1024

class BufferedSocket
{
public:
	explicit BufferedSocket(SOCKET s) : socket(s), start(0), end(-1) 
	{}

	~BufferedSocket()
	{
		WSAAsyncSelect(socket, 0, 0, 0);	
		ioctlsocket(socket, FIONBIO, 0);	
		shutdown(socket, SD_SEND);
		closesocket(socket);	
	}

	void write(char message);
	void write(char message, WORD data1, WORD data2);
	int writeToSocket();
	WORD readWord();
	bool isMine(SOCKET s);

private:
	void write(char* buf, int len);

	SOCKET socket;
	char buffer[BUFSIZE];
	int start;
	int end;
};
