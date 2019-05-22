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
public abstract class Component {

    private String serverName;
    private boolean status;
    private double uptime;
    private int cpuLoad;
    private double diskSpace;

    public Component(String serverName, boolean status, double uptime, int cpuLoad, double diskSpace) {
        this.serverName = serverName;
        this.status = status;
        this.uptime = cpuLoad;
        this.diskSpace = diskSpace;
    }
    
    public String getServerName() {
        return this.serverName;
    }
    
    public boolean getStatus() {
        return this.status;
    }
    
    public double getUptime() {
        return this.uptime;
    }
    
    public int getCpuLoad() {
        return this.cpuLoad;
    }
    
    public double getDiskSpace() {
        return this.diskSpace;
    }
    
    
    
}
