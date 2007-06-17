#include "stdafx.h"
#include "TicTacToe.h"
#include "Game.h"
#include "WindowEvents.h"

#define CROSS_COLOR 0xFF0000
#define CIRCLE_COLOR 0x0000FF

extern HWND hWnd;

int getCellSize(HWND hWnd)
{
	RECT r;
	GetClientRect(hWnd, &r);
	
	return min(
		(r.right - r.left) / H_CELLS, 
		(r.bottom - r.top) / V_CELLS
	);

}

HPEN CROSS_PEN = CreatePen(PS_SOLID, 2, CROSS_COLOR);
HPEN CIRCLE_PEN = CreatePen(PS_SOLID, 2, CIRCLE_COLOR);
HPEN GRID_PEN = (HPEN) GetStockObject(BLACK_PEN);

void paintWindow(HWND hWnd, HDC hDC)
{
	int cellSize = getCellSize(hWnd);
	SelectObject(hDC, GRID_PEN);
	for (int x = 0; x < H_CELLS + 1; x++)
	{
		MoveToEx(hDC, x * cellSize, 0, NULL);
		LineTo(hDC, x * cellSize, V_CELLS * cellSize);
	}
	for (int y = 0; y < V_CELLS + 1; y++)
	{
		MoveToEx(hDC, 0, y * cellSize, NULL);
		LineTo(hDC, H_CELLS * cellSize, y * cellSize);
	}
	for (int x = 0; x < H_CELLS; x++)
	{
		for (int y = 0; y < V_CELLS; y++)
		{
			int l = x * cellSize;
			int t = y * cellSize;
			int f = 1;
			switch (getCellState(x, y))
			{
			case CROSS:
				SelectObject(hDC, CROSS_PEN);
				MoveToEx(hDC, l + f, t + f, NULL);
				LineTo(hDC, l + cellSize - f, t + cellSize - f);
				MoveToEx(hDC, l + f, t + cellSize - f, NULL);
				LineTo(hDC, l + cellSize - f, t + f);
				break;
			case CIRCLE:
				SelectObject(hDC, CIRCLE_PEN);
				Ellipse(hDC, l + f, t + f, l + cellSize, t + cellSize);
				break;
			}
		}
	}

	char* message = NULL;
	switch (game.getState())
	{
	case Game::WAITING_FOR_X:
		message = "Waiting for the first player...";
		break;
	case Game::WAITING_FOR_Y:
		message = "Waiting for the second player...";
		break;
	}
	if (message != NULL)
	{
		SIZE size;
		int len = (int) strlen(message);
		GetTextExtentPoint32A(hDC, message, len, &size);
		int w = cellSize * H_CELLS;
		int h = cellSize * V_CELLS;
		SelectObject(hDC, GRID_PEN);
		int l = (w - size.cx) / 2;
		int t = (h - size.cy) / 2;
		int f = 10;
		int rl = l - f;
		int rt = t - f;
		int rr = l + size.cx + f;
		int rb = t + size.cy + f;
		int shift = 3;
		SelectObject(hDC, GetStockObject(BLACK_BRUSH));
		Rectangle(hDC, rl + shift, rt + shift, rr + shift, rb + shift);
		SelectObject(hDC, GetStockObject(WHITE_BRUSH));
		Rectangle(hDC, rl, rt, rr, rb);
		TextOutA(hDC, l, t, message, len);
	}
}

void handleLeftClick(HWND hWnd, int xPos, int yPos)
{
/*	static int c = 0;
	int cellSize = getCellSize(hWnd);
	int x = xPos / cellSize;
	int y = yPos / cellSize;
	if (setCellState(x, y, ((c % 2) ? CROSS : CIRCLE)))
	{
		c++;
	}
	InvalidateRect(hWnd, NULL, TRUE);*/
}

void repaint()
{
	InvalidateRect(hWnd, NULL, TRUE);
}	