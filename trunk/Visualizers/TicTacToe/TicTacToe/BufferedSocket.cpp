#include "stdafx.h"
#include "BufferedSocket.h"

void BufferedSocket::write(char message)
{
	wBuf.write(&message, 1);
	writeToSocket();
}

void BufferedSocket::write(char message, WORD data1, WORD data2)
{
	wBuf.write(&message, 1);
	wBuf.write(&data1, 2);
	wBuf.write(&data2, 2);
	writeToSocket();	
}


int BufferedSocket::writeToSocket()
{
	if (wBuf.isEmpty())
	{
		return 0;
	}
	int sent = send(socket, wBuf.getStartAddress(), wBuf.getSize(), 0);
	wBuf.remove(sent);
	return sent;
}

WORD BufferedSocket::readWord()
{
	WORD res;
	rBuf.read(&res, sizeof(res));
	return res;
}

void BufferedSocket::receiveAll()
{
	int count = recv(socket, rBuf.getEndAddress(), BUFSIZE, 0);
	rBuf.append(count);
}

bool BufferedSocket::areBytesReady(int count)
{
	return count <= rBuf.getSize();
}

void BufferedSocket::clearReadBuffer()
{
	rBuf.clear();
}

bool BufferedSocket::isMine(SOCKET s)
{
	return s == socket;
}

//////////////////////////////////////

void Buffer::write(const void* buf, int len)
{
	if (end + len >= BUFSIZE)
	{
		throw "panic";
	}

	for (int i = 0; i < len; i++)
	{
		buffer[end + i + 1] = ((char*) buf)[i];
	}
	append(len);
}

void Buffer::read(void* buf, int len)
{
	if (len > getSize())
	{
		throw "panic";
	}

	for (int i = 0; i < len; i++)
	{
		((char*) buf)[i] = buffer[start + i];
	}
	remove(len);
}

void Buffer::remove(int count)
{
	if (count > 0)
	{
		start += count;
		if (start > end)
		{
			start = 0;
			end = -1;
		}
	}
}

void Buffer::append(int count)
{
	if (count > 0)
	{
		if (end >= BUFSIZE)
		{
			throw "panic";
		}
		end += count;
	}
}

void Buffer::clear()
{
	remove(getSize());
}

