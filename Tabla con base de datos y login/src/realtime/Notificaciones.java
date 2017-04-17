/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package realtime;

import static config.Config.*;
import static controllers.TableList.notificationsCountLabel;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.NotificacionesModel;
import models.PermisosModel;
import objects.Notification;

/**
 *
 * @author lg269
 */
public class Notificaciones implements Runnable {

    public Thread thread;
    private final NotificacionesModel NOTIFICACIONES_MODEL;
    private final PermisosModel PERMISOS_MODEL;
    private final Object[] BOTONES = {"Si", "No", "Posponer :v"};

    public Notificaciones() {
        thread = new Thread(this);
        NOTIFICACIONES_MODEL = new NotificacionesModel();
        PERMISOS_MODEL = new PermisosModel();
    }

    @Override
    public void run() {
        while (true) {
            NOTIFICACIONES_MODEL.getNotificationsCount(correo, (rs) -> {
                try {
                    notificationsCountLabel.setText(rs.getInt("count") + "");
                    notifications = new Notification[rs.getInt("count")];
                } catch (SQLException ex) {
                    Logger.getLogger(Notificaciones.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            NOTIFICACIONES_MODEL.getNotifications(correo, (rs) -> {
                try {
                    switch (JOptionPane.showOptionDialog(null, rs.getString("mensaje"), "Mensaje de: " + rs.getString("remitente"), 0, 0, null, BOTONES, BOTONES[0])) {
                        case 0: //si
                            PERMISOS_MODEL.insertPermisos(userId, rs.getInt("grupo_id"));
                            NOTIFICACIONES_MODEL.deleteNotification(rs.getInt("id"));
                            break;
                        case 1: //no
                            NOTIFICACIONES_MODEL.deleteNotification(rs.getInt("id"));
                            break;
                        default:
                            NOTIFICACIONES_MODEL.updateNotification(rs.getInt("id"));
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Notificaciones.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            NOTIFICACIONES_MODEL.getAllNotifications(correo, (rs) -> {
                try {
                    for (int i = 0; i < notifications.length; i++) {
                        notifications[i] = new Notification(rs.getInt("id"), rs.getInt("status"), rs.getInt("usuarios_id"), rs.getInt("grupo_id"), rs.getString("mensaje"), rs.getString("remitente"), rs.getString("destinatario"));
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Notificaciones.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Notificaciones.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
