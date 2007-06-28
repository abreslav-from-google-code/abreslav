#pragma once

#include <set>

template <typename T>
class Nested
{
public:
	Nested()
		: encloser(NULL)
	{}

	void setEncloser(T* e)
	{
		encloser = e;
	}
protected:
	T* encloser;
};

class Observer
{
public:
	virtual void valueChanged() = 0;
};

class Observable
{
public:
	void addObserver(Observer* o)
	{
		observers.insert(o);
	}
	
	void removeObserver(Observer* o)
	{
		observers.erase(o);
	}

protected:
	void notify()
	{
		for (std::set<Observer*>::iterator i = observers.begin(); i != observers.end(); i++)
		{
			(*i)->valueChanged();
		}
	}

private:
	std::set<Observer*> observers;
};

template <typename T>
class ObservableProperty : public Observable
{
public:
	ObservableProperty(T x) : value(x)
	{
	}

	ObservableProperty()
	{
	}

	T& operator=(const T other)
	{
		if (value != other)
		{
			value = other;
			notify();
		}
		return value;
	}

	const T& operator*() const
	{
		return value;
	}
private:
	T value;
};