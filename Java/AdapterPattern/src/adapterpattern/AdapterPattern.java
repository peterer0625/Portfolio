/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adapterpattern;

/**
 *
 * @author KT
 */
public class AdapterPattern {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Wolf wolf = new Wolf();
        WolfAdapter wolfAdapter = new WolfAdapter(wolf);
        testDog(wolfAdapter);
    }
    
    public static void testDog(Dog dog)
    {
        dog.bark();
    }    
}
