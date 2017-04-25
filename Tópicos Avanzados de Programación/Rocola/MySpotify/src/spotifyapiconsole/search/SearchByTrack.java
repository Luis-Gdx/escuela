/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spotifyapiconsole.search;

import static app.Search.dataList;
import static app.Search.history;
import static app.Search.jScrollPane2;
import static app.Search.search;
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
    private final int SIZE;

    public SearchByTrack() {
        thread = new Thread(this, "Track");
        SPOTIFY = new Spotify();
        SPOTIFY.setLimit(20);
        SIZE = 150;
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
            System.out.println(track.getName());
            dataList.add(new TrackPanel(track));
        }
        if (dataList.getComponentCount() > 0) {
            history.push(dataList);
            jScrollPane2.setViewportView(dataList);
        } else {
            jScrollPane2.setViewportView(new NotFound("ninguna canción"));
        }
    }

}
