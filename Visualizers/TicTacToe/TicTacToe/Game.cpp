#include "stdafx.h"
#include "TicTacToe.h"
#include "Game.h"
#include "WindowEvents.h"
#include "Server.h"

Game game;

Game::State Game::getState() const
{
	return state;
}

void Game::processEvent(int _event, SOCKET s)
{
	Player p = NONE;
	switch (state)
	{
	case WAITING_FOR_X:
		break;
	case X_TURN:
	case Y_TURN:
		if (playerSockets[Y]->isMine(s))
		{
			p = Y;
			s = SOCKET_ERROR;
		}
	case WAITING_FOR_Y:
		if (playerSockets[X]->isMine(s))
		{
			p = X;
			s = SOCKET_ERROR;
		}
		break;
	default:
		throw "panic";
	}
	processEvent(_event, p, s);
}

void Game::processEvent(int _event, Player player, SOCKET s)
{
	switch (_event)
	{
	case FD_ACCEPT:
		switch (state)
		{
		case WAITING_FOR_X:
			playerSockets[X] = new BufferedSocket(accept(s, NULL, NULL));
			state = WAITING_FOR_Y;
			sendIDAndField(YOU_ARE_X, X, H_CELLS, V_CELLS);
			repaint();
			break;
		case WAITING_FOR_Y:
			playerSockets[Y] = new BufferedSocket(accept(s, NULL, NULL));
			stopListening();
			sendIDAndField(YOU_ARE_Y, Y, H_CELLS, V_CELLS);
			playerSockets[X]->write(YOUR_TURN);
			state = X_TURN;
			repaint();
			break;
		default:
			throw "panic";
		}
		break;
	case FD_READ:
		{
			playerSockets[player]->receiveAll();
			if (!((state == X_TURN) && (player == X)) &&
				!((state == Y_TURN) && (player == Y)))
			{
				playerSockets[player]->clearReadBuffer();			
				break;
			}
			if (playerSockets[player]->areBytesReady(4))
			{
				WORD x = playerSockets[player]->readWord();
				WORD y = playerSockets[player]->readWord();
				processTurn(player, x, y);

				Sleep(400);

				Player other = (player == X) ? Y : X;
				playerSockets[other]->write(OTHER_PLAYERS_TURN_DATA, x, y);
				state = (state == X_TURN) ? Y_TURN : X_TURN;
			}
			break;
		}
	case FD_WRITE:
		playerSockets[player]->writeToSocket();
		break;
	case FD_CLOSE:
//		delete playerSockets[player];
//		playerSockets[player] = NULL;
		break;
	default:
		throw "panic";
	}
}

void Game::processTurn(Player player, int x, int y)
{
	setCellState(x, y, (player == X) ? CROSS : CIRCLE);
	repaint();
}

void Game::sendIDAndField(Message message, Player player, WORD w, WORD h)
{
	playerSockets[player]->write(message, w, h);
}

////////////////////////////////////////////////////////////////////////////////////////////

CellState field[H_CELLS][V_CELLS];

void clearField()
{
	for (int x = 0; x < H_CELLS; x++)
	{
		for (int y = 0; y < V_CELLS; y++)
		{
			field[x][y] = EMPTY;
		}
	}
}

bool setCellState(int x, int y, CellState value)
{
	if ((x < 0) || (x >= H_CELLS)
		|| (y < 0) || (y >= V_CELLS)
		|| field[x][y] != EMPTY)
	{
		return false;
	}
	field[x][y] = value;
	return true;
}

CellState getCellState(int x, int y)
{
	if ((x < 0) || (x >= H_CELLS)
		|| (y < 0) || (y >= V_CELLS))
	{
		throw FieldIndexOutOfBounds();
	}
	return field[x][y];
}