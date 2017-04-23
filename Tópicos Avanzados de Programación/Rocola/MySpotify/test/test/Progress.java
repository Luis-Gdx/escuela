/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.logging.Level;
import java.util.logging.Logger;
import static test.NewJFrame.flag;
import static test.NewJFrame.i;
import static test.NewJFrame.jLabel1;
import static test.NewJFrame.jSlider1;

/**
 *
 * @author Luis G
 */
public class Progress implements Runnable {

    Thread thread;
    public int pausedOnFrame;
    String segundos = "0:00/0:30";

    public Progress() {
        thread = new Thread(this);
    }

    @Override
    public void run() {
        try {
            for (; i < 1150; i++) {
                jSlider1.setValue(i);
                Thread.sleep(26);
                segundos = Double.toString(i / 38.3).substring(0, Double.toString(i / 38.3).indexOf("."));
                jLabel1.setText("0:" + ((segundos.length() > 1) ? segundos : "0" + segundos) + " / 0:30");
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
