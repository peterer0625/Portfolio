// VariableLifeCycle.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <iostream>
using namespace std;

int golbalVariable = 0;

void fun1()
{
    static int staticVariable = 0;
    int localVariable1 = 0;

    golbalVariable++;
    staticVariable++;
    localVariable1++;

    cout << golbalVariable << endl;
    cout << staticVariable << endl;
    cout << localVariable1 << endl;
}

void fun2()
{
    static int staticVariable = 0;
    int localVariable1 = 0;

    golbalVariable++;
    staticVariable++;
    localVariable1++;

    cout << golbalVariable << endl;
    cout << staticVariable << endl;
    cout << localVariable1 << endl;
}

int _tmain(int argc, _TCHAR* argv[])
{
    fun1();
    fun2();
    fun1();
    fun2();
    return 0;
}

