/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectkbsdmonitor;

import java.util.ArrayList;

/**
 *
 * @author Marc
 */
public class Monitor {
    private ArrayList<Component> webserverList;
    private ArrayList<Component> databaseserverList;
    private ArrayList<Component> databaseloadbalancerList;
    private ArrayList<Component> firewallList;
    
    public Monitor(){
        this.webserverList = new ArrayList<Component>();
        this.databaseserverList = new ArrayList<Component>();
        this.databaseloadbalancerList = new ArrayList<Component>();
        this.firewallList = new ArrayList<Component>();
    }
    
    // toevoegen component aan hoofdscherm om te kunnen slepen.
    public void addComponentWebserver(Component cn) {
        this.webserverList.add(cn);
    }
    
    public void addComponentDatabaseserver(Component cn) {
        this.databaseserverList.add(cn);
    }
    
    public void addComponentDatabaseloadbalancer(Component cn) {
        this.databaseloadbalancerList.add(cn);
    }
    
    public void addComponentFirewall(Component cn) {
        this.firewallList.add(cn);
    }

    public ArrayList<Component> getWebserverList() {
        return webserverList;
    }

    public ArrayList<Component> getDatabaseserverList() {
        return databaseserverList;
    }

    public ArrayList<Component> getDatabaseloadbalancerList() {
        return databaseloadbalancerList;
    }

    public ArrayList<Component> getFirewallList() {
        return firewallList;
    }
    
    public int getSizews() {
        return webserverList.size();
    }
    
    public int getSizedbs() {
        return databaseserverList.size();
    }
    
    public int getSizefw() {
        return databaseloadbalancerList.size();
    }
    
    public int getSizedbl() {
        return firewallList.size();
    }
    
}
