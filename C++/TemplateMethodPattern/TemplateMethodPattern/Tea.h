#pragma once

#include "stdafx.h"
#include "Beverage.h"
#include <iostream>
using namespace std;

class Tea : Beverage
{
public:
    void brew()
    {
        cout << "Brew Tea." << endl;
    }
};