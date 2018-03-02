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
public class Character
{
    private AttackBehavior mAttackBehavior = null;
            
    public Character(AttackBehavior attackBehavior)
    {
        this.mAttackBehavior = attackBehavior;
    }
    
    public void performAttack()
    {
        this.mAttackBehavior.attack();
    }
}
