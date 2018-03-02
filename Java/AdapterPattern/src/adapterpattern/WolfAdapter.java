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
public class WolfAdapter extends Dog
{
    private Wolf mWolf = null;
    
    public WolfAdapter(Wolf wolf)
    {
        this.mWolf = wolf;
    }
    
    @Override
    public void bark()
    {
        this.mWolf.howl();
    }
}
