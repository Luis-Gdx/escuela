/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.ResultSet;

/**
 *
 * @author Luis G
 */
public class GroupsModel extends Connector {

    public ResultSet getGroups(int id) {
        return this.getData("SELECT grupo.id, grupo.nombre FROM grupo WHERE grupo.usuarios_id = " + id);
    }

    public int insertGroup(String nombre, int id) {
        return this.executeQuery("INSERT INTO grupo (nombre, usuarios_id) VALUES ('" + nombre + "', " + id + ")");
    }

    public int deleteGroupById(int id) {
        return executeQuery("DELETE FROM grupo WHERE grupo.id = " + id);
    }

    public ResultSet getGroupInfo(int id) {
        return getData("SELECT grupo.nombre, Count(alumnos.id) AS count FROM grupo INNER JOIN alumnos ON grupo.id = alumnos.grupo_id WHERE grupo.id = " + id + " GROUP BY grupo.nombre");
    }

    public int updateGroupName(String nombre, int id) {
        return executeQuery("UPDATE grupo SET nombre = '" + nombre + "' WHERE grupo.id = " + id);
    }

}
