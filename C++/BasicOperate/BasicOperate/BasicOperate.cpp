// BasicOperate.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <iostream>
using namespace std;


int _tmain(int argc, _TCHAR* argv[])
{
    int i = 0;
    i = i++ + ++i;
    cout << i << endl;
    return 0;
}

