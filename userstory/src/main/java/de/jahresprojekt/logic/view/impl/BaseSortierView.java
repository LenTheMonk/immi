/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jahresprojekt.logic.view.impl;

import de.jahresprojekt.persistence.entities.impl.BaseEntity;
import de.jahresprojekt.persistence.repositories.impl.BaseRepository;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.SortMeta;

/**
 *
 * @author Lukas Eckert
 * @author Lennart
 * @author Tim
 */
@Deprecated
public abstract class BaseSortierView<T extends BaseEntity,
        REP extends BaseRepository<T>> {
    
    private List<T> objects;
    
    private List<SortMeta> sortByList;
    
    private REP repository;

    public BaseSortierView(BaseRepository<T> rep) {
        this.repository = (REP) rep;
    }
    
    @PostConstruct
    public void init() {
        sortByList = new ArrayList<>();
        this.initSortMeta();
    }
    
    /**
     * Initialisiert die SortMeta mit den Feldern, nach
     * denen die Entities sortiert werden können.
     */
    abstract void initSortMeta();
    
    
    // Getters
    
    public List<T> getObjects() {
        return objects;
    }
    
    public List<SortMeta> getSortByList() {
        return sortByList;
    }
    
    public void onRowEdit(RowEditEvent<T> event) {
        FacesMessage msg = new FacesMessage("Product Edited", String
                .valueOf(event.getObject().getId()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent<T> event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", String
                .valueOf(event.getObject().getId()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();

        if (newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
}
