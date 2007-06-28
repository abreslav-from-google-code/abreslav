#pragma once

#pragma once

#include <exception>
#include "Observable.h"

#define H_CELLS 30
#define V_CELLS (H_CELLS + 5)

class FieldIndexOutOfBounds : public std::exception
{
	virtual const char* what() const throw()
	{
		return "Field index out of bounds";
	}
};

#define THROW(a) 

class Game : public Observable
{
public:
	typedef enum
	{
		EMPTY,
		CROSS,
		CIRCLE
	} CellState;

	typedef enum
	{
		PLAY,
		CROSS_WON,
		CIRCLE_WON,
		CROSS_ERROR,
		CIRCLE_ERROR
	} Status;

	Game()
		: status(PLAY)
	{
		clearField();
	}

	void clearField();
	void setCellState(int x, int y, CellState value);
	Status getStatus() const;
	CellState getCellState(int x, int y) const THROW(FieldIndexOutOfBounds) ;
private:
	CellState field[H_CELLS][V_CELLS];
	Status status;
};