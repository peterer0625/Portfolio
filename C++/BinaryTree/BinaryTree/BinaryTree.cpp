// BinaryTree.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <iostream>
#include <string>
using namespace std;

#include "TreeNode.h"
#include "Solution.h"

#include <iostream>
#include <string>
using namespace std;

int _tmain(int argc, _TCHAR* argv[])
{
    TreeNode *pTreeNode0 = new TreeNode("+");

    TreeNode *pTreeNode1 = new TreeNode("3");
    TreeNode *pTreeNode2 = new TreeNode("*");

    TreeNode *pTreeNode3 = new TreeNode("6");
    TreeNode *pTreeNode4 = new TreeNode("5");

    pTreeNode0->mpLeft = pTreeNode1;
    pTreeNode0->mpRight = pTreeNode2;

    pTreeNode2->mpLeft = pTreeNode3;
    pTreeNode2->mpRight = pTreeNode4;

    Solution *pSolution = new Solution();
    cout << pSolution->calculate(pTreeNode0) << endl;

    return 0;
}

