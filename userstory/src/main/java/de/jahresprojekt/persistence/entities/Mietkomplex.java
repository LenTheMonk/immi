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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
@Table(name = Mietkomplex.TABLE_NAME)
public class Mietkomplex extends BaseEntity{
	
    public static final String TABLE_NAME = "MIETKOMPLEX";
	 
    @Id
    @GeneratedValue
    private long id;
        
    @OneToMany(mappedBy = Mietobjekt.MAP_MIETKOMPLEX,
        cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    private List<Mietobjekt> mietobjekte = new ArrayList<>();
    
    public static final String MAP_MIETER = "mieter";
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE,
        CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name="MIETER_MIETKOMPLEX")
    private Mieter mieter;
    
    public Mietkomplex() {
    }
    
    @Override
    public String getTableName() {
        return Mietkomplex.TABLE_NAME;
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
    
//    public void setMietkomplexId(Integer aMietkomplexId) {
//    	mietkomplexId = aMietkomplexId;
//    }
    
    public List<Mietobjekt> getMietobjekt() {
        return mietobjekte;
    }
    
    public void addMietobjekt(Mietobjekt aMietobjekt) {
        mietobjekte.add(aMietobjekt);
        aMietobjekt.setMietkomplex(this);
    }
    
    public Mieter getMieter() {
        return mieter;
    }

    public void setMieter(Mieter aMieter) {
        mieter = aMieter;
    }
    
}