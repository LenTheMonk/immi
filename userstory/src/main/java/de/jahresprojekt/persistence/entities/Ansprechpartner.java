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
@Table(name = Ansprechpartner.TABLE_NAME)
public class Ansprechpartner extends BaseEntity{
    
    // Den Namen der Tabelle hier immer statisch deklarieren,
    // die brauchen wir technisch aktuell.
    public static final String TABLE_NAME = "ANSPRECHPARTNER";
	
    @Id
    @GeneratedValue
    private long id;
    
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
    
    @OneToMany(mappedBy = Mietobjekt.MAP_ANSPRECHPARTNER,
        cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Mietobjekt> mietobjekte = new ArrayList<>();
    
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