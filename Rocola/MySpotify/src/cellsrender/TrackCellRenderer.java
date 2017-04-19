/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cellsrender;

import java.awt.Color;
import java.awt.Component;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import objects.Track;

/**
 *
 * @author Luis G
 */
public class TrackCellRenderer extends JLabel implements ListCellRenderer<Track> {

    private final int SIZE = 150;

    public TrackCellRenderer() {
        setOpaque(true);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends Track> list, Track track, int index, boolean isSelected, boolean cellHasFocus) {
        String duracion = Double.toString(track.getDuration());
        try {
            duracion = Double.toString(track.getDuration()).substring(0, Double.toString(track.getDuration()).indexOf(".") + 3);
        } catch (Exception e) {

        }
        setText("<html><head><style>li{list-style-type: none}</style></head><body><ul><li><strong><span style='font-size: 11px'>" + track.getName() + "</span></strong></li><li><span style='font-size: 8.75px'><strong>Artista: </strong>" + track.getArtists().get(0).getName() + "</span></li><li><span style='font-size: 8.75px'><strong>Album: </strong>" + track.getAlbum().getName() + "</span></li><li><span style='font-size: 8.75px'><strong>Duración: </strong>" + duracion + "</span></li>" + (track.isExplicit() ? "<li><span style='font-size: 8.75px'><strong>EXPLÍCITO</strong></span></li>" : "") + "<li><span style='font-size: 8.75px'><strong>EXPLÍCITO</strong></span></li><li><span style='font-size: 8.75px'><strong>Popularidad: </strong>" + track.getPopularity() + "</span></li><li><span style='font-size: 8.75px'><strong>Numero de canción</strong>" + track.getTrackNumber() + "</span></li></ul></body></html>");
        if (!track.getAlbum().getImages().isEmpty()) {
            try {
                setIcon(new ImageIcon(new ImageIcon((new URL(track.getAlbum().getImages().get(track.getAlbum().getImages().size() - 3)))).getImage().getScaledInstance(SIZE, SIZE, java.awt.Image.SCALE_AREA_AVERAGING)));
            } catch (MalformedURLException ex) {
                Logger.getLogger(ArtistCellRenderer.class.getName()).log(Level.SEVERE, null, ex);
                try {
                    setIcon(new ImageIcon(new ImageIcon((new URL(track.getAlbum().getImages().get(track.getAlbum().getImages().size() - 2)))).getImage().getScaledInstance(SIZE, SIZE, java.awt.Image.SCALE_AREA_AVERAGING)));
                } catch (MalformedURLException ex1) {
                    Logger.getLogger(TrackCellRenderer.class.getName()).log(Level.SEVERE, null, ex1);
                    try {
                        setIcon(new ImageIcon(new ImageIcon((new URL(track.getAlbum().getImages().get(track.getAlbum().getImages().size() - 1)))).getImage().getScaledInstance(SIZE, SIZE, java.awt.Image.SCALE_AREA_AVERAGING)));
                    } catch (MalformedURLException ex2) {
                        Logger.getLogger(TrackCellRenderer.class.getName()).log(Level.SEVERE, null, ex2);
                    }
                }
            }
        } else {
            try {
                setIcon(new ImageIcon(new ImageIcon((new URL("https://cdn.browshot.com/static/images/not-found.png"))).getImage().getScaledInstance(SIZE, SIZE, java.awt.Image.SCALE_AREA_AVERAGING)));
            } catch (MalformedURLException ex) {
                Logger.getLogger(ArtistCellRenderer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.setBackground(new Color(238, 238, 238));
        return this;
    }

}
