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
public class NotificacionesModel extends Connector {

    public ResultSet getNotifications(String destinatario) {
        return this.getData("SELECT DISTINCT notificaciones.mensaje, notificaciones.`status`, notificaciones.remitente notificaciones.destinatario, notificaciones.usuarios_id FROM usuarios, notificaciones WHERE notificaciones.destinatario = '" + destinatario + "' AND notificaciones.`status` = false");
    }

    public int sendNotification(String mensaje, String remitente, String destinatario, int id, int grupo_id) {
        return this.executeQuery("INSERT INTO notificaciones (mensaje, status, remitente, destinatario, usuarios_id, grupo_id) VALUES ('" + mensaje + "', false, '" + remitente + "', '" + destinatario + "', " + id + ", " + grupo_id + ")");
    }

    public int deleteNotification(int id) {
        return executeQuery("DELETE FROM notificaciones WHERE id = " + id);
    }

}
