// mul.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <iostream>
#include <string>
using namespace std;

int mul(int x, int y)
{
    int result = 0;
    while (x != 0)
    {
        if (x & 1 == 0)
        {
            result = result;
        }
        else
        {
            result = result + y;
        }

        y = y << 1;
        x = x >> 1;
    }

    return result;
}

int _tmain(int argc, _TCHAR* argv[])
{
    cout << std::to_string(mul(3, 5)) << endl;
    return 0;
}

