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
public class BooKingInfo implements Serializable{
    String currentDate;
    String licensePlate;
    String bookingDate;
    String repayDate;
    float total;

    public BooKingInfo(String currentDate, String licensePlate, String bookingDate, String repayDate, float total) {
        this.currentDate = currentDate;
        this.licensePlate = licensePlate;
        this.bookingDate = bookingDate;
        this.repayDate = repayDate;
        this.total = total;
    }

    public BooKingInfo(String currentDate, String licensePlate, String bookingDate, String repayDate) {
        this.currentDate = currentDate;
        this.licensePlate = licensePlate;
        this.bookingDate = bookingDate;
        this.repayDate = repayDate;
    }

    
    public BooKingInfo() {
    }
    

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getRepayDate() {
        return repayDate;
    }

    public void setRepayDate(String repayDate) {
        this.repayDate = repayDate;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
    public Vector toVector(){
        Vector v = new Vector();
        v.add(currentDate);
        v.add(licensePlate);
        v.add(bookingDate);
        v.add(repayDate);
        v.add(total);
        return v;
    }
}
