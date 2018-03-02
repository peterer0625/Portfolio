/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semaphoresample;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KT
 */
public class SemaphoreSample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        ResourcePool resourcePool = new ResourcePool();
        
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run()
            {
                while(true)
                {
                    try
                    {
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                        break;
                    }
                    resourcePool.release();
                    System.out.println("resource release");
                }
            }
        });
        
        thread.start();
        
        int count = 0;
        while(true)
        {
            count++;
            try
            {
                Thread.sleep(500);
                int value = resourcePool.acquire();
                System.out.println(count + " resource get " + value);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            
            if (count >= 20)
            {
                break;
            }
        }
        
        thread.interrupt();
    }
    
}
