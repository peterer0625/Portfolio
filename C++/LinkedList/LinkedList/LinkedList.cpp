// LinkedList.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include "LinkedList.h"

int _tmain(int argc, _TCHAR* argv[])
{
    LinkedList* pList = new LinkedList();
    pList->push_front(1);
    pList->push_front(2);
    pList->push_front(3);
    cout << pList->toString() << endl;

    pList->delete_node(3);
    cout << pList->toString() << endl;
    return 0;
}

