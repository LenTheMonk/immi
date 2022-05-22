/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jahresprojekt.persistence.entities.impl;

/**
 * 
 * @author Lukas Eckert
 * @author Simon Stabbert
 */
import de.jahresprojekt.persistence.entities.impl.BaseEntity;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.FetchType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@Entity
@Table(name = Ansprechpartner.TABLE_NAME)
public class Ansprechpartner extends BaseEntity{
    
    public static final String TABLE_NAME = "ANSPRECHPARTNER";
	
    @Id
    @GeneratedValue
    private long id;
    
    public static final String MAP_VORNAME = "vorname";
    @Column(nullable = false, name = Ansprechpartner.MAP_VORNAME)
    private String vorname;
    
    public static final String MAP_NAME = "name";
    @Column(nullable = false, name = Ansprechpartner.MAP_NAME)
    private String name;
    
    public static final String MAP_EMAIL = "email";
    @Column(nullable = false, name = Ansprechpartner.MAP_EMAIL)
    private String email;
    
    public static final String MAP_FESTNETZ= "festnetz";
    @Column(nullable = false, name = Ansprechpartner.MAP_FESTNETZ) 
    private String festnetz;
     
    public static final String MAP_MOBIL = "mobil";
    @Column(nullable = false, name = Ansprechpartner.MAP_MOBIL)
    private String mobil;
    
    
    @OneToMany(mappedBy = Mietobjekt.MAP_ANSPRECHPARTNER,
        fetch=FetchType.EAGER,
        cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Mietobjekt> mietobjekte;
    
    public Ansprechpartner() {
    }
    
    public Ansprechpartner(String aVorname, String aName, String aEmail, String aFestnetz, String aMobil) {
        vorname = aVorname;
        name = aName;
        email = aEmail;
        festnetz = aFestnetz;
        mobil = aMobil;
    }

    @Override
    public String getTableName() {
        return Ansprechpartner.TABLE_NAME;
    }
    
    // Getter Setter
    
    @Override
    public long getId() {
        return id;
    }
    
    @Override
    public void setId(long aId) {
        id = aId; 
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
    
    public String getFestnetz() {
        return festnetz;
    }
    
    public void setFestnetz(String aFestnetz) {
       festnetz = aFestnetz;
    }
    
    public String getMobil() {
       return mobil;
    }
    
    public void setMobil(String aMobil) {
       mobil = aMobil;
    }
    
    public List<Mietobjekt> getMietobjekte() {
        return mietobjekte;
    }
    
    public void addMietobjekte(Mietobjekt aMietobjekt) {
        mietobjekte.add(aMietobjekt);
        aMietobjekt.setAnsprechpartner(this);
    }
    
}