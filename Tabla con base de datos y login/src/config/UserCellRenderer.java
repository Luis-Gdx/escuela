/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import static config.Config.DEFAULT_PRESSED;
import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Luis G
 */
public class UserCellRenderer extends JLabel implements ListCellRenderer<User> {

    //Online online;
    public UserCellRenderer() {
        /*online = new Online();
        online.thread.start();*/
        setOpaque(true);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends User> list, User user, int index, boolean isSelected, boolean cellHasFocus) {
        setText(user.getNombre());
        if (user.getPermisoId() != -1) {
            if (user.isOnline()) {
                this.setIcon(new ImageIcon(getClass().getResource("/images/online.png")));
            } else {
                this.setIcon(new ImageIcon(getClass().getResource("/images/offline.png")));
            }
        } else {
            this.setIcon(null);
        }
        this.setBorder(new EmptyBorder(0, 7, 0, 0));
        Color background;
        Color foreground;

        // check if this cell represents the current DnD drop location
        JList.DropLocation dropLocation = list.getDropLocation();
        if (dropLocation != null
                && !dropLocation.isInsert()
                && dropLocation.getIndex() == index) {

            background = Color.BLUE;
            foreground = Color.WHITE;

            // check if this cell is selected
        } else if (isSelected) {
            if (user.getPermisoId() != -1) {
                background = DEFAULT_PRESSED;
                foreground = Color.WHITE;
            } else {
                background = Color.gray;
                foreground = Color.WHITE;
            }

            // unselected, and not the DnD drop location
        } else if (user.getPermisoId() != -1) {
            background = Color.WHITE;
            foreground = Color.BLACK;
        } else {
            background = Color.lightGray;
            foreground = Color.BLACK;
        };
        this.setFont(new Font("Arial", 12, 12));
        setBackground(background);
        setForeground(foreground);
        return this;
    }
}
