/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectkbsd;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author Marc
 */
public class Networkeditor extends JFrame implements ActionListener {

    private ArrayList<EigenschappenComponentDialoog> ecdlist;
    private Network network;
    private int prijs;
    private boolean willClear = false;
    private openComponent componentopen;
    private double antwoord;
    private String path; // pad naar geopende opslaglocaite
    private File savepath; // pad naar gekozen opslaglocatie
    private double beschikbaarheidsPercentage;
    private JLabel jlc7; // firewall
    private JLabel jlc8; // databaseloadbalancer
    private JButton jButton1; //opslaan van het ontwerp
    private JButton jButton2; // optimalistatie (beschikbaarheidspercentage)
    private JButton jButton3; // reset ontwerp
    private JButton jButton4; // openen ontwerp
    private JLabel jLabel1; //databaseserver2
    private JLabel jLabel10; //databaseserver1
    private JLabel jLabel11; //tekst bij databaseserver2
    private JLabel jLabel12; //tekst bij databaseserver3
    private JLabel jLabel13; //databaseloadbalancer
    private JLabel jLabel14; //firewall
    private JLabel jLabel15; //tekst bij databaseloadbalancer
    private JLabel jLabel16; //tekst bij firewall
    private JLabel jLabel17; //webserver2
    private JLabel jLabel18; //webserver3
    private JLabel jLabel19; //tekst bij webserver3
    private JLabel jLabel20; //tekst bij webserver2
    private JLabel jLabel3; //webserver1
    private JLabel jLabel4; //totale kosten
    private JLabel jLabel5; //beschikbaarheidspercentage
    private JLabel jLabel6; //tekst bij databaseserver1
    private JLabel jLabel8; //tekst bij webserver1
    private JLabel jLabel9; //databaseserver3
    private JLabel jLabel2; //tekst
    private JLabel jLabel7; //tekst
    private GraphicNetwork jPanel1;
    private OptimaliserenDialoog od;
    private ArrayList<JLabel> databaseServers3;
    private ArrayList<JLabel> webServers3;
    private ArrayList<JLabel> databaseServers2;
    private ArrayList<JLabel> webServers2;
    private ArrayList<JLabel> databaseServers1;
    private ArrayList<JLabel> webServers1;
    private ArrayList<JLabel> firewall;
    private ArrayList<JLabel> databaseLoadbalancer;
    private int aantalFirewall = 0, aantalDatabaseloadbalancer = 0, aantalWebservers = 0, aantalDatabaseservers = 0;
    private int[] mogelijkhedenGoedOntwerp = new int[6];
    private EigenschappenComponentDialoog ecd;
    private JOptionPane jop;
    private long openPrijs;
    private double openUptime;
    private JDialog jdl;

    public Networkeditor(Network network) {
        //  JSONParser parser = new JSONParser();
        this.network = network;
        ecdlist = new ArrayList<EigenschappenComponentDialoog>();
        databaseServers3 = new ArrayList<JLabel>();
        webServers3 = new ArrayList<JLabel>();
        databaseServers2 = new ArrayList<JLabel>();
        webServers2 = new ArrayList<JLabel>();
        databaseServers1 = new ArrayList<JLabel>();
        webServers1 = new ArrayList<JLabel>();
        firewall = new ArrayList<JLabel>();
        databaseLoadbalancer = new ArrayList<JLabel>();

        initComponents(); //deze methode zorgt voor het aanmaken van de GUI(dus alle JButtons, JTextFields, JLabels, etc.)

        jLabel9.addMouseListener(ml); //databaseserver3
        jLabel18.addMouseListener(ml); //webserver3
        jLabel14.addMouseListener(ml); //firewall
        jLabel13.addMouseListener(ml); //databaseloadbalancer
        jLabel17.addMouseListener(ml); //webserver2
        jLabel1.addMouseListener(ml); //databaseserver2
        jLabel10.addMouseListener(ml); //databaseserver1
        jLabel3.addMouseListener(ml); //webserver1

        setVisible(true);
        setSize(new java.awt.Dimension(1402, 678));
        setLocationRelativeTo(null);

        ecd = new EigenschappenComponentDialoog(this);
        jop = new JOptionPane("Voeg eerst een Firewall en een Databaseloadbalancer toe!", 0);
        jdl = jop.createDialog(this, "Foutmelding");
    }

