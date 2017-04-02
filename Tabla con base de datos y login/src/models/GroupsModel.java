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
        return this.getData("SELECT grupo.nombre FROM grupo WHERE grupo.usuarios_id = " + id);
    }

    public void insertGroup(String nombre, int id) {
        this.executeQuery("INSERT INTO grupo (nombre, usuarios_id) VALUES ('" + nombre + "', " + id + ")");
    }

}
