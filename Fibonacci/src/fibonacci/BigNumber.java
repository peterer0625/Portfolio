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
public class BigNumber
{
    private int[] mBigNumber = new int[5000];
    
    public BigNumber()
    {
        for (int i = 0; i < this.mBigNumber.length; i++)
        {
            this.mBigNumber[i] = 0;
        }
    }
    
    public void set(int value)
    {
        for (int i = 0; i < this.mBigNumber.length; i++)
        {
            this.mBigNumber[i] = 0;
        }
        this.mBigNumber[0] = value;
    }
    
    public static BigNumber add(BigNumber a, BigNumber b)
    {
        BigNumber result = new BigNumber();
        for (int i = 0; i < result.mBigNumber.length; i++)
        {
            result.mBigNumber[i] = a.mBigNumber[i] + b.mBigNumber[i];
            
            boolean carry = false;
            if (result.mBigNumber[i] >= 100000000)
            {
                result.mBigNumber[i]  = result.mBigNumber[i] - 100000000;
                carry = true;
            }
            
            if (carry == true && i < a.mBigNumber.length)
            {
                a.mBigNumber[i + 1] =  a.mBigNumber[i + 1] + 1;
            }
        }
        
        return result;
    }
    
    @Override
    public String toString()
    {
        String result = "";
        boolean show = false;
        for (int i = this.mBigNumber.length - 1; i >= 0; i--)
        {
            String s;
            s = String.valueOf(this.mBigNumber[i]);
            if (this.mBigNumber[i] != 0)
            {
                if (show == true)
                {
                    while (s.length() < 8)
                    {
                        s = "0" + s;
                    }
                }
                show = true;
            }
            
            if (show == true)
            {
                result = result + s;
            }            
        }
        
        return result;
    }
}
