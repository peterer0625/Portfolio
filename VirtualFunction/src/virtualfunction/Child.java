/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtualfunction;

/**
 *
 * @author KT
 */
public class Child extends Parent
{
    public Child()
    {
        System.out.println("Child");
        print();
    }
    
    public void print()
    {
        System.out.println("Child print");
    }    
}
