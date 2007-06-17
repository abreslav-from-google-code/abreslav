#pragma once

#include <exception>

#define H_CELLS 30
#define V_CELLS (H_CELLS + 5)

typedef enum
{
	EMPTY,
	CROSS,
	CIRCLE
} CellState;

class FieldIndexOutOfBounds : public std::exception
{
	virtual const char* what() const throw()
	{
		return "Field index out of bounds";
	}
};

#define THROW(a) 

void clearField();
bool setCellState(int x, int y, CellState value);
CellState getCellState(int x, int y) THROW(FieldIndexOutOfBounds);