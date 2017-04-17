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
public class NotificacionesModel extends Connector {

    public int sendNotification(String mensaje, String remitente, String destinatario, int id, int grupo_id) {
        return this.executeQuery("INSERT INTO notificaciones (mensaje, status, remitente, destinatario, usuarios_id, grupo_id) VALUES ('" + mensaje + "', false, '" + remitente + "', '" + destinatario + "', " + id + ", " + grupo_id + ")");
    }

    public ResultSet getAllNotifications(String destinatario, Callback callback) {
        return getData("SELECT * FROM notificaciones WHERE destinatario = '" + destinatario + "'", callback);
    }

    public ResultSet getNotifications(String destinatario, Callback callback) {
        return this.getData("SELECT notificaciones.id, notificaciones.mensaje, notificaciones.`status`, notificaciones.remitente, notificaciones.destinatario, notificaciones.usuarios_id, notificaciones.grupo_id FROM notificaciones WHERE notificaciones.destinatario = '" + destinatario + "' AND notificaciones.`status` = 0", callback);
    }

    public ResultSet getNotificationsCount(String destinatario, Callback callback) {
        return this.getData("SELECT Count(notificaciones.id) AS count FROM notificaciones WHERE notificaciones.destinatario = '" + destinatario + "'", callback);
    }

    public int updateNotification(int id) {
        return executeQuery("UPDATE notificaciones SET status = 1");
    }

    public int deleteNotification(int id) {
        return executeQuery("DELETE FROM notificaciones WHERE id = " + id);
    }

    public int deleteNotificationByGrupo(int id) {
        return executeQuery("DELETE FROM notificaciones WHERE grupo_id = " + id);
    }
}
