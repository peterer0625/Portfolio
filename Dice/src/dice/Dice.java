/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dice;

import com.sun.glass.ui.Pixels;

/**
 *
 * @author KT
 */
public class Dice
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        double [] value = new double[6];
        value[0] = 1;
        value[1] = 1;
        value[2] = value[0] + value[1];
        value[3] = value[0] + value[1] + value[2];
        value[4] = value[0] + value[1] + value[2] + value[3];
        value[5] = value[0] + value[1] + value[2] + value[3] + value[4];
        
        int n = 610;
        int s = 6;
        
        double result = 0;
        if (n < s)
        {
            result = value[n];
        }
        
        while (s <= n)
        {
            result = value[0] + value[1] + value[2] + value[3] + value[4] + value[5];
            
            value[0] =  value[1];
            value[1] =  value[2];
            value[2] =  value[3];
            value[3] =  value[4];
            value[4] =  value[5];
            value[5] =  result;
            
            s++;
        }
        
        System.out.println(result);
        //System.out.println(calculate(n));
    }
    
    public static int calculate(int n)
    {
        if (n >= 6)
        {
            return calculate(n - 1) + calculate(n - 2) + calculate(n - 3) + calculate(n - 4) + calculate(n -5) + calculate(n - 6);
        }
        else if (n == 5)
        {
            return calculate(n - 1) + calculate(n - 2) + calculate(n - 3) + calculate(n - 4) + calculate(n -5);
        }
        else if (n == 4)
        {
            return calculate(n - 1) + calculate(n - 2) + calculate(n - 3) + calculate(n - 4);
        }
        else if (n == 3)
        {
            return calculate(n - 1) + calculate(n - 2) + calculate(n - 3);
        }
        else if (n == 2)
        {
            return calculate(n - 1) + calculate(n - 2);
        }
        else if (n == 1)
        {
            return calculate(n - 1);
        }
        else
        {
            return 1;
        }
    }
}
