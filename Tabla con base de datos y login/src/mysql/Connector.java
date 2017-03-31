/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql;

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

    private static Connection con;

    public Connector() {

    }

    public static ResultSet getData(String query) {
        ResultSet rs = null;
        try {
            connect();
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/escuela", "root", "");
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
        } catch (Exception e) {
            System.out.println(":V");
        }
        return rs;
    }

    public static void executeQuery(String query) {
        try {
            connect();
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/escuela", "root", "");
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);
            System.out.println("Exito :v");
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
            if (e.getErrorCode() == 1062) {
                JOptionPane.showMessageDialog(null, "Ese correo ya esta registrado", "error", 0);
            } else {
                JOptionPane.showMessageDialog(null, "A ocurrido un error " + e, "error", 0);
            }
        }
    }

    public static void connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
        }
    }

    public static void close() throws SQLException {
        con.close();
    }

}
