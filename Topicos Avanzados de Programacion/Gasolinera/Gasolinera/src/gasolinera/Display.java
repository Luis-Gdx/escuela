/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gasolinera;

/**
 *
 * @author lg269
 */
public class Display implements Runnable {

    Thread thread;

    public Display() {
        thread = new Thread(this, "Display");
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
