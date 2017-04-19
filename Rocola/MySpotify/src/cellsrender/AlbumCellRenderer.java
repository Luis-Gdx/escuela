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
import objects.Album;

/**
 *
 * @author Luis G
 */
public class AlbumCellRenderer extends JLabel implements ListCellRenderer<Album> {

    private final int SIZE = 75;

    public AlbumCellRenderer() {
        setOpaque(true);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends Album> list, Album album, int index, boolean isSelected, boolean cellHasFocus) {
        setText("<html><head><style>li{list-style-type: none}</style></head><body><ul><li><strong><span style='font-size: 11px'>" + album.getName() + "</span></strong></li><li><span style='font-size: 8.75px'><strong>Tipo: </strong>" + album.getType() + "</span></li><li><span style='font-size: 8.75px'><strong>Artista: </strong>" + album.getArtists().get(0).getName() + "</span></li></ul></body></html>");
        if (!album.getImages().isEmpty()) {
            try {
                setIcon(new ImageIcon(new ImageIcon((new URL(album.getImages().get(album.getImages().size() - 1)))).getImage().getScaledInstance(SIZE, SIZE, java.awt.Image.SCALE_AREA_AVERAGING)));
            } catch (MalformedURLException ex) {
                Logger.getLogger(ArtistCellRenderer.class.getName()).log(Level.SEVERE, null, ex);
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
