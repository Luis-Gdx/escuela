/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorama;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static memorama.Memorama.gameOver;
import static memorama.Memorama.tiempo;

/**
 *
 * @author lg269
 */
public class Tiempo implements Runnable {

    Thread thread;

    public Tiempo() {
        thread = new Thread(this);
    }

    @Override
    public void run() {
        for (int i = 0; !gameOver; i++) {
            tiempo.setText(i + "");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Tiempo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        JOptionPane.showMessageDialog(null, "Has ganado :v", "ganaste", 1);
    }

}
