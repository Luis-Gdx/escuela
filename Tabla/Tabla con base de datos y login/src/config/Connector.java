/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import interfaces.*;
import java.sql.*;
import java.util.logging.*;
import javax.swing.*;

/**
 *
 * @author Luis G
 */
public class Connector {

    public Connector() {

    }

    protected boolean getData(String query, Callback callback) {
        ResultSet rs = null;
        Connection conn = null;
        Statement stmt = null;
        boolean isNull = false;
        try {
            connect();
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/escuela", "root", "");
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            for (int i = 0; rs.next(); i++) {
                callback.callback(rs, i);
            }
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isNull;
    }

    protected ResultSet getData(String query) {
        ResultSet rs = null;
        Connection conn = null;
        Statement stmt = null;
        try {
            connect();
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/escuela", "root", "");
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e);
        }
        return rs;
    }

    protected int executeQuery(String query) {
        int id = -1;
        try {
            connect();
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/escuela", "root", "");
            Statement stmt = conn.createStatement();
            id = stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            }
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, e);
            switch (e.getErrorCode()) {
                case 1062:
                    JOptionPane.showMessageDialog(null, "Ese correo ya esta registrado", "error", 0);
                    break;
                case 1054:
                    JOptionPane.showMessageDialog(null, "El registro no existe", "error", 0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "A ocurrido un error " + e, "error", 0);
                    System.out.println(e);
                    break;
            }
        }
        return id;
    }

    private void connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
        }
    }

}
