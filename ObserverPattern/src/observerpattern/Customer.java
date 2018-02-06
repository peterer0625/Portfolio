/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observerpattern;

/**
 *
 * @author KT
 */
public class Customer implements Observer
{
    private String mName;
    
    public Customer(String name)
    {
        this.mName = name;
    }
    @Override
    public void update(String message)
    {
        System.out.println(this.mName + " receive " + message);
    }    
}
