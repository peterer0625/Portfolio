/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package waitnotify;

/**
 *
 * @author KT
 */
public class WaitNotify {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Object object = new Object();
        
        Thread thread1 = new Thread(new Runnable(){
            @Override
            public void run() {
                synchronized(object)
                {
                    while(true)
                    {
                        try
                        {
                            System.out.println("Thread1 Wait");
                            object.wait();
                            System.out.println("Thread1 Wake Up");
                        }
                        catch (Exception e)
                        {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        
        Thread thread2 = new Thread(new Runnable(){
            @Override
            public void run() {
                while(true)
                {
                    synchronized (object)
                    {
                        try
                        {
                            System.out.println("Thread2 Sleep");
                            Thread.sleep(1000);
                            System.out.println("Thread2 Notify");
                            object.notify();
                        }
                        catch (Exception e)
                        {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        
        thread1.start();
        thread2.start();
    }
    
}
