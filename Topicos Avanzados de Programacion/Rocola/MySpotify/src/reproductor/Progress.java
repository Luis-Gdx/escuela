/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reproductor;

import java.util.logging.Level;
import java.util.logging.Logger;
import static app.Search.flag;
import static app.Search.i;
import static app.Search.jSlider1;
import static app.Search.time;

/**
 *
 * @author Luis G
 */
public class Progress implements Runnable {

    public Thread thread;
    public int pausedOnFrame;
    String segundos = "0:00/0:30";

    public Progress() {
        thread = new Thread(this);
    }

    @Override
    public void run() {
        try {
            for (; i < 1150; i++) {
                //System.out.println(i);
                jSlider1.setValue(i);
                Thread.sleep(26);
                segundos = Double.toString(i / 38.3).substring(0, Double.toString(i / 38.3).indexOf("."));
                time.setText("0:" + ((segundos.length() > 1) ? segundos : "0" + segundos) + " / 0:30");
                while (!flag) {
                    Thread.sleep(1);
                }
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Progress.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String getDecimals(String duration) {
        String duracion = duration;
        try {
            duracion = duration.substring(0, duration.indexOf(".") + 3);
        } catch (Exception e) {

        }
        return duracion;
    }

}
