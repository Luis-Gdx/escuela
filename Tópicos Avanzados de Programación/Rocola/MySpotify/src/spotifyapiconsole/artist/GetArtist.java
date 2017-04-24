/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spotifyapiconsole.artist;

import spotifyapi.Spotify;

/**
 *
 * @author Luis G
 */
public class GetArtist implements Runnable {

    public Thread thread;
    private final Spotify SPOTIFY;
    private final int SIZE;
    private String req;

    public GetArtist(String req) {
        thread = new Thread(this, "Get artist");
        SPOTIFY = new Spotify();
        SIZE = 75;
        this.req = req;
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
