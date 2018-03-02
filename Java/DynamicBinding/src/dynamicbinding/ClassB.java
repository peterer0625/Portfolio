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
public class ClassB extends ClassA
{
    public ClassB()
    {
        
    }
    
    static public void print1()
    {
        System.out.println("This is ClassB.");
    }      
    
    public void print2()
    {
        System.out.println("This is ClassB.");
    }
}
