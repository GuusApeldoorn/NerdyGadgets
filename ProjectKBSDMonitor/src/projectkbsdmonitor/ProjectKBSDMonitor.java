/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectkbsdmonitor;

/**
 *
 * @author Marc
 */
public class ProjectKBSDMonitor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Webserver w1 = new Webserver(true, 5.5, 80, 500);
        Webserver w2 = new Webserver(true, 5.5, 80, 500);
        Webserver w3 = new Webserver(true, 5.5, 80, 500);
        Webserver w4 = new Webserver(true, 5.5, 80, 500);
        
        
        
        Monitor m1 = new Monitor();
        m1.addComponentWebserver(w1);
        m1.addComponentWebserver(w2);
        m1.addComponentWebserver(w3);
        m1.addComponentWebserver(w4);
        Monitoring m01 = new Monitoring(m1);


    }
    
}
