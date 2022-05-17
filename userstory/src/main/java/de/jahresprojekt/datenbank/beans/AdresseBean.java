/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jahresprojekt.datenbank.beans;

import de.jahresprojekt.datenbank.dao.AdresseDao;
import de.jahresprojekt.datenbank.model.Adresse;
import javax.annotation.PostConstruct;

/**
 *
* @author Lukas Eckert
 */
public class AdresseBean extends BeanTemp<Adresse, AdresseDao>{

    public AdresseBean() {
        super(new AdresseDao());
    }
    
    @PostConstruct
    public void init(){
        resetItem();
    }
    
    @Override
    public void resetItem() {
        this.item = new Adresse();
    }
    
}
