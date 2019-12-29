package gia.dto;

import java.util.Vector;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */
public class CustomerDTO {
    String idCard;
    String name;
    String address;
    String tel;


    public CustomerDTO(String idCard, String name, String address, String tel) {
        this.idCard = idCard;
        this.name = name;
        this.address = address;
        this.tel = tel;

    }
    
    public CustomerDTO() {
    }



    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

   

   

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    
    
    public Vector toVector(){
        Vector v = new Vector();
        v.add(idCard);
        v.add(name);
        v.add(address);
        v.add(tel);
        return v;
    }
}
