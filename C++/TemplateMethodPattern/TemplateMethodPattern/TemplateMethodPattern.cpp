// TemplateMethodPattern.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include "Beverage.h"
#include "Coffee.h"
#include "Tea.h"

int _tmain(int argc, _TCHAR* argv[])
{
    Beverage* pCoffee = (Beverage*)new Coffee();
    Beverage* pTea = (Beverage*)new Tea();

    pCoffee->prepareRecipe();
    pTea->prepareRecipe();

    return 0;
}

