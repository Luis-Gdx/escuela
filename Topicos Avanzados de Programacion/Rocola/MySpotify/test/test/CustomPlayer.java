/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.net.URL;
import javax.swing.JOptionPane;
import javazoom.jl.player.Player;

/**
 *
 * @author Luis G
 */
public class CustomPlayer {

    private Player player;
    private FileInputStream FIS;
    private BufferedInputStream BIS;
    private boolean canResume;
    private String path;
    private int total;
    private int stopped;
    private boolean valid;

    public CustomPlayer() {
        player = null;
        FIS = null;
        valid = false;
        BIS = null;
        path = null;
        total = 0;
        stopped = 0;
        canResume = false;
    }

    public boolean canResume() {
        return canResume;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void pause() {
        try {
            stopped = FIS.available();
            player.close();
            FIS = null;
            BIS = null;
            player = null;
            if (valid) {
                canResume = true;
            }
        } catch (Exception e) {

        }
    }

    public void resume() {
        if (!canResume) {
            return;
        }
        if (play(total - stopped)) {
            canResume = false;
        }
    }

    public boolean play(int pos) {
        valid = true;
        canResume = false;
        try {
            BIS = new BufferedInputStream(new URL("https://p.scdn.co/mp3-preview/4839b070015ab7d6de9fec1756e1f3096d908fba").openStream());
            player = new Player(BIS);
            new Thread(
                    new Runnable() {
                public void run() {
                    try {
                        player.play();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Error playing mp3 file");
                        valid = false;
                    }
                }
            }
            ).start();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error playing mp3 file");
            valid = false;
        }
        return valid;
    }

}