    MouseListener ml = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (willClear) {
                resetOntwerp();
                willClear = false;
                return;
            } // Kijkt of er een model al gemaakt is, anders clearen bij nieuwe toevoegen
            if (e.getSource() == jLabel10) { //databaseserver1
                try {
                    if (aantalDatabaseservers < 8) {

                        Databaseserver ds = new Databaseserver("HAL9001DB", 0.90, 5100); //moet het op deze manier Marc?
                        ecd.setUptime(ds.availabilityPercentage());
                        ecd.setPrijs(ds.getPrice());
                        ecd.setNaam(ds.getNaam());
                        ecd.setType("databaseServer1");
                        ecd.setVisible(true);

                        if (ecd.getIsClosed() == false) {
                            if (databaseLoadbalancer.isEmpty() == false && firewall.isEmpty() == false) {
                                databaseServers1.add(jLabel10);
                                jPanel1.setDatabaseServers1(databaseServers1);
                                repaint();
                                prijs += ecd.getPrijs();
                                jLabel4.setText("Totale kosten: €" + Integer.toString(prijs) + ",-");
                                aantalDatabaseservers++;
                                calculateAvailabilityPercentage(ecd.getUptime(), 0.95, 0.98, 0.80, 0.90, 0.95);
                                for (EigenschapComponent eg : ecd.getec().getlist()) {
                                    System.out.println(eg.getNaam());
                                    System.out.println("---");
                                }

                            } else {
                                jdl.show();
                            }
                        }
                    }
                } catch (NullPointerException npe) {
                    System.out.print(npe);
                }
            }

            if (e.getSource() == jLabel1) { //databaseserver2
                try {
                    if (aantalDatabaseservers < 8) {
                        Databaseserver ds = new Databaseserver("HAL9002DB", 0.95, 7700); //moet het op deze manier Marc?
                        ecd.setUptime(ds.availabilityPercentage());
                        ecd.setPrijs(ds.getPrice());
                        ecd.setNaam(ds.getNaam());
                        ecd.setType("databaseServer2");
                        ecd.setVisible(true);

                        if (ecd.getIsClosed() == false) {
                            if (databaseLoadbalancer.isEmpty() == false && firewall.isEmpty() == false) {
                                databaseServers2.add(jLabel1);
                                jPanel1.setDatabaseServers2(databaseServers2);
                                repaint();
                                prijs += ecd.getPrijs();
                                jLabel4.setText("Totale kosten: €" + Integer.toString(prijs) + ",-");
                                aantalDatabaseservers++;
                                calculateAvailabilityPercentage(0.90, ecd.getUptime(), 0.98, 0.80, 0.90, 0.95);
                                ecdlist.add(ecd);
                            } else {
                                jdl.show();
                            }
                        }
                    }
                } catch (NullPointerException npe) {
                    System.out.print(npe);
                }
            }

            if (e.getSource() == jLabel9) { //databaseserver3
                try {
                    if (aantalDatabaseservers < 8) {
                        Databaseserver ds = new Databaseserver("HAL9003DB", 0.98, 12200); //moet het op deze manier Marc?
                        ecd.setUptime(ds.availabilityPercentage());
                        ecd.setPrijs(ds.getPrice());
                        ecd.setNaam(ds.getNaam());
                        ecd.setType("databaseServer3");
                        ecd.setVisible(true);

                        if (ecd.getIsClosed() == false) {
                            if (databaseLoadbalancer.isEmpty() == false && firewall.isEmpty() == false) {
                                databaseServers3.add(jLabel9);
                                jPanel1.setDatabaseServers3(databaseServers3);
                                repaint();
                                prijs += ecd.getPrijs();
                                jLabel4.setText("Totale kosten: €" + Integer.toString(prijs) + ",-");
                                aantalDatabaseservers++;
                                calculateAvailabilityPercentage(0.90, 0.95, ecd.getUptime(), 0.80, 0.90, 0.95);

                            } else {
                                jdl.show();
                            }
                        }
                    }
                } catch (NullPointerException npe) {
                    System.out.print(npe);
                }
            }

