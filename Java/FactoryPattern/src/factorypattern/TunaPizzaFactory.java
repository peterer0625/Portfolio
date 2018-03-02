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
public class TunaPizzaFactory implements PizzaFactory
{
    @Override
    public Pizza createPizza()
    {
        return new TunaPizza();
    }      
}
