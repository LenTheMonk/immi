/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jahresprojekt.logic.service;

import de.jahresprojekt.logic.util.HashUtils;
import de.jahresprojekt.logic.util.StringUtils;
import de.jahresprojekt.persistence.service.NutzerRepository;
import de.jahresprojekt.persistence.entities.Nutzer;
import java.io.Serializable;
import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 * Service Klasse für loginRedux.xhtml
 * @author Lukas Eckert
 */
@Named(value = "loginService") 
@SessionScoped
public class LoginService implements Serializable {
    
    private NutzerRepository nutzerRep;
    private Nutzer activeUser;
    
    private Daten daten = new Daten();
    
    protected int nummer;
    
    protected String hubert = "Hanswurst";
    protected String username = "";
    
    // Getter Setter

    public void setNummer(int nummer) {
        System.out.println("##############set###################");
        this.nummer = nummer;
    }

    public int getNummer() {
        System.out.println("##############get##########################");
        return nummer;
    }

    public Daten getDaten() {
        return daten;
    }

    public void setDaten(Daten daten) {
        this.daten = daten;
    }
    
    
    
    
    
    public Nutzer getActiveUser() {
        return activeUser;
    }

    public void setActiveUser(Nutzer activeUser) {
        this.activeUser = activeUser;
    }

    public String getHubert() {
        return hubert;
    }

    public void setHubert(String hubert) {
        System.out.println("");
        System.out.println("");
        System.out.println(hubert);
        System.out.println("");
        System.out.println("");
        this.hubert = hubert;
    }

    public void setUsername(String username) {
        System.out.println(username);
        this.username = username;
    }

    public String getUsername() {
        
        System.out.println("\n\n\nHALLO WELT\n\n\n");
        
        return username;
    }
    
    public NutzerRepository getNutzerRep() {
        if (nutzerRep == null) {
            nutzerRep = new NutzerRepository();
        }
        return nutzerRep;
    }
    
    
    public boolean doLogin() {
        if (StringUtils.isEmpty(username) ||
            StringUtils.isEmpty(hubert)) {
                System.out.println("\n\nFELDER LEER\n\n");
                return false;
        }
        
        this.activeUser = getNutzerRep()
            .getNutzerByLogin(username, HashUtils.getHash(hubert))
            .orElse(null);
        
        System.out.println("Nutzer gefunden: " + activeUser.getName());
        
        return activeUser != null;
    }
    
    
    public class Daten {

        public Daten() {
        }
        
        String nutzerNameDaten;
        String nutzerPasswortDaten;

        public String getNutzerNameDaten() {
            System.out.println("\n\n\n" + nutzerNameDaten + "HIER WERT \n\n\n");
            return nutzerNameDaten;
        }

        public String getNutzerPasswortDaten() {
            return nutzerPasswortDaten;
        }

        public void setNutzerNameDaten(String nutzerNameDaten) {
            System.out.println("\n\n\n HABE BEKOMMEN " + nutzerNameDaten + "\n\n\n");
            this.nutzerNameDaten = nutzerNameDaten;
        }

        public void setNutzerPasswortDaten(String nutzerPasswortDaten) {
            this.nutzerPasswortDaten = nutzerPasswortDaten;
        }
        
        
    }
}
