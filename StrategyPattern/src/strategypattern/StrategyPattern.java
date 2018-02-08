/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategypattern;

/**
 *
 * @author KT
 */
public class StrategyPattern {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Character warrior = new Character((AttackBehavior)new NormalAttackBehavior());
        Character master = new Character((AttackBehavior)new MagicAttackBehavior());
        
        warrior.performAttack();
        master.performAttack();
    }    
}
