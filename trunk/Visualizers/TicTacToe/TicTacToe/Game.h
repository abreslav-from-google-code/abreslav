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
		PLAY = 0,
		CROSS_WON = 1,
		CIRCLE_WON = 2,
		CROSS_ERROR = 3,
		CIRCLE_ERROR = 4
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
	Status checkStatus(int xx, int yy);
	Status checkLine(int x0, int y0, int dx, int dy);

	CellState field[H_CELLS][V_CELLS];
	Status status;
};