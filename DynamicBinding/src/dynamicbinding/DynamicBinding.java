/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamicbinding;

/**
 *
 * @author KT
 */
public class DynamicBinding
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // TODO code application logic here
        ClassA classa = new ClassB();
        classa.print1();
        classa.print2();
        
        // Compile error
        // ClassB classb = new ClassA();
    }
    
}
