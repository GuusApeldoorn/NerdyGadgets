/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectkbsd;

import java.util.ArrayList;

/**
 *
 * @author stefa
 */
public class openComponent {
    private static ArrayList<openComponent> componentlist;
    private String naam;
    private long prijs;
    private double uptime;

    public openComponent(String naam, long prijs, double uptime) {
       
        this.naam = naam;
        this.prijs = prijs;
        this.uptime = uptime;
    }
    
    public void addComponentList(openComponent oc) {
        componentlist.add(oc);
        
    }
    
    public ArrayList<openComponent> getComponentList() {
        return componentlist;
    }
    
    public String getNaam() {
        return naam;
    }
    
    public long getPrijs() {
        return prijs;
    }
    
    public double getUptime() {
        return uptime;
    }
    
    public void flushArray() {
        this.componentlist = new ArrayList<openComponent>();
    }
    public String toString() {
        return "naam: " + naam + " prijs: " + prijs + " uptime: " + uptime;
    }
}
