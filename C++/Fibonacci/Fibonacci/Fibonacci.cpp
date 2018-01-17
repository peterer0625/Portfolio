// Fibonacci.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <iostream>
using namespace std;

// f(n) = f(n-1) + f(n-2)
// f(0) = 1
// f(1) = 1

int _tmain(int argc, _TCHAR* argv[])
{
    int n = 5;
    int* f = new int[n + 1];
    f[0] = 1;
    f[1] = 1;
    for (int i = 2; i <= n; i++)
    {
        f[i] = f[i - 1] + f[i - 2];
    }

    cout << f[n] << endl;

    return 0;
}

