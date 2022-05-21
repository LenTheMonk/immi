/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jahresprojekt.logic.view;

import de.jahresprojekt.persistence.entities.base.BaseEntity;
import de.jahresprojekt.persistence.service.BaseRepository;
import java.util.List;

/**
 *
 * @author Lukas Eckert
 */
public interface IView<T extends BaseEntity> {
    
    /**
     * Liefert eine vollständige Liste der Entities.
     * @return Liste der Entities.
     */
    public List<T> getFullList();
    
    /**
     * Setzt die vollständige Liste der Entities.
     * @param liste Liste der Entities
     */
    public void setFullList(List<T> liste);
    
    /**
     * Aktualisiert die Liste der persistenten Entities.
     */
    public void fetchListe();
}
