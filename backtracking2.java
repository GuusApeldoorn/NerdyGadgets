/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rekenuit_backtrackingtest;

/**
 *
 * @author Gerrit
 */
public class backtracking2 {

    //beschikbaarheden
    private static final double beschikbaarheidEis = 99.99, firewall = 0.99999, dbloadbalancer = 0.99999; //beschikbaarheid van de firewall en databaseloadbalancer
    private static final double dbserver1 = 0.90, dbserver2 = 0.95, dbserver3 = 0.98;                     //beschikbaarheid van de databaseservers
    private static final double webserver1 = 0.80, webserver2 = 0.90, webserver3 = 0.95;                  //beschikbaarheid webservers

    //prijzen
    private static final int firewall_prijs = 2000, dbloadbalancer_prijs = 2000;                          //prijzen van de firewall en databaseloadbalancer
    private static final int dbserver1_prijs = 5100, dbserver2_prijs = 7700, dbserver3_prijs = 12200;     //prijzen van de databaseservers
    private static final int webserver1_prijs = 2200, webserver2_prijs = 3200, webserver3_prijs = 5100;   //prijzen van de webservers

    //array met combinaties
    private double[] combinaties_dbservers = {dbserver1, dbserver2, dbserver3};
    private double[] combinaties_webservers = {webserver1, webserver2, webserver3};
    private double[] tussentijds_antwoord = new double[2]; //plek 1 voor tussentijds antwoord dbserver, plek 2 voor tussentijds antwoord webserver.

    //antwoord
    private double antwoord;

    //tot de macht
    private double macht1 = 3.0, macht2 = 1.0, macht3 = 0.0, macht4 = 1.0, macht5 = 4.0, macht6 = 0.0;

    //loop int
    private int loop_int = 1, a_loop = 0, b_loop = 1, c_loop = 0;

    //prijs van infrastructuur
    private int prijs = 0;

    //antwoord gevonden
    private boolean gevonden;

    public backtracking2() {
        
        antwoord = ((firewall * dbloadbalancer) * (1 - ((Math.pow(1 - dbserver1, macht1)) * (Math.pow(1 - dbserver2, macht2)) * (Math.pow(1 - dbserver3, macht3)))) * 
                ((1 - ((Math.pow(1 - webserver1, macht4)) * (Math.pow(1 - webserver2, macht5)) * (Math.pow(1 - webserver3, macht6)))) * 100));
        
        prijs = (int) ((firewall_prijs + dbloadbalancer_prijs) + (dbserver1_prijs * macht1) + (dbserver2_prijs * macht2) + (dbserver3_prijs * macht3) + 
                (webserver1_prijs * macht4) + (webserver2_prijs * macht5) + (webserver3_prijs * macht6));
        
        System.out.println(antwoord + "% voor €" + prijs + ",-");
    }

}
