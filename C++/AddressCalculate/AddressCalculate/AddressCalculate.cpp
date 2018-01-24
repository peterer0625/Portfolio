// AddressCalculate.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <iostream>
using namespace std;

int _tmain(int argc, _TCHAR* argv[])
{
    int a[3][4] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
    int *b[3] = { a[0], a[1], a[2] };
    cout << *(a) << endl;
    cout << *(a + 1) << endl;
    cout << *(b[0] + 1) << endl;

    return 0;
}

