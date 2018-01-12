/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package race;

/**
 *
 * @author KT
 */
public class Rabbit extends Animal
{
    public Rabbit(int target)
    {
        super(1, 6, target, "Rabbit");
        this.setTarget(target);
    }
    
    public void showMessage()
    {
        System.out.println("I am rabbit.");
    }    
}
