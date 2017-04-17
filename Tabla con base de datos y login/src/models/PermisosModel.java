/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import config.Connector;

/**
 *
 * @author Luis G
 */
public class PermisosModel extends Connector {

    public int insertPermisos(int userId, int grupoId, boolean admin, boolean create, boolean read, boolean update, boolean delete) {
        return this.executeQuery("INSERT INTO permisos (admin, `create`, `read`, `update`, `delete`, usuarios_id, grupo_id) VALUES (" + admin + ", " + create + ", " + read + ", " + update + ", " + delete + ", " + userId + ", " + grupoId + ")");
    }

    public int updatePermisos(boolean admin, boolean create, boolean read, boolean update, boolean delete, int id) {
        return executeQuery("UPDATE permisos SET admin = " + admin + ", `create` = " + create + ", `read` = " + read + ", `update` = " + update + ", `delete` = " + delete + " WHERE id = " + id);
    }

    public int deletePermisoById(int id) {
        return executeQuery("DELETE FROM permisos WHERE permisos.id = " + id);
    }

    public int deletePermisoByGrupo(int id) {
        return executeQuery("DELETE FROM permisos WHERE permisos.grupo_id = " + id);
    }
}
