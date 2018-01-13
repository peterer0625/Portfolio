/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invert.binary.tree;

/**
 *
 * @author KT
 */
public class Solution
{
    public TreeNode invertTree(TreeNode root)
    {
        if (root.left != null && root.right != null)
        {
            TreeNode node = root.left;
            root.left = root.right;
            root.right = node;
            
            this.invertTree(root.left);
            this.invertTree(root.right);
        }
        
        return root;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // TODO code application logic here
        TreeNode node1 = new TreeNode(1);
        node1.left = new TreeNode(0);
        node1.right = new TreeNode(2);
        
        System.out.println(new Solution().invertTree(node1));
        
        System.out.println(node1.val + " " + node1.left.val + " " + node1.right.val);
    }
    
}
