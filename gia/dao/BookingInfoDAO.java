/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gia.dao;

import gia.dto.BooKingInfo;
import gia.dto.CarDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class BookingInfoDAO implements Serializable {

    private Connection conn;
    private PreparedStatement preStm;
    private ResultSet rs;

    public BookingInfoDAO() {
    }

    private void closeConnection() throws Exception {
        if (rs != null) {
            rs.close();
        }
        if (preStm != null) {
            preStm.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    public BooKingInfo getBookingInfo(String id) throws Exception {
        String currentDate = null;
        String licensePlate = null;
        String bookingDate = null;
        String repayDate = null;
        float total = 0;
        BooKingInfo dto = null;
        try{
            conn = MyConnection.getMyConnection();
            String sql = "select CurrentDate, LicensePlate, BookingDate, RepayDate, Total from (Customer a join OrderInfo b on a.CustomerID=b.CustomerID) join OrderDetail c on b.OrderID=c.IDOrder where a.IDCard = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, id);
            rs = preStm.executeQuery();

            while(rs.next()){
                currentDate = rs.getString("CurrentDate");
                licensePlate = rs.getString("LicensePlate");
                bookingDate = rs.getString("BookingDate");
                repayDate = rs.getString("RepayDate");
                total = rs.getFloat("Total");
                dto = new BooKingInfo(currentDate, licensePlate, bookingDate, repayDate, total);            
            }
            
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            closeConnection();
        }
        return dto;
    }
    
    public List<BooKingInfo> checkReturnCar(String idCard) throws Exception {
        List<BooKingInfo> list = null;
        String currentDate = null;
        String licensePlate = null;
        String bookingDate = null;
        String repayDate = null;
        float total = 0;
        BooKingInfo dto = null;
        try{
            conn = MyConnection.getMyConnection();
            String sql = "select CurrentDate, LicensePlate, BookingDate, RepayDate from (Customer a join OrderInfo b on a.CustomerID=b.CustomerID) join OrderDetail c on b.OrderID=c.IDOrder where a.IDCard = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, idCard);
            rs = preStm.executeQuery();
            while(rs.next()){
                currentDate = rs.getString("CurrentDate");
                licensePlate = rs.getString("LicensePlate");
                bookingDate = rs.getString("BookingDate");
                repayDate = rs.getString("RepayDate");
                dto = new BooKingInfo(currentDate, licensePlate, bookingDate, repayDate);  
                if(list == null){
                    list = new ArrayList<>();
                    list.add(dto);
                }
                list.add(dto);
            }          
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            closeConnection();
        }
        return list;
    }
    
    public boolean returnCar(CarDTO dto) throws Exception{
        boolean check = false;
        int i;
        try {
            String sql = "Update car set State = ? where LicensePlate = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getLicensePlate());
            preStm.setString(2, dto.getState());
            i = preStm.executeUpdate();
            if (i > 0) {
                check = true;
            }
        } catch (Exception e) {
        }finally{
            closeConnection();
        }
        return check;
    }
}
