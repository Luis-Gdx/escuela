/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cellsrender;

import java.awt.Color;
import java.awt.Component;
import java.util.concurrent.TimeUnit;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import spotifyapiconsole.search.objects.Track;

/**
 *
 * @author Luis G
 */
public class TrackCellRenderer extends JLabel implements ListCellRenderer<Track> {

    public TrackCellRenderer() {
        setOpaque(true);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends Track> list, Track track, int index, boolean isSelected, boolean cellHasFocus) {
        long millis = track.getDuration();
        String duration = String.format("%02d : %02d",
                TimeUnit.MILLISECONDS.toMinutes(millis),
                TimeUnit.MILLISECONDS.toSeconds(millis)
                - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
        /*this.setImage(track.getAlbum().getImages().get(0));
        this.setName(track.getName());
        this.setArtist(track.getArtists().get(0).getName());
        this.setAlbum(track.getAlbum().getName());
        this.setDuration(duration);
        this.setExplicit(track.isExplicit());
        this.setPopularity(track.getPopularity());
        this.setTrackNumber(track.getTrackNumber());
        this.setData();*/
        setText("<html><head><style>li{list-style-type: none}</style></head><body><ul><li><strong><span style='font-size: 11px'>" + track.getName() + "</span></strong></li><li><span style='font-size: 8.75px'><strong>Artista: </strong>" + track.getArtists().get(0).getName() + "</span></li><li><span style='font-size: 8.75px'><strong>Album: </strong>" + track.getAlbum().getName() + "</span></li><li><span style='font-size: 8.75px'><strong>Duración: </strong>" + duration + "</span></li>" + (track.isExplicit() ? "<li><span style='font-size: 8.75px'><strong>EXPLÍCITO</strong></span></li>" : "") + "<li><span style='font-size: 8.75px'><strong>Popularidad: </strong>" + track.getPopularity() + "</span></li><li><span style='font-size: 8.75px'><strong>Numero de canción: </strong>" + track.getTrackNumber() + "</span></li></ul></body></html>");
        setIcon(track.getAlbum().getImages().get(0));
        Color background;
        JList.DropLocation dropLocation = list.getDropLocation();
        if (dropLocation
                != null
                && !dropLocation.isInsert()
                && dropLocation.getIndex() == index) {

            background = new Color(238, 238, 238);

            // check if this cell is selected
        } else if (isSelected) {
            background = new Color(207, 216, 220);

            // unselected, and not the DnD drop location
        } else {
            background = new Color(238, 238, 238);
        }
        /*setBackgroundToPanels(background);*/

        this.setBackground(background);

        return this;
    }

}
