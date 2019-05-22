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
public class Firewall extends Component {

    private double availability;
    private int price;

    public Firewall(double availability, int price) {
        super("Firewall", availability, price);
        this.availability = availability;
        this.price = price;
    }

    public double getAvailability() {
        return this.availability;
    }

    public int getPrice() {
        return this.price;
    }
}
