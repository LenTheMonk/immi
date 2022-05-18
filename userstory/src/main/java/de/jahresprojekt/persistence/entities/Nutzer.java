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
import de.jahresprojekt.persistence.entities.base.BasePojo;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;


@Entity
@Table(name = Nutzer.TABLE_NAME)
public class Nutzer extends BasePojo {
    
    // Den Namen der Tabelle hier immer statisch deklarieren,
    // die brauchen wir technisch aktuell.
    public static final String TABLE_NAME = "NUTZER";
    
    @Id
    @GeneratedValue
    private long id;
    
    @Column(nullable = false)
    private String nutzername;
    
    @Column(nullable = false)
    private String passwort;
    
    @Column(nullable = false)
    private boolean istAdministrator;
      
    @Column(nullable = false)
    private String vorname;
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private String email;
    
    @Column(nullable = false)
    private String festnetz;
       
    @Column(nullable = false)
    private String mobil;
    
    public Nutzer() {
    }
    
    public Nutzer(
        String aNutzername, String aPasswort, Boolean aIstAdministrator,
        String aVorname, String aName, String aFestnetz, String aMobil) {
    	nutzername = aNutzername;
        passwort = aPasswort;
        istAdministrator = aIstAdministrator;
        vorname = aVorname;
        name = aName;
        festnetz = aFestnetz;
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