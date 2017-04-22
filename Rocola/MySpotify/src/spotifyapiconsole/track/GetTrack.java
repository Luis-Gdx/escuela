/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spotifyapiconsole.track;

import static myspotify.Search.flag;
import static myspotify.Search.i;
import static myspotify.Search.img;
import static myspotify.Search.jSlider1;
import static myspotify.Search.pausedOnFrame;
import static myspotify.Search.player;
import static myspotify.Search.progress;
import static myspotify.Search.songUrl;
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
    private Track track;
    private String req;

    public GetTrack(String req) {
        thread = new Thread(this, "Get track");
        SPOTIFY = new Spotify();
        SIZE = 75;
        track = new Track();
        this.req = req;
    }

    @Override
    public void run() {
        System.out.println(":v");
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
