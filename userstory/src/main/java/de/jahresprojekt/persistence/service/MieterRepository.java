/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jahresprojekt.persistence.service;

import de.jahresprojekt.persistence.entities.Mieter;

/**
 *
 * @author Lukas Eckert
 */
public class MieterRepository extends BaseRepository<Mieter> {

    @Override
    Class getManagedClass() {
        return Mieter.class;
    }
    
}
