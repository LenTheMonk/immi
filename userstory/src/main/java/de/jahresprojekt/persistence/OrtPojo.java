/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jahresprojekt.persistence;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
* @author Lukas Eckert
 */
@Entity
@Table(name = "ORT")
public class OrtPojo implements Serializable {
    @Id @GeneratedValue
    long id;
    String name;
    int plz;

    // Default Constructor for PoJo
    public OrtPojo() {
    }
    
    public OrtPojo(String name, int plz) {
        this.name = name;
        this.plz = plz;
    }
    
    // id

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    
    
    
    // Get

    public String getName() {
        return name;
    }

    public int getPlz() {
        return plz;
    }
    
    // Set

    public void setName(String name) {
        this.name = name;
    }

    public void setPlz(int plz) {
        this.plz = plz;
    }
    
    
}
