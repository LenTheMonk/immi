/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jahresprojekt.persistence.dao;

import de.jahresprojekt.persistence.dao.base.IHibernateDao;
import de.jahresprojekt.persistence.utils.HibernateUtils;
import org.hibernate.Transaction;
import de.jahresprojekt.persistence.entities.base.IPojo;
import javax.persistence.PersistenceException;


/**
 *
 * @author Lukas Eckert
 * @param <T> Pojo das von der Dao verwaltet wird
 */
public abstract class BaseHibernateDao<T extends IPojo> implements IHibernateDao<T>{

    public static final long NO_ID = -210L;
    
    @Override
    public Long save(T pojo, Transaction tx) {
        Long id = null;
        try {
            id = (long) HibernateUtils.getOpenSession().save(pojo);
            tx.commit();
        } catch (Exception e) {
            if (tx!=null) {
                // Rollback im Fehlerfall
                tx.rollback();
                e.printStackTrace();
                // PersistenceException weiter werfen,
                // damit der Service das mitbekommt
                if (e instanceof PersistenceException) {
                    throw e;
                }
            }
        }
        return id;
    }
    
    /**
     * Liefert Klasse des Pojo.
     * @return Klasse des Pojo
     */
    abstract Class getPojoClass();

    @Override
    public T getByID(long iD) {
        T pojo = null;
        
        try {
            pojo = (T) HibernateUtils.getOpenSession().get(this.getPojoClass(), iD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pojo;
    }
    
}
