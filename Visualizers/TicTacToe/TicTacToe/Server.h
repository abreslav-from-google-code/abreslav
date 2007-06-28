#pragma once
#include "Winsock2.h"

#define SOCKET_EVENT WM_USER + 1

#include "BufferedSocket.h"
#include "Observable.h"
#include "Player.h"

class GameServer
{
public:
	typedef enum
	{
		WAITING_FOR_X = 1,
		WAITING_FOR_Y = 2,
		X_TURN = 3,
		Y_TURN = 4
	} State;
	
	typedef enum
	{
		RESULT_ERROR,
		RESULT_OK
	} Result;

	GameServer(Game& g) 
		: state(WAITING_FOR_X),
		  game(g),
		  x(g, xSocket),
		  y(g, ySocket)
	{
	}

	~GameServer()
	{
		WSACleanup();
	}

	Result setup();
	Result start(HWND hWnd);
	void handleEvent(HWND hWnd, SOCKET s, int _event, int error);

	State getState() const
	{
		return *state;
	}

	void addStateObserver(Observer* so)
	{
		state.addObserver(so);
	}

	void removeStateObserver(Observer* so)
	{
		state.removeObserver(so);
	}

	void addGameObserver(Observer* so)
	{
		game.addObserver(so);
	}

	void removeGameObserver(Observer* so)
	{
		game.removeObserver(so);
	}

	const Game& getGame() const
	{
		return game;
	}
	
private:
	void stopListening();
	void processEvent(int _event, SOCKET s);
	void initPlayer(Player& p, BufferedSocket& bs, SOCKET s);
	void processEvent(int _event, Player& p, BufferedSocket& bs);

	Game& game;
	SOCKET listenSocket;
	ObservableProperty<State> state;
	BufferedSocket xSocket;
	BufferedSocket ySocket;
	CrossPlayer x;
	CirclePlayer y;
};