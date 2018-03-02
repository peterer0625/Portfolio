/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singlenumber;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author KT
 * Description
 * Given an array of integers, every element appears twice except for one. Find that single one.
 */
public class Solution
{
    public int singleNumber(int[] nums)
    {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++)
        {
            if (map.containsKey(nums[i]) == true)
            {
                map.remove(nums[i]);
                continue;
            }
            
            map.put(nums[i], nums[i]);
        }
        
        ArrayList list = new ArrayList(map.values());
        
        return (int)list.get(0);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // TODO code application logic here
        System.out.println(new Solution().singleNumber(new int [] {1, 2, 1, 2, 3}));
    }
    
}
