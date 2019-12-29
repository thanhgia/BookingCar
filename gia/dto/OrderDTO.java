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
public class OrderDTO implements Serializable{
    String id;
    String currentDate;
    int customerId;

    public OrderDTO(String id, String currentDate, int customerId) {
        this.id = id;
        this.currentDate = currentDate;
        this.customerId= customerId;
    }

    public OrderDTO() {
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    
    
    
    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    
    public Vector toVector(){
        Vector v = new Vector();
        v.add(id);
        v.add(currentDate);
        return v;
    }
}
