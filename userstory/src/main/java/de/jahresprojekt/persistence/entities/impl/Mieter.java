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

@Entity
@Table(name = Mieter.TABLE_NAME)
public class Mieter extends BaseEntity{
	
    public static final String TABLE_NAME = "MIETER";
    
    @Id
    @GeneratedValue
    private long id;
    
    public static final String MAP_ANREDE = "anrede";
    @Column(nullable = false, name = Mieter.MAP_ANREDE)
    private String anrede;
    
    public static final String MAP_VORNAME = "vorname";
    @Column(nullable = false, name = Mieter.MAP_VORNAME)
    private String vorname;
    
    public static final String MAP_NAME = "name";
    @Column(nullable = false, name = Mieter.MAP_NAME)
    private String name;
    
    public static final String MAP_STRASSEALT = "strasseAlt";
    @Column(nullable = false, name = Mieter.MAP_STRASSEALT)
    private String strasseAlt;
    
    public static final String MAP_PLZALT = "plzAlt";
    @Column(nullable = false, name = Mieter.MAP_PLZALT)
    private String plzAlt;
    
    public static final String MAP_ORTALT= "ortAlt";
    @Column(nullable = false, name = Mieter.MAP_ORTALT)
    private String ortAlt;
    
    public static final String MAP_EMAIL = "email";
    @Column(nullable = false, name = Mieter.MAP_EMAIL)
    private String email;
    
    public static final String MAP_FESTNETZ= "festnetz";
    @Column(nullable = false, name = Mieter.MAP_FESTNETZ) 
    private String festnetz;
     
    public static final String MAP_MOBIL = "mobil";
    @Column(nullable = false, name = Mieter.MAP_MOBIL)
    private String mobil;
    
    public static final String MAP_IBAN = "iban";
    @Column(nullable = false, name = Mieter.MAP_IBAN)
    private String iban;
    
    public static final String MAP_BIC = "bic";
    @Column(nullable = false, name = Mieter.MAP_BIC)
    private String bic;
    
    public static final String MAP_KONTOINHABER = "kontoinhaber";
    @Column(nullable = false, name = Mieter.MAP_KONTOINHABER)
    private String kontoinhaber;
    
    public static final String MAP_KREDITINSTITUT = "Kreditinstitut";
    @Column(nullable = false, name = Mieter.MAP_KREDITINSTITUT)
    private String kreditinstitut;
   
    
    @OneToMany(mappedBy = Mietobjekt.MAP_MIETER, fetch=FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    private List<Mietobjekt> mietobjekte = new ArrayList<>();
    
    @OneToMany(mappedBy = Mietkomplex.MAP_MIETER, fetch=FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    private List<Mietkomplex> mietkomplexe = new ArrayList<>();
    
    public Mieter() {
    }
    
    public Mieter(String aAnrede, String aVorname, String aName, String aStrasseAlt, String aPlzAlt,
    String aOrtAlt, String aEmail, String aFestnetz, String aMobil, String aIban,  String aBic, 
    String aKontoinhaber, String aKreditinstitut) {
    	anrede = aAnrede;
        vorname = aVorname;
        name = aName;
        strasseAlt = aStrasseAlt;
        plzAlt = aPlzAlt;
        ortAlt = aOrtAlt;
        email = aEmail;
        festnetz = aFestnetz;
        mobil = aMobil;
       	iban = aIban;
        bic = aBic;
        kontoinhaber = aKontoinhaber;
        kreditinstitut = aKreditinstitut;
    }
    
    @Override
    public String getTableName() {
        return Mieter.TABLE_NAME;
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
    
    public String getAnrede() {
        return anrede;
    }
    
    public void setAnrede(String aAnrede) {
       anrede = aAnrede;
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
    
    public String getStrasseAlt() {
        return strasseAlt;
    }
    
    public void setStrasseAlt(String aStrasseAlt) {
       strasseAlt = aStrasseAlt;
    }
    
    public String getPlzAlt() {
        return plzAlt;
    }
    
    public void setPlzAlt(String aPlzAlt) {
       plzAlt = aPlzAlt;
    }
    
    public String getOrtAlt() {
        return ortAlt;
    }
    
    public void setOrtAlt(String aOrtAlt) {
       ortAlt = aOrtAlt;
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
    
    public String getIban() {
        return iban;
    }
    
    public void setIban(String aIban) {
       iban = aIban;
    }   
    public String getBic() {
        return bic;
    }
    
    public void setBic(String aBic) {
       bic = aBic;
    }
       
    public String getKontoinhaber() {
        return kontoinhaber;
    }
    
    public void setKontinhaber(String aKontoinhaber) {
       kontoinhaber = aKontoinhaber;
    }
       
    public String getKreditinstitut() {
    	return kreditinstitut;
    }		
    
    public void setKreditinstitut(String aKreditinstitut) {
       kreditinstitut = aKreditinstitut;
    }
    
    public List<Mietobjekt> getMietobjekte() {
        return mietobjekte;
    }
    
    public void addMietobjekt(Mietobjekt aMietobjekt) {
        mietobjekte.add(aMietobjekt);
        aMietobjekt.setMieter(this);
    }
    
    public List<Mietkomplex> getMietkomplexe() {
        return mietkomplexe;
    }
    
    public void addMietkomplex(Mietkomplex aMietkomplex) {
        mietkomplexe.add(aMietkomplex);
        aMietkomplex.setMieter(this);
    }
}