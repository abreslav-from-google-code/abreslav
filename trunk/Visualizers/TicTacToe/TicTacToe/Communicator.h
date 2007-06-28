#pragma once
#include <exception>
#include <string>

#define UC_THROW(a)

class BufferUnderflowException : std::exception
{
	virtual const char* what() const throw()
	{
		return "Buffer inderflow";
	}
};

class Communicator
{
public:
	virtual ~Communicator()
	{
	}
	
	template<typename T>
	void write(T data)
	{
		write(&data, sizeof(data));
	}
	
	virtual bool areBytesReady(size_t size) = 0;
	
	template<typename T>
	bool isTypeReady()
	{
		return areBytesReady(sizeof(T));
	}

	template<typename T>
	T read() UC_THROW(BufferUnderflowException)
	{
		if (!isTypeReady<T>())
		{
			throw BufferUnderflowException();
		}
		T result;
		read(&result, sizeof(result));
		return result;
	}
	
	void writeString(const std::string& s);
	bool isStringReady();
	void readString(std::string& s) UC_THROW(BufferUnderflowException);
protected:
	virtual void write(const void* buffer, size_t len) = 0;
	virtual void read(void* buffer, size_t len) = 0;
	virtual void peek(void* buffer, size_t len) = 0;
};