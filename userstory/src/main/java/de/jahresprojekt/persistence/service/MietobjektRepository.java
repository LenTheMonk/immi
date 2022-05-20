/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jahresprojekt.persistence.service;

import de.jahresprojekt.persistence.entities.Mietobjekt;

/**
 *
 * @author Lukas Eckert
 */
public class MietobjektRepository extends BaseRepository<Mietobjekt>{

    @Override
    Class getManagedClass() {
        return Mietobjekt.class;
    }
    
}
