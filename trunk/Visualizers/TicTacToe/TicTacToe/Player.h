#pragma once

#include "Communicator.h"
#include "Observable.h"
#include <string>
#include "Game.h"

class Player : public Observable
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
		PLAY = 1,
		YOU_WIN = 2,
		YOU_LOOSE = 3,
		YOUR_ERROR = 4
	} StatusMessage;

	Player(Game& g, Communicator& c) 
		: game(g),
		  state(WAITING_FOR_FIELD),
		  other(NULL),
		  comm(c),
		  name("<unknown>")
	{
	}

	virtual ~Player()
	{
	}

	const std::string& getName() const
	{
		return name;
	}

	bool isNameReady() const
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
	virtual bool isWonStatus(Game::Status status) = 0;
	virtual bool isLostStatus(Game::Status status) = 0;
	virtual bool isErrorStatus(Game::Status status) = 0;

	bool isPlayStatus(Game::Status status)
	{
		return 
			!isWonStatus(status) 
			&& !isLostStatus(status) 
			&& !isErrorStatus(status);
	}

private:
	void othersNameReady();
	void opponentTurn(WORD x, WORD y, Game::Status s);
	State sendOthersName();
	State Player::processGameStatus(Game::Status s, State playState);

	Game& game;
	State state;
	Communicator& comm;
	std::string name;
	Player* other;
	WORD fWidth;
	WORD fHeight;
};

namespace m_or
{
	template <typename T> 
	class Base
	{
	public:
		static bool is(T v)
		{
			return false;
		}
	};

	template <typename T, T VALUE, typename B = Base<T>> 
	class Or : public B
	{
	public:
		static bool is(T v)
		{
			return (v == VALUE) || B::is(v);
		}
	};
}

template <
	Player::Message MESSAGE, 
	Player::State STATE, 
	Game::CellState CELL_STATE,
	typename WON_STATUS, // assumed to have static bool is(Game::Status)
	typename LOST_STATUS,
	typename ERROR_STATUS>
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

	virtual bool isWonStatus(Game::Status status)
	{
		return WON_STATUS::is(status);
	}

	virtual bool isLostStatus(Game::Status status)
	{
		return LOST_STATUS::is(status);
	}

	virtual bool isErrorStatus(Game::Status status)
	{
		return ERROR_STATUS::is(status);
	}
};

template <Game::Status VALUE, typename B = m_or::Base<Game::Status>> 
class SOr : public m_or::Or<Game::Status, VALUE, B>
{};

typedef SpecificPlayer<
		Player::YOU_ARE_X, 
		Player::WAITING_FOR_TURN_DATA, 
		Game::CROSS, 
		SOr<Game::CROSS_WON, SOr<Game::CIRCLE_ERROR>>,
		SOr<Game::CIRCLE_WON>, 
		SOr<Game::CROSS_ERROR>> 
	CrossPlayer;

typedef SpecificPlayer<
		Player::YOU_ARE_Y, 
		Player::WAITING_FOR_OTHERS_TURN_DATA, 
		Game::CIRCLE, 
		SOr<Game::CIRCLE_WON, SOr<Game::CROSS_ERROR>>,
		SOr<Game::CROSS_WON>, 
		SOr<Game::CIRCLE_ERROR>> 
	CirclePlayer;