/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package global;

import java.awt.Color;
import panels.TrackPanel;

/**
 *
 * @author Luis G
 */
public class ItemsController {

    private static TrackPanel currentJPanel = null;

    public static void setCurrentTrackPanel(TrackPanel panel) {
        if (currentJPanel != null) {
            if (currentJPanel != panel) {
                currentJPanel.setBackgroundToPanels(new Color(238, 238, 238));
                currentJPanel = panel;
            }
        } else {
            currentJPanel = panel;
        }
    }

}
