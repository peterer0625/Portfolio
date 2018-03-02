/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semaphoresample;

import java.util.concurrent.Semaphore;

/**
 *
 * @author KT
 */
public class ResourcePool
{
    private Semaphore mSemaphore = new Semaphore(10, true);
    private int mResourceUsedCount = 0;
    
    public int acquire() throws InterruptedException
    {
        this.mSemaphore.acquire();
        mResourceUsedCount++;
        return mResourceUsedCount;
    }
    
    public void release()
    {
        this.mSemaphore.release();
        mResourceUsedCount--;
    }
}
