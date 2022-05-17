/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jahresprojekt.datenbank.beans;

import de.jahresprojekt.datenbank.dao.OrtDao;
import de.jahresprojekt.datenbank.model.Ort;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
* @author Lukas Eckert
 */
@Named(value = "city") 
@SessionScoped
public class OrtBean extends BeanTemp<Ort, OrtDao>{

    public OrtBean() {
        super(new OrtDao());
    }
    
    @PostConstruct
    public void init(){
        resetItem();
    }
    
    @Override
    public void resetItem() {
        this.item = new Ort();
    }
    
}
