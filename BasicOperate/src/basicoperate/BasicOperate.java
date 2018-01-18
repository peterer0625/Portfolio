/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicoperate;

/**
 *
 * @author KT
 */
public class BasicOperate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        int aa = 1;
        int bb = 1;
        int cc = aa+++bb++;
        System.out.println(aa);
        System.out.println(bb);
        System.out.println(cc);
    }
    
}
