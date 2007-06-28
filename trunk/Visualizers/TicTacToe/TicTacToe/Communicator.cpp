#include "stdafx.h"
#include "Communicator.h"

#define READSTR_BUFSIZE 1024

void Communicator::writeString(const std::string& s)
{
	write(s.size());
	write(s.c_str(), s.size());
}
bool Communicator::isStringReady()
{
	if (!isTypeReady<std::string::size_type>())
	{
		return false;
	}
	std::string::size_type size;
	peek(&size, sizeof(size));
	return areBytesReady(size + sizeof(size));
}

void Communicator::readString(std::string& s) UC_THROW(BufferUnderflowException)
{
	if (!isTypeReady<std::string::size_type>())
	{
		throw BufferUnderflowException();
	}
	std::string::size_type size;
	read(&size, sizeof(size));

	if (!areBytesReady(size))
	{
		throw BufferUnderflowException();
	}
	
	char buffer[READSTR_BUFSIZE + 1];
	s = "";
	
	while (size > 0)
	{
		size_t toRead = min(size, READSTR_BUFSIZE - 1);
		read(buffer, toRead);
		buffer[toRead] = 0;
		s += buffer;
		size -= toRead;
	}
}
