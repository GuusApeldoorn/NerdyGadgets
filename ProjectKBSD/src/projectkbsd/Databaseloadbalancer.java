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
public class Databaseloadbalancer extends Component {

    private double availability;
    private int price;

    public Databaseloadbalancer(double availability, int price) {
        super("Databaseloadbalancer", availability, price);
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
