/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jahresprojekt.persistence.entities;

import java.io.Serializable;

/**
 * Interface für Entities.
 * @author Lukas Eckert
 */
public interface IEntity extends Serializable {
    
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
    void setId(long iD);
}
