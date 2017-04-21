/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cellsrender;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import spotifyapiconsole.search.objects.Artist;

/**
 *
 * @author Luis G
 */
public class ArtistCellRenderer extends JLabel implements ListCellRenderer<Artist> {

    public ArtistCellRenderer() {
        setOpaque(true);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends Artist> list, Artist artist, int index, boolean isSelected, boolean cellHasFocus) {
        setText("<html><head><style>li{list-style-type: none}</style></head><body><ul><li><strong><span style='font-size: 11px'>" + artist.getName() + "</span></strong></li>" + (!artist.getGenres().isEmpty() ? "<li><span style='font-size: 8.75px'><strong>Géneros: </strong>" + artist.getGenres() + "</span></li>" : "") + "<li><strong>Seguidores: </strong>" + artist.getFollowers() + "</li></ul></body></html>");
        setIcon(artist.getImages().get(0));
        this.setBackground(new Color(238, 238, 238));
        return this;
    }

}
