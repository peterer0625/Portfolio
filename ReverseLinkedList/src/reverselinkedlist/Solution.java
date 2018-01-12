/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reverselinkedlist;

/**
 *
 * @author KT
 */
public class Solution
{
    private ListNode reverseList(ListNode n1, ListNode n2)
    {
        if (n1 != null && n2 != null)
        {
            ListNode node = reverseList(n2, n2.next);
            
            n2.next = n1;
            n1.next = null;
            
            return node;
        }
        else
        {
            return n1;
        }       
    }
    
    public ListNode reverseList(ListNode head)
    {
        if (head == null || head.next == null)
        {
            return head;
        }
        
        return reverseList(head, head.next);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // TODO code application logic here
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        
        node1.next = node2;
        node2.next = node3;
        node3.next = null;
        
        ListNode result = new Solution().reverseList(node1);
        
        while(result != null)
        {
            System.out.print(result.val + " -> ");
            result = result.next;
        }
        System.out.print("null");
    }
    
}
