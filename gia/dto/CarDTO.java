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
public class CarDTO {
    private String licensePlate;
    private String brand;
    private String color;
    private int amountOfSeat;
    private float price;
    private String state;

    

    public CarDTO(String licensePlate, String brand, String color, int amountOfSeat, float price, String state) {
        this.licensePlate = licensePlate;
        this.brand = brand;
        this.color = color;
        this.amountOfSeat = amountOfSeat;
        this.price = price;
        this.state = state;
        
    }

    public CarDTO(String state, String lice) {
        this.state = state;
        this.licensePlate = lice;
    }
    

    public CarDTO() {
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAmountOfSeat() {
        return amountOfSeat;
    }

    public void setAmountOfSeat(int amountOfSeat) {
        this.amountOfSeat = amountOfSeat;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

 
    
    public Vector toVector(){
        Vector v = new Vector();
        v.add(licensePlate);
        v.add(brand);
        v.add(color);
        v.add(amountOfSeat);
        v.add(price);
        v.add(state);
        return v;
    }
}
