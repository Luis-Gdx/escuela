/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spotifyapiconsole.track;

import static app.Search.dataList;
import static app.Search.history;
import static app.Search.jScrollPane2;
import panels.NotFound;
import panels.TrackPanel;
import spotifyapi.Spotify;
import spotifyapiconsole.search.objects.Track;

/**
 *
 * @author Luis G
 */
public class GetTracks implements Runnable {

    public Thread thread;
    private final Spotify SPOTIFY;
    private final int SIZE;
    private String req;

    public GetTracks(String req) {
        thread = new Thread(this, "Track");
        SPOTIFY = new Spotify();
        SPOTIFY.setLimit(20);
        SIZE = 150;
        this.req = req;
    }

    @Override
    public void run() {
        SPOTIFY.get(req, "tracks by album");

        try {
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                Track track = new Track();
                track.setAlbum(SPOTIFY.getAlbumByArtist(SIZE));
                track.setArtists(SPOTIFY.getArtist(i));
                track.setDuration(SPOTIFY.getDuration(i));
                track.setExplicit(SPOTIFY.isExplicit(i));
                track.setId(SPOTIFY.getId(i));
                track.setName(SPOTIFY.getName(i));
                //track.setPopularity(SPOTIFY.getPopularity(i));
                track.setTrackNumber(SPOTIFY.getTrackNumber(i));
                track.setType(SPOTIFY.getType(i));
                System.out.println(track.getName());
                dataList.add(new TrackPanel(track));
            }
        } catch (Exception e) {
        }

        if (dataList.getComponentCount() > 0) {
            history.push(dataList);
            jScrollPane2.setViewportView(dataList);
        } else {
            jScrollPane2.setViewportView(new NotFound("ninguna canción"));
        }
    }

}
