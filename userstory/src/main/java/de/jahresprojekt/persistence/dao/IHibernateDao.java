/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jahresprojekt.persistence.dao;

/**
 *
 * @author Lukas Eckert
 * @param <IBasePOJO> POJO das verwaltet wird
 */
public interface IHibernateDao<IBasePOJO>{
    
    /**
     * Lädt ein Pojo anhand seiner ID.
     * @param iD iD
     * @return POJO
     */
    IBasePOJO getByID(long iD);
    
    /**
     * Speichert/Updated ein Pojo in der DB
     * @param pojo Pojo
     * @return id des gespeicherten Pojo
     */
    long save(IBasePOJO pojo);
}
