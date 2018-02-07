#pragma once

#include "stdafx.h"
#include <iostream>
using namespace std;

class Beverage
{
public:
    Beverage()
    {
        this->brew();
    }

    void prepareRecipe()
    {
        boilWater();
        brew();
        pourInCup();
    }

    void boilWater()
    {
       cout << "Boil Water." << endl;
    }

    virtual void brew()
    {
        cout << "Brew Beverage." << endl;
    }

    void pourInCup()
    {
        cout << "Pour in cup." << endl;
    }
};
