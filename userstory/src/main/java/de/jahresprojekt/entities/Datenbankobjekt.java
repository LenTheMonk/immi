/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jahresprojekt.entities;

/**
 *
 * @author lukas
 */
public abstract class Datenbankobjekt {
    
    private long id;
    
    public Datenbankobjekt(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
