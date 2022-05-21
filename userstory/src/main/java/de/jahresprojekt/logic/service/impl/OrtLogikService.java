/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jahresprojekt.logic.service.impl;

import de.jahresprojekt.persistence.service.OrtRepository;
import de.jahresprojekt.persistence.entities.Ort;

/**
 *
 * @author Lukas Eckert
 */
public class OrtLogikService extends BaseLogikService<Ort, OrtRepository> {

    public OrtLogikService() {
        this.setRepository(new OrtRepository());
    }
    
}
