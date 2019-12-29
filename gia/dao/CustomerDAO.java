/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gia.dao;

import gia.dto.CustomerDTO;
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
public class CustomerDAO implements Serializable {

    private Connection conn;
    private PreparedStatement preStm;
    private ResultSet rs;

    public CustomerDAO() {
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

    public boolean insert(CustomerDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "Insert into Customer(IDCard, FullName, Address, Telephone) values(?,?,?,?)";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getIdCard());
            preStm.setString(2, dto.getName());
            preStm.setString(3, dto.getAddress());
            preStm.setString(4, dto.getTel());
            preStm.executeUpdate();
            check = true;
        } finally {
            closeConnection();
        }
        return check;

    }

    public List<CustomerDTO> loadCustomerManager() throws Exception {
        List<CustomerDTO> result = null;

        try {

            conn = MyConnection.getMyConnection();
            if (conn != null) {
                String sql = "Select IDcard, FullName, Address, Telephone from Customer";
                preStm = conn.prepareStatement(sql);
                rs = preStm.executeQuery();
                result = new ArrayList<>();
                while (rs.next()) {
                    String idCard = rs.getString("IDcard");
                    String fullName = rs.getString("FullName");
                    String address = rs.getString("Address");
                    String telephone = rs.getString("Telephone");
                    CustomerDTO dto = new CustomerDTO(idCard, fullName, address, telephone);
                    result.add(dto);

                }
            }
        } finally {
            closeConnection();
        }
        return result;
    }
    
    public CustomerDTO loadCarsByIdCard(String idCustomer) throws Exception {
        CustomerDTO dto = null;

        try {
            conn = MyConnection.getMyConnection();
            if (conn != null) {
                String sql = "Select  IDcard, FullName, Address, Telephone from Customer where IDCard = ?";
                preStm = conn.prepareStatement(sql);
                preStm.setString(1, idCustomer);
                rs = preStm.executeQuery();
                if (rs.next()) {
                    String id = rs.getString("IDcard");
                    String name = rs.getString("FullName");
                    String addr = rs.getString("Address");
                    String telephone = rs.getString("Telephone");
                    dto = new CustomerDTO(id, name, addr, telephone);
                }
            }

        } finally {
            closeConnection();
        }
        return dto;
    }
    
    public boolean update(CustomerDTO dto) throws Exception {
        boolean check = false;
        int i = 0;
        try {
            String sql = "Update Customer set FullName = ?, Address = ?, Telephone = ? Where IDcard = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getName());
            preStm.setString(2, dto.getTel());
            preStm.setString(3, dto.getAddress());
            preStm.setString(4, dto.getIdCard());
            i = preStm.executeUpdate();
            if (i > 0) {
                check = true;
            }
        } finally {
            closeConnection();
        }
        return check;
    }
}
