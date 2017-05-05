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
import static gasolinera.Gasolinera.premiumLitros;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author lg269
 */
public class Premium implements Runnable {

    Thread thread;

    public Premium() {
        thread = new Thread(this, "Premium");
    }

    public void run() {
        jButton1.setEnabled(false);
        for (int i = 0; i < ((jComboBox1.getSelectedIndex() == 0) ? litros / 20 : litros); i++) {
            if (Integer.parseInt(premiumLitros.getText()) > 0) {
                premiumLitros.setText("" + (Integer.parseInt(premiumLitros.getText()) - 1));
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
            JOptionPane.showMessageDialog(null, "Tipo de gasolina: Premium\nLitros: " + (litros / 20) + "\nson $" + litros + " pesos",
                    "Cuenta", 1);
        } else {
            JOptionPane.showMessageDialog(null, "Tipo de gasolina: Premium\nLitros: " + litros + "\nson $" + litros * 20 + " pesos", "Cuenta", 1);
        }
        display.setText("");
        jButton1.setEnabled(true);
    }

}
