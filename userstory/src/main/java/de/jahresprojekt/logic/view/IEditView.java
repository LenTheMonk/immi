/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jahresprojekt.logic.view;

import de.jahresprojekt.persistence.entities.impl.BaseEntity;
import de.jahresprojekt.persistence.repositories.impl.BaseRepository;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Lukas Eckert
 */
public interface IEditView <T extends BaseEntity>
        extends IView <T> {
    
    /**
     * Aktion, die bei einem Editier-Event ausgelöst wird.
     * @param event 
     */
    public void onRowEdit(RowEditEvent<T> event);
    
    /**
     * Aktion, die bei einem Editier-Abbruch-Event ausgelöst wird.
     * @param event 
     */
    public void onRowCancel(RowEditEvent<T> event);
    
    /**
     * Aktion, die bei einem Cell-Edit-Event ausgelöst wird.
     * @param event 
     */
    public void onCellEdit(CellEditEvent event);
}
