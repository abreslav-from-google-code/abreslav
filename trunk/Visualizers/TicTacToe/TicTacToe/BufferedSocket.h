#pragma once

#include "Winsock2.h"
#include "Communicator.h"

#define BUFSIZE 1024

class Buffer
{
public:
	Buffer() : start(0), end(0)
	{
	}

	const char* getStartAddress() const
	{
		return &buffer[start];
	}

	char* getEndAddress()
	{
		return &buffer[end];
	}

	void write(const void* buf, size_t len);
	void read(void* buf, size_t len);
	void peek(void* buf, size_t len);
	void remove(size_t count);
	void append(size_t count);
	void clear();

	bool isEmpty() const
	{
		return start > end;
	}

	size_t getSize() const
	{
		return end - start;
	}
private:
	char buffer[BUFSIZE];
	size_t start;
	size_t end;
};

class BufferedSocket : public Communicator
{
public:
	explicit BufferedSocket() : socket(SOCKET_ERROR) 
	{}

	virtual ~BufferedSocket()
	{
		WSAAsyncSelect(socket, 0, 0, 0);	
		ioctlsocket(socket, FIONBIO, 0);	
		shutdown(socket, SD_SEND);
		closesocket(socket);	
	}

	void setSocket(SOCKET s)
	{
		if (socket != SOCKET_ERROR)
		{
			throw "panic";
		}
		socket = s;
	}

	virtual bool areBytesReady(size_t size);

	int writeToSocket();
	void receiveAll();
	void clearReadBuffer();
	bool isMine(SOCKET s);

protected:
	virtual void write(const void* buffer, size_t len);
	virtual void read(void* buffer, size_t len);
	virtual void peek(void* buffer, size_t len);
private:
	SOCKET socket;

	Buffer rBuf;
	Buffer wBuf;
};
