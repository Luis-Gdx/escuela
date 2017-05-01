/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package global;

import static config.Config.BACKGROUND;
import panels.AlbumPanel;
import panels.ArtistPanel;
import panels.TrackPanel;

/**
 *
 * @author Luis G
 */
public class ItemsController {

    private static ArtistPanel currentArtistJPanel = null;
    private static AlbumPanel currentAlbumJPanel = null;
    private static TrackPanel currentTrackJPanel = null;

    public static void setCurrentArtistPanel(ArtistPanel panel) {
        if (currentArtistJPanel != null) {
            if (currentArtistJPanel != panel) {
                currentArtistJPanel.setBackgroundToPanels(BACKGROUND);
                currentArtistJPanel = panel;
            }
        } else {
            currentArtistJPanel = panel;
        }
    }

    public static void setCurrentAlbumPanel(AlbumPanel panel) {
        if (currentAlbumJPanel != null) {
            if (currentAlbumJPanel != panel) {
                currentAlbumJPanel.setBackgroundToPanels(BACKGROUND);
                currentAlbumJPanel = panel;
            }
        } else {
            currentAlbumJPanel = panel;
        }
    }

    public static void setCurrentTrackPanel(TrackPanel panel) {
        if (currentTrackJPanel != null) {
            if (currentTrackJPanel != panel) {
                currentTrackJPanel.setBackgroundToPanels(BACKGROUND);
                currentTrackJPanel = panel;
            }
        } else {
            currentTrackJPanel = panel;
        }
    }

}
