#pragma once

#include "stdafx.h"
#include <iostream>
#include <string>
using namespace std;

#include "TreeNode.h"

class Solution
{
public:
    bool searchValue(TreeNode* pTreeNode, int value)
    {
        if (pTreeNode == NULL)
        {
            return false;
        }
        else if (value == pTreeNode->mValue)
        {
            return true;
        }
        else if (value < pTreeNode->mValue)
        {
            return this->searchValue(pTreeNode->mpLeft, value);
        }
        else
        {
            return this->searchValue(pTreeNode->mpRight, value);
        }
    }
};