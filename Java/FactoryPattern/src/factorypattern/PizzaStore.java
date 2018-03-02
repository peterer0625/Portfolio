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
public class PizzaStore
{
    private PizzaFactory mPizzaFactory = null;
    
    public PizzaStore(PizzaFactory pizzaFactory)
    {
        this.setPizzaFactory(pizzaFactory);
    }
    
    public void setPizzaFactory(PizzaFactory pizzaFacroty)
    {
        this.mPizzaFactory = pizzaFacroty;
    }
    
    public Pizza orderPizza()
    {
        Pizza pizza = this.mPizzaFactory.createPizza();
        pizza.bake();
        pizza.deliver();
        
        return pizza;
    }
}
