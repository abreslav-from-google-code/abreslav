#include "stdafx.h"
#include "Game.h"

////////////////////////////////////////////////////////////////////////////////////////////

void Game::clearField()
{
	status = PLAY;
	for (int x = 0; x < H_CELLS; x++)
	{
		for (int y = 0; y < V_CELLS; y++)
		{
			field[x][y] = EMPTY;
		}
	}
	notify();
}

Game::Status Game::getStatus() const
{
	return status;
}

void Game::setCellState(int x, int y, Game::CellState value)
{
	if ((x < 0) || (x >= H_CELLS)
		|| (y < 0) || (y >= V_CELLS)
		|| field[x][y] != EMPTY)
	{
		status = (value == CROSS) ? CROSS_ERROR : CIRCLE_ERROR;
	}
	else
	{
		field[x][y] = value;
	}
	notify();
	return;
}

Game::CellState Game::getCellState(int x, int y) const
{
	if ((x < 0) || (x >= H_CELLS)
		|| (y < 0) || (y >= V_CELLS))
	{
		throw FieldIndexOutOfBounds();
	}
	return field[x][y];
}