/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jahresprojekt.persistence.service;

import de.jahresprojekt.persistence.entities.Nutzer;
import java.util.List;
import java.util.Optional;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Lukas Eckert
 */
public class NutzerRepository extends BaseRepository<Nutzer>{

    @Override
    Class getManagedClass() {
        return Nutzer.class;
    }
    
    public Optional<Nutzer> getNutzerByLogin(String name, String hashPw) {
        // Builder
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Nutzer> query = builder.createQuery(getManagedClass());
        
        // Query
        Root<Nutzer> root = query.from(getManagedClass());
        query.select(root);
        query.where(builder.equal(root.get(Nutzer.MAP_NUTZERNAME), name));
        query.where(builder.equal(root.get(Nutzer.MAP_PASSWORT), hashPw));
        
        System.out.println("Name: " + name + " PW: " + hashPw);
        System.out.println(query.toString());
        
        // Nutzer ermitteln
        List<Nutzer> ergebnis = manager.createQuery(query).getResultList();
        if (ergebnis.size() == 1) {
            System.out.println("Nutzer vorhanden!");
            return Optional.of(ergebnis.get(0));
        }
        
        // Kein Nutzer ermittelt
        System.out.println("Kein Nutzer vorhanden!");
        return Optional.empty();
    }
}
