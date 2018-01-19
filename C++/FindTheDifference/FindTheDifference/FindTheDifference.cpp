// FindTheDifference.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include "Solution.h"
using namespace std;

int _tmain(int argc, _TCHAR* argv[])
{
    Solution solution;
    string s = "abcd";
    string t = "abcde";

    cout << solution.findTheDifference(s, t) << endl;
    return 0;
}

