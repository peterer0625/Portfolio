// Define.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <iostream>
using namespace std;

#define AAA 123

void TestA()
{
    cout << AAA << endl;
}

void TestB()
{
    cout << AAA << endl;
}

int _tmain(int argc, _TCHAR* argv[])
{
    TestA();
    TestB();
    return 0;
}

