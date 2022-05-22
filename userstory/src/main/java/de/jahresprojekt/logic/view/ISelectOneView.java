/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jahresprojekt.logic.view;

import de.jahresprojekt.persistence.entities.impl.BaseEntity;
import java.util.List;
import javax.faces.convert.Converter;
import javax.faces.validator.Validator;

/**
 *
 * @author Lukas Eckert
 * @param <T> Entity
 * @param <FT> Filtertyp
 */
public interface ISelectOneView<T extends BaseEntity, FT> extends Converter<T>, Validator<List<T>> {
    
    /**
     * Filtert die verfügbaren Entities basierend auf dem Filterkriterium.
     * @param filter Filterkriterium
     * @return Liste gefiltert
     */
    public List<T> getFilteredList(FT filter);
    
}
