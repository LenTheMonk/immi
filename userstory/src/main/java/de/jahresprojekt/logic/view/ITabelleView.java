/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jahresprojekt.logic.view;

import de.jahresprojekt.logic.service.ILogikService;
import de.jahresprojekt.logic.service.impl.BaseLogikService;
import de.jahresprojekt.persistence.entities.impl.BaseEntity;
import de.jahresprojekt.persistence.repositories.impl.BaseRepository;

/**
 *
 * @author Lukas Eckert
 */
public interface ITabelleView<T extends BaseEntity>
        extends ISortierView<T>, IEditView<T>, IAddView<T> {
    
    
    /**
     * Liefert den Logikservice.
     * @return 
     */
    public BaseLogikService getLogikService();
    
    /**
     * Setzt den LogikService.
     * @param service 
     */
    public void setLogikService(BaseLogikService service);
    
    /**
     * Entfernt Objekt.
     * @param obj 
     */
    public void remove(T obj);
}
