#Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.

#Example 1:
#Input:
#    5
#   / \
#  3   6
# / \   \
#2   4   7

#Target = 9

#Output: True
#Example 2:
#Input:
#    5
#   / \
#  3   6
# / \   \
#2   4   7

#Target = 28

#Output: False

class TreeNode:
    def __init__(self, value):
        self.left = None
        self.right = None
        self.val = value

class Solution:

    def findTarget(self, root, k):
        """
            :type root: TreeNode
            :type k: int
            :rtype: bool
            """
        list = []
        if (root != None):
            list.append(root.val)
            self.findValue(root, list)

        print (list)

        for i in list:
            for j in list:
                if i + j == k and i != j:
                    return True

        return False

    def findValue(self, node, list):
        if (node.left != None):
            list.append(node.left.val)
            self.findValue(node.left, list)

        if (node.right != None):
            list.append(node.right.val)
            self.findValue(node.right, list)


def stringToTreeNode(input):
    input = input.strip()
    input = input[1:-1]
    if not input:
        return None

    inputValues = [s.strip() for s in input.split(',')]
    root = TreeNode(int(inputValues[0]))
    nodeQueue = [root]
    front = 0
    index = 1
    while index < len(inputValues):
        node = nodeQueue[front]
        front = front + 1

        item = inputValues[index]
        index = index + 1
        if item != "null":
            leftNumber = int(item)
            node.left = TreeNode(leftNumber)
            nodeQueue.append(node.left)

        if index >= len(inputValues):
            break

        item = inputValues[index]
        index = index + 1
        if item != "null":
            rightNumber = int(item)
            node.right = TreeNode(rightNumber)
            nodeQueue.append(node.right)
    return root

root = stringToTreeNode("[5,3,6,2,4,null,7]")
c = Solution().findTarget(root, 9)
print(c)