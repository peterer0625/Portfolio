/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package findmaxconsecutiveones;

/**
 *
 * @author KT
 * Description
 * Given a binary array, find the maximum number of consecutive 1s in this array.
 * 
 * Example 1:
 * Input: [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s.
 *     The maximum number of consecutive 1s is 3.
 * Note:
 * 
 * The input array will only contain 0 and 1.
 * The length of input array is a positive integer and will not exceed 10,000
 */
public class Solution {
    
    public int findMaxConsecutiveOnes(int[] nums)
    {
        int result = 0;
        int count = 0;
        
        if (nums.length == 1)
        {
            if (nums[0] == 1)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }
        
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] == 0)
            {
                if (count > result)
                {
                    result = count;
                }
                count = 0;
            }
            else
            {
                count++;
            }
        }
        
        if (count > result)
        {
            result = count;
        }
        
        return result;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(new Solution().findMaxConsecutiveOnes(new int[] {1, 1, 0, 1, 1, 1, 1}));
    }
    
}
