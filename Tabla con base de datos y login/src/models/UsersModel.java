/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import config.Connector;
import interfaces.Callback;
import java.sql.ResultSet;
import static security.Hash.sha256;

/**
 *
 * @author Luis G
 */
public class UsersModel extends Connector {

    public ResultSet getUserById(int id) {
        return getData("SELECT  id, user, email FROM usuarios WHERE id = " + id);
    }

    public boolean getOnline(int id, Callback callback) {
        return getData("SELECT online FROM usuarios WHERE id = " + id, callback);
    }

    public int updateOnline(boolean online, int id) {
        return executeQuery("UPDATE usuarios SET online = " + online + " WHERE id = " + id);
    }

    public boolean getPendingUsers(int notificationId, Callback callback) {
        return getData("SELECT usuarios.id, usuarios.`user`, usuarios.email, notificaciones.id AS notificacion_id FROM usuarios INNER JOIN notificaciones ON notificaciones.destinatario = usuarios.email WHERE notificaciones.grupo_id = " + notificationId, callback);
    }

    public boolean getUserByTable(int grupoId, int id, Callback callback) {
        return getData("SELECT permisos.id AS permisoId, usuarios.`user`, usuarios.email, permisos.admin, permisos.`create`, permisos.`read`, permisos.`update`, permisos.`delete`, usuarios.id, usuarios.online FROM usuarios INNER JOIN permisos ON permisos.usuarios_id = usuarios.id INNER JOIN grupo ON permisos.grupo_id = grupo.id WHERE usuarios.id <> " + id + " AND permisos.grupo_id = " + grupoId, callback);
    }

    public ResultSet getPermisosByTable(int grupoId, int id) {
        return getData("SELECT permisos.admin, permisos.`create`, permisos.`read`, permisos.`update`, permisos.`delete` FROM permisos INNER JOIN usuarios ON usuarios.id = permisos.usuarios_id WHERE permisos.grupo_id = " + grupoId + " AND usuarios.id = " + id);
    }

    public ResultSet getUserByEmail(String email) {
        return getData("SELECT  * FROM usuarios WHERE email = '" + email + "'");
    }

    public int insertUser(String user, String email, String password) {
        return executeQuery("INSERT INTO usuarios (user, email, password, online) VALUES ('"
                + user + "', '" + email.toLowerCase() + "', '"
                + sha256(password) + "', true)");
    }

    public ResultSet getUserId(String correo) {
        return getData("SELECT id FROM usuarios WHERE email = '" + correo + "'");
    }

}
