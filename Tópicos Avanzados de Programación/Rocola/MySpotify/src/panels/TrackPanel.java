/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panels;

import static app.Search.cantidadActual;
import static app.Search.dataList;
import static app.Search.jScrollPane2;
import static config.Config.BACKGROUND;
import static config.Config.SELECTED_ITEM;
import static global.ItemsController.setCurrentTrackPanel;
import java.awt.Color;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;
import spotifyapiconsole.album.GetAlbum;
import spotifyapiconsole.search.objects.Track;
import spotifyapiconsole.track.GetTrack;
import spotifyapiconsole.track.GetTracks;

/**
 *
 * @author Luis G
 */
public class TrackPanel extends javax.swing.JPanel {

    Track track;

    public TrackPanel(Track track) {
        initComponents();
        this.track = track;
        imageIcon.setIcon(track.getAlbum().getImages().get(0));
        explicitValue.setVisible(false);
        nameValue.setText(setHtml("<strong><span style='font-size: 11px'>" + track.getName() + "</span></strong>"));
        artistLabel.setText(setHtml("<span style='font-size: 8.75px'><strong>Artista:</strong></span>"));
        artistValue.setText(setHtml("<span style='font-size: 8.75px'>" + track.getArtists().get(0).getName() + "</span>"));
        albumLabel.setText(setHtml("<span style='font-size: 8.75px'><strong>Album:</strong></span>"));
        albumValue.setText(setHtml("<span style='font-size: 8.75px'>" + track.getAlbum().getName() + "</span>"));
        durationLabel.setText(setHtml("<span style='font-size: 8.75px'><strong>Duración:</strong></span>"));
        durationValue.setText(setHtml("<span style='font-size: 8.75px'>" + trackDuration(track.getDuration()) + "</span>"));
        if (track.isExplicit()) {
            explicitValue.setVisible(true);
            explicitValue.setText(setHtml("<span style='font-size: 8.75px'><strong>EXPLÍCITO</strong></span>"));

        } else {
            explicitValue.setVisible(false);
            explicitValue.setText("");
        }
        popularityLabel.setText(setHtml("<span style='font-size: 8.75px'><strong>Popularidad:</strong></span>"));
        popularityValue.setText(setHtml("<span style='font-size: 8.75px'>" + track.getPopularity() + "</span>"));
        trackNumberLabel.setText(setHtml("<span style='font-size: 8.75px'><strong>Número de canción:</strong></span>"));
        trackNumberValue.setText(setHtml("<span style='font-size: 8.75px'>" + track.getTrackNumber() + "</span>"));
        replay.setText(setHtml("<span style='font-size: 9px'><strong>Reproducir</strong></span>"));
        this.setBackground(BACKGROUND);
    }

    private String setHtml(String txt) {
        return "<html>" + txt + "</html>";
    }

    public void setBackgroundToPanels(Color color) {
        this.setBackground(color);
        namePanel.setBackground(color);
        artistPanel.setBackground(color);
        albumPanel.setBackground(color);
        durationPanel.setBackground(color);
        explicitPanel.setBackground(color);
        popularityPanel.setBackground(color);
        trackNumberPanel.setBackground(color);
        dataPanel.setBackground(color);
    }

