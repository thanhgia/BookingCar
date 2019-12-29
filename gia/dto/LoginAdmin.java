/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gia.dto;

import java.io.Serializable;
import java.util.Vector;

/**
 *
 * @author Administrator
 */
public class LoginAdmin implements Serializable{
    String admin;
    String passWord;

    public LoginAdmin(String admin, String passWord) {
        this.admin = admin;
        this.passWord = passWord;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    public Vector toVector (){
        Vector v = new Vector();
        v.add(admin);
        v.add(passWord);
        return v;
    }
    
}
