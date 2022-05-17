/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jahresprojekt.persistence.entities.base;

import java.io.Serializable;

/**
 * Interface für Pojos.
 * @author Lukas Eckert
 */
public interface IPojo extends Serializable {
    
    /**
     * Liefert den Namen der Datenbanktabelle des POJO.
     * @return Name der Tabelle
     */
    String getTableName();
    
    /**
     * Liefert ID des POJO.
     * @return ID
     */
    long getId();
    
    /**
     * Setzt ID des POJO.
     * @param iD ID
     */
    void setID(long iD);
}
