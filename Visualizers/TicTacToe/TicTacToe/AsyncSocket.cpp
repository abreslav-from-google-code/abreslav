#include "stdafx.h"
#include "AsyncSocket.h"

void AsyncSocket::write(const void* buffer, size_t len)
{
	wBuf.write(buffer, len);
	writeToSocket();
}

void AsyncSocket::read(void* buffer, size_t len)
{
	rBuf.read(buffer, len);
}

void AsyncSocket::peek(void* buffer, size_t len)
{
	rBuf.peek(buffer, len);
}

void AsyncSocket::close()
{
	shutdown(socket, SD_SEND);
// The socket is closed by GameServer when it receives FD_CLOSE
	//	closesocket(socket);
	

	rBuf.clear();
	wBuf.clear();
	socket = SOCKET_ERROR;
}

bool AsyncSocket::areBytesReady(size_t size)
{
	return size <= rBuf.getSize();
}

int AsyncSocket::writeToSocket()
{
	if (wBuf.isEmpty())
	{
		return 0;
	}
	int sent = send(socket, wBuf.getStartAddress(), (int) wBuf.getSize(), 0);
	wBuf.remove(sent);
	return sent;
}

void AsyncSocket::receiveAll()
{
	int count = recv(socket, rBuf.getEndAddress(), BUFSIZE, 0);
	rBuf.append(count);
}

void AsyncSocket::clearReadBuffer()
{
	rBuf.clear();
}

bool AsyncSocket::isMine(SOCKET s)
{
	return s == socket;
}

//////////////////////////////////////

void Buffer::write(const void* buf, size_t len)
{
	if (end + len - 1 >= BUFSIZE)
	{
		throw "Written data exceeds buffer size";
	}

	for (size_t i = 0; i < len; i++)
	{
		buffer[end + i] = ((char*) buf)[i];
	}
	append(len);
}

void Buffer::peek(void* buf, size_t len)
{
	if (len > getSize())
	{
		throw "Attempt to read more data than available";
	}

	for (size_t i = 0; i < len; i++)
	{
		((char*) buf)[i] = buffer[start + i];
	}
}

void Buffer::read(void* buf, size_t len)
{
	peek(buf, len);
	remove(len);
}

void Buffer::remove(size_t count)
{
	if (count > 0)
	{
		start += count;
		if (start >= end)
		{
			start = 0;
			end = 0;
		}
	}
}

void Buffer::append(size_t count)
{
	if (count > 0)
	{
		if (end > BUFSIZE)
		{
			throw "Stored data exceeds buffer size";
		}
		end += count;
	}
}

void Buffer::clear()
{
	remove(getSize());
}

