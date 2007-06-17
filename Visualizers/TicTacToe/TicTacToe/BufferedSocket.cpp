#include "stdafx.h"
#include "BufferedSocket.h"

void BufferedSocket::write(char message)
{
	write(&message, 1);
	writeToSocket();
}

void BufferedSocket::write(char message, WORD data1, WORD data2)
{
	write(&message, 1);
	write((char*) &data1, 2);
	write((char*) &data2, 2);
	writeToSocket();	
}


int BufferedSocket::writeToSocket()
{
	if (start > end)
	{
		return 0;
	}
	int sent = send(socket, &buffer[start], end - start + 1, 0);
	if (sent > 0)
	{
		start += sent;
		if (start > end)
		{
			start = 0;
			end = -1;
		}
	}
	return sent;
}

WORD BufferedSocket::readWord()
{
	WORD res;
	int r = recv(socket, (char*) &res, sizeof(res), 0);
	if (r < sizeof(res))
	{
		throw "panic";
	}
	return res;
}

bool BufferedSocket::isMine(SOCKET s)
{
	return s == socket;
}

void BufferedSocket::write(char* buf, int len)
{
	if (end + len >= BUFSIZE)
	{
		throw "panic";
	}

	for (int i = 0; i < len; i++)
	{
		buffer[end + i + 1] = buf[i];
	}
	end += len;
}
