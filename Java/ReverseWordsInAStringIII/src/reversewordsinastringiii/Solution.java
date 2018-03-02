/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversewordsinastringiii;

/**
 *
 * @author KT
 * Description
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 * 
 * Example 1:
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 */
public class Solution
{
    public String reverseWords(String s)
    {
        String result = "";
        String[] words = s.split(" ");
        for (int i = 0; i < words.length; i++)
        {
            result = result + " " + this.reserveWord(words[i]);
        }
        
        result = result.trim();
        return result;
    }
    
    private String reserveWord(String s)
    {
        char[] result = s.toCharArray();
        
        int halfLength = result.length / 2;
        for (int i = 0; i < halfLength; i++)
        {
            char temp = result[i];
            result[i] = result[result.length - i - 1];
            result[result.length - i - 1] = temp;
        }
        
        return String.copyValueOf(result);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        System.out.println(new Solution().reverseWords("Let's take LeetCode contest"));
    }
    
}
