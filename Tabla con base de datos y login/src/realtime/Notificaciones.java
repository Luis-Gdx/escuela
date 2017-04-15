/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package realtime;

import static config.Config.correo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.NotificacionesModel;

/**
 *
 * @author lg269
 */
public class Notificaciones implements Runnable {

    public Thread thread;
    private final NotificacionesModel NOTIFICACIONES_MODEL;

    public Notificaciones() {
        thread = new Thread(this);
        NOTIFICACIONES_MODEL = new NotificacionesModel();
    }

    @Override
    public void run() {
        while (true) {
            ResultSet notificaciones = NOTIFICACIONES_MODEL.getNotifications(correo);
            try {
                while (notificaciones.next()) {
                    System.out.println("Mensaje: " + notificaciones.getString("mensaje"));
                    System.out.println("Status: " + notificaciones.getInt("status"));
                    System.out.println("De: " + notificaciones.getString("remitente"));
                    System.out.println("Para: " + notificaciones.getString("destinataro"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(Notificaciones.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Notificaciones.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
