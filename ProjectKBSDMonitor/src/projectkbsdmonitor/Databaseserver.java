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
public class Databaseserver extends Component {
    
    public Databaseserver(boolean status, double uptime, int cpuLoad, double diskSpace ) {
        super("Databaseloadbalancer", status, uptime, cpuLoad, diskSpace);
    }
    
}
