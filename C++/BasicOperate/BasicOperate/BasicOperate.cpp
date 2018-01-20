// BasicOperate.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <iostream>
using namespace std;

int min(int a, int b, int c)
{
    return (a <= b && a <= c) ? a : (b <= c ? b : c);
}

int _tmain(int argc, _TCHAR* argv[])
{
    // i++ ++i
    int i = 0;
    i = i++ + ++i;
    cout << i << endl;

    cout << "----------------------------------------" << endl;

    // Escapes
    cout << "\\\" \\" << endl;

    cout << "----------------------------------------" << endl;

    // condition ? a : b
    cout << min(1, 100, -25) << endl;

    cout << "----------------------------------------" << endl;

    // continue, if
    for (int i = 0; i < 15; i++)
    {
        if (i <= 4 && i >= 6)
        {
            continue;
        }

        if (i > 10)
        {
            cout << "i > 10" << endl;
        }
    }

    cout << "----------------------------------------" << endl;

    // two dimension array allocate 
    int **ppArray = NULL;
    ppArray = new int*[3];

    for (int i = 0; i < 3; i++)
    {
        ppArray[i] = new int[3];
    }

    for (int i = 0; i < 3; i++)
    {
        for (int j = 0; j < 3; j++)
        {
            ppArray[i][j] = i * j;
        }
    }

    for (int i = 0; i < 3; i++)
    {
        for (int j = 0; j < 3; j++)
        {
            cout << ppArray[i][j] << endl;
        }
    }
    
    for (int i = 0; i < 3; i++)
    {
        delete[] ppArray[i];
    }

    delete[] ppArray;

    cout << "----------------------------------------" << endl;

    int a = 1;
    int *p = &a;
    cout << *p + 1 << endl;

    int **pp = &p;
    cout << **pp + 1 << endl;

    cout << "----------------------------------------" << endl;
    int aa = 1;
    int bb = 1;
    int cc = aa+++bb++;
    cout << aa << endl;
    cout << bb << endl;
    cout << cc << endl;

    cout << "----------------------------------------" << endl;
    // const

    const int d = 0;
    int const e = 0;

    // compile error
    // d = 1;
    // e = 1;
    int z = 1;
    int* const f = &z;
    cout << *f << endl;
    *f = 2;
    cout << *f << endl;

    // compile error
    // int y = 1;
    // f = &y;

    const int &x = 100;
    // compile error
    // x = 200;
    cout << x << endl;
    
    const int *g = &z;
    // compile error
    // *g = 1;
    g = &e;

    // bit operation
    int value = -1;
    int r = value >> 1;
    cout << r << endl;

    value = 1;
    r = value >> 1;
    cout << r << endl;

    return 0;
}

