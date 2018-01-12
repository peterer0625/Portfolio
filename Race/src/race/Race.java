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
public class Race {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Animal turtle = new Turtle(100);
        int resultTurtle = turtle.run();
        turtle.showMessage();
        
        Animal rabbit = new Rabbit(100);
        int resultRabbit = rabbit.run();
        rabbit.showMessage();
        
        if (resultTurtle < resultRabbit)
        {
            System.out.println("Turtle win.");
        }
        else if (resultTurtle > resultRabbit)
        {
            System.out.println("Rabbit win.");
        }
        else
        {
            System.out.println("Tied.");
        }
    }
    
}
