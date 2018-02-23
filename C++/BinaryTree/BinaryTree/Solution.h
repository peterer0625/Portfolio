#pragma once

#include "stdafx.h"
#include <iostream>
#include <string>
using namespace std;

#include "TreeNode.h"

class Solution
{
public:
    int calculate(TreeNode* pTreeNode)
    {
        if (pTreeNode == NULL)
        {
            return 0;
        }
        else if (pTreeNode->mValue == "+")
        {
            return calculate(pTreeNode->mpLeft) + calculate(pTreeNode->mpRight);
        }
        else if (pTreeNode->mValue == "*")
        {
            return calculate(pTreeNode->mpLeft) * calculate(pTreeNode->mpRight);
        }
        else
        {
            return stoi(pTreeNode->mValue);
        }
    }
};