// CharArray.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <iostream>
using namespace std;


int _tmain(int argc, _TCHAR* argv[])
{
    char str1[] = "hello1";
    char str2[10] = "hello2";
    char str3[] = { 'h', 'e', 'l', 'l', 'o', '3', '\0' };
    char *str4 = "hello4";

    cout << str1 << strlen(str1) << endl;
    cout << str2 << strlen(str2) << endl;
    cout << str3 << strlen(str3) << endl;
    cout << str4 << strlen(str4) << endl;

    return 0;
}

