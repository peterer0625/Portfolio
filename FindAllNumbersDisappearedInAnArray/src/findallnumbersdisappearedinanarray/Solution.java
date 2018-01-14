/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package findallnumbersdisappearedinanarray;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author KT
 */
public class Solution
{
    public List<Integer> findDisappearedNumbers(int[] nums)
    {
        int[] count = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
        {
            count[i] = 0;
        }
        
        for (int i = 0; i < nums.length; i++)
        {
            count[nums[i] - 1] = 1;
        }
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++)
        {
            if (count[i] == 0)
            {
                result.add(i + 1);
            }
        }
        
        return result;        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        System.out.println(new Solution().findDisappearedNumbers(new int[]{1, 2, 3, 5, 2}));
    }
    
}
