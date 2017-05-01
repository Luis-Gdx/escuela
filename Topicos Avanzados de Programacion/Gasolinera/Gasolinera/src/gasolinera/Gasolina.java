/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gasolinera;

import static gasolinera.Gasolinera.jButton1;
import static gasolinera.Gasolinera.jComboBox1;
import static gasolinera.Gasolinera.jPanel1;
import static gasolinera.Gasolinera.jTextField1;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis G
 */
public class Gasolina implements Runnable {

    Thread thread;

    public Gasolina() {
        thread = new Thread(this, "Gasolina");
    }

    public void run() {
        jButton1.setEnabled(false);
        for (int i = 0; i < ((jComboBox1.getSelectedIndex() == 0) ? Double.parseDouble(jTextField1.getText()) / 16 : Double.parseDouble(jTextField1.getText())); i++) {
            if (jPanel1.getHeight() < 515) {
                jPanel1.setSize(jPanel1.getWidth(), jPanel1.getHeight() + 1);
                //jLabel1.setText(i + "");
            } else {
                JOptionPane.showMessageDialog(null, "Se acabo la gasolina :'v", "Se acabo xd", 0);
                break;
            }
            try {
                Thread.sleep(75);
            } catch (InterruptedException ex) {
                Logger.getLogger(Gasolina.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (jComboBox1.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "son $" + jTextField1.getText() + " pesos", "Cuenta", 1);
        } else {
            JOptionPane.showMessageDialog(null, "son $" + Double.parseDouble(jTextField1.getText()) * 16 + " pesos", "Cuenta", 1);
        }
        jButton1.setEnabled(true);
    }
}
