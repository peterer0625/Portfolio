/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conditionsample;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author KT
 */
public class ConditionSample
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();
        
        Thread thread0 = new Thread(new Runnable() {
            @Override
            public void run() {
                try
                {
                    reentrantLock.lock();
                    System.out.println("thread0 lock");
                    
                    System.out.println("thread0 wait");
                    condition.await();
                    System.out.println("thread0 wake up");
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    reentrantLock.unlock();
                    System.out.println("thread0 unlock");
                }
            }
        }
        );
        
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try
                {
                    reentrantLock.lock();
                    System.out.println("thread1 lock");
                    
                    System.out.println("thread1 wait");
                    condition.await();
                    System.out.println("thread1 wake up");
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    reentrantLock.unlock();
                    System.out.println("thread1 unlock");
                }
            }
        }
        );
        
        Thread thread2 = new Thread(new Runnable(){
            @Override
            public void run() {
                try
                {
                    reentrantLock.lock();
                    System.out.println("thread2 lock");
                    
                    System.out.println("thread2 sleep 3 sec");
                    Thread.sleep(3000);
                    
                    System.out.println("thread2 send signal");
                    condition.signalAll();

                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    reentrantLock.unlock();
                    System.out.println("thread2 unlock");
                }
            }
        }
        );
        
        thread0.start();
        thread1.start();
        
        try
        {
            Thread.sleep(1000);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        thread2.start();
    }
    
}
