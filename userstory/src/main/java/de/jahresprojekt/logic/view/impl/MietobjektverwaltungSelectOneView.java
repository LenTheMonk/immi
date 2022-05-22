/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jahresprojekt.logic.view.impl;

import de.jahresprojekt.persistence.entities.impl.Mieter;
import de.jahresprojekt.persistence.entities.impl.Mietobjekt;
import de.jahresprojekt.persistence.repositories.controlling.RepositoryFactory;
import de.jahresprojekt.persistence.repositories.impl.BaseRepository;
import de.jahresprojekt.persistence.repositories.impl.MieterRepository;
import de.jahresprojekt.persistence.repositories.impl.MietobjektRepository;
import java.util.List;
import java.util.function.Predicate;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;

/**
 *
 * @author Lukas Eckert
 */
@Named(value = "mietobjektMieterSelectView")
@SessionScoped
@FacesConverter(value = "mietobjektMieterSelectView", managed = true)
@FacesValidator(value = "mietobjektMieterSelectView")
public class MietobjektverwaltungSelectOneView extends BaseSelectOneView<Mieter, MieterRepository, String> {
    
    @Override
    public Mieter getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && value.trim().length() > 0) {
         List<Mieter> mieterliste = this.getAllAvailable();
         Mieter found = mieterliste.stream()
            .filter(this.getDefinedPredicate(value))
            .findAny()
            .orElse(null);

         return found;
      }
      return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Mieter value) {
        if (value != null) {
            return value.getName();
        }
        return null;
    }

    
    
    public MietobjektverwaltungSelectOneView() {
        this.setRepository(RepositoryFactory.getMieterRepositorySingleton());
    }
    
    @Override
    Predicate<Mieter> getDefinedPredicate(String filterName) {
        return new MieterPredicate(filterName);
    }

    @Override
    List<Mieter> getFilteredRepositoryResults() {
        return this.getRepository().findAll();
    }

    @Override
    public List<Mieter> getFilteredListReady() {
        return super.getFilteredListReady();
    }

    @Override
    public List<Mieter> getAllAvailable() {
        return super.getAllAvailable();
    }
    
    private class MieterPredicate implements Predicate<Mieter> {
        private final String filterName;
        
        public MieterPredicate(String filterName) {
            this.filterName = filterName;
        }
        
        @Override
        public boolean test(Mieter t) {
            return t.getName().equals(this.filterName);
        }
    }
    
}