            if (e.getSource() == jLabel3) { //webserver1
                try {
                    if (aantalWebservers < 8) {
                        Webserver ws = new Webserver("HAL9001W", 0.80, 2200); //moet het op deze manier Marc?
                        ecd.setUptime(ws.availabilityPercentage());
                        ecd.setPrijs(ws.getPrice());
                        ecd.setNaam(ws.getNaam());
                        ecd.setType("webServer1");
                        ecd.setVisible(true);

                        if (ecd.getIsClosed() == false) {
                            if (databaseLoadbalancer.isEmpty() == false && firewall.isEmpty() == false) {
                                webServers1.add(jLabel3);
                                jPanel1.setWebServers1(webServers1);
                                repaint();
                                prijs += ecd.getPrijs();
                                jLabel4.setText("Totale kosten: €" + Integer.toString(prijs) + ",-");
                                aantalWebservers++;
                                System.out.println(ecd.getNaam() + "rrrrrrrrrrrrrrrrrrrrrr");

                            } else {
                                jdl.show();
                            }
                        }
                    }
                } catch (NullPointerException npe) {
                    System.out.print(npe);
                }
            }

            if (e.getSource() == jLabel17) { //webserver2
                try {
                    if (aantalWebservers < 8) {
                        Webserver ws = new Webserver("HAL9002W", 0.90, 3200); //moet het op deze manier Marc?
                        ecd.setUptime(ws.availabilityPercentage());
                        ecd.setPrijs(ws.getPrice());
                        ecd.setNaam(ws.getNaam());
                        ecd.setType("webServer2");
                        ecd.setVisible(true);

                        if (ecd.getIsClosed() == false) {
                            if (databaseLoadbalancer.isEmpty() == false && firewall.isEmpty() == false) {
                                webServers2.add(jLabel17);
                                jPanel1.setWebServers2(webServers2);
                                repaint();
                                prijs += ecd.getPrijs();
                                jLabel4.setText("Totale kosten: €" + Integer.toString(prijs) + ",-");
                                aantalWebservers++;
                                calculateAvailabilityPercentage(0.90, 0.95, 0.98, 0.80, ecd.getUptime(), 0.95);
                                ecdlist.add(ecd);
                            } else {
                                jdl.show();
                            }
                        }
                    }
                } catch (NullPointerException npe) {
                    System.out.print(npe);
                }
            }

            if (e.getSource() == jLabel18) { //webserver3
                try {
                    if (aantalWebservers < 8) {
                        Webserver ws = new Webserver("HAL9003W", 0.95, 5100); //moet het op deze manier Marc?
                        ecd.setUptime(ws.availabilityPercentage());
                        ecd.setPrijs(ws.getPrice());
                        ecd.setNaam(ws.getNaam());
                        ecd.setType("webServer3");
                        ecd.setVisible(true);

                        if (ecd.getIsClosed() == false) {
                            if (databaseLoadbalancer.isEmpty() == false && firewall.isEmpty() == false) {
                                webServers3.add(jLabel18);
                                jPanel1.setWebServers3(webServers3);
                                repaint();
                                prijs += ecd.getPrijs();
                                jLabel4.setText("Totale kosten: €" + Integer.toString(prijs) + ",-");
                                aantalWebservers++;
                                calculateAvailabilityPercentage(0.90, 0.95, 0.98, 0.80, 0.90, ecd.getUptime());
                                ecdlist.add(ecd);

                            } else {
                                jdl.show();
                            }
                        }
                    }
                } catch (NullPointerException npe) {
                    System.out.print(npe);
                }
            }

            if (e.getSource() == jLabel14) { //firewall
                try {
                    if (aantalFirewall < 1) {
                        Firewall fw = new Firewall(0.99999, 2000); //moet het op deze manier Marc?
                        firewall.add(jLabel14);
                        jPanel1.setFirewall(firewall);
                        prijs += fw.getPrice();
                        jLabel4.setText("Totale kosten: €" + Integer.toString(prijs) + ",-");
                        aantalFirewall++;
                        repaint();
                    }
                } catch (NullPointerException npe) {
                    System.out.print(npe);
                }
            }

