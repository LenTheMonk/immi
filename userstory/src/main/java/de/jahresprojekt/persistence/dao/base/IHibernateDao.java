/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jahresprojekt.persistence.dao.base;

import javax.persistence.PersistenceException;
import org.hibernate.Transaction;

/**
 * Interface für die DAOs.
 * @author Lukas Eckert
 * @param <IBasePOJO> POJO das verwaltet wird
 */
public interface IHibernateDao<IBasePOJO>{
    
    /**
     * Lädt ein Pojo anhand seiner ID.
     * @param iD ID zu der geladen werden soll
     * @return POJO das geladen wurde
     */
    IBasePOJO getByID(long iD);
    
    /**
     * Speichert/Updated ein Pojo in der DB.
     * Die Transaktion muss mitgeliefert werden.
     * @param pojo Pojo
     * @param tx Transaktion
     * @return ID des gespeicherten Pojo
     */
    Long save(IBasePOJO pojo, Transaction tx) throws PersistenceException;
}
