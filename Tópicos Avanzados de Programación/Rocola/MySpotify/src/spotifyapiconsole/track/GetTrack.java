/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spotifyapiconsole.track;

import static app.Search.artistReproductor;
import static app.Search.flag;
import static app.Search.i;
import static app.Search.img;
import static app.Search.isMusic;
import static app.Search.jSlider1;
import static app.Search.nameReproductor;
import static app.Search.pausedOnFrame;
import static app.Search.player;
import static app.Search.progress;
import static app.Search.songUrl;
import reproductor.Music;
import reproductor.Progress;
import spotifyapi.Spotify;
import spotifyapiconsole.track.objects.Track;

/**
 *
 * @author Luis G
 */
public class GetTrack implements Runnable {

    public Thread thread;
    private final Spotify SPOTIFY;
    private final int SIZE;
    private String req;
    private Track track;

    public GetTrack(String req) {
        thread = new Thread(this, "Get track");
        SPOTIFY = new Spotify();
        SIZE = 75;
        this.req = req;
        track = new Track();
        isMusic = true;
    }

    @Override
    public void run() {
        SPOTIFY.get(this.req, "track");
        track.setAlbum(SPOTIFY.getAlbum(SIZE));
        track.setArtist(SPOTIFY.getArtist());
        track.setExplicit(SPOTIFY.isExplicit());
        track.setId(SPOTIFY.getId());
        track.setName(SPOTIFY.getName());
        track.setPopularity(SPOTIFY.getPopularity());
        track.setPreviewUrl(SPOTIFY.getPreviewUrl());
        track.setTrackNumber(SPOTIFY.getTrackNumber());
        track.setType(SPOTIFY.getType());
        songUrl = track.getPreviewUrl();
        img.setIcon(track.getAlbum().getImages().get(0));
        nameReproductor.setText(this.track.getName());
        artistReproductor.setText(this.track.getArtist().get(0).getName());
        if (!progress.thread.isAlive()) {
            progress = new Progress();
            progress.thread.start();
        }
        if (flag) {
            player.stop();
        } else {
            flag = false;
        }
        jSlider1.setValue(0);
        pausedOnFrame = jSlider1.getValue();
        i = pausedOnFrame;
        new Music().thread.start();
    }

    public Track getTrack() {
        return this.track;
    }
}
