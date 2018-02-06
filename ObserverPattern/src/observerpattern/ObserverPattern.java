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
public class ObserverPattern {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        NewOffice newOffice = new NewOffice();
        
        Customer peter = new Customer("Peter");
        Customer john = new Customer("John");
        
        newOffice.registerObserver(peter);
        newOffice.registerObserver(john);
        
        newOffice.notifyObservers("test");
    }    
}
