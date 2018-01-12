/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package race;

import java.util.Random;

/**
 *
 * @author KT
 */
public class Turtle extends Animal
{    
    public Turtle(int target)
    {
        super(2, 4, target, "Turtle");
        this.setTarget(target);
    }
    
    public void showMessage()
    {
        System.out.println("I am turtle.");
    }
}
