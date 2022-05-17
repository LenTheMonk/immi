/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jahresprojekt.datenbank.model;

import java.io.Serializable;

/**
 *
* @author Lukas Eckert
 */
public abstract class ModelTemp implements Serializable {
  //-------------------------------------------------------------------------
  //  Class-Var(s)
  //-------------------------------------------------------------------------     
    protected static long anzahl = 0; 

    public static long getAnzahl() { return anzahl; }

    public static synchronized void incAnzahl() { anzahl++; }
     
    
  //-------------------------------------------------------------------------
  //  Var(s)
  //-------------------------------------------------------------------------     
    protected long id = -1;


  //-------------------------------------------------------------------------
  //  Constructor(s)
  //-------------------------------------------------------------------------     
    public ModelTemp()
    {
        super();
        incAnzahl();
        this.id = anzahl;
    }


  //-------------------------------------------------------------------------
  //  Get / Set
  //------------------------------------------------------------------------- 
    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public boolean hasId() { return this.id > -1; }

}