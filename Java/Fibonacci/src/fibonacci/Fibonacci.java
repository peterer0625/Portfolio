/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fibonacci;

/**
 *
 * @author KT
 */
public class Fibonacci {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        BigNumber[] value = new BigNumber[2];
        value[0] = new BigNumber();
        value[1] = new BigNumber();
        value[0].set(0);
        value[1].set(1);
        
        int n = 8181;
        int s = 2;
        
        BigNumber result = new BigNumber();
        while(s <= n)
        {
            result = BigNumber.add(value[0], value[1]);
            value[0] = value[1];
            value[1] = result;
            s++;
        }
        
        System.out.println(result);
    }
    
}
