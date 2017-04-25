/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panels;

import static app.Search.dataList;
import static app.Search.jScrollPane2;
import static config.Config.SELECTED_ITEM;
import static global.ItemsController.setCurrentArtistPanel;
import java.awt.Color;
import spotifyapiconsole.album.GetAlbum;
import spotifyapiconsole.search.objects.Artist;

/**
 *
 * @author Luis G
 */
public class ArtistPanel extends javax.swing.JPanel {

    /**
     * Creates new form ArtistPanel
     */
    Artist artist;

    public ArtistPanel(Artist artist) {
        initComponents();
        this.generesPanel.setVisible(false);
        this.artist = artist;
        this.imageIcon.setIcon(artist.getImages().get(0));
        this.nameValue.setText(setHtml("<strong><span style='font-size: 11px'>" + artist.getName() + "</span></strong>"));
        if (!artist.getGenres().isEmpty()) {
            this.generesPanel.setVisible(true);
            this.generesLabel.setText(setHtml("<span style='font-size: 8.75px'><strong>Géneros: </strong></span>"));
            this.generesValue.setText(setHtml("<span style='font-size: 8.75px'>" + artist.getGenres() + "</span>"));
        }
        this.followersLabel.setText(setHtml("<span style='font-size: 8.75px'><strong>Seguidores: </strong></span>"));
        this.followersValue.setText(setHtml("<span style='font-size: 8.75px'>" + artist.getFollowers() + "</span>"));
    }

    private String setHtml(String txt) {
        return "<html>" + txt + "</html>";
    }

    public void setBackgroundToPanels(Color color) {
        this.setBackground(color);
        dataPanel.setBackground(color);
        namePanel.setBackground(color);
        generesPanel.setBackground(color);
        followersPanel.setBackground(color);
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
        generesPanel = new javax.swing.JPanel();
        generesLabel = new javax.swing.JLabel();
        generesValue = new javax.swing.JLabel();
        followersPanel = new javax.swing.JPanel();
        followersLabel = new javax.swing.JLabel();
        followersValue = new javax.swing.JLabel();

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

        generesPanel.setBackground(new java.awt.Color(24, 24, 24));
        generesPanel.setForeground(new java.awt.Color(255, 255, 255));

        generesLabel.setBackground(new java.awt.Color(24, 24, 24));
        generesLabel.setForeground(new java.awt.Color(255, 255, 255));
        generesLabel.setText("Género");

        generesValue.setBackground(new java.awt.Color(24, 24, 24));
        generesValue.setForeground(new java.awt.Color(255, 255, 255));
        generesValue.setText("blink-182");
        generesValue.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout generesPanelLayout = new javax.swing.GroupLayout(generesPanel);
        generesPanel.setLayout(generesPanelLayout);
        generesPanelLayout.setHorizontalGroup(
            generesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(generesPanelLayout.createSequentialGroup()
                .addComponent(generesLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(generesValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        generesPanelLayout.setVerticalGroup(
            generesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(generesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(generesLabel)
                .addComponent(generesValue))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        dataPanel.add(generesPanel, gridBagConstraints);

        followersPanel.setBackground(new java.awt.Color(24, 24, 24));
        followersPanel.setForeground(new java.awt.Color(255, 255, 255));

        followersLabel.setBackground(new java.awt.Color(24, 24, 24));
        followersLabel.setForeground(new java.awt.Color(255, 255, 255));
        followersLabel.setText("Seguidores");

        followersValue.setBackground(new java.awt.Color(24, 24, 24));
        followersValue.setForeground(new java.awt.Color(255, 255, 255));
        followersValue.setText("blink-182");
        followersValue.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout followersPanelLayout = new javax.swing.GroupLayout(followersPanel);
        followersPanel.setLayout(followersPanelLayout);
        followersPanelLayout.setHorizontalGroup(
            followersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(followersPanelLayout.createSequentialGroup()
                .addComponent(followersLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(followersValue))
        );
        followersPanelLayout.setVerticalGroup(
            followersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(followersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(followersLabel)
                .addComponent(followersValue))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        dataPanel.add(followersPanel, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(imageIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(dataPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(340, Short.MAX_VALUE))
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
        setCurrentArtistPanel(this);
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
        setCurrentArtistPanel(this);
        new GetAlbum(this.artist.getId()).thread.start();
    }//GEN-LAST:event_nameValueMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel dataPanel;
    private javax.swing.JLabel followersLabel;
    private javax.swing.JPanel followersPanel;
    private javax.swing.JLabel followersValue;
    private javax.swing.JLabel generesLabel;
    private javax.swing.JPanel generesPanel;
    public static javax.swing.JLabel generesValue;
    private javax.swing.JLabel imageIcon;
    private javax.swing.JPanel namePanel;
    private javax.swing.JLabel nameValue;
    // End of variables declaration//GEN-END:variables
}
