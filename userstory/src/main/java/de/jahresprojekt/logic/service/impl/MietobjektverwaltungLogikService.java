/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jahresprojekt.logic.service.impl;

import de.jahresprojekt.persistence.entities.impl.Mietobjekt;
import de.jahresprojekt.persistence.repositories.impl.MietobjektRepository;

/**
 *
 * @author Lukas Eckert
 */
public class MietobjektverwaltungLogikService extends
        BaseLogikService<Mietobjekt, MietobjektRepository> {

    public MietobjektverwaltungLogikService() {
        this.setRepository(new MietobjektRepository());
    }
    
}
