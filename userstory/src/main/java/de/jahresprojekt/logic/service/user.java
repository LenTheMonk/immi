
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.jahresprojekt.logic.service;



import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;






/**
 *
 * @author George
 */

public class user {
    
    String email;
    String password;
    
    public String pruefen(){
                
       boolean pruefung = false;
        String connectionUrl = null;//connectionUrl muss eingeben
        
       try (Connection conn = DriverManager.getConnection(connectionUrl);
          Statement  s = conn.createStatement();)
        {
             String sql="";//SQL abfrage
        ResultSet rs = s.executeQuery(sql);
           //result
               while(rs.next())
                   pruefung = true;         
       } 
       catch (Exception se)
       {
            return "falsh";
                    }
            
        if(pruefung)
            return "startSeite.xhtml";
        else 
        return null;
   }

    public String getemail(){
        return email;
    }
    
    public void setemail(String email){
        this.email =  email;
    }
    public String getpassword(){
        return password;
    }
    
    public void setpassword(String password){
        this.password =  password;
    }

   
    
}
