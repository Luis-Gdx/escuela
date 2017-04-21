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
import spotifyapiconsole.search.objects.Album;

/**
 *
 * @author Luis G
 */
public class AlbumCellRenderer extends JLabel implements ListCellRenderer<Album> {

    public AlbumCellRenderer() {
        setOpaque(true);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends Album> list, Album album, int index, boolean isSelected, boolean cellHasFocus) {
        setText("<html><head><style>li{list-style-type: none}</style></head><body><ul><li><strong><span style='font-size: 11px'>" + album.getName() + "</span></strong></li><li><span style='font-size: 8.75px'><strong>Tipo: </strong>" + album.getType() + "</span></li><li><span style='font-size: 8.75px'><strong>Artista: </strong>" + album.getArtists().get(0).getName() + "</span></li></ul></body></html>");
        setIcon(album.getImages().get(0));
        this.setBackground(new Color(238, 238, 238));
        return this;
    }

}
