/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import javax.swing.DefaultListModel;
import static myspotify.ArtistsSearch.search;
import objects.Track;
import spotifyapi.Spotify;
import static myspotify.ArtistsSearch.trackList;

/**
 *
 * @author Luis G
 */
public class SearchByTrack implements Runnable {

    public Thread thread;
    private final Spotify SPOTIFY;
    private DefaultListModel<Track> trackListModel;

    public SearchByTrack() {
        thread = new Thread(this, "Track");
        SPOTIFY = new Spotify();
        trackListModel = new DefaultListModel();
    }

    @Override
    public void run() {
        SPOTIFY.get(search.getText(), "track");
        int total = SPOTIFY.getTotal();
        for (int i = 0; i < ((total > 20) ? 20 : total); i++) {
            Track track = new Track();
            track.setAlbum(SPOTIFY.getAlbum(i));
            track.setArtists(SPOTIFY.getArtist(i));
            track.setDuration(SPOTIFY.getDuration(i));
            track.setExplicit(SPOTIFY.isExplicit(i));
            track.setId(SPOTIFY.getId(i));
            track.setName(SPOTIFY.getName(i));
            track.setPopularity(SPOTIFY.getPopularity(i));
            track.setTrackNumber(SPOTIFY.getTrackNumber(i));
            track.setType(SPOTIFY.getType(i));
            trackListModel.addElement(track);
        }
        trackList.setModel(trackListModel);
    }

}
