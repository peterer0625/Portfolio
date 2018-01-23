#pragma once
#include "Base.h"

#include <iostream>
using namespace std;

class Child : Base
{
private:

public:
    Child()
    {
        cout << "Child" << endl;
        print();
    }

    void print()
    {
        cout << "Child's print." << endl;
    }
};