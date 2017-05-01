/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorama;

import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author Luis G
 */
public class Reproductor implements Runnable {

    private String path;
    private String sound;
    public Thread thread;

    public Reproductor() {
        thread = new Thread(this, "Reproductor");
    }

    @Override
    public void run() {
        try {
            Clip clip = AudioSystem.getClip();
            File sound = new File(path);
            clip.open(AudioSystem.getAudioInputStream(sound));
            clip.start();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        try {
            path = "./sounds/" + sound + ".wav";
            /*try {
                path = getClass().getResource("/sounds/" + sound + ".wav").toString();
                JOptionPane.showMessageDialog(null, path);
                path = path.replaceAll("jar:", "");
                path = path.substring(6, path.length());
                JOptionPane.showMessageDialog(null, path);
                path = path.replaceAll("%20", " ");
                path = path.replaceAll("%c3%b3", "ó");
                JOptionPane.showMessageDialog(null, path);
            } catch (Exception e) {
                try {
                } catch (Exception ex) {
                }
            }*/
            this.sound = sound;
        } catch (Exception e) {
        }
    }

}