            if (e.getSource() == jLabel13) { //databaseloadbalancer
                try {
                    if (aantalDatabaseloadbalancer < 1) {
                        Databaseloadbalancer dlb = new Databaseloadbalancer(0.99999, 2000); //moet het op deze manier Marc?
                        databaseLoadbalancer.add(jLabel13);
                        jPanel1.setDatabaseLoadbalancer(databaseLoadbalancer);
                        prijs += dlb.getPrice();
                        jLabel4.setText("Totale kosten: €" + Integer.toString(prijs) + ",-");
                        aantalDatabaseloadbalancer++;
                        repaint();
                    }
                } catch (NullPointerException npe) {
                    System.out.print(npe);
                }
            }
        }

        @Override
        public void mousePressed(MouseEvent e
        ) {

        }

        @Override
        public void mouseReleased(MouseEvent e
        ) {
        }

        @Override
        public void mouseEntered(MouseEvent e
        ) {
        }

        @Override
        public void mouseExited(MouseEvent e
        ) {
        }
    };

    public void saveComponents() {
        JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            savepath = file;
            JOptionPane.showMessageDialog(null, "Ontwerp opgeslagen op " + savepath + ".json");
        }
        int keyCounter = 0;
        boolean isOptimized = false;
        for (int ontwerp : mogelijkhedenGoedOntwerp) { //Check of optimalisatie is gebruikt
            if (ontwerp > 0) { // Als er voor minimaal een server 1 of meerdere zijn, dan...
                isOptimized = true; // kunnen we de indeling opslaan
            }
        }
        if (isOptimized) { //Check of optimalisatie is gebruikt en al doorlopen is
            JSONArray componentList = new JSONArray(); //maak een JSON array voor alle json componenten
            for (int ontwerp : mogelijkhedenGoedOntwerp) { //Loopje om voor iedere key de juiste gegevens toe te voegen. Key 0 = db1, Key 3 = wb1, Key 5 = wb3 enz.
                if (keyCounter == 0 && ontwerp > 0) { //db1
                    for (int i = ontwerp; i > 0; i--) {
                        JSONObject databaseServer1 = new JSONObject();
                        databaseServer1.put("naam", "databaseServer1");
                        databaseServer1.put("aantal", ontwerp);
                        databaseServer1.put("uptime", od.getA().getDbserver1());
                        databaseServer1.put("prijs", od.getA().getDbserver1_prijs());
                        componentList.add(databaseServer1);
                    }
                }
                if (keyCounter == 1 && ontwerp > 0) { //db2
                    for (int i = ontwerp; i > 0; i--) {
                        JSONObject databaseServer2 = new JSONObject();
                        databaseServer2.put("naam", "databaseServer2");
                        databaseServer2.put("aantal", ontwerp);
                        databaseServer2.put("uptime", od.getA().getDbserver2());
                        databaseServer2.put("prijs", od.getA().getDbserver2_prijs());
                        componentList.add(databaseServer2);
                    }
                }
                if (keyCounter == 2 && ontwerp > 0) { //db3
                    for (int i = ontwerp; i > 0; i--) {
                        JSONObject databaseServer3 = new JSONObject();
                        databaseServer3.put("naam", "databaseServer3");
                        databaseServer3.put("aantal", ontwerp);
                        databaseServer3.put("uptime", od.getA().getDbserver3());
                        databaseServer3.put("prijs", od.getA().getDbserver3_prijs());
                        componentList.add(databaseServer3);
                    }
                }
                if (keyCounter == 3 && ontwerp > 0) { //wb1
                    for (int i = ontwerp; i > 0; i--) {
                        JSONObject webServer1 = new JSONObject();
                        webServer1.put("naam", "webServer1");
                        webServer1.put("aantal", ontwerp);
                        webServer1.put("uptime", od.getA().getWebserver1());
                        webServer1.put("prijs", od.getA().getWebserver1_prijs());
                        componentList.add(webServer1);
                    }
                }
                if (keyCounter == 4 && ontwerp > 0) {//wb2
                    for (int i = ontwerp; i > 0; i--) {
                        JSONObject webServer2 = new JSONObject();
                        webServer2.put("naam", "webServer2");
                        webServer2.put("aantal", ontwerp);
                        webServer2.put("uptime", od.getA().getWebserver2());
                        webServer2.put("prijs", od.getA().getWebserver2_prijs());
                        componentList.add(webServer2);
                    }
                }
                if (keyCounter == 5 && ontwerp > 0) { //wb3
                    for (int i = ontwerp; i > 0; i--) {
                        JSONObject webServer3 = new JSONObject();
                        webServer3.put("naam", "webServer3");
                        webServer3.put("aantal", ontwerp);
                        webServer3.put("uptime", od.getA().getWebserver3());
                        webServer3.put("prijs", od.getA().getWebserver3_prijs());
                        componentList.add(webServer3);
                    }

                }

                keyCounter++;
            }
            try (FileWriter file = new FileWriter(savepath + ".json")) { //Maak het bestand *json

                file.write(componentList.toJSONString());
                file.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else { // handgemaakt ontwerp

            JSONArray componentList = new JSONArray();
            for (EigenschapComponent egc : ecd.getec().getlist()) {
                JSONObject obj = new JSONObject();

                obj.put("naam", egc.getNaam());
                obj.put("customnaam", egc.getCustomNaam());
                obj.put("uptime", egc.getUptime());
                obj.put("prijs", egc.getPrijs());
                componentList.add(obj);
            }
            try (FileWriter file = new FileWriter(savepath + ".json")) { //Maak het bestand *json

                file.write(componentList.toJSONString());
                file.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    } // voor het ontwerp op te slaan als json > button3

    public void openJsonFile() { // om het json bestand te openen als ontwerp > button4

        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        int returnValue = jfc.showOpenDialog(null);
        // int returnValue = jfc.showSaveDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            willClear = true;
            File selectedFile = jfc.getSelectedFile();
            path = selectedFile.getAbsolutePath();

            JSONParser parser = new JSONParser();

            try {
                JSONArray a = (JSONArray) parser.parse(new FileReader(path));
                boolean arrayInitialised = true;
                for (Object o : a) {
                    JSONObject ontwerp = (JSONObject) o;

                    String naam = (String) ontwerp.get("naam");

                    long openPrijs = (long) ontwerp.get("prijs");

                    double openUptime = (double) ontwerp.get("uptime");

                    openComponent componentopen = new openComponent(naam, openPrijs, openUptime);
                    if (arrayInitialised) {
                        componentopen.flushArray();
                        arrayInitialised = false;
                    }
                    componentopen.addComponentList(componentopen);
                    this.componentopen = componentopen;

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
//        resetOntwerp();
            jLabel4.setText("Totale kosten: €0,-");
            jLabel5.setText("Beschikbaarheidspercentage: 0.0%");
            prijs = 0;
            try {
                ecd.getec().clearlist();
            } catch (Exception e) {
                
            }
            aantalFirewall = 0;
            aantalDatabaseservers = 0;
            aantalWebservers = 0;
            aantalDatabaseloadbalancer = 0;
            databaseServers1.clear();
            databaseServers2.clear();
            databaseServers3.clear();
            webServers1.clear();
            webServers2.clear();
            webServers3.clear();
            firewall.clear();
            databaseLoadbalancer.clear();
            repaint();

            double uptimedb1 = 1;
            double uptimedb2 = 1;
            double uptimedb3 = 1;
            double uptimewb1 = 1;
            double uptimewb2 = 1;
            double uptimewb3 = 1;
            for (openComponent cpn : componentopen.getComponentList()) {
                if (cpn.getNaam().equals("databaseServer1")) {
                    

                    databaseServers1.add(jLabel10);
                    jPanel1.setDatabaseServers1(databaseServers1);
                    repaint();

                    prijs += cpn.getPrijs(); //cpn.getPrijs()
                    jLabel4.setText("Totale kosten: €" + prijs);
                    uptimedb1 = uptimedb1 * (1 - cpn.getUptime());
                   
                }

                if (cpn.getNaam().equals("databaseServer2")) {
                  
                    databaseServers2.add(jLabel1);
                    jPanel1.setDatabaseServers2(databaseServers2);
                    repaint();
                    prijs += cpn.getPrijs(); //cpn.getPrijs()
                    jLabel4.setText("Totale kosten: €" + prijs);
                    uptimedb2 = uptimedb2 * (1 - cpn.getUptime());
                }

                if (cpn.getNaam().equals("databaseServer3")) {
                  
                    databaseServers3.add(jLabel9);
                    jPanel1.setDatabaseServers3(databaseServers3);
                    repaint();
                    prijs += cpn.getPrijs(); //cpn.getPrijs()
                    jLabel4.setText("Totale kosten: €" + prijs);
                    uptimedb3 = uptimedb3 * (1 - cpn.getUptime());
                }
                if (cpn.getNaam().equals("webServer1")) {

                 
                    webServers1.add(jLabel3);
                    jPanel1.setWebServers1(webServers1);
                    repaint();
                    prijs += cpn.getPrijs(); //cpn.getPrijs()
                    jLabel4.setText("Totale kosten: €" + prijs);
                    uptimewb1 = uptimewb1 * (1 - cpn.getUptime());
                }
                if (cpn.getNaam().equals("webServer2")) {
                
                    webServers2.add(jLabel17);
                    jPanel1.setWebServers2(webServers2);
                    repaint();
                    prijs += cpn.getPrijs(); //cpn.getPrijs()
                    jLabel4.setText("Totale kosten: €" + prijs);
                    uptimewb2 = uptimewb2 * (1 - cpn.getUptime());
                }
                if (cpn.getNaam().equals("webServer3")) {
               
                    webServers3.add(jLabel18);
                    jPanel1.setWebServers3(webServers3);
                    repaint();
                    prijs += cpn.getPrijs(); //cpn.getPrijs()
                    jLabel4.setText("Totale kosten: €" + prijs);
                    uptimewb3 = uptimewb3 * (1 - cpn.getUptime());
                }

            }
            Firewall fw = new Firewall(0.99999, 2000); // voeg in het model de FW toe
            firewall.add(jLabel14);
            jPanel1.setFirewall(firewall);
            prijs += fw.getPrice();

            Databaseloadbalancer dlb = new Databaseloadbalancer(0.99999, 2000); //Voeg in het model de LB toe
            databaseLoadbalancer.add(jLabel13);
            jPanel1.setDatabaseLoadbalancer(databaseLoadbalancer);
            prijs += dlb.getPrice();
            repaint();
            jLabel4.setText("Totale kosten: €" + prijs);
            double availability = 100 * 0.99999 * 0.99999 * (1 - (uptimedb1 * uptimedb2 * uptimedb3)) * (1 - (uptimewb1 * uptimewb2 * uptimewb3));
            jLabel5.setText("Beschikbaarheidspercentage: " + availability);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e
    ) {
        if (e.getSource() == jButton1) { //opslaan ontwerp
            BufferedImage image = new BufferedImage(jPanel1.getWidth(), jPanel1.getHeight(), BufferedImage.TYPE_INT_RGB);
            Graphics2D g = image.createGraphics();
            jPanel1.printAll(g);
            g.dispose();
            saveComponents();
            try {
                ImageIO.write(image, "jpg", new File("Ontwerp.jpg"));
                ImageIO.write(image, "png", new File("Ontwerp.png"));
            } catch (IOException exp) {
                exp.printStackTrace();
            }
        }

        if (e.getSource() == jButton2) { //optimaliseren ontwerp
            resetOntwerp();
            OptimaliserenDialoog od = new OptimaliserenDialoog(this);
            this.od = od;
            mogelijkhedenGoedOntwerp = od.getMogelijkhedenGoedOntwerp();
            jLabel4.setText("Totale kosten: €" + od.getPrijs() + ",-");
            jLabel5.setText("Beschikbaarheidspercentage: " + od.getAvailabilityPercentage() + "%");
            willClear = true;

            if (od.getCancelIngedrukt() == false) {
                try { //databaseserver1
                    Databaseserver ds = new Databaseserver("HAL9001DB", 0.90, 5100); //moet het op deze manier Marc?
                    int loop = mogelijkhedenGoedOntwerp[0];
                    for (int i = 0; i < loop; i++) {
                        databaseServers1.add(jLabel10);
                    }
                    jPanel1.setDatabaseServers1(databaseServers1);
                    repaint();
                } catch (NullPointerException npe) {
                    System.out.print(npe);
                }

                try { //databaseserver2
                    Databaseserver ds = new Databaseserver("HAL9002DB", 0.95, 7700); //moet het op deze manier Marc?
                    int loop = mogelijkhedenGoedOntwerp[1];
                    for (int i = 0; i < loop; i++) {
                        databaseServers2.add(jLabel1);
                    }
                    jPanel1.setDatabaseServers2(databaseServers2);
                    repaint();
                } catch (NullPointerException npe) {
                    System.out.print(npe);
                }

                try { //databaseserver3
                    Databaseserver ds = new Databaseserver("HAL9003DB", 0.98, 12200); //moet het op deze manier Marc?
                    int loop = mogelijkhedenGoedOntwerp[2];
                    for (int i = 0; i < loop; i++) {
                        databaseServers3.add(jLabel9);
                    }
                    jPanel1.setDatabaseServers3(databaseServers3);
                    repaint();
                } catch (NullPointerException npe) {
                    System.out.print(npe);
                }

                try { //webserver1
                    Webserver ws = new Webserver("HAL9001W", 0.80, 2200); //moet het op deze manier Marc?
                    int loop = mogelijkhedenGoedOntwerp[3];
                    for (int i = 0; i < loop; i++) {
                        webServers1.add(jLabel3);
                    }
                    jPanel1.setWebServers1(webServers1);
                    repaint();
                } catch (NullPointerException npe) {
                    System.out.print(npe);
                }

                try { //webserver2
                    Webserver ws = new Webserver("HAL9002W", 0.90, 3200); //moet het op deze manier Marc?
                    int loop = mogelijkhedenGoedOntwerp[4];
                    for (int i = 0; i < loop; i++) {
                        webServers2.add(jLabel17);
                    }
                    jPanel1.setWebServers2(webServers2);
                    repaint();
                } catch (NullPointerException npe) {
                    System.out.print(npe);
                }

                try { //webserver3
                    Webserver ws = new Webserver("HAL9003W", 0.95, 5100); //moet het op deze manier Marc?
                    int loop = mogelijkhedenGoedOntwerp[5];
                    for (int i = 0; i < loop; i++) {
                        webServers3.add(jLabel18);
                    }
                    jPanel1.setWebServers3(webServers3);
                    repaint();
                } catch (NullPointerException npe) {
                    System.out.print(npe);
                }

                try { //firewall
                    Firewall fw = new Firewall(0.99999, 2000); //moet het op deze manier Marc?
                    firewall.add(jLabel14);
                    jPanel1.setFirewall(firewall);
                    repaint();
                } catch (NullPointerException npe) {
                    System.out.print(npe);
                }

                try { //databaseloadbalancer
                    Databaseloadbalancer dlb = new Databaseloadbalancer(0.99999, 2000); //moet het op deze manier Marc?
                    databaseLoadbalancer.add(jLabel13);
                    jPanel1.setDatabaseLoadbalancer(databaseLoadbalancer);
                    repaint();
                } catch (NullPointerException npe) {
                    System.out.print(npe);
                }
            }
        }

        if (e.getSource() == jButton3) { //reset ontwerp
            resetOntwerp();
        }

        if (e.getSource() == jButton4) { // open json file ontwerp
            openJsonFile();
        }

    }

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new GraphicNetwork();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Java Applicatie");
        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1500, 600));
        setResizable(false);

        jLabel1.setIcon(new javax.swing.ImageIcon("databaseserver2.png")); // NOI18N

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 873, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 560, Short.MAX_VALUE)
        );

        jLabel4.setText("Totale kosten:");

        jLabel5.setText("Beschikbaarheidspercentage:");

        jButton1.setText("Ontwerp opslaan");
        jButton1.addActionListener(this);

        jButton2.setText("Optimaliseren");
        jButton2.addActionListener(this);

        jLabel6.setText("HAL9001DB (€5100,-)");

        jLabel9.setIcon(new javax.swing.ImageIcon("databaseserver3.png")); // NOI18N

        jLabel10.setIcon(new javax.swing.ImageIcon("databaseserver1.png")); // NOI18N

        jLabel11.setText("HAL9002DB (€7700,-)");

        jLabel12.setText("HAL9003DB (€12200,-)");

        jLabel14.setIcon(new javax.swing.ImageIcon("firewall.png")); // NOI18N

        jLabel15.setText("DBLoadBalancer (€2000,-)");

        jLabel16.setText("Firewall (€2000,-)");

        jLabel13.setIcon(new javax.swing.ImageIcon("databaseloadbalancer.png")); // NOI18N

        jLabel17.setIcon(new javax.swing.ImageIcon("webserver2.png")); // NOI18N

        jLabel8.setText("HAL9001W (€2200,-)");

        jLabel3.setIcon(new javax.swing.ImageIcon("webserver1.png")); // NOI18N

        jLabel20.setText("HAL9002W (€3200,-)");

        jLabel18.setIcon(new javax.swing.ImageIcon("webserver3.png")); // NOI18N

        jLabel19.setText("HAL9003W (€5100,-)");

        jButton3.setText("Reset ontwerp");
        jButton3.addActionListener(this);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("Klik op de icons hierboven om een component toe te voegen aan het panel");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel7.setText("Gemaakt door BrogrammersV2");

        jButton4.setText("Openen ontwerp");
        jButton4.addActionListener(this);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel6)
                                                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(24, 24, 24)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel1)
                                                                        .addComponent(jLabel11)))
                                                        .addComponent(jLabel8))
                                                .addGap(33, 33, 33)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(24, 24, 24)
                                                                .addComponent(jLabel12))
                                                        .addComponent(jLabel9)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addGap(16, 16, 16)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel19)
                                                                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(16, 16, 16))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jLabel14)
                                                        .addComponent(jLabel16))
                                                .addGap(42, 42, 42)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel20)
                                                        .addComponent(jLabel17)
                                                        .addComponent(jLabel13)
                                                        .addComponent(jLabel15)))
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel7))
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel5)
                                                        .addComponent(jLabel4))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButton2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton4))
                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel17)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jLabel10)
                                                                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                                                                        .addComponent(jLabel9))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(jLabel6)
                                                                        .addComponent(jLabel11)
                                                                        .addComponent(jLabel12))
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(70, 70, 70)
                                                                                .addComponent(jLabel3))
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jLabel18)))))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel8)
                                                        .addComponent(jLabel19)
                                                        .addComponent(jLabel20))
                                                .addGap(46, 46, 46)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel14)
                                                        .addComponent(jLabel13))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel16)
                                                        .addComponent(jLabel15))
                                                .addGap(51, 51, 51)
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel7))
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel5))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jButton2)
                                                .addComponent(jButton3)
                                                .addComponent(jButton1)
                                                .addComponent(jButton4)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1420, 679));
        setLocationRelativeTo(null);
    }// </editor-fold>               

    private void calculateAvailabilityPercentage(double db1, double db2, double db3, double web1, double web2, double web3) {
        if ((databaseServers1.isEmpty() == true && databaseServers2.isEmpty() == true && databaseServers3.isEmpty() == true) || (webServers1.isEmpty() == true && webServers2.isEmpty() == true && webServers3.isEmpty() == true)) {
            jLabel5.setText("Beschikbaarheidspercentage: 0.0%");
        } else {
            double lengteDb1 = databaseServers1.size();
            double lengteDb2 = databaseServers2.size();
            double lengteDb3 = databaseServers3.size();
            double lengteWeb1 = webServers1.size();
            double lengteWeb2 = webServers2.size();
            double lengteWeb3 = webServers3.size();
            antwoord = ((0.99999 * 0.99999) * (1 - ((Math.pow(1 - db1, lengteDb1)) * (Math.pow(1 - db2, lengteDb2)) * (Math.pow(1 - db3, lengteDb3)))) * ((1 - ((Math.pow(1 - web1, lengteWeb1)) * (Math.pow(1 - web2, lengteWeb2)) * (Math.pow(1 - web3, lengteWeb3)))) * 100));
            jLabel5.setText("Beschikbaarheidspercentage: " + antwoord + "%");
        }
    }

    private void resetOntwerp() { //deze methode maakt het hele JPanel leeg en de bijbehorende attributen
        jPanel1.setResetPanel(true);
        jLabel4.setText("Totale kosten: €0,-");
        jLabel5.setText("Beschikbaarheidspercentage: 0.0%");
        prijs = 0;
        aantalFirewall = 0;
        aantalDatabaseservers = 0;
        aantalWebservers = 0;
        aantalDatabaseloadbalancer = 0;
        databaseServers1.clear();
        databaseServers2.clear();
        databaseServers3.clear();
        webServers1.clear();
        webServers2.clear();
        webServers3.clear();
        firewall.clear();
        databaseLoadbalancer.clear();
        if (ecd.getec() == null) { //Clear de lijst met handgeselecteerde componenten alleen wanneer arraylist al bestaat (als je optimized voordat je een component selecteerd bestaat de arraylist niet en geeft dit een error)
        } else {
            ecd.getec().clearlist();
        }

        repaint();
    }
}
