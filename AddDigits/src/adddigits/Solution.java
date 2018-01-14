/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adddigits;

/**
 *
 * @author KT
 * Description
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 * 
 * For example:
 * 
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
 */
public class Solution
{
    public int addDigits(int num)
    {
        int result = (num / 10) + (num % 10);
        if (result / 10 >= 1)
        {
            return addDigits(result);
        }
        
        return result;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        System.out.println(new Solution().addDigits(38));
    }
    
}
