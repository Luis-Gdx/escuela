/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panels;

import static app.Search.dataList;
import static app.Search.jScrollPane2;
import static config.Config.SELECTED_ITEM;
import static global.ItemsController.setCurrentAlbumPanel;
import java.awt.Color;
import spotifyapiconsole.search.objects.Album;
import spotifyapiconsole.track.GetTracks;

/**
 *
 * @author Luis G
 */
public class AlbumPanel extends javax.swing.JPanel {

    /**
     * Creates new form ArtistPanel
     */
    Album album;

    public AlbumPanel(Album album) {
        initComponents();
        this.album = album;
        this.imageIcon.setIcon(this.album.getImages().get(0));
        this.nameValue.setText(setHtml("<strong><span style='font-size: 11px'>" + this.album.getName() + "</span></strong>"));
        this.tipoLabel.setText(setHtml("<span style='font-size: 8.75px'><strong>Tipo: </strong></span>"));
        this.tipoValue.setText(setHtml("<span style='font-size: 8.75px'>" + this.album.getType() + "</span>"));
        this.artistaLabel.setText(setHtml("<span style='font-size: 8.75px'><strong>Artista: </strong></span>"));
        this.artistaValue.setText(setHtml("<span style='font-size: 8.75px'>" + this.album.getArtists().get(0).getName() + "</span>"));
    }

    private String setHtml(String txt) {
        return "<html>" + txt + "</html>";
    }

    public void setBackgroundToPanels(Color color) {
        this.setBackground(color);
        dataPanel.setBackground(color);
        namePanel.setBackground(color);
        tipoPanel.setBackground(color);
        artistaPanel.setBackground(color);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        imageIcon = new javax.swing.JLabel();
        dataPanel = new javax.swing.JPanel();
        namePanel = new javax.swing.JPanel();
        nameValue = new javax.swing.JLabel();
        tipoPanel = new javax.swing.JPanel();
        tipoLabel = new javax.swing.JLabel();
        tipoValue = new javax.swing.JLabel();
        artistaPanel = new javax.swing.JPanel();
        artistaLabel = new javax.swing.JLabel();
        artistaValue = new javax.swing.JLabel();

        setBackground(new java.awt.Color(24, 24, 24));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        imageIcon.setText("Image");

        dataPanel.setBackground(new java.awt.Color(24, 24, 24));
        dataPanel.setLayout(new java.awt.GridBagLayout());

        namePanel.setBackground(new java.awt.Color(24, 24, 24));
        namePanel.setForeground(new java.awt.Color(255, 255, 255));

        nameValue.setForeground(new java.awt.Color(255, 255, 255));
        nameValue.setText("Nombre");
        nameValue.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nameValue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nameValueMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout namePanelLayout = new javax.swing.GroupLayout(namePanel);
        namePanel.setLayout(namePanelLayout);
        namePanelLayout.setHorizontalGroup(
            namePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(nameValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        namePanelLayout.setVerticalGroup(
            namePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(nameValue)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        dataPanel.add(namePanel, gridBagConstraints);

        tipoPanel.setBackground(new java.awt.Color(24, 24, 24));
        tipoPanel.setForeground(new java.awt.Color(255, 255, 255));

        tipoLabel.setBackground(new java.awt.Color(24, 24, 24));
        tipoLabel.setForeground(new java.awt.Color(255, 255, 255));
        tipoLabel.setText("Tipo");

        tipoValue.setBackground(new java.awt.Color(24, 24, 24));
        tipoValue.setForeground(new java.awt.Color(255, 255, 255));
        tipoValue.setText("blink-182");
        tipoValue.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout tipoPanelLayout = new javax.swing.GroupLayout(tipoPanel);
        tipoPanel.setLayout(tipoPanelLayout);
        tipoPanelLayout.setHorizontalGroup(
            tipoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tipoPanelLayout.createSequentialGroup()
                .addComponent(tipoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tipoValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tipoPanelLayout.setVerticalGroup(
            tipoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tipoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(tipoLabel)
                .addComponent(tipoValue))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        dataPanel.add(tipoPanel, gridBagConstraints);

        artistaPanel.setBackground(new java.awt.Color(24, 24, 24));
        artistaPanel.setForeground(new java.awt.Color(255, 255, 255));

        artistaLabel.setBackground(new java.awt.Color(24, 24, 24));
        artistaLabel.setForeground(new java.awt.Color(255, 255, 255));
        artistaLabel.setText("Artista");

        artistaValue.setBackground(new java.awt.Color(24, 24, 24));
        artistaValue.setForeground(new java.awt.Color(255, 255, 255));
        artistaValue.setText("blink-182");
        artistaValue.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout artistaPanelLayout = new javax.swing.GroupLayout(artistaPanel);
        artistaPanel.setLayout(artistaPanelLayout);
        artistaPanelLayout.setHorizontalGroup(
            artistaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(artistaPanelLayout.createSequentialGroup()
                .addComponent(artistaLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(artistaValue))
        );
        artistaPanelLayout.setVerticalGroup(
            artistaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(artistaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(artistaLabel)
                .addComponent(artistaValue))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        dataPanel.add(artistaPanel, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(imageIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(dataPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(361, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(dataPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(imageIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        setBackgroundToPanels(SELECTED_ITEM);
        setCurrentAlbumPanel(this);
    }//GEN-LAST:event_formMouseClicked

    private void nameValueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nameValueMouseClicked
        if (dataList.getComponentCount() > 0) {
            dataList.removeAll();
            //jScrollPane2.setViewportView(dataList);
        }
        jScrollPane2.getVerticalScrollBar().setValue(jScrollPane2.getVerticalScrollBar().getMinimum());
        jScrollPane2.getHorizontalScrollBar().setValue(jScrollPane2.getHorizontalScrollBar().getMinimum());
        jScrollPane2.setViewportView(new Loader());
        setBackgroundToPanels(SELECTED_ITEM);
        setCurrentAlbumPanel(this);
        new GetTracks(this.album.getId()).thread.start();
    }//GEN-LAST:event_nameValueMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel artistaLabel;
    private javax.swing.JPanel artistaPanel;
    private javax.swing.JLabel artistaValue;
    private javax.swing.JPanel dataPanel;
    private javax.swing.JLabel imageIcon;
    private javax.swing.JPanel namePanel;
    private javax.swing.JLabel nameValue;
    private javax.swing.JLabel tipoLabel;
    private javax.swing.JPanel tipoPanel;
    public static javax.swing.JLabel tipoValue;
    // End of variables declaration//GEN-END:variables
}
