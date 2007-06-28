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
	if (s == getWonStatus())
	{
		state = WON;
		comm.write(YOU_WIN);
	} else if (s == getLostStatus())
	{
		state = LOST;
		comm.write(YOU_LOOSE);
	} else if (s == getErrorStatus())
	{
		state = LOST;
		comm.write(YOUR_ERROR);
	} else {
		state = WAITING_FOR_TURN_DATA;
		comm.write(PLAY);
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
				throw "panic";
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
			state = WAITING_FOR_OTHERS_TURN_DATA;
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
		throw "panic";
	}
}
