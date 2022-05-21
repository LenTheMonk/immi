/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jahresprojekt.logic.service.impl;

import de.jahresprojekt.logic.service.ILogikService;
import de.jahresprojekt.persistence.entities.base.BaseEntity;
import de.jahresprojekt.persistence.service.BaseRepository;

/**
 *
 * @author Lukas Eckert
 */
public abstract class BaseLogikService<T extends BaseEntity, REPO extends BaseRepository<T>>
        implements ILogikService<REPO> {

    private REPO repository;
    
    @Override
    public REPO getRepository() {
        return this.repository;
    }
    
    @Override
    public void setRepository(REPO rep) {
        this.repository = rep;
    }
}
