/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package realtime;

import config.UserCellRenderer;
import static controllers.AdminDashboard.LIST_MODEL;
import static controllers.AdminDashboard.userCellRender;
import static controllers.AdminDashboard.userList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.UsersModel;

/**
 *
 * @author Luis G
 */
public class Online implements Runnable {

    public Thread thread;
    private final UsersModel USERS_MODEL;
    private ResultSet user;
    private boolean online = false;

    public Online() {
        thread = new Thread(this);
        USERS_MODEL = new UsersModel();
    }

    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < LIST_MODEL.getSize(); i++) {
                user = USERS_MODEL.getOnline(LIST_MODEL.getElementAt(i).getId());
                try {
                    while (user.next()) {
                        LIST_MODEL.getElementAt(i).setOnline(user.getBoolean("online"));
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Online.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            userList.setCellRenderer(new UserCellRenderer());
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Online.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
