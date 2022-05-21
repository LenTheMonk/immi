/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jahresprojekt.tutorial;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lukas
 */
@Deprecated
public abstract class GenericBean<T> implements Serializable {
    
    private T object;
    
    private List<T> objectList;
    
    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public List<T> getObjectList() {
        if (this.objectList == null) {
            this.objectList = new ArrayList();
        }
        return this.objectList;
    }

    public void setObjectList(List<T> objectList) {
        if(objectList != null) {            
            this.objectList = objectList;
        }
    }
    
    public void addObjectToList() {
        if(this.getObjectList().contains(this.object)) {
            return;
        }
        this.objectList.add(this.object);
        this.resetObject();
    }
    
    public void deleteObjectFromList(T tObj) {
        this.getObjectList().remove(tObj);
    }
    
    public abstract void resetObject();
}
