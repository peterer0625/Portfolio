/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maxareaofisland;

/**
 *
 * @author KT
 * Decription
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 * 
 * Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)
 * 
 * Example 1:
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,1,1,0,1,0,0,0,0,0,0,0,0],
 *  [0,1,0,0,1,1,0,0,1,0,1,0,0],
 *  [0,1,0,0,1,1,0,0,1,1,1,0,0],
 *  [0,0,0,0,0,0,0,0,0,0,1,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
 * Example 2:
 * [[0,0,0,0,0,0,0,0]]
 * Given the above grid, return 0.
 */
public class Solution
{
    private int findArea(int[][] grid, int x, int y)
    {
        int v1 = 0;
        int v2 = 0;
        int v3 = 0;
        int v4 = 0;
        
        if (grid[x][y] == 0)
        {
            return 0;
        }
        
        grid[x][y] = 0;
        
        if (x + 1 < grid.length)
        {
            v1 = findArea(grid, x + 1, y);
        }
        
        if (y + 1 < grid[x].length)
        {
            v2 = findArea(grid, x, y + 1);
        }
        
        if (x - 1 >= 0)
        {
            v3 = findArea(grid, x - 1, y);
        }
        
        if (y - 1 >= 0)
        {
            v4 = findArea(grid, x, y - 1);
        }
        
        int result = v1 + v2 + v3 + v4 + 1;
        
        return result;
    }
    
    public int maxAreaOfIsland(int[][] grid)
    {
        if (grid == null)
        {
            return 0;
        }        
        
        int maxResult = 0;
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[i].length; j++)
            {
                if (grid[i][j] == 1)
                {
                    int result = findArea(grid, i, j);
                    if (maxResult < result)
                    {
                        maxResult = result;
                    }
                }

            }
        }
        
        return maxResult;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        System.out.println(new Solution().maxAreaOfIsland(new int[][]{{0, 1},{1,1}}));
    }
    
}
