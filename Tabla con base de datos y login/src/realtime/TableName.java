/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package realtime;

import static config.Config.userId;
import static controllers.TableList.LIST_MODEL;
import static controllers.TableList.card;
import static controllers.TableList.groupList;
import static controllers.TableList.groupName;
import static controllers.TableList.grupo;
import static controllers.TableList.numeroAlumnos;
import java.sql.*;
import java.util.logging.*;
import models.*;
import objects.*;

/**
 *
 * @author Luis G
 */
public class TableName implements Runnable {

    public Thread thread;
    private final GroupsModel GROUPS_MODEL;

    public TableName() {
        thread = new Thread(this);
        GROUPS_MODEL = new GroupsModel();
    }

    @Override
    public void run() {
        if (LIST_MODEL.getSize() > 0) {
            while (true) {
                GROUPS_MODEL.getGroups(userId, (rs, i) -> {
                    Grupo grupo = LIST_MODEL.getElementAt(i);
                    try {
                        grupo.setId(rs.getInt("id"));
                        grupo.setNombre(rs.getString("nombre"));
                    } catch (SQLException ex) {
                        Logger.getLogger(controllers.TableList.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
                if (card.isVisible()) {
                    GROUPS_MODEL.getGroupInfo(groupList.getSelectedValue().getId(), (rs, i) -> {
                        try {
                            grupo = rs.getString("nombre");
                            groupName.setText("Nombre del grupo: " + grupo);
                            numeroAlumnos.setText("Número de alumnos: " + rs.getInt("count"));
                        } catch (SQLException ex) {
                            Logger.getLogger(controllers.TableList.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    });
                }
                groupList.setCellRenderer(new cellsrenderer.GrupoCellRenderer());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(TableName.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
