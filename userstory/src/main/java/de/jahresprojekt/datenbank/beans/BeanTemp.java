/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jahresprojekt.datenbank.beans;

import de.jahresprojekt.datenbank.dao.DaoTemp;
import de.jahresprojekt.datenbank.model.ModelTemp;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author lukas
 */
public abstract class BeanTemp<T extends ModelTemp, D extends DaoTemp>
        implements Serializable {
  //-------------------------------------------------------------------------
  //  Constructor(s)
  //-------------------------------------------------------------------------     
    public BeanTemp(D dao) 
    { 
        super(); 
        this.dao = dao;
    } 


  //-------------------------------------------------------------------------
  //  Item
  //-------------------------------------------------------------------------     
    protected T item = null; 
    
    public T getItem() { return item; }

    public void setItem(T item) { this.item = item; } 
    
    public abstract void resetItem();
    

  //-------------------------------------------------------------------------
  //  DAO / ItemList
  //-------------------------------------------------------------------------     
    protected D dao = null; 

    public List<T> getItemList() { return (dao != null) ? dao.list() : null; }

    public void saveItem() { if (dao != null) { dao.save(item); } }
  
    public void removeItem(T item) { if (dao != null) { dao.delete(item); } } 
     

  //-------------------------------------------------------------------------
  //  Else ... 
  //-------------------------------------------------------------------------     
    protected void setMessage(String comonentId, FacesMessage.Severity type, String header, String msg) { FacesContext.getCurrentInstance().addMessage(comonentId, new FacesMessage(type, header, msg)); }    
    
    public void setErrorMessage(String header, String msg) { setMessage(null, FacesMessage.SEVERITY_ERROR, header, msg); }
    
    public void setInfoMessage(String header, String msg) { setMessage(null, FacesMessage.SEVERITY_INFO, header, msg); }
    

    
}
