/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectkbsd;

/**
 *
 * @author Marc
 */
public abstract class Component {
    private String serverName;
    private double availabilityPercentage;
    private int price;
    
    public Component(String serverName, double availabilityPercentage, int price){
        this.serverName = serverName;
        this.availabilityPercentage = availabilityPercentage;
        this.price = price;
    }
    
    public String getServerName(){
        return this.serverName;
    }
    
    public double availabilityPercentage(){
        return this.availabilityPercentage;
    }
    
    public int getPrice(){
        return this.price;
    }
}


