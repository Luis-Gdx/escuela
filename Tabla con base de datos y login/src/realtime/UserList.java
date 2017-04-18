/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package realtime;

import cellsrenderer.*;
import static config.Config.userId;
import controllers.*;
import static controllers.AdminDashboard.listModel;
import static controllers.AdminDashboard.tableId;
import static controllers.AdminDashboard.userList;
import java.sql.*;
import java.util.logging.*;
import models.*;
import objects.*;

/**
 *
 * @author Luis G
 */
public class UserList implements Runnable {

    public Thread thread;
    private final UsersModel USERS_MODEL;
    private ResultSet user;
    private boolean online = false;

    public UserList() {
        thread = new Thread(this);
        thread.setName("Online");
        USERS_MODEL = new UsersModel();
    }

    @Override
    public void run() {
        while (true) {
            USERS_MODEL.getUserByTable(tableId, userId, (rs, i) -> {
                for (int j = 0; j < listModel.size(); j++) {
                    User user = listModel.getElementAt(j);
                    try {
                        if (user.getId() == rs.getInt("id")) {
                            user.setId(rs.getInt("id"));
                            user.setNombre(rs.getString("user"));
                            user.setPermisoId(rs.getInt("permisoId"));
                            user.setEmail(rs.getString("email"));
                            user.setAdmin(rs.getBoolean("admin"));
                            user.setC(rs.getBoolean("create"));
                            user.setR(rs.getBoolean("read"));
                            user.setU(rs.getBoolean("update"));
                            user.setD(rs.getBoolean("delete"));
                            user.setOnline(rs.getBoolean("online"));
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(AdminDashboard.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            userList.setCellRenderer(new UserCellRenderer());
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(UserList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
