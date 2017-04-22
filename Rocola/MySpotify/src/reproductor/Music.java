/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reproductor;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;
import myspotify.Search;
import static myspotify.Search.flag;
import static myspotify.Search.jSlider1;
import static myspotify.Search.pausedOnFrame;
import static myspotify.Search.player;
import static myspotify.Search.songUrl;

/**
 *
 * @author Luis G
 */
public class Music implements Runnable {

    public Thread thread;
    InputStream is;

    public Music() {
        thread = new Thread(this);
        try {
            is = new URL(songUrl).openStream();
        } catch (MalformedURLException ex) {
            Logger.getLogger(Music.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Music.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        try {
            BufferedInputStream bis = new BufferedInputStream(is);
            player = new AdvancedPlayer(bis);
            player.setPlayBackListener(new PlaybackListener() {
                public void playbackStarted(PlaybackEvent event) {
                    flag = true;
                }

                public void playbackFinished(PlaybackEvent event) {
                    pausedOnFrame = jSlider1.getValue();
                    flag = false;
                }

            });
            player.play(pausedOnFrame, Integer.MAX_VALUE);
        } catch (JavaLayerException ex) {
            Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
