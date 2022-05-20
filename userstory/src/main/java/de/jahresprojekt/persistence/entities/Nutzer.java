/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jahresprojekt.persistence.entities;

/**
 * 
 * @author Lukas Eckert
 * @author Simon Stabbert
 */
import de.jahresprojekt.persistence.entities.base.BaseEntity;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;

@Entity
@Table(name = Nutzer.TABLE_NAME)
public class Nutzer extends BaseEntity {
    

    public static final String TABLE_NAME = "NUTZER";
    
    @Id
    @GeneratedValue
    private long id;
    
    public static final String MAP_NUTZERNAME = "nutzername";  
    @Column(nullable = false, name = Nutzer.MAP_NUTZERNAME)
    private String nutzername;
    
    public static final String MAP_PASSWORT = "passwort";
    @Column(nullable = false, name = Nutzer.MAP_PASSWORT)
    private String passwort;
    
    public static final String MAP_ISTADMINISTRATOR = "istAdminstrator";
    @Column(nullable = false, name = Nutzer.MAP_ISTADMINISTRATOR)
    private boolean istAdministrator;
     
    public static final String MAP_VORNAME = "vorname";
    @Column(nullable = false, name = Nutzer.MAP_VORNAME)
    private String vorname;
    
    public static final String MAP_NAME = "name";
    @Column(nullable = false, name = Nutzer.MAP_NAME)
    private String name;
    
    public static final String MAP_EMAIL = "email";
    @Column(nullable = false, name = Nutzer.MAP_EMAIL)
    private String email;
    
    public static final String MAP_FESTNETZ = "festnetz";
    @Column(nullable = false) 
    private String festnetz;
     
    public static final String MAP_MOBIL = "mobil";
    @Column(nullable = false, name = Nutzer.MAP_MOBIL)
    private String mobil;
    
    public Nutzer() {
    }
    
    public Nutzer(
        String aNutzername, String aPasswort, Boolean aIstAdministrator,
        String aVorname, String aName, String aEmail, String aFestnetz,
        String aMobil) {
            nutzername = aNutzername;
            passwort = aPasswort;
            istAdministrator = aIstAdministrator;
            vorname = aVorname;
            name = aName;
            email = aEmail;
            festnetz = aFestnetz;
            mobil = aMobil;
    }
    
    @Override
    public long getId() {
        return id;
    }
    
    @Override
    public void setId(long aId) {
        id = aId;
    }
    
    public String getNutzername() {
        return nutzername;
    }
    
    public void setNutzername(String aNutzername) {
       nutzername = aNutzername;
    }
    
    public String getPasswort() {
        return passwort;
    }
    
    public void setPasswort(String aPasswort) {
       passwort = aPasswort;
    }
    
    public String getVorname() {
        return vorname;
    }
    
    public void setVorname(String aVorname) {
       vorname = aVorname;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String aName) {
       name = aName;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String aEmail) {
       email = aEmail;
    }
    
    public void setFestnetz(String aFestnetz) {
       festnetz = aFestnetz;
    }
    
    public String getFestnetz() {
        return festnetz;
    }
    
    public void setMobil(String aMobil) {
       mobil = aMobil;
    }
    
    public String getMobil() {
       return mobil;
    }

    public boolean getIstAdministrator() {
        return istAdministrator;
    }

    public void setIstAdministrator(boolean istAdministrator) {
        this.istAdministrator = istAdministrator;
    }

    @Override
    public String getTableName() {
        return Nutzer.TABLE_NAME;
    }
    
}