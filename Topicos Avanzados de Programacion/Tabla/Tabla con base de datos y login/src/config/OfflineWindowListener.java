/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import static config.Config.userId;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import models.UsersModel;

/**
 *
 * @author Luis G
 */
public class OfflineWindowListener implements WindowListener {

    private final UsersModel USERS_MODEL;

    public OfflineWindowListener() {
        this.USERS_MODEL = new UsersModel();
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        USERS_MODEL.updateOnline(false, userId);
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

}
