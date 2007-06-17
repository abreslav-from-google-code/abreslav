#pragma once

#include "BufferedSocket.h"

class Game
{
public:
	typedef enum
	{
		WAITING_FOR_X = 1,
		WAITING_FOR_Y = 2,
		X_TURN = 3,
		Y_TURN = 4
	} State;

	Game() : state(WAITING_FOR_X)
	{}

	~Game()
	{
		if (state != WAITING_FOR_X)
		{
			delete playerSockets[X];
		}
		if (state != WAITING_FOR_Y)
		{
			delete playerSockets[Y];
		}
	}

	void processEvent(int _event, SOCKET s);
	State getState() const;
	
	typedef enum
	{
		YOU_ARE_X = 100,
		YOU_ARE_Y = 101,
		YOUR_TURN = 102,
		OTHER_PLAYERS_TURN_DATA = 103,
	} Message;

private:
	typedef enum
	{
		NONE = -1,
		X = 0, 
		Y = 1
	} Player;
	
	void processEvent(int _event, Player player, SOCKET s);
	void processTurn(Player player, int x, int y);
	void sendIDAndField(Message message, Player player, WORD w, WORD h);
	State state;
	BufferedSocket* playerSockets[2];
};

extern Game game;

