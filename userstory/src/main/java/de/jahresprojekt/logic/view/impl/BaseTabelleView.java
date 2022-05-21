/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jahresprojekt.logic.view.impl;

import de.jahresprojekt.logic.service.ILogikService;
import de.jahresprojekt.logic.view.ITabelleView;
import de.jahresprojekt.persistence.entities.base.BaseEntity;
import de.jahresprojekt.persistence.service.BaseRepository;
import java.io.Serializable;
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
 */
public abstract class BaseTabelleView <T extends BaseEntity>
        implements ITabelleView<T>, Serializable {
    
    private ILogikService service;
    
    private List<T> entities;
    
    private List<SortMeta> sortMeta;
    
    /**
     * Initialisiert die SortMeta.
     */
    public abstract void initSortMeta();

    public void init() {
        this.sortMeta = new ArrayList<>();
        this.initSortMeta();
        this.setFullList(this.getLogikService().getRepository().findAll());
    }
    
    @Override
    public List<T> getFullList() {
        return this.entities;
    }

    @Override
    public void fetchListe() {
        this.getFullList().clear();
        this.getFullList().addAll(this.getLogikService().getRepository().findAll());
    }

    @Override
    public void setFullList(List<T> liste) {
        this.entities = liste;
    }

    @Override
    public List<SortMeta> getSortBy() {
        return this.sortMeta;
    }

    @Override
    public void setSortBy(List<SortMeta> meta) {
        this.sortMeta = meta;
    }

    @Override
    public ILogikService getLogikService() {
        return this.service;
    }
    
    @Override
    public void setLogikService(ILogikService service) {
        this.service = service;
    }
    
    @Override
    public void onRowEdit(RowEditEvent<T> event) {
        this.getLogikService().getRepository().save(this.getFullList());
        this.fetchListe();
        FacesMessage msg = new FacesMessage("Objekt bearbeitet",
            String.valueOf(event.getObject().getId()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    @Override
    public void onRowCancel(RowEditEvent<T> event) {
        FacesMessage msg = new FacesMessage("Bearbeitung abgebrochen",
            String.valueOf(event.getObject().getId()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    @Override
    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();

        if (newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Wert geändert", "Alter Wert: " + oldValue
                    + ", Neuer Wert: " + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    /**
     * Initialisiert neues Entity.
     * @return Entity
     */
    abstract T initNewEntity();
    
    @Override
    public void onAddNew() {
        T newEntitiy = this.initNewEntity();
        
        this.entities.add(newEntitiy);
        
        FacesMessage msg = new FacesMessage("Entity erstellt",
                String.valueOf(newEntitiy.getId()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    
}
