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
public class MagicAttackBehavior implements AttackBehavior
{
    @Override
    public void attack()
    {
        System.out.println("Magic Attack.");
    }   
}
