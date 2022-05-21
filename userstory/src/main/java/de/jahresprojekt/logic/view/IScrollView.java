/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jahresprojekt.logic.view;

import de.jahresprojekt.persistence.entities.base.BaseEntity;
import org.primefaces.model.LazyDataModel;

/**
 *
 * @author Lukas Eckert
 */
public interface IScrollView<T extends BaseEntity> extends IView<T>{
    
    /**
     * Setzt das LazyDataModel für Scrolls.
     * @param lazyModel 
     */
    public void setLazyModel(LazyDataModel<T> lazyModel);
    
    /**
     * Liefert das LazyDataModel für Scrolls.
     * @return 
     */
    public LazyDataModel<T> getLazyModel();
}
