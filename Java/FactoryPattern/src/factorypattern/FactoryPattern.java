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
public class FactoryPattern
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        PizzaStore pizzaStore = new PizzaStore((PizzaFactory)new HawaiiPizzaFactory());
        pizzaStore.orderPizza();
        
        pizzaStore.setPizzaFactory(new TunaPizzaFactory());
        pizzaStore.orderPizza();
    }
    
}
