/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Beans/Bean.java to edit this template
 */
package de.jahresprojekt.logic.service;


import java.beans.*;
import java.io.Serializable;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Alex
 */
@Named(value = "LogikBean") 
@SessionScoped
public class LogikBean implements Serializable {
    
    private Login login = new Login();
    
    public void Btn_Login_Pressed(){
        this.login.DoLogin();
        System.out.println(this.login.Password_Hash);
    }
    
    
}
