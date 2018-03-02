/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facadepattern;

/**
 *
 * @author KT
 */
public class MakeCoffee
{
    private Boil mBoil;
    private Coffee mCoffee;
    private Pour mPour;
    private Stir mStir;
    
    public MakeCoffee(Boil boil, Coffee coffee, Pour pour, Stir stir)
    {
        this.mBoil = boil;
        this.mCoffee = coffee;
        this.mPour = pour;
        this.mStir = stir;
    }
    
    public void process()
    {
        this.mBoil.boilWater();
        this.mCoffee.blueMountain();
        this.mPour.pourHotWater();
        this.mStir.slowStir();
    }
}
