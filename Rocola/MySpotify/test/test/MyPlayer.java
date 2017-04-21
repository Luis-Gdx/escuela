package test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;

public class MyPlayer implements Runnable {

    private AdvancedPlayer currentPlayer;

    private URL urlToFile;

    //frames
    private int intFrames = 0;

    private boolean status = false;

    public MyPlayer(String path) throws IOException {
        //Set audio file
        this.urlToFile = new URL(path);

        //Set and start THREAD
        Thread playerThread = new Thread(this);
        playerThread.start();

    }

    @Override
    public void run() {
        try {
            play();
        } catch (IOException | JavaLayerException e) {
            e.printStackTrace();
        }
    }

    public void play() throws IOException, JavaLayerException {
        if (status == false) {
            System.out.println("Frame " + intFrames);
            InputStream audioStream = urlToFile.openStream();
            //create player
            try {
                this.currentPlayer = new AdvancedPlayer(audioStream);
                this.currentPlayer.setPlayBackListener(new PlaybackListener() {
                    @Override
                    public void playbackFinished(PlaybackEvent arg0) {
                        arg0.setSource(currentPlayer);
                        intFrames = arg0.getFrame();
                        super.playbackFinished(arg0);
                    }

                    @Override
                    public void playbackStarted(PlaybackEvent arg0) {
                        arg0.setSource(currentPlayer);
                        arg0.setFrame(intFrames);
                        super.playbackStarted(arg0);
                    }
                });
            } catch (JavaLayerException e) {
                e.printStackTrace();

            }
            currentPlayer.play(intFrames, Integer.MAX_VALUE);
        } else {
            pause();
        }

    }

    public void pause() {
        this.status = false;
        currentPlayer.stop();
    }

    public void resume() throws IOException, JavaLayerException {
        play();
    }

}
