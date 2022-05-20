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
    
    protected String passwort = "pW";
    protected String username;
    
    // Getter Setter

    public void setNummer(int nummer) {
        System.out.println("\n############## set Nummer ###################\n");
        this.nummer = nummer;
    }

    public int getNummer() {
        System.out.println("\n############## get Nummer ###################\n");
        return nummer;
    }

    public Daten getDaten() {
        System.out.println("\n\n======== Get Daten ========\n\n");
        return daten;
    }

    public void setDaten(Daten daten) {
        System.out.println("\n\n======== Set Daten ========\n\n");
        this.daten = daten;
    }
    
    
    
    
    
    public Nutzer getActiveUser() {
        return activeUser;
    }

    public void setActiveUser(Nutzer activeUser) {
        this.activeUser = activeUser;
    }

    public String getPasswort() {
         System.out.println("\n\n+++++++++ Get Passwort +++++++++n\n");
        return passwort;
    }

    public void setPasswort(String passwort) {
        System.out.println("\n\n+++++++++ Set Passwort +++++++++\n\n");
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
        System.out.println("\n\n <<<<<<< Methode doLogin >>>>>>>>");
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
    
    
    public class Daten {

        public Daten() {
        }
        
        String nutzerNameDaten;
        String nutzerPasswortDaten;

        public String getNutzerNameDaten() {
            System.out.println("\n\n\n" + nutzerNameDaten + " get Nutzernamdaten \n\n\n");
            return nutzerNameDaten;
        }

        public String getNutzerPasswortDaten() {
            return nutzerPasswortDaten;
        }

        public void setNutzerNameDaten(String nutzerNameDaten) {
            System.out.println("\n\n\n Set NutzernameDaten BEKOMMEN " + nutzerNameDaten + "\n\n\n");
            this.nutzerNameDaten = nutzerNameDaten;
        }

        public void setNutzerPasswortDaten(String nutzerPasswortDaten) {
            this.nutzerPasswortDaten = nutzerPasswortDaten;
        }
        
        
    }
}
