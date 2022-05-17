/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jahresprojekt.persistence.dao;

import de.jahresprojekt.persistence.entities.Ort;

/**
 *
 * @author Lukas Eckert
 */
public class OrtDao extends BaseHibernateDao<Ort> {

    @Override
    Class getPojoClass() {
        return Ort.class;
    }
    
}
