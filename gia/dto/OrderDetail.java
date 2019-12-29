/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gia.dto;

import java.util.Vector;

/**
 *
 * @author Administrator
 */
public class OrderDetail {

    int orderID;
    String LicensePlate;
    String bookingDate;
    String repayDate;
    float total;

    public OrderDetail(int orderID, String bookingDate, String repayDate, float total, String lice) {
        this.orderID = orderID;
        this.bookingDate = bookingDate;
        this.repayDate = repayDate;
        this.total = total;
        this.LicensePlate = lice;
    }

    

    
    public OrderDetail(int orderID, String LicensePlate, String bookingDate, String repayDate, float total) {
        this.orderID = orderID;
        this.LicensePlate = LicensePlate;
        this.bookingDate = bookingDate;
        this.repayDate = repayDate;
        this.total = total;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getLicensePlate() {
        return LicensePlate;
    }

    public void setLicensePlate(String LicensePlate) {
        this.LicensePlate = LicensePlate;
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
        v.add(LicensePlate);
        v.add(orderID);
        v.add(bookingDate);
        v.add(repayDate);
        v.add(total);
        return v;
    }
}
