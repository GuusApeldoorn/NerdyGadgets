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
public class EigenschapComponent {

    private static ArrayList<EigenschapComponent> list;
    private String naam;
    private String customnaam;
    private long prijs;
    private double uptime;
    private static boolean newlist = true;

    public EigenschapComponent(String naam, long prijs, double uptime, String customnaam) {
        this.naam = naam;
        this.prijs = prijs;
        this.uptime = uptime;
        this.customnaam = customnaam;
    }

    public String getNaam() {
        return naam;
    }

    public void clearlist() {
        list.clear();
    }

    public long getPrijs() {
        return prijs;
    }

    public String getCustomNaam() {
        return customnaam;
    }

    public double getUptime() {
        return uptime;
    }

    public void intlist() {
        list = new ArrayList<EigenschapComponent>();

    }

    public void setlist(EigenschapComponent ec) {
        list.add(ec);
    }

    public ArrayList<EigenschapComponent> getlist() {
        return list;
    }

}
