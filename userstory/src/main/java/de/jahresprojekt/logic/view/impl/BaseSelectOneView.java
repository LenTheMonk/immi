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
import java.util.function.Predicate;
import java.util.stream.Collectors;
import de.jahresprojekt.logic.view.ISelectOneView;
import de.jahresprojekt.persistence.entities.impl.Mieter;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Lukas Eckert
 * @param <T> Entity
 * @param <REP> Repository
 * @param <FT> Filtertyp
 */
public abstract class BaseSelectOneView<T extends BaseEntity,
        REP extends BaseRepository<T>, FT>
        implements ISelectOneView<T, FT>, Serializable {

    REP repository;
    
    private List<T> allAvailable;
    
    private List<T> filteredListReady;
    
    @Override
    public List<T> getFilteredList(FT filter) {
        List<T> result = new ArrayList<>();
        
        List<Object> streamRes = this.getAllAvailable()
            .stream()
            .filter(getDefinedPredicate(filter))
            .collect(Collectors.toList());
        
        for (Object o : streamRes) {
            result.add((T) o);
        }
        
        return result;
    }
    
    public void refresh() {
        this.filteredListReady = new ArrayList<>();
        this.getFilteredListBitteOhneRefresh().addAll(this.getFilteredRepositoryResults());
    }
    
    abstract Predicate<T> getDefinedPredicate(FT filter);
    
    abstract List<T> getFilteredRepositoryResults();
                
    public List<T> getAllAvailable() {
        if (this.allAvailable == null) {
            this.allAvailable = new ArrayList<>();
        }
        System.out.println("Liste Aller Mieter " + this.allAvailable.size());
        return this.allAvailable;
    }
    
    private List<T> getFilteredListBitteOhneRefresh() {
        if (this.filteredListReady == null) {
            this.filteredListReady = new ArrayList<>();
        }
        return this.filteredListReady;
    }

    public List<T> getFilteredListReady() {
        if (this.filteredListReady == null) {
            this.filteredListReady = new ArrayList<>();
        }
        this.refresh();
        System.out.println("Liste gefilterter Mieter " + this.filteredListReady.size());
        return this.filteredListReady;
    }
    
    

    public REP getRepository() {
        return repository;
    }

    public void setRepository(REP repository) {
        this.repository = repository;
    }
    
    @Override
    public void validate(FacesContext context, UIComponent component, List<T> value) throws ValidatorException {
        if (value == null || value.size() > 1) {
            throw new ValidatorException(new FacesMessage("Maximal 1 Objekt erlaubt!"));
        }
    }
}
