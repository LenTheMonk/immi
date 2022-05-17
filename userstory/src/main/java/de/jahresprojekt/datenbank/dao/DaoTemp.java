/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jahresprojekt.datenbank.dao;

import de.jahresprojekt.datenbank.model.ModelTemp;
import java.util.ArrayList;
import java.util.List;

/**
 *
* @author Lukas Eckert
 */
public class DaoTemp<T extends ModelTemp> implements IDaoFunctions<T>
{
  //-------------------------------------------------------------------------
  //  Var(s)
  //-------------------------------------------------------------------------     
    protected List<T> itemList = new ArrayList<>();
    
    
  //-------------------------------------------------------------------------
  //  Constructor(s)
  //-------------------------------------------------------------------------     
    public DaoTemp() { super(); }
     
    
  //-------------------------------------------------------------------------
  //  Method(s)
  //-------------------------------------------------------------------------     
    @Override
    public void save(T item)
    {
        if (item != null && item.hasId() && !itemList.contains(item)) { list().add(item); } 
    }

    @Override
    public T load(int id)
    { 
        if (itemList != null && !itemList.isEmpty())
        {
            for (T item : list())
            {
                if (item.getId() == id) { return item; }
            }
        }
        return null;
    }

    @Override
    public void delete(T item)
    {
        if (itemList != null && itemList.contains(item))
        {
            itemList.remove(item);
        }
    }

    @Override
    public List<T> list()
    {
        if (itemList == null) { itemList = new ArrayList<>(); }
        return itemList;
    }
  
}

