/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package realtime;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luis G
 */
public class UserList implements Runnable {

    public Thread thread;

    public UserList() {
        thread = new Thread(this);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(UserList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
