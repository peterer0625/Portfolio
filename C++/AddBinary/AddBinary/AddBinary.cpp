// AddBinary.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include <string>
using namespace std;

/*
Given two binary strings a and b, return their sum as a binary string.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
*/

class Solution {
public:
    string addBinary(string a, string b)
    {
        string result = "";
        bool carry = false;

        // Handle the length if a length is different from b length
        if (a.length() != b.length())
        {
            if (a.length() > b.length())
            {
                int count = a.length() - b.length();
                for (int i = 0; i < count; i++)
                {
                    b = "0" + b;
                }
            }
            else
            {
                int count = b.length() - a.length();
                for (int i = 0; i < count; i++)
                {
                    a = "0" + a;
                }
            }
        }

        // Adder
        for (int i = 0; i < a.length(); i++)
        {
            string a_bit = a.substr(a.length() - i - 1, 1);
            string b_bit = b.substr(b.length() - i - 1, 1);

            if (carry == false)
            {
                if (a_bit == "0")
                {
                    if (b_bit == "0")
                    {
                        // 0+0+0
                        result = "0" + result;
                        carry = false;
                    }
                    else
                    {
                        // 0+0+1
                        result = "1" + result;
                        carry = false;
                    }
                }
                else
                {
                    if (b_bit == "0")
                    {
                        // 0+1+0
                        result = "1" + result;
                        carry = false;
                    }
                    else
                    {
                        // 0+1+1
                        result = "0" + result;
                        carry = true;
                    }
                }
            }
            else
            {
                if (a_bit == "0")
                {
                    if (b_bit == "0")
                    {
                        // 1+0+0
                        result = "1" + result;
                        carry = false;
                    }
                    else
                    {
                        // 1+0+1
                        result = "0" + result;
                        carry = true;
                    }
                }
                else
                {
                    if (b_bit == "0")
                    {
                        // 1+1+0
                        result = "0" + result;
                        carry = true;
                    }
                    else
                    {
                        // 1+1+1
                        result = "1" + result;
                        carry = true;
                    }
                }
            }
        }

        if (carry == true)
        {
            result = "1" + result;
        }

        return result;
    }
};

int main()
{
    string a = "1", b = "111";
    Solution* pSolution = new Solution();
    string result = pSolution->addBinary(a, b);

    cout << result << endl;
}

// Run program: Ctrl + F5 or Debug > Start Without Debugging menu
// Debug program: F5 or Debug > Start Debugging menu

// Tips for Getting Started: 
//   1. Use the Solution Explorer window to add/manage files
//   2. Use the Team Explorer window to connect to source control
//   3. Use the Output window to see build output and other messages
//   4. Use the Error List window to view errors
//   5. Go to Project > Add New Item to create new code files, or Project > Add Existing Item to add existing code files to the project
//   6. In the future, to open this project again, go to File > Open > Project and select the .sln file
