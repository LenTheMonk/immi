/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jahresprojekt.persistence.dao;

import de.jahresprojekt.persistence.dao.base.IHibernateDao;
import de.jahresprojekt.persistence.utils.HibernateUtils;
import java.sql.SQLIntegrityConstraintViolationException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import de.jahresprojekt.persistence.entities.base.IPojo;

/**
 *
 * @author Lukas Eckert
 * @param <T> Pojo das von der Dao verwaltet wird
 */
public abstract class BaseHibernateDao<T extends IPojo> implements IHibernateDao<T>{

    public static final long NO_ID = -210L;
    
    @Override
    public long save(T pojo) {
        Session currentSession = HibernateUtils.getOpenSession();
        Transaction tx = null;
        Long id = null;
        try {
            tx = currentSession.beginTransaction();
            id = (long) currentSession.save(pojo);
            System.out.println(pojo.getTableName());
            System.out.println(id);
            tx.commit();
            return id;
        } catch (Exception e) {
            if (tx!=null) {
                tx.rollback();
                e.printStackTrace();
            }
            if (e.getClass() == ConstraintViolationException.class){
                return NO_ID;
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
        Session currentSession = HibernateUtils.getOpenSession();
        Transaction tx = null;
        T pojo = null;
        
        try {
            tx = currentSession.beginTransaction();
            pojo = (T) currentSession.get(this.getPojoClass(), iD);
            tx.commit();
        } catch (Exception e) {
            if (tx!=null) {
                tx.rollback();
                e.printStackTrace();
            }
        }
        return pojo;
    }
    
}
