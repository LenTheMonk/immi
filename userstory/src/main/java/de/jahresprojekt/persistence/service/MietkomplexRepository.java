/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jahresprojekt.persistence.service;

import de.jahresprojekt.persistence.entities.Mietkomplex;

/**
 *
 * @author Lukas Eckert
 */
public class MietkomplexRepository extends BaseRepository<Mietkomplex>{

    @Override
    Class getManagedClass() {
        return Mietkomplex.class;
    }
    
}
