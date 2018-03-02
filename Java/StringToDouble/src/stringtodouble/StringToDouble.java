/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringtodouble;

/**
 *
 * @author KT
 */
public class StringToDouble {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        System.out.println(stringToDouble("123.123"));
    }
    
    public static double stringToDouble(String string)
    {
        char[] c = string.toCharArray();
        double result = 0;
        double fraction = 0;
        for (int i = 0; i < c.length; i++)
        {
            if (c[i] == '.')
            {
                fraction = 0.1;
                continue;
            }
            
            if (fraction == 0)
            {
                result = result * 10 +  (c[i] - '0');
            }
            else
            {
                result = result +  (c[i] - '0') * fraction;
                fraction = fraction * 0.1;
            }            
        }
        
        return result;
    }
    
}
