#include "stdafx.h"
#include "Game.h"

////////////////////////////////////////////////////////////////////////////////////////////
const int line = 5;

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

Game::Status Game::checkStatus(int xx, int yy)
{
	int l = max(xx - line + 1, 0);
	int t = max (yy - line + 1, 0);
	int r = min (xx + line - 1, H_CELLS - 1);
	int b = min (yy + line - 1, V_CELLS - 1);

#define CHECK_LINE(x, y, dx, dy) \
	{\
		Status r = checkLine(x, y, dx, dy);\
		if (r != PLAY) \
		{\
			return r;\
		}\
	}

	CHECK_LINE(l, t, 1, 1);// main diagonal
	CHECK_LINE(l, b, 1, -1); // secondary diagonal
	CHECK_LINE(xx, t, 0, 1); // vertical
	CHECK_LINE(l, yy, 1, 0); // horizontal

	return PLAY;
}

Game::Status Game::checkLine(int x0, int y0, int dx, int dy)
{
	int c = 0;
	CellState lastState = EMPTY;
	for (int i = 0; i < line * 2 + 1; i++)
	{
		int x = x0 + i * dx;
		int y = y0 + i * dy;
		if (field[x][y] == lastState)
		{
			c++;
			if (c >= 5)
			{
				break;
			}
		}
		else
		{
			lastState = field[x][y];
			c = 1;
		}
	}

	if (c >= 5)
	{
		if (lastState == CROSS)
		{
			return CROSS_WON;
		} 
		else if (lastState == CIRCLE)
		{
			return CIRCLE_WON;
		}
	}
	return PLAY;
}

void Game::setCellState(int x, int y, Game::CellState value)
{
	if (status != PLAY)
	{
		return;
	}
	if ((x < 0) || (x >= H_CELLS)
		|| (y < 0) || (y >= V_CELLS)
		|| field[x][y] != EMPTY)
	{
		status = (value == CROSS) ? CROSS_ERROR : CIRCLE_ERROR;
	}
	else
	{
		field[x][y] = value;
		status = checkStatus(x, y);
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