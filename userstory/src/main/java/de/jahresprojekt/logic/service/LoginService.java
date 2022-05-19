/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jahresprojekt.logic.service;

import de.jahresprojekt.logic.util.HashUtils;
import de.jahresprojekt.persistence.service.NutzerRepository;
import de.jahresprojekt.persistence.entities.Nutzer;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 * Service Klasse für loginRedux.xhtml
 * @author Lukas Eckert
 */
@Named(value = "loginService") 
@SessionScoped
public class LoginService implements Serializable {
    
    private final NutzerRepository nutzerRep = new NutzerRepository();
    private Nutzer activeUser;
    
    
    public boolean doLogin(String username, String password) {
        if (username == null || password == null) {
            return false;
        }
        
        this.activeUser = nutzerRep
            .getNutzerByLogin(username, HashUtils.getHash(password))
            .orElse(null);
        
        return activeUser != null;
    }
    
    // Getter Setter
    
    public Nutzer getActiveUser() {
        return activeUser;
    }

    public void setActiveUser(Nutzer activeUser) {
        this.activeUser = activeUser;
    }
    
    
    
}
