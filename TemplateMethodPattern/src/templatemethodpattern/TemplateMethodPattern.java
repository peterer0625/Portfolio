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
public class TemplateMethodPattern {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Beverage coffee = new Coffee();
        coffee.prepareRecipe();
        
        Beverage tea = new Tea();
        tea.prepareRecipe();
    }
    
}
