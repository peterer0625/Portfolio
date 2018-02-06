/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observerpattern;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author KT
 */
public class NewOffice implements Subject
{
    private List<Observer> mObserverList = new ArrayList();
            
    @Override
    public void registerObserver(Observer observer)
    {
        this.mObserverList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer)
    {
        this.mObserverList.remove(observer);
    }

    @Override
    public void notifyObservers(String message)
    {
        for (int i = 0; i < this.mObserverList.size(); i++)
        {
            Observer observer = (Observer)this.mObserverList.get(i);
            observer.update(message);
        }
    }    
}
