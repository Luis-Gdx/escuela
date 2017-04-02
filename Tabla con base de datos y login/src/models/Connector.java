/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis G
 */
public class Connector {

    public Connector() {

    }

    protected ResultSet getData(String query) {
        ResultSet rs = null;
        try {
            connect();
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/escuela", "root", "");
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
        } catch (Exception e) {
            System.out.println(":v");
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
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
            if (e.getErrorCode() == 1062) {
                JOptionPane.showMessageDialog(null, "Ese correo ya esta registrado", "error", 0);
            } else if (e.getErrorCode() == 1054) {
                JOptionPane.showMessageDialog(null, "El registro no existe", "error", 0);
            } else {
                JOptionPane.showMessageDialog(null, "A ocurrido un error " + e, "error", 0);
                System.out.println(e);
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
