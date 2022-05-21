/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jahresprojekt.persistence.repositories.impl;

import de.jahresprojekt.persistence.entities.impl.Ort;


/**
 *
 * @author Lukas Eckert
 */
public class OrtRepository extends BaseRepository<Ort> {

    @Override
    Class getManagedClass() {
        return Ort.class;
    }
    
}
