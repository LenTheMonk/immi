/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jahresprojekt.logic.service.impl;

import de.jahresprojekt.logic.util.HashUtils;
import de.jahresprojekt.logic.util.StringUtils;
import de.jahresprojekt.persistence.repositories.impl.NutzerRepository;
import de.jahresprojekt.persistence.entities.impl.Nutzer;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 * Service Klasse für loginRedux.xhtml
 * @author Lukas Eckert
 * @author Alex
 */
@Named(value = "loginService") 
@SessionScoped
public class LoginService implements Serializable {
    
    private NutzerRepository nutzerRep;
    private Nutzer activeUser;
    
    protected String passwort;
    protected String username;
    
    // Getter Setter

    public Nutzer getActiveUser() {
        return activeUser;
    }

    public void setActiveUser(Nutzer activeUser) {
        this.activeUser = activeUser;
    }

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
    
    public NutzerRepository getNutzerRep() {
        if (nutzerRep == null) {
            nutzerRep = new NutzerRepository();
        }
        return nutzerRep;
    }
    
    
    public boolean doLogin() {
        System.out.println("Username: " + username + " Passwort: " + passwort + "\n\n");
        if (StringUtils.isEmpty(username) ||
            StringUtils.isEmpty(passwort)) {
                System.out.println("\n\nFELDER LEER\n\n");
                return false;
        }
        
        this.activeUser = getNutzerRep()
            .getNutzerByLogin(username, HashUtils.getHash(passwort))
            .orElse(null);
        
        System.out.println("Nutzer gefunden: " + activeUser.getName());
        
        return activeUser != null;
    }
}
