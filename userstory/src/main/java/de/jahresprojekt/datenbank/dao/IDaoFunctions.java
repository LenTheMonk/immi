/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jahresprojekt.datenbank.dao;

import java.util.List;

/**
 *
* @author Lukas Eckert
 */
public interface IDaoFunctions<T> {
  //-------------------------------------------------------------------------
  //  Method(s)
  //-------------------------------------------------------------------------     
    public void save(T item);
    
    public T load(int id);
    
    public void delete(T item);
    
    public List<T> list();
}
