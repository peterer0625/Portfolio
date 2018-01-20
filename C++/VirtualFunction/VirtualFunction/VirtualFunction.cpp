// VirtualFunction.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include "Base.h"
#include "Child.h"

int _tmain(int argc, _TCHAR* argv[])
{
    Base* pBase = (Base *)new Child();
    pBase->print();
    return 0;
}

