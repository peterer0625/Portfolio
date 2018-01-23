#pragma once

#include <iostream>
using namespace std;

class Base
{
private:

public:
    Base()
    {
        cout << "Base" << endl;
        print();
    }

    virtual void print();
};