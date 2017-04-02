/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.ResultSet;
import security.BCrypt;

/**
 *
 * @author Luis G
 */
public class UsersModel extends Connector {

    public ResultSet getUserByEmail(String email) {
        return getData("SELECT  * FROM usuarios WHERE email = '" + email + "'");
    }

    public int insertUser(String user, String email, String password) {
        return executeQuery("INSERT INTO usuarios (user, email, password) VALUES ('"
                + user + "', '" + email.toLowerCase() + "', '"
                + BCrypt.hashpw(password, BCrypt.gensalt()) + "')");
    }

    public ResultSet getUserId(String correo) {
        return getData("SELECT id FROM usuarios WHERE email = '" + correo + "'");
    }
}
