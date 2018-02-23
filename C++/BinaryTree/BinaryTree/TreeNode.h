#pragma once

#include "stdafx.h"
#include <iostream>
#include <string>
using namespace std;

class TreeNode
{
public:
    TreeNode(string value)
        : mpLeft(NULL),
        mpRight(NULL)
    {
        this->mValue = value;
    }

    string mValue;
    TreeNode *mpLeft;
    TreeNode *mpRight;
};
