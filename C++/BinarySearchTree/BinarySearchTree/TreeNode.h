#pragma once

#include "stdafx.h"
#include <iostream>
#include <string>
using namespace std;

class TreeNode
{
public:
    TreeNode(int value)
        : mpLeft(NULL),
        mpRight(NULL)
    {
        this->mValue = value;
    }

    int mValue;
    TreeNode *mpLeft;
    TreeNode *mpRight;
};
