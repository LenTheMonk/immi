/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jahresprojekt.logic.service;

import de.jahresprojekt.persistence.service.BaseRepository;

/**
 *
 * @author Lukas Eckert
 */
public interface ILogikService <REPO extends BaseRepository> {
    
    /**
     * Liefert das Repository, welches von der View verwendet wird.
     * @return 
     */
    public REPO getRepository();
    
    /**
     * Setzt das Repository der View.
     * @param rep Repository
     */
    public void setRepository(REPO rep);
}
