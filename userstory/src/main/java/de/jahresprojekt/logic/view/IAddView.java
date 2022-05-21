/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jahresprojekt.logic.view;

import de.jahresprojekt.persistence.entities.base.BaseEntity;

/**
 *
 * @author Lukas Eckert
 */
public interface IAddView<T extends BaseEntity> extends IView<T> {
    
    /**
     * Methode die bei Hinzufügen einer neuen Spalte ausgeführt wird.
     */
    public void onAddNew();
}
