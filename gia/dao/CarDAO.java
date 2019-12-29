package gia.dao;

import gia.dto.CarDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrator
 */
public class CarDAO implements Serializable {

    private Connection conn;
    private PreparedStatement preStm;
    private ResultSet rs;

    public CarDAO() {
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

    public List<CarDTO> loadCar() throws Exception {
        List<CarDTO> result = null;

        try {

            conn = MyConnection.getMyConnection();
            if (conn != null) {
                String sql = "Select LicensePlate, Brand, Color, AmountOfSeat, Price, State from car";
                preStm = conn.prepareStatement(sql);
                rs = preStm.executeQuery();
                result = new ArrayList<>();
                while (rs.next()) {
                    String liencePlate = rs.getString("LicensePlate");
                    String brand = rs.getString("Brand");
                    String color = rs.getString("Color");
                    int amountOfSeat = rs.getInt("AmountOfSeat");
                    float price = rs.getFloat("Price");
                    String state = rs.getString("State");
                    if (state.equalsIgnoreCase("Free") == true) {
                        CarDTO dto = new CarDTO(liencePlate, brand, color, amountOfSeat, price, state);
                        result.add(dto);
                    }
                }
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    //load car fo manager car
    public List<CarDTO> loadCarManager() throws Exception {
        List<CarDTO> result = null;

        try {

            conn = MyConnection.getMyConnection();
            if (conn != null) {
                String sql = "Select LicensePlate, Brand, Color, AmountOfSeat, Price, State from car";
                preStm = conn.prepareStatement(sql);
                rs = preStm.executeQuery();
                result = new ArrayList<>();
                while (rs.next()) {
                    String liencePlate = rs.getString("LicensePlate");
                    String brand = rs.getString("Brand");
                    String color = rs.getString("Color");
                    int amountOfSeat = rs.getInt("AmountOfSeat");
                    float price = rs.getFloat("Price");
                    String state = rs.getString("State");
                    CarDTO dto = new CarDTO(liencePlate, brand, color, amountOfSeat, price, state);
                    result.add(dto);
                }
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public CarDTO loadCarsByLicensePlate(String LicensePlate) throws Exception {
        CarDTO dto = null;

        try {
            conn = MyConnection.getMyConnection();
            if (conn != null) {
                String sql = "Select LicensePlate, Brand, Color, AmountOfSeat, Price, State from car where LicensePlate = ?";
                preStm = conn.prepareStatement(sql);
                preStm.setString(1, LicensePlate);
                rs = preStm.executeQuery();
                if (rs.next()) {
                    String liencePlate = rs.getString("LicensePlate");
                    String brand = rs.getString("Brand");
                    String color = rs.getString("Color");
                    int amountOfSeat = rs.getInt("AmountOfSeat");
                    float price = rs.getFloat("Price");
                    String state = rs.getString("State");
                    dto = new CarDTO(liencePlate, brand, color, amountOfSeat, price, state);
                }
            }

        } finally {
            closeConnection();
        }
        return dto;
    }

    public boolean update(CarDTO dto) throws Exception {
        boolean check = false;
        int i = 0;
        try {
            String sql = "Update car set Brand = ?, Color = ?, AmountOfSeat = ?, Price = ?, State = ? Where LicensePlate = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getBrand());
            preStm.setString(2, dto.getColor());
            preStm.setInt(3, dto.getAmountOfSeat());
            preStm.setFloat(4, dto.getPrice());
            preStm.setString(5, dto.getState());
            preStm.setString(6, dto.getLicensePlate());
            i = preStm.executeUpdate();
            if (i > 0) {
                check = true;
            }
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean addCar(CarDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "Insert into Car(LicensePlate, Brand, Color, AmountOfSeat, Price, State) values(?,?,?,?,?,?)";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getLicensePlate());
            preStm.setString(2, dto.getBrand());
            preStm.setString(3, dto.getColor());
            preStm.setInt(4, dto.getAmountOfSeat());
            preStm.setFloat(5, dto.getPrice());
            preStm.setString(6, dto.getState());
            preStm.executeUpdate();
            check = true;
        } finally {
            closeConnection();
        }
        return check;

    }

    public boolean delete(String lice) throws Exception {
        boolean check = false;
        try {
            String sql = "Delete From Car Where LicensePlate = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, lice);//set id for start delete
            check = preStm.executeUpdate() > 0;
            check = true;
        } finally {
            closeConnection();
        }
        return check;

    }

    public boolean returnCar(CarDTO dto) throws Exception {
        boolean check = false;
        int i;
        try {
            String sql = "Update car set State = ? where LicensePlate = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getState());
            preStm.setString(2, dto.getLicensePlate());

            i = preStm.executeUpdate();
            if (i > 0) {
                check = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return check;
    }

    public List<CarDTO> findByLikeSeat(int search) throws Exception {
        List<CarDTO> result = null;
        String lice = null;
        String brand = null;
        String color = null;
        int seat = 0;
        float price = 0;
        String state = null;
        CarDTO dto = null;
        try {
            conn = MyConnection.getMyConnection();
            if (conn != null) {
                String sql = "Select LicensePlate, Brand, Color, AmountOfSeat, Price, State From car Where AmountOfSeat LIKE ?";
                preStm = conn.prepareStatement(sql);
                preStm.setInt(1, search);
                rs = preStm.executeQuery();
                result = new ArrayList<>();
                while (rs.next()) {
                    seat = rs.getInt("AmountOfSeat");
                    lice = rs.getString("LicensePlate");
                    brand = rs.getString("Brand");
                    color = rs.getString("Color");
                    price = rs.getFloat("Price");
                    state = rs.getString("State");
                    if (state.equalsIgnoreCase("Free") == true) {
                        dto = new CarDTO(state, brand, color, seat, price, state);
                        result.add(dto);
                    }

                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }
}
