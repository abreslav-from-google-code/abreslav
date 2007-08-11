#include "stdafx.h"
#include "Player.h"

void Player::setFieldSize(WORD w, WORD h)
{
	ASSERT(state == WAITING_FOR_FIELD);
	fWidth = w;
	fHeight = h;
	state = WAITING_FOR_HELLO;
}

void Player::setOther(Player* o)
{
	ASSERT(other == NULL);
	other = o;
	if (other->isNameReady())
	{
		othersNameReady();
	}
}

void Player::othersNameReady()
{
	if (state == WAITING_FOR_OTHERS_NAME)
	{
		state = sendOthersName();
	}
}

Player::State Player::sendOthersName()
{
	if (other == NULL || !other->isNameReady())
	{
		return WAITING_FOR_OTHERS_NAME;
	}
	comm.writeString(other->getName());
	return getFirstGameState();
}

void Player::opponentTurn(WORD x, WORD y, Game::Status s)
{
	ASSERT(state == WAITING_FOR_OTHERS_TURN_DATA);
	comm.write(x);
	comm.write(y);
	state = processGameStatus(s, WAITING_FOR_TURN_DATA);
}

void Player::gameRestarted()
{
	sendResultMessage(YOU_LOOSE);

	state = WAITING_FOR_FIELD;
	name = "<unknown>";
	other = NULL;
	fWidth = 0;
	fHeight = 0;

	comm.close();
}

void Player::surrender()
{
	if (other != NULL)
	{
		other->sendResultMessage(YOU_WIN);
	}
}

void Player::sendResultMessage(Player::StatusMessage s)
{
	switch (state) 
	{
	case WAITING_FOR_TURN_DATA:
	case WAITING_FOR_OTHERS_TURN_DATA:
		comm.write(fWidth);
		comm.write(fHeight);
		comm.write(s);
		break;
	case WON:
	case LOST:
		break;
	default:
		throw "Unsupported behaviour";
	}
}


Player::State Player::processGameStatus(Game::Status s, Player::State playState)
{
	if (isWonStatus(s))
	{
		comm.write(YOU_WIN);
		return WON;
	} 
	else if (isLostStatus(s))
	{
		comm.write(YOU_LOOSE);
		return LOST;
	} 
	else if (isErrorStatus(s))
	{
		comm.write(YOUR_ERROR);
		return LOST;
	} 
	else 
	{
		comm.write(PLAY);
		return playState;
	}
}

void Player::step()
{
	switch (state)
	{
	case WAITING_FOR_FIELD:
		// see setFieldSize()
		break;
	case WAITING_FOR_HELLO:
		if (comm.isTypeReady<Message>())
		{
			if (comm.read<Message>() != HELLO)
			{
				throw "Protocol expectation broken";
			}
			comm.write(getYouAreMessage());
			comm.write(fWidth);
			comm.write(fHeight);
			state = WAITING_FOR_NAME;
		}
		break;
	case WAITING_FOR_NAME:
		if (comm.isStringReady())
		{
			comm.readString(name);
			notify();
			state = sendOthersName();
			if (other != NULL)
			{
				other->othersNameReady();
			}
		}
		break;
	case WAITING_FOR_OTHERS_NAME:
		// see othersNameReady()
		break;
	case WAITING_FOR_TURN_DATA:
		if (comm.areBytesReady(sizeof(WORD) * 2))
		{
			WORD x = comm.read<WORD>();
			WORD y = comm.read<WORD>();
			game.setCellState(x, y, getMyCellState());
			other->opponentTurn(x, y, game.getStatus());
			if (!isPlayStatus(game.getStatus()))
			{
				comm.write(fWidth);
				comm.write(fHeight);
				state = processGameStatus(game.getStatus(), WAITING_FOR_OTHERS_TURN_DATA);
			}
			else
			{
				state = WAITING_FOR_OTHERS_TURN_DATA;
			}
		}
		break;
	case WAITING_FOR_OTHERS_TURN_DATA:
		// see opponentTurn()
		break;
	case WON:
		break;
	case LOST:
		break;
	default:
		throw "Impossible state";
	}
}
