/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jahresprojekt.persistence.repositories.impl;

import de.jahresprojekt.persistence.entities.impl.NebenkostenJahr;

/**
 *
 * @author Lukas Eckert
 */
public class NebenkostenJahrRepository extends BaseRepository<NebenkostenJahr>{

    @Override
    Class getManagedClass() {
        return NebenkostenJahr.class;
    }
    
}
