#include "stdafx.h"
#include <string>
#include "WindowEvents.h"
#include "Player.h"

#define CROSS_COLOR 0xFF0000
#define CIRCLE_COLOR 0x0000FF

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

void WindowPainter::drawGrid(HDC hDC, int cellSize)
{
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
}

void WindowPainter::fillGrid(HDC hDC, int cellSize)
{
	for (int x = 0; x < H_CELLS; x++)
	{
		for (int y = 0; y < V_CELLS; y++)
		{
			int l = x * cellSize;
			int t = y * cellSize;
			int f = 1;
			switch (gameServer.getGame().getCellState(x, y))
			{
			case Game::CROSS:
				SelectObject(hDC, CROSS_PEN);
				MoveToEx(hDC, l + f, t + f, NULL);
				LineTo(hDC, l + cellSize - f, t + cellSize - f);
				MoveToEx(hDC, l + f, t + cellSize - f, NULL);
				LineTo(hDC, l + cellSize - f, t + f);
				break;
			case Game::CIRCLE:
				SelectObject(hDC, CIRCLE_PEN);
				Ellipse(hDC, l + f, t + f, l + cellSize, t + cellSize);
				break;
			}
		}
	}
}

void drawPlayerStatus(HDC hDC, int x, int y, int lineHeight, const std::string& message, const std::string& name)
{
	TextOutA(hDC, x, y, message.c_str(), (int) message.size());
	y += lineHeight;
	TextOutA(hDC, x, y, name.c_str(), (int) name.size());
}

void WindowPainter::drawPlayerStatuses(HDC hDC, int cellSize)
{
	int field = 20;
	int x = cellSize * H_CELLS + field;
	int y = field;
	char* s = "X";
	SIZE size;
	GetTextExtentPoint32A(hDC, s, (int) strlen(s), &size);

	SetTextColor(hDC, CROSS_COLOR);
	drawPlayerStatus(hDC, x, y, size.cy, "X player:", gameServer.getX().getName());
	SetTextColor(hDC, CIRCLE_COLOR);
	drawPlayerStatus(hDC, x, y + size.cy * 2, size.cy, "O player:", gameServer.getY().getName());
}

void WindowPainter::drawMessageBox(HDC hDC, int cellSize)
{
	SetTextColor(hDC, 0);
	char* message = NULL;
	switch (gameServer.getState())
	{
	case GameServer::WAITING_FOR_X:
		message = "Waiting for the first player...";
		break;
	case GameServer::WAITING_FOR_Y:
		message = "Waiting for the second player...";
		break;
	}
	if (message == NULL)
	{
		switch (gameServer.getGame().getStatus())
		{
		case Game::CROSS_WON:
			message = "X has won!";
			break;
		case Game::CIRCLE_WON:
			message = "O has won!";
			break;
		case Game::CROSS_ERROR:
			message = "X has made an erroneous turn and lost!";
			break;
		case Game::CIRCLE_ERROR:
			message = "O has made an erroneous turn and lost!";
			break;
		}
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

void WindowPainter::paintWindow(HWND hWnd, HDC hDC)
{
	int cellSize = getCellSize(hWnd);
	drawGrid(hDC, cellSize);
	fillGrid(hDC, cellSize);
	drawPlayerStatuses(hDC, cellSize);
	drawMessageBox(hDC, cellSize);
}

void WindowPainter::repaint()
{
	InvalidateRect(hWnd, NULL, TRUE);
//	MessageBeep(-1);
//	RedrawWindow(hWnd, NULL, NULL, RDW_ERASE | RDW_INTERNALPAINT | RDW_INVALIDATE | RDW_UPDATENOW);
}	