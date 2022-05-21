package de.jahresprojekt.logic.service;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author George
 */
@Named
@RequestScoped
public class MessagesView {

    public void email() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("E-Mail", "HausBauGbR@immobilien.de"));
    }

    public void whatsapp() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage( "Whatsapp", "+1555 777 8896"));
    }

    public void instagram() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage( "Instagram", "HausBauGbR"));
    }
    
    public void phone() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage( "Tele", "0211 8928750"));
    }
}

