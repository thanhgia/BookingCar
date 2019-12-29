/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gia.dao;

import gia.dto.OrderDetail;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class OrderDetailDAO implements Serializable {

    private Connection conn;
    private PreparedStatement preStm;
    private ResultSet rs;

    public OrderDetailDAO() {
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

    public boolean insertOrderDetail(OrderDetail dto) throws Exception {
        boolean check = false;
        try {
            String sql = "Insert into OrderDetail(LicensePlate, IDOrder, BookingDate, RepayDate, Total) values(?,?,?,?,?)";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getLicensePlate());
            preStm.setInt(2, dto.getOrderID());
            preStm.setString(3, dto.getBookingDate());
            preStm.setString(4, dto.getRepayDate());
            preStm.setFloat(5, dto.getTotal());
            preStm.executeUpdate();
            check = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return check;
    }

    public OrderDetail getOrder(String lice) {
         OrderDetail dto = null;
        try {
           
            conn = MyConnection.getMyConnection();
            String sql = "select LicensePlate, IDOrder, BookingDate, RepayDate, Total from OrderDetail where LicensePlate = ? ";
            preStm = conn.prepareCall(sql);
            preStm.setString(1, lice);
            rs = preStm.executeQuery();
            if(rs.next()){
                int id = rs.getInt("IDOrder");
                String bookingDate = rs.getString("BookingDate");
                String repayDate = rs.getString("RepayDate");
                float total = rs.getFloat("total");
                String licensePlate = rs.getString("LicensePlate");
                dto = new OrderDetail(id, bookingDate, repayDate, total, licensePlate);
            }
        } catch (Exception ex) {
            Logger.getLogger(OrderDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dto;
    }
}
