/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jahresprojekt.persistence.service.iRepositories;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityTransaction;

/**
 * Interface für Repositories.
 * @author Lukas Eckert
 * @param <T>
 */
public interface IRepository<T> {
    
    /**
     * Liefert alle Objekte.
     * @return Liste Aller Objekte.
     */
    public List<T> findAll();
    
    /**
     * Liefert ein Optional zu einer ID.
     * @param id ID
     * @return Optional
     */
    public Optional<T> findById(Long id);
    
    /**
     * Startet einen Save mit der übergebenen Transaktion.
     * @param obj Obj
     * @param t Transaktion
     * @return Gespeichertes Objekt
     */
    public Optional<T> save(T obj, EntityTransaction t);
    
    /**
     * Startet einen Save, die Transaktion wird im Save aufgebaut.
     * @param obj Obj
     * @return Gespeichertes Objekt
     */
    public Optional<T> save(T obj);
    
    
    /**
     * Speichert eine Liste an Objekten.
     * @param objList Liste.
     * @return Gespeicherte Objekte
     */
    public List<Optional<T>> save(List<T> objList);
    
    /**
     * Löscht das Objekt aus der DB, die Transaktion wird im DEL aufgebaut.
     * @param obj Obj
     */
    public void delete(T obj);
    
    /**
     * Löscht das Objekt mit der übergebenen Transaktion.
     * @param obj Obj
     * @param t Transaktion
     */
    public void delete(T obj, EntityTransaction t);
    
    /**
     * Löscht eine Liste von Objekten
     * @param objList Liste von Objekten
     */
    public void deleteList(List<T> objList);
}
