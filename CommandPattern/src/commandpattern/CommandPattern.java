/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandpattern;

/**
 *
 * @author KT
 */
public class CommandPattern {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Light light = new Light();
        Command lightOnCOmmand = new LightOnCommand(light);
        
        Control control = new Control();
        control.setCommand(lightOnCOmmand);
        
        control.pressButton();
    }    
}
