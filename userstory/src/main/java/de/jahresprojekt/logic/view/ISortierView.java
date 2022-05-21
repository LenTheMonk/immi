/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jahresprojekt.logic.view;

import de.jahresprojekt.persistence.entities.impl.BaseEntity;
import java.util.List;
import org.primefaces.model.SortMeta;

/**
 *
 * @author Lukas Eckert
 */
public interface ISortierView<T extends BaseEntity>
        extends IView<T> {
    
    /**
     * Liefert eine Liste der Sortierungsoptionen
     * @return Sortierungsoptionen
     */
    public List<SortMeta> getSortBy();
    
    /**
     * Setzt die Liste der Sortierungsoptionen.
     * @param meta Sortierungsoptionen
     */
    public void setSortBy(List<SortMeta> meta);
}
