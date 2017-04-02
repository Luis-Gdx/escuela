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
public class AlumnosModel extends Connector {

    public AlumnosModel() {

    }

    public ResultSet getAlumnos() {
        return getData("SELECT * FROM alumnos");
    }

    public void insertAlumno(String nombre, String apellidoPaterno, String apellidoMaterno, String sexo, int edad, String direccion, String telefono, String correo) {
        executeQuery("INSERT INTO alumnos (nombre, apellido_paterno,"
                + " apellido_materno, sexo, edad, direccion, telefono, correo)"
                + " VALUES ('" + nombre + "', '" + apellidoPaterno + "', '"
                + apellidoMaterno + "', '" + sexo + "', '"
                + edad + "', '" + direccion + "', '" + telefono + "', '" + correo + "')");
    }

    public void deleteById(int id) {
        executeQuery("DELETE FROM alumnos WHERE id = " + id);
    }

    public void deleteAll() {
        executeQuery("TRUNCATE alumnos");
    }

}
