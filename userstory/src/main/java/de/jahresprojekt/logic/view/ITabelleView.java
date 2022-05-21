/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jahresprojekt.logic.view;

import de.jahresprojekt.logic.service.ILogikService;
import de.jahresprojekt.persistence.entities.base.BaseEntity;
import de.jahresprojekt.persistence.service.BaseRepository;

/**
 *
 * @author Lukas Eckert
 */
public interface ITabelleView<T extends BaseEntity>
        extends ISortierView<T>, IEditView<T> {
    
    
    /**
     * Liefert den Logikservice.
     * @return 
     */
    public ILogikService getLogikService();
    
    /**
     * Setzt den LogikService.
     * @param service 
     */
    public void setLogikService(ILogikService service);
}
