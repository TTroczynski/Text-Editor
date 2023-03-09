package com.texteditor;
import java.util.ArrayList;

public class PrgHistory {
    private ArrayList<Momento> history;
    private int index;
    
    public PrgHistory()
    {
        history = new ArrayList<Momento>();
        index = -1;
    }

    public void Add(Progress progress)
    {
        Momento atIndex = new Progress();

        if(progress.GetState().isEmpty())
        {
            return;
        }
        if(index >= 0)
        {
            atIndex = history.get(index);
        }
         
        if(!progress.GetState().equals(atIndex.GetState()))
        {
            index++;
            history.add(progress);
        }
        
    }

    public Momento GetLast()
    {
        Momento temp = new Progress("");
        if(--index >= 0)
        {
            return history.get(index);
        }
        index = 0;
        return temp;
    }

    public Momento GetNext()
    {
        int size = history.size();
        if(++index < size)
        {
            return history.get(index);  
        }
        return history.get(history.size() - 1);
    }

}
