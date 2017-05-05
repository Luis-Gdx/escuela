/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gasolinera;

import static gasolinera.Gasolinera.display;
import static gasolinera.Gasolinera.jButton1;
import static gasolinera.Gasolinera.jComboBox1;
import static gasolinera.Gasolinera.litros;
import static gasolinera.Gasolinera.magnaLitros;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis G
 */
public class Magna implements Runnable {

    Thread thread;

    public Magna() {
        thread = new Thread(this, "Magna");
    }

    public void run() {
        jButton1.setEnabled(false);
        for (int i = 0; i < ((jComboBox1.getSelectedIndex() == 0) ? litros / 16 : litros); i++) {
            if (Integer.parseInt(magnaLitros.getText()) > 0) {
                magnaLitros.setText("" + (Integer.parseInt(magnaLitros.getText()) - 1));
                if (jComboBox1.getSelectedIndex() == 1) {
                    display.setText("" + (Integer.parseInt(display.getText()) - 1));
                }
            } else {
                JOptionPane.showMessageDialog(null, "Se acabo la gasolina :'v", "Se acabo xd", 0);
                break;
            }
            try {
                Thread.sleep(75);
            } catch (InterruptedException ex) {
                Logger.getLogger(Magna.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (jComboBox1.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Tipo de gasolina: Magna\nLitros: " + (litros / 16) + "\nson $" + litros + " pesos", "Cuenta", 1);
        } else {
            JOptionPane.showMessageDialog(null, "Tipo de gasolina: Magna\nLitros: " + litros + "\nson $" + litros * 16 + " pesos", "Cuenta", 1);
        }
        display.setText("");
        jButton1.setEnabled(true);
    }
}
