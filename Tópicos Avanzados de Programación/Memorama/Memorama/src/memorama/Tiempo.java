/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorama;

import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static memorama.Memorama.gameOver;
import static memorama.Memorama.tiempo;

/**
 *
 * @author lg269
 */
public class Tiempo implements Runnable {

    JFrame frame;

    Thread thread;
    Connector conn = new Connector() {
        @Override
        public void then(ResultSet rs) {

        }
    };

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
        String nombre = JOptionPane.showInputDialog(null, "Has terminado con un tiempo de " + tiempo.getText() + " segundos, Ingresa tu nombre para registrar tu puntuación :v", "ganaste", 1);
        conn.executeQuery("INSERT INTO puntuaciones (nombre, tiempo) VALUES ('" + nombre + "', " + Integer.parseInt(tiempo.getText()) + ")");
        new MainMenu().setVisible(true);
        getFrame().dispose();
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

}
