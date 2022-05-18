/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jahresprojekt.persistence.service;

import de.jahresprojekt.persistence.entities.base.BasePojo;
import de.jahresprojekt.persistence.service.base.IRepository;
import de.jahresprojekt.persistence.utils.HibernateUtils;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

/**
 * Abstrakte Implementierung eines Repositories.
 * @author Lukas Eckert
 * @param <T> Generic Pojo
 */
public abstract class BaseRepository<T extends BasePojo> implements IRepository<T> {
    private final EntityManager manager;

    /**
     * Konstruktor.
     */
    public BaseRepository() {
        this.manager = HibernateUtils.getCurrentEntityManager();
    }
    
    /**
     * Liefert die Klasse des gemanagten Generics.
     * @return Klasse
     */
    abstract Class getManagedClass();
    
    @Override
    public List<T> findAll() {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(getManagedClass());
        query.from(getManagedClass());
        
        return manager.createQuery(query).getResultList();
    }
    
    @Override
    public Optional<T> findById(Long id) {
        T obj = (T) manager.find(getManagedClass(), id);
        return (Optional<T>) (obj != null ? Optional.of(obj) : Optional.empty());
    }
    
    @Override
    public Optional<T> save(T obj, EntityTransaction t) {
        try {    
            manager.persist(obj);
        } catch (Exception e) {
            t.rollback();
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<T> save(T obj) {
        try {
            manager.getTransaction().begin();
            manager.persist(obj);
            manager.getTransaction().commit();
            return Optional.of(obj);
        } catch (Exception e) {
            manager.getTransaction().rollback();
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void delete(T obj) {
        try {
            manager.getTransaction().begin();
            obj = (T) manager.find(getManagedClass(), obj.getId());
            manager.remove(obj);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
            e.printStackTrace();
        }
    }
    
}
