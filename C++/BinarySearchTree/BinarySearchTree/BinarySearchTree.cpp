// BinarySearchTree.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include "Solution.h"
#include "TreeNode.h"

#include <iostream>
#include <string>
using namespace std;

int _tmain(int argc, _TCHAR* argv[])
{
    TreeNode* pTreeNode5 = new TreeNode(5);
    TreeNode* pTreeNode2 = new TreeNode(2);
    TreeNode* pTreeNode6 = new TreeNode(6);

    TreeNode* pTreeNode3 = new TreeNode(3);
    TreeNode* pTreeNode1 = new TreeNode(1);

    pTreeNode5->mpLeft = pTreeNode2;
    pTreeNode5->mpRight = pTreeNode6;

    pTreeNode2->mpLeft = pTreeNode1;
    pTreeNode2->mpRight = pTreeNode3;

    Solution* pSolution = new Solution();
    cout << pSolution->searchValue(pTreeNode5, 2) << endl;

    return 0;
}

