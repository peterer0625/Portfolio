/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package detectcapital;

/**
 *
 * @author KT
 * Description
 * Given a word, you need to judge whether the usage of capitals in it is right or not.
 * 
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 * 
 * All letters in this word are capitals, like "USA".
 * All letters in this word are not capitals, like "leetcode".
 * Only the first letter in this word is capital if it has more than one letter, like "Google".
 * Otherwise, we define that this word doesn't use capitals in a right way.
 * Example 1:
 * Input: "USA"
 * Output: True
 * Example 2:
 * Input: "FlaG"
 * Output: False
 */
public class Solution
{
    public boolean detectCapitalUse(String word)
    {
        char[] charWord = word.toCharArray();
        
        int wordCase = 0;
        
        if (charWord[0] >= 'A' && charWord[0] <= 'Z')
        {
            wordCase = 3;
        }
        else
        {
            wordCase = 2;
        }
        
        for (int i = 0; i < charWord.length; i++)
        {
            if (wordCase == 1)
            {
                if (charWord[i] >= 'a' && charWord[i] <= 'z')
                {
                    return false;
                }
            }
            else if (wordCase == 2)
            {
                if (charWord[i] >= 'A' && charWord[i] <= 'Z')
                {
                    return false;
                }
            }            
            else if (wordCase == 3)
            {
                if (i == 1 && charWord[i] >= 'A' && charWord[i] <= 'Z')
                {
                    wordCase = 1;
                }
                else if (i > 0 && charWord[i] >= 'A' && charWord[i] <= 'Z')
                {
                    return false;
                }
            }
        }
        
        return true;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        System.out.println(new Solution().detectCapitalUse("USA"));
    }
    
}
