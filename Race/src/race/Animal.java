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
public abstract class Animal
{
    private int mMaxStep = 0;
    private int mMinStep = 0;    
    private int mTarget = 0;
    private String mName = "";
    
    public Animal(int minStep, int maxStep, int target, String name)
    {
        this.setMinStep(minStep);
        this.setMaxStep(maxStep);
        this.setTarget(target);
        this.setName(name);
    }
    
    public void setMinStep(int minStep)
    {
        this.mMinStep = minStep;
    }
    
    public int getMinStep()
    {
        return this.mMinStep;
    }
    
    public void setMaxStep(int maxStep)
    {
        this.mMaxStep = maxStep;
    }
    
    public int getMaxStep()
    {
        return this.mMaxStep;
    }  
    
    public void setTarget(int target)
    {
        this.mTarget = target;
    }
    
    public int getTarget()
    {
        return this.mTarget;
    }
    
    public void setName(String name)
    {
        this.mName = name;
    }
    
    public String getName()
    {
        return this.mName;
    }
        
    public int run()
    {
        int time = 0;
        
        Random random = new Random();
        int current = 0;        
        while(current < this.getTarget())
        {
            int step = random.nextInt(this.getMaxStep() - this.getMinStep() + 1) + this.getMinStep();
            current = current + step;
            
            System.out.println(this.getName() + " run " + step + " steps. The distance form target is " + (this.getTarget() - current));
            time++;
        }
        
        return time;
    }
    
    public abstract void showMessage();
}
