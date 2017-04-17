/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package realtime;

import cellsrenderer.GrupoCellRenderer;
import static config.Config.ALERT;
import static config.Config.DANGER;
import static config.Config.DEFAULT;
import static config.Config.SECONDARY;
import static config.Config.userId;
import static controllers.TableList.*;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.GroupsModel;
import models.UsersModel;
import objects.Grupo;

/**
 *
 * @author Luis G
 */
public class Permisos implements Runnable {

    public Thread thread;
    private final GroupsModel GROUPS_MODEL;
    private final UsersModel USERS_MODEL;

    public Permisos() {
        thread = new Thread(this);
        GROUPS_MODEL = new GroupsModel();
        USERS_MODEL = new UsersModel();
    }

    @Override
    public void run() {
        while (true) {
            GROUPS_MODEL.getGroups(userId, (rs, i) -> {
                try {
                    Grupo grupo = LIST_MODEL.getElementAt(i);
                    grupo.setNombre(rs.getString("nombre"));
                    grupo.setId(rs.getInt("id"));
                } catch (SQLException ex) {
                    Logger.getLogger(Online.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            groupList.setCellRenderer(new GrupoCellRenderer());

            if (card.isVisible()) {
                getSelectedItemData();
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Permisos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void getSelectedItemData() {
        boolean isNull = true;
        try {
            GROUPS_MODEL.getGroupInfo(groupList.getSelectedValue().getId(), (rs, i) -> {
                try {
                    grupo = rs.getString("nombre");
                    groupName.setText("Nombre del grupo: " + grupo);
                    numeroAlumnos.setText("Número de alumnos: " + rs.getInt("count"));
                } catch (SQLException ex) {
                    Logger.getLogger(Permisos.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            //isNull = false;
            ResultSet groupInfo2 = GROUPS_MODEL.getUsersInGroup(groupList.getSelectedValue().getId());
            while (groupInfo2.next()) {
                numeroUsuarios.setText("Número de usuarios: " + groupInfo2.getInt("count"));
                isNull = false;
            }
            ResultSet userInfo = USERS_MODEL.getPermisosByTable(groupList.getSelectedValue().getId(), userId);
            while (userInfo.next()) {
                if (userInfo.getBoolean("admin")) {
                    type.setText("Tipo de usuario: Admin");
                    administrar.setBackground(SECONDARY);
                    administrar.setVisible(true);
                } else {
                    type.setText("Tipo de usuario: Estandar");
                    administrar.setVisible(false);
                }
                c.setForeground(userInfo.getBoolean("create") ? DEFAULT : Color.GRAY);
                r.setForeground(userInfo.getBoolean("read") ? ALERT : Color.GRAY);
                u.setForeground(userInfo.getBoolean("update") ? SECONDARY : Color.GRAY);
                d.setForeground(userInfo.getBoolean("delete") ? DANGER : Color.GRAY);
            }
            if (isNull) {
                groupName.setText("Nombre del grupo: " + groupList.getSelectedValue().getNombre());
                numeroAlumnos.setText("Número de alumnos: 0");
            }
            card.setVisible(true);
        } catch (Throwable ex) {
            //Logger.getLogger(TableList.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
    }
}
