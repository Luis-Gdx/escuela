/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luis G
 */
public class ConnectionTest {

    private void connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
        }
    }

    public void getData(String query, Callback callback) {
        Map<String, Object> map;
        map = new HashMap();
        ResultSet rs = null;
        Connection conn = null;
        Statement stmt = null;
        try {
            connect();
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/escuela", "root", "");
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                callback.callback(rs);
            }
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {

        ConnectionTest conn = new ConnectionTest();
        Map<String, String> cells = new HashMap<String, String>();
        Stack<User> stack = new Stack();
        cells.put("id", "int");
        cells.put("user", "String");
        cells.put("email", "String");
        conn.getData("SELECT * FROM usuarios", (rs) -> {
            try {
                stack.add(new User(rs.getInt("id"), rs.getString("user"), rs.getString("email")));
            } catch (SQLException ex) {
                System.out.println(":v");
                Logger.getLogger(ConnectionTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        System.out.println(stack.get(0).getNombre());
        System.out.println(stack.get(1).getNombre());
        System.out.println(stack.get(2).getNombre());
    }

    public void c(String k, String v) {
        System.out.println(":v");
    }

    interface Callback {

        public void callback(ResultSet rs);

    }

}

class User {

    int id;
    String nombre, correo;

    public User(int id, String nombre, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

}
