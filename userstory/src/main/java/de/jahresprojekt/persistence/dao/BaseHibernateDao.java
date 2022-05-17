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
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Criteria;


/**
 * Abstrakte Implementierung der IHibernateDao.
 * @author Lukas Eckert
 * @param <T> Pojo das von der Dao verwaltet wird
 */
public abstract class BaseHibernateDao<T extends IPojo>
    implements IHibernateDao<T> {
    
    @Override
    public Long save(T pojo, Transaction tx) {
        // Wenn wir nicht speichern können, wird so null zurückgegeben.
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
    public T getByID(Long iD) {
        T pojo = null;
        
        try {
            pojo = (T) HibernateUtils.getOpenSession().get(this.getPojoClass(), iD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pojo;
    }

    @Override
    public List<T> getAll() {
        List<T> pojos = new ArrayList<>();
        
        
        EntityManager manager = HibernateUtils.getOpenSession()
            .getEntityManagerFactory().createEntityManager();
        
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        
        CriteriaQuery<T> query = builder.createQuery(getPojoClass());
        
        query.from(getPojoClass());
        
        //query.
        // HibernateUtils.getOpenSession().
        // TODO @Lukas Eckert
        
        return pojos;
    }

    @Override
    public List<Long> save(List<T> list, Transaction t) throws PersistenceException {
        List<Long> savedIDs = new ArrayList<>();
        
        // TODO @Lukas Eckert
        
        return savedIDs;
    }

    @Override
    public List<T> getByID(List<Long> list) {
        List<T> pojos = new ArrayList<>();
        
        // TODO @Lukas Eckert
        
        return pojos;   
    }
    
}
