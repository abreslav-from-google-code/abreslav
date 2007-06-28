#include "stdafx.h"
#include "Server.h"

class WindowPainter
{
public:
	WindowPainter(GameServer& gs, HWND h)
		: gameServer(gs),
		  hWnd(h)
	{
		repaintObserver.setEncloser(this);
		gameServer.addStateObserver(&repaintObserver);	
		gameServer.addGameObserver(&repaintObserver);
	}

	~WindowPainter()
	{
		gameServer.removeStateObserver(&repaintObserver);
		gameServer.removeGameObserver(&repaintObserver);
	}

	void repaint();
	void paintWindow(HWND hWnd, HDC hDC);
private:
	WindowPainter(WindowPainter&);
	HWND hWnd;
	GameServer& gameServer;

	static WindowPainter INSTANCE;

	class RepaintObserver : public Nested<WindowPainter>, public Observer 
	{
	public:
		virtual void valueChanged()
		{
			encloser->repaint();
		}
	} repaintObserver;
};