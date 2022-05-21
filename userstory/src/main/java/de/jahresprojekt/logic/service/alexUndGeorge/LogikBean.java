/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Beans/Bean.java to edit this template
 */
package de.jahresprojekt.logic.service.alexUndGeorge;


import de.jahresprojekt.persistence.repositories.impl.NutzerRepository;
import java.beans.*;
import java.io.Serializable;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import de.jahresprojekt.persistence.entities.impl.Nutzer;

/**
 *
 * @author Alex
 */
@Named(value = "LogikBean") 
@SessionScoped
public class LogikBean implements Serializable {
    
    private Login login = new Login();
    private String boolStr_LoginSuccess = "false";
    
    private NutzerRepository nutzerQuelle = new NutzerRepository();
    
    public void Btn_Login_Pressed() {
        
        if (this.login.DoLogin()){
            this.boolStr_LoginSuccess = "true";
        }
        System.out.println(this.login.Password_Hash);
    }
    
    
}
