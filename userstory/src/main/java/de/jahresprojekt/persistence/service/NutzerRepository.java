/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jahresprojekt.persistence.service;

import de.jahresprojekt.persistence.entities.Nutzer;

/**
 *
 * @author Lukas Eckert
 */
public class NutzerRepository extends BaseRepository<Nutzer>{

    @Override
    Class getManagedClass() {
        return Nutzer.class;
    }
    
}
