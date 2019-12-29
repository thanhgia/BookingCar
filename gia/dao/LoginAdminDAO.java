/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gia.dao;

import gia.dto.LoginAdmin;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Administrator
 */
public class LoginAdminDAO implements Serializable {

    Connection conn;
    PreparedStatement preStm;
    ResultSet rs;

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

    public boolean checkData(String admin, String pass) throws Exception {
        boolean result = false;
        try {
            String sql = "Select Admin, Password from Login";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            while (rs.next()) {
                if (admin.equals("" + rs.getString(1))) {
                    if (pass.equals("" + rs.getString(2))) {
                        result = true;
                    }
                }

            }

        } finally {
            closeConnection();
        }
        return result;
    }
}
