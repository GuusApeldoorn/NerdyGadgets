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
public class Webserver extends Component {

    private double availability;
    private int price;
    private String naam;

    public Webserver(String naam, double availability, int price) {
        super("Webserver", availability, price);
        this.availability = availability;
        this.price = price;
        this.naam = naam;
    }

    public double getAvailability() {
        return this.availability;
    }

    public int getPrice() {
        return this.price;
    }

    public String getNaam() {
        return this.naam;
    }
}
