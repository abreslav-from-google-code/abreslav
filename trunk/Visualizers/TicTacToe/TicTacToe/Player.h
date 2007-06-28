#pragma once

#include "Communicator.h"
#include <string>
#include "Game.h"

class Player
{
public:
	typedef enum
	{
		HELLO = 99,
		YOU_ARE_X = 100,
		YOU_ARE_Y = 101,
	} Message;

	typedef enum
	{
		WAITING_FOR_FIELD = 1,
		WAITING_FOR_HELLO = 2,
		WAITING_FOR_NAME = 3,
		WAITING_FOR_OTHERS_NAME = 4,
		WAITING_FOR_TURN_DATA = 5,
		WAITING_FOR_OTHERS_TURN_DATA = 6,
		WON = 7,
		LOST = 8
	} State;

	typedef enum
	{
		PLAY,
		YOU_WIN,
		YOU_LOOSE,
		YOUR_ERROR
	} StatusMessage;

	Player(Game& g, Communicator& c) 
		: game(g),
		  state(WAITING_FOR_FIELD),
		  other(NULL),
		  comm(c)
	{
	}

	virtual ~Player()
	{
	}

	const std::string& getName() const
	{
		return name;
	}

	bool isNameReady()
	{
		return state > WAITING_FOR_NAME;
	}

	void setOther(Player* o);
	void setFieldSize(WORD w, WORD h);
	void step();
protected:
	virtual Message getYouAreMessage() = 0;
	virtual State getFirstGameState() = 0;
	virtual Game::CellState getMyCellState() = 0;
	virtual Game::Status getWonStatus() = 0;
	virtual Game::Status getLostStatus() = 0;
	virtual Game::Status getErrorStatus() = 0;

private:
	void othersNameReady();
	void opponentTurn(WORD x, WORD y, Game::Status s);
	State sendOthersName();

	Game& game;
	State state;
	Communicator& comm;
	std::string name;
	Player* other;
	WORD fWidth;
	WORD fHeight;
};

template <
	Player::Message MESSAGE, 
	Player::State STATE, 
	Game::CellState CELL_STATE,
	Game::Status WON_STATUS,
	Game::Status LOST_STATUS,
	Game::Status ERROR_STATUS>
class SpecificPlayer : public Player
{
public:
	SpecificPlayer(Game& g, Communicator& c)
		: Player(g, c)
	{
	}
protected:
	virtual Player::Message getYouAreMessage()
	{
		return MESSAGE;
	}

	virtual Player::State getFirstGameState()
	{
		return STATE;
	}

	virtual Game::CellState getMyCellState()
	{
		return CELL_STATE;
	}

	virtual Game::Status getWonStatus()
	{
		return WON_STATUS;
	}

	virtual Game::Status getLostStatus()
	{
		return LOST_STATUS;
	}

	virtual Game::Status getErrorStatus()
	{
		return ERROR_STATUS;
	}
};

typedef SpecificPlayer<
		Player::YOU_ARE_X, 
		Player::WAITING_FOR_TURN_DATA, 
		Game::CROSS, Game::CROSS_WON, 
		Game::CIRCLE_WON, Game::CROSS_ERROR> 
	CrossPlayer;

typedef SpecificPlayer<
		Player::YOU_ARE_Y, 
		Player::WAITING_FOR_OTHERS_TURN_DATA, 
		Game::CIRCLE, Game::CIRCLE_WON, 
		Game::CROSS_WON, Game::CIRCLE_ERROR> 
	CirclePlayer;