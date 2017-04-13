/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package realtime;

import controllers.TableList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luis G
 */
public class Permisos implements Runnable {

    TableList tableList;

    public Thread thread;

    public Permisos() {
        thread = new Thread(this);
        //tableList = new TableList();
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(":v");
            //tableList.getGroups();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Permisos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
