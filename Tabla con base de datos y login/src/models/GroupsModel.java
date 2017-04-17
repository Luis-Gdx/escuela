/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import config.Connector;
import interfaces.Callback;
import java.sql.ResultSet;

/**
 *
 * @author Luis G
 */
public class GroupsModel extends Connector {

    public ResultSet getGroups(int id, Callback callback) {
        return getData("SELECT grupo.id, grupo.nombre FROM grupo INNER JOIN permisos ON permisos.grupo_id = grupo.id WHERE permisos.usuarios_id = " + id, callback);
    }

    public int insertGroup(String nombre) {
        return this.executeQuery("INSERT INTO grupo (nombre) VALUES ('" + nombre + "')");
    }

    public int deleteGroupById(int id) {
        return executeQuery("DELETE FROM grupo WHERE grupo.id = " + id);
    }

    public ResultSet getGroupInfo(int id, Callback callback) {
        return getData("SELECT grupo.nombre, Count(alumnos.id) AS count FROM grupo INNER JOIN alumnos ON grupo.id = alumnos.grupo_id WHERE grupo.id = " + id, callback);
    }

    public ResultSet getUsersInGroup(int id) {
        return getData("SELECT Count(usuarios.id) AS count FROM usuarios INNER JOIN permisos ON usuarios.id = permisos.usuarios_id WHERE permisos.grupo_id = " + id);
    }

    public int updateGroupName(String nombre, int id) {
        return executeQuery("UPDATE grupo SET nombre = '" + nombre + "' WHERE grupo.id = " + id);
    }

}
