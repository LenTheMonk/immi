/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jahresprojekt.persistence.service;

import de.jahresprojekt.persistence.entities.base.BaseEntity;
import de.jahresprojekt.persistence.service.iRepositories.IRepository;
import de.jahresprojekt.persistence.utils.HibernateUtils;
import java.util.ArrayList;
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
public abstract class BaseRepository<T extends BaseEntity>
        implements IRepository<T> {
    protected final EntityManager manager;

    /**
     * Konstruktor.
     */
    public BaseRepository() {
        System.out.println("Wir sind im Constructor");
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
    public List<Optional<T>> save(List<T> list) {
        List<Optional<T>> ergebnis = new ArrayList<>();
        try {
            EntityTransaction et = manager.getTransaction();
            et.begin();
            for (T element : list) {
                ergebnis.add(this.save(element, et));
            }
            et.commit();
            return ergebnis;
        } catch (Exception e) {
            manager.getTransaction().rollback();
            e.printStackTrace();
        }
        return ergebnis;
    }

    @Override
    public void delete(T obj) {
        try {
            manager.getTransaction().begin();
            obj = this.findById(obj.getId()).get();
            if (obj == null) {
                return;
            }
            manager.remove(obj);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void delete(T obj, EntityTransaction et) {
        try {
            obj = this.findById(obj.getId()).get();
            if (obj == null) {
                return;
            }
            manager.remove(obj);
        } catch (Exception e) {
            manager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void deleteList(List<T> list) {
            try {
                EntityTransaction et = manager.getTransaction();
                et.begin();
                for (T element : list) {
                    this.delete(element, et);
                }
                et.commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
            e.printStackTrace();
        }
    }
    
}
