/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factorypattern;

/**
 *
 * @author KT
 */
public class Pizza
{
    private String mName;
    
    public void setName(String name)
    {
        this.mName = name;
    }
    
    public void bake()
    {
        System.out.println(this.mName + " is baking.");
    }
    
    public void deliver()
    {
        System.out.println(this.mName + " is delivering.");
    }
}
