#pragma once

#include "stdafx.h"
#include <iostream>
#include <string>
using namespace std;

#include "ListNode.h"

class LinkedList
{
public:
    ListNode *mRoot;

    LinkedList()
    {
        this->mRoot = NULL;
    }

    void push_front(int value)
    {
        ListNode *pNode = new ListNode();
        pNode->mValue = value;
        pNode->mNext = this->mRoot;

        this->mRoot = pNode;
    }

    void delete_node(int value)
    {
        ListNode* pCurrent = this->mRoot;
        ListNode* pPrecious = NULL;
        while (pCurrent != NULL)
        {
            if (pCurrent->mValue == value)
            {
                break;
            }

            pPrecious = pCurrent;
            pCurrent = pCurrent->mNext;
        }

        if (pCurrent == this->mRoot)
        {
            this->mRoot = this->mRoot->mNext;
            delete pCurrent;
        }
        else if (pCurrent == NULL)
        {
            return;
        }
        else
        {
            pPrecious->mNext = pCurrent->mNext;
            delete pCurrent;
        }
    }

    string toString()
    {
        string result;
        result = "";

        ListNode* pCurrent = this->mRoot;
        while (pCurrent != NULL)
        {
            result = result + std::to_string(pCurrent->mValue) + " => ";
            pCurrent = pCurrent->mNext;
        }

        result = result + "null";

        return result;
    }

};