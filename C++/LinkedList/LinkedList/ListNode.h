#pragma once

#include "stdafx.h"
#include <iostream>
#include <string>
using namespace std;

class ListNode
{
public:
    ListNode()
    {
        this->mNext = NULL;
        this->mValue = 0;
    }

    ListNode *mNext;
    int mValue;
};