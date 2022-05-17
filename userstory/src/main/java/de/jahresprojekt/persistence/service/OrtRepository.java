/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jahresprojekt.persistence.service;

import java.util.List;
import javax.persistence.EntityManager;
import de.jahresprojekt.persistence.entities.Ort;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Lukas Eckert
 */
public class OrtRepository {
    private EntityManager manager;

    public OrtRepository(EntityManager man) {
        this.manager = man;
    }
    
    public List<Ort> findAll() {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Ort> query = builder.createQuery(Ort.class);
        query.from(Ort.class);
        
        return manager.createQuery(query).getResultList();
    }
    
}
