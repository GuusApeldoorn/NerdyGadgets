/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rekenuit_backtrackingtest;

import java.io.File;

/**
 *
 * @author Gerrit
 */
public class Rekenuit_backtrackingTest {

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
    private double macht = 1.0, macht2 = 1.0;

    //loop int
    private int loop_int = 1;

    //prijs van infrastructuur
    private int prijs = 0;

    //antwoord gevonden
    private boolean gevonden;

    //uitkomsten
//    private File uitkomsten = new File("C:\\Users\\Gerrit\\Desktop", "uitkomsten.txt");
    public Rekenuit_backtrackingTest() {

        for (int i = 0; i < loop_int; i++) {
            
            System.out.println("Momenteel: " + macht + " databaseserver(s). en " + macht2 + " webserver(s).");
            
            for (double test : combinaties_dbservers) {

                antwoord = ((firewall * dbloadbalancer) * (1 - (Math.pow(1 - test, macht))) * 100); //dit is de meest eenvoudige vorm (dit moet standaard; minimaal 1 dbserver en 1 webserver)
                tussentijds_antwoord[0] = antwoord;

                if (test == 0.90) {
                    prijs = (int) (dbserver1_prijs * macht);
                } else if (test == 0.95) {
                    prijs = (int) (dbserver2_prijs * macht);
                } else if (test == 0.98) {
                    prijs = (int) (dbserver3_prijs * macht);
                }

                for (double test1 : combinaties_webservers) {

                    antwoord = (tussentijds_antwoord[0] * (1 - (Math.pow(1 - test1, macht2))));

                    if (test == 0.80) {
                        prijs += (int) (webserver1_prijs * macht);
                    } else if (test == 0.90) {
                        prijs += (int) (webserver2_prijs * macht);
                    } else if (test == 0.95) {
                        prijs += (int) (webserver3_prijs * macht);
                    }

                    if (antwoord >= beschikbaarheidEis) {
                        System.out.println("===Gevonden!=== " + antwoord + " voor €" + prijs + ",- ===Gevonden!===");
                        gevonden = true;
                        break;
                    } else {
                        System.out.println(antwoord + " voor €" + prijs + ",-");
                    }

                }

            }

            if (gevonden) {
                break;
            } else if (macht == macht2) {
                macht += 1.0;
                loop_int += 1;
                System.out.println("+1 databaseserver.");
            } else {
                macht2 += 1.0;
                loop_int += 1;
                System.out.println("+1 webserver.");
            }

        }

    }

    public static void main(String[] args) {
        Rekenuit_backtrackingTest test = new Rekenuit_backtrackingTest();
    }

}
