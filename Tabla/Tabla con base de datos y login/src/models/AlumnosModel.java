/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import config.Connector;
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

    public ResultSet getAlumnoById(int id, int grupoId) {
        return getData("SELECT * FROM alumnos WHERE id = " + id + " AND grupo_id = " + grupoId);
    }

    public int insertAlumno(String nombre, String apellidoPaterno,
            String apellidoMaterno, String sexo, int edad, String direccion,
            String telefono, String correo, int grupo_id) {
        return executeQuery("INSERT INTO alumnos (nombre, apellido_paterno,"
                + " apellido_materno, sexo, edad, direccion, telefono, correo, grupo_id)"
                + " VALUES ('" + nombre + "', '" + apellidoPaterno + "', '"
                + apellidoMaterno + "', '" + sexo + "', '"
                + edad + "', '" + direccion + "', '" + telefono + "', '"
                + correo + "', '" + grupo_id + "')");
    }

    public int deleteById(int groupId, int id) {
        return executeQuery("DELETE FROM alumnos WHERE alumnos.grupo_id = " + groupId + " AND alumnos.id = " + id);
    }

    public int deleteAllById(int id) {
        return executeQuery("DELETE FROM alumnos WHERE alumnos.grupo_id = " + id);
    }

    public ResultSet getAlumnosByGroup(int id) {
        return getData("SELECT * FROM alumnos WHERE grupo_id = " + id);
    }

    public int updateAlumno(String nombre, String apellidoPaterno,
            String apellidoMaterno, String sexo, int edad, String direccion,
            String telefono, String correo, int grupo_id, int id) {
        return executeQuery("UPDATE alumnos SET nombre = '" + nombre
                + "', apellido_paterno = '" + apellidoPaterno + "',"
                + " apellido_materno = '" + apellidoMaterno + "', sexo = '" + sexo
                + "', edad = '" + edad + "' , direccion = '" + direccion
                + "', telefono = '" + telefono + "', correo = '" + correo + "' WHERE id = " + id);
    }

}
