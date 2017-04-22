/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spotifyapiconsole.search;

import java.util.ArrayList;
import javax.swing.JPanel;
import static myspotify.Search.dataList;
import static myspotify.Search.jScrollPane2;
import static myspotify.Search.search;
import panels.Loader;
import panels.NotFound;
import panels.TrackPanel;
import spotifyapi.Spotify;
import spotifyapiconsole.search.objects.Track;

/**
 *
 * @author Luis G
 */
public class SearchByTrack implements Runnable {

    public Thread thread;
    private final Spotify SPOTIFY;
    private int limit = 20;
    private final int SIZE;
    ArrayList<JPanel> panels = new ArrayList();

    public SearchByTrack() {
        thread = new Thread(this, "Track");
        SPOTIFY = new Spotify();
        SPOTIFY.setLimit(limit);
        SIZE = 150;
        jScrollPane2.setViewportView(new Loader());
    }

    @Override
    public void run() {
        SPOTIFY.get(search.getText(), "tracks");
        int limit = SPOTIFY.getLimit();
        int total = SPOTIFY.getTotal();
        for (int i = 0; i < ((total > limit) ? limit : total); i++) {
            Track track = new Track();
            track.setAlbum(SPOTIFY.getAlbum(i, SIZE));
            track.setArtists(SPOTIFY.getArtist(i));
            track.setDuration(SPOTIFY.getDuration(i));
            track.setExplicit(SPOTIFY.isExplicit(i));
            track.setId(SPOTIFY.getId(i));
            track.setName(SPOTIFY.getName(i));
            track.setPopularity(SPOTIFY.getPopularity(i));
            track.setTrackNumber(SPOTIFY.getTrackNumber(i));
            track.setType(SPOTIFY.getType(i));
            panels.add(new TrackPanel(track));
            System.out.println(track.getName());
        }
        for (JPanel panel : panels) {
            dataList.add(panel);
        }
        if (dataList.getComponentCount() > 0) {
            jScrollPane2.setViewportView(dataList);
        } else {
            jScrollPane2.setViewportView(new NotFound("canción"));
        }
    }

}
