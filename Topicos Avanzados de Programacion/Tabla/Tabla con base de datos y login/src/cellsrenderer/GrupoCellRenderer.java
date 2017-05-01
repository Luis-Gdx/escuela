/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cellsrenderer;

import static config.Config.DEFAULT_PRESSED;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.border.EmptyBorder;
import objects.Grupo;

/**
 *
 * @author Luis G
 */
public class GrupoCellRenderer extends JLabel implements ListCellRenderer<Grupo> {

    public GrupoCellRenderer() {
        setOpaque(true);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends Grupo> list, Grupo grupo, int index, boolean isSelected, boolean cellHasFocus) {
        setText("<html> <div style='margin: 5px'>" + grupo.getNombre() + "</html>");
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
            background = DEFAULT_PRESSED;
            foreground = Color.WHITE;

            // unselected, and not the DnD drop location
        } else {
            background = Color.WHITE;
            foreground = Color.BLACK;
        };
        this.setFont(new Font("Arial", 12, 12));
        setBackground(background);
        setForeground(foreground);
        return this;
    }
}
