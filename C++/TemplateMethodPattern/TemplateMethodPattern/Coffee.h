#pragma once

#include "stdafx.h"
#include "Beverage.h"
#include <iostream>
using namespace std;

class Coffee : Beverage
{
public:
    void brew()
    {
        cout << "Brew Coffee." << endl;
    }
};