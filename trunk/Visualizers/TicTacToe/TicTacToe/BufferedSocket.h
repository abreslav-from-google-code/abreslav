#pragma once

#include "Winsock2.h"

#define BUFSIZE 1024

class Buffer
{
public:
	Buffer() : start(0), end(-1)
	{
	}

	const char* getStartAddress() const
	{
		return &buffer[start];
	}

	char* getEndAddress()
	{
		return &buffer[end + 1];
	}

	void write(const void* buf, int len);
	void read(void* buf, int len);
	void remove(int count);
	void append(int count);
	void clear();

	bool isEmpty() const
	{
		return start > end;
	}

	int getSize() const
	{
		return end - start + 1;
	}
private:
	char buffer[BUFSIZE];
	int start;
	int end;
};

class BufferedSocket
{
public:
	explicit BufferedSocket(SOCKET s) : socket(s) 
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
	void receiveAll();
	void clearReadBuffer();
	bool areBytesReady(int count);
	WORD readWord();
	bool isMine(SOCKET s);

private:
	SOCKET socket;

	Buffer rBuf;
	Buffer wBuf;
};