    private String trackDuration(long millis) {
        return String.format("%02d : %02d",
                TimeUnit.MILLISECONDS.toMinutes(millis),
                TimeUnit.MILLISECONDS.toSeconds(millis)
                - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
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
        artistPanel = new javax.swing.JPanel();
        artistLabel = new javax.swing.JLabel();
        artistValue = new javax.swing.JLabel();
        albumPanel = new javax.swing.JPanel();
        albumLabel = new javax.swing.JLabel();
        albumValue = new javax.swing.JLabel();
        durationPanel = new javax.swing.JPanel();
        durationLabel = new javax.swing.JLabel();
        durationValue = new javax.swing.JLabel();
        explicitPanel = new javax.swing.JPanel();
        explicitValue = new javax.swing.JLabel();
        popularityPanel = new javax.swing.JPanel();
        popularityLabel = new javax.swing.JLabel();
        popularityValue = new javax.swing.JLabel();
        trackNumberPanel = new javax.swing.JPanel();
        trackNumberLabel = new javax.swing.JLabel();
        trackNumberValue = new javax.swing.JLabel();
        replay = new javax.swing.JLabel();

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
        nameValue.setText("Titulo");

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

        artistPanel.setBackground(new java.awt.Color(24, 24, 24));
        artistPanel.setForeground(new java.awt.Color(255, 255, 255));

        artistLabel.setForeground(new java.awt.Color(255, 255, 255));
        artistLabel.setText("Artista:");

        artistValue.setForeground(new java.awt.Color(255, 255, 255));
        artistValue.setText("blink-182");
        artistValue.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        artistValue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                artistValueMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout artistPanelLayout = new javax.swing.GroupLayout(artistPanel);
        artistPanel.setLayout(artistPanelLayout);
        artistPanelLayout.setHorizontalGroup(
            artistPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(artistPanelLayout.createSequentialGroup()
                .addComponent(artistLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(artistValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        artistPanelLayout.setVerticalGroup(
            artistPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(artistPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(artistLabel)
                .addComponent(artistValue))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        dataPanel.add(artistPanel, gridBagConstraints);

        albumPanel.setBackground(new java.awt.Color(24, 24, 24));
        albumPanel.setForeground(new java.awt.Color(255, 255, 255));

        albumLabel.setForeground(new java.awt.Color(255, 255, 255));
        albumLabel.setText("Album:");

        albumValue.setForeground(new java.awt.Color(255, 255, 255));
        albumValue.setText("blink-182");
        albumValue.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        albumValue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                albumValueMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout albumPanelLayout = new javax.swing.GroupLayout(albumPanel);
        albumPanel.setLayout(albumPanelLayout);
        albumPanelLayout.setHorizontalGroup(
            albumPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(albumPanelLayout.createSequentialGroup()
                .addComponent(albumLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(albumValue))
        );
        albumPanelLayout.setVerticalGroup(
            albumPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(albumPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(albumLabel)
                .addComponent(albumValue))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        dataPanel.add(albumPanel, gridBagConstraints);

        durationPanel.setBackground(new java.awt.Color(24, 24, 24));
        durationPanel.setForeground(new java.awt.Color(255, 255, 255));

        durationLabel.setForeground(new java.awt.Color(255, 255, 255));
        durationLabel.setText("Duración:");

        durationValue.setForeground(new java.awt.Color(255, 255, 255));
        durationValue.setText("02:52");

        javax.swing.GroupLayout durationPanelLayout = new javax.swing.GroupLayout(durationPanel);
        durationPanel.setLayout(durationPanelLayout);
        durationPanelLayout.setHorizontalGroup(
            durationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(durationPanelLayout.createSequentialGroup()
                .addComponent(durationLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(durationValue))
        );
        durationPanelLayout.setVerticalGroup(
            durationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(durationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(durationLabel)
                .addComponent(durationValue))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        dataPanel.add(durationPanel, gridBagConstraints);

        explicitPanel.setBackground(new java.awt.Color(24, 24, 24));
        explicitPanel.setForeground(new java.awt.Color(255, 255, 255));

        explicitValue.setForeground(new java.awt.Color(255, 255, 255));
        explicitValue.setText("EXPLÍCITO");

        javax.swing.GroupLayout explicitPanelLayout = new javax.swing.GroupLayout(explicitPanel);
        explicitPanel.setLayout(explicitPanelLayout);
        explicitPanelLayout.setHorizontalGroup(
            explicitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(explicitValue)
        );
        explicitPanelLayout.setVerticalGroup(
            explicitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(explicitValue)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        dataPanel.add(explicitPanel, gridBagConstraints);

        popularityPanel.setBackground(new java.awt.Color(24, 24, 24));
        popularityPanel.setForeground(new java.awt.Color(255, 255, 255));

        popularityLabel.setForeground(new java.awt.Color(255, 255, 255));
        popularityLabel.setText("Popularidad:");

        popularityValue.setForeground(new java.awt.Color(255, 255, 255));
        popularityValue.setText("62");

        javax.swing.GroupLayout popularityPanelLayout = new javax.swing.GroupLayout(popularityPanel);
        popularityPanel.setLayout(popularityPanelLayout);
        popularityPanelLayout.setHorizontalGroup(
            popularityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(popularityPanelLayout.createSequentialGroup()
                .addComponent(popularityLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(popularityValue))
        );
        popularityPanelLayout.setVerticalGroup(
            popularityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(popularityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(popularityLabel)
                .addComponent(popularityValue))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        dataPanel.add(popularityPanel, gridBagConstraints);

        trackNumberPanel.setBackground(new java.awt.Color(24, 24, 24));
        trackNumberPanel.setForeground(new java.awt.Color(255, 255, 255));

        trackNumberLabel.setForeground(new java.awt.Color(255, 255, 255));
        trackNumberLabel.setText("Número de canción:");

        trackNumberValue.setForeground(new java.awt.Color(255, 255, 255));
        trackNumberValue.setText("1");

        javax.swing.GroupLayout trackNumberPanelLayout = new javax.swing.GroupLayout(trackNumberPanel);
        trackNumberPanel.setLayout(trackNumberPanelLayout);
        trackNumberPanelLayout.setHorizontalGroup(
            trackNumberPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(trackNumberPanelLayout.createSequentialGroup()
                .addComponent(trackNumberLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(trackNumberValue))
        );
        trackNumberPanelLayout.setVerticalGroup(
            trackNumberPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(trackNumberPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(trackNumberLabel)
                .addComponent(trackNumberValue))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        dataPanel.add(trackNumberPanel, gridBagConstraints);

        replay.setBackground(new java.awt.Color(24, 24, 24));
        replay.setForeground(new java.awt.Color(255, 255, 255));
        replay.setText("Reproducir");
        replay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        replay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                replayMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        dataPanel.add(replay, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(imageIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(dataPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(194, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imageIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
            .addComponent(dataPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        setBackgroundToPanels(SELECTED_ITEM);
        setCurrentTrackPanel(this);
    }//GEN-LAST:event_formMouseClicked

    private void replayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_replayMouseClicked
        if (Integer.parseInt(cantidadActual.getText()) >= 5) {
            cantidadActual.setText((Integer.parseInt(cantidadActual.getText()) - 5) + "");
            setBackgroundToPanels(SELECTED_ITEM);
            setCurrentTrackPanel(this);
            GetTrack getTrack = new GetTrack(this.track.getId());
            getTrack.thread.start();
        } else {
            JOptionPane.showMessageDialog(null, "Dinero insuficiente, la cancion esta de a $5 :v", "Sin dinero xd", 0);
        }
    }//GEN-LAST:event_replayMouseClicked

    private void albumValueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_albumValueMouseClicked
        if (dataList.getComponentCount() > 0) {
            dataList.removeAll();
            //jScrollPane2.setViewportView(dataList);
        }
        jScrollPane2.getVerticalScrollBar().setValue(jScrollPane2.getVerticalScrollBar().getMinimum());
        jScrollPane2.getHorizontalScrollBar().setValue(jScrollPane2.getHorizontalScrollBar().getMinimum());
        jScrollPane2.setViewportView(new Loader());
        setBackgroundToPanels(SELECTED_ITEM);
        setCurrentTrackPanel(this);
        new GetTracks(this.track.getAlbum().getId()).thread.start();
    }//GEN-LAST:event_albumValueMouseClicked

    private void artistValueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_artistValueMouseClicked
        if (dataList.getComponentCount() > 0) {
            dataList.removeAll();
        }
        jScrollPane2.getVerticalScrollBar().setValue(jScrollPane2.getVerticalScrollBar().getMinimum());
        jScrollPane2.getHorizontalScrollBar().setValue(jScrollPane2.getHorizontalScrollBar().getMinimum());
        jScrollPane2.setViewportView(new Loader());
        setBackgroundToPanels(SELECTED_ITEM);
        setCurrentTrackPanel(this);
        System.out.println(this.track.getArtists().get(0).getId());
        new GetAlbum(this.track.getArtists().get(0).getId()).thread.start();
    }//GEN-LAST:event_artistValueMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel albumLabel;
    private javax.swing.JPanel albumPanel;
    private javax.swing.JLabel albumValue;
    private javax.swing.JLabel artistLabel;
    private javax.swing.JPanel artistPanel;
    public static javax.swing.JLabel artistValue;
    private javax.swing.JPanel dataPanel;
    private javax.swing.JLabel durationLabel;
    private javax.swing.JPanel durationPanel;
    private javax.swing.JLabel durationValue;
    private javax.swing.JPanel explicitPanel;
    private javax.swing.JLabel explicitValue;
    private javax.swing.JLabel imageIcon;
    private javax.swing.JPanel namePanel;
    private javax.swing.JLabel nameValue;
    private javax.swing.JLabel popularityLabel;
    private javax.swing.JPanel popularityPanel;
    private javax.swing.JLabel popularityValue;
    private javax.swing.JLabel replay;
    private javax.swing.JLabel trackNumberLabel;
    private javax.swing.JPanel trackNumberPanel;
    private javax.swing.JLabel trackNumberValue;
    // End of variables declaration//GEN-END:variables
}
