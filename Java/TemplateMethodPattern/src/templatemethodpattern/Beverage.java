/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package templatemethodpattern;

/**
 *
 * @author KT
 */
public abstract class Beverage
{
    public void prepareRecipe()
    {
        boilWater();
        brew();
        pourInCup();
    }
    
    public void boilWater()
    {
        System.out.println("Boil Water.");
    }
    
    public abstract void brew();
    
    public void pourInCup()
    {
        System.out.println("Pour in cup.");
    }    
}
