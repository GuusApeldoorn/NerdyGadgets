/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectkbsd;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Gerrit
 */
public class GraphicNetwork extends JPanel {

    private BufferedImage imageDatabaseServer3; //databaseserver3 foto
    private BufferedImage imageWebserver3; //webserver3 foto
    private BufferedImage imageDatabaseServer2; //databaseserver2 foto
    private BufferedImage imageWebserver2; //webserver2 foto
    private BufferedImage imageDatabaseServer1; //databaseserver1 foto
    private BufferedImage imageWebserver1; //webserver1 foto
    private BufferedImage imageFirewall; //firewall foto
    private BufferedImage imageDatabaseLoadbalancer; //databaseloadbalancer foto
    private ArrayList<JLabel> databaseServers3;
    private ArrayList<JLabel> webServers3;
    private ArrayList<JLabel> databaseServers2;
    private ArrayList<JLabel> webServers2;
    private ArrayList<JLabel> databaseServers1;
    private ArrayList<JLabel> webServers1;
    private ArrayList<JLabel> firewall;
    private ArrayList<JLabel> databaseLoadbalancer;
    private JLabel test, test1;
    private boolean resetPanel;

    public GraphicNetwork() {

        databaseServers3 = new ArrayList<JLabel>();
        webServers3 = new ArrayList<JLabel>();
        databaseServers2 = new ArrayList<JLabel>();
        webServers2 = new ArrayList<JLabel>();
        databaseServers1 = new ArrayList<JLabel>();
        webServers1 = new ArrayList<JLabel>();
        firewall = new ArrayList<JLabel>();
        databaseLoadbalancer = new ArrayList<JLabel>();
        test = new JLabel();
        test1 = new JLabel();

        setBackground(new java.awt.Color(153, 153, 153));

        try {
            imageDatabaseServer3 = ImageIO.read(new File("databaseserver3.png"));
            imageWebserver3 = ImageIO.read(new File("webserver3.png"));
            imageDatabaseServer2 = ImageIO.read(new File("databaseserver2.png"));
            imageWebserver2 = ImageIO.read(new File("webserver2.png"));
            imageDatabaseServer1 = ImageIO.read(new File("databaseserver1.png"));
            imageWebserver1 = ImageIO.read(new File("webserver1.png"));
            imageFirewall = ImageIO.read(new File("firewall.png"));
            imageDatabaseLoadbalancer = ImageIO.read(new File("databaseloadbalancer.png"));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.yellow);

        int aantalFirewall = 0;

        for (JLabel jl : firewall) {
            if (aantalFirewall < 1) {
                g.drawImage(imageFirewall, 0, 250, this);
            }
            aantalFirewall++;
            test = jl;
        }

        int y3 = 20;
        int y4 = 20;
        int aantalWebServers = 0;

        for (JLabel jl : webServers1) {
            if (aantalWebServers < 8) {
                g.drawImage(imageWebserver1, 160, y3, this);
                g.setColor(Color.BLACK);
                g.drawLine(160, y3 + 31, 84, 281);
                g.drawLine(265, y3 + 31, 360, 281);
                y3 += 65;
            }
            aantalWebServers++;
        }

        for (JLabel jl : webServers2) {
            if (aantalWebServers < 8) {
                g.drawImage(imageWebserver2, 160, y3, this);
                g.setColor(Color.BLACK);
                g.drawLine(160, y3 + 31, 84, 281);
                g.drawLine(265, y3 + 31, 360, 281);
                y3 += 65;
            }
            aantalWebServers++;
        }

        for (JLabel jl : webServers3) {
            if (aantalWebServers < 8) {
                g.drawImage(imageWebserver3, 160, y3, this);
                g.setColor(Color.BLACK);
                g.drawLine(160, y3 + 31, 84, 281);
                g.drawLine(265, y3 + 31, 360, 281);
                y3 += 65;
            }
            aantalWebServers++;
        }

        int aantalDatabaseLoadbalancer = 0;

        for (JLabel jl : databaseLoadbalancer) {
            if (aantalDatabaseLoadbalancer < 1) {
                g.drawImage(imageDatabaseLoadbalancer, 360, 250, this);
            }
            aantalDatabaseLoadbalancer++;
            test1 = jl;
        }

        int y1 = 20;
        int y2 = 20;
        int aantalDatabaseServers = 0;

        for (JLabel jl : databaseServers1) {
            if (aantalDatabaseServers < 8) {
                g.drawImage(imageDatabaseServer1, 520, y1, this);
                g.setColor(Color.BLACK);
                g.drawLine(520, y1 + 31, 445, 281);
                y1 += 65;
            }
            aantalDatabaseServers++;
        }

        for (JLabel jl : databaseServers2) {
            if (aantalDatabaseServers < 8) {
                g.drawImage(imageDatabaseServer2, 520, y1, this);
                g.setColor(Color.BLACK);
                g.drawLine(520, y1 + 31, 445, 281);
                y1 += 65;
            }
            aantalDatabaseServers++;
        }

        for (JLabel jl : databaseServers3) {
            if (aantalDatabaseServers < 8) {
                g.drawImage(imageDatabaseServer3, 520, y1, this);
                g.setColor(Color.BLACK);
                g.drawLine(520, y1 + 31, 445, 281);
                y1 += 65;
            }
            aantalDatabaseServers++;
        }

        if (resetPanel == true) {
            g.setColor(new java.awt.Color(153, 153, 153));
            g.drawRect(0, 0, 892, 370); //jPanel1 is 892 width en 370 height
            g.fillRect(0, 0, 892, 370); //jPanel1 is 892 width en 370 height
            resetPanel = false;
        }

//        g.drawLine(test.getX(), test.getY(), test1.getX(), test1.getY());
//        g.setColor(Color.black);
//        g.drawLine(80, 181, 360, 181);
    }

    public void setDatabaseServers1(ArrayList al) {
        databaseServers1 = al;
    }

    public void setDatabaseServers2(ArrayList al) {
        databaseServers2 = al;
    }

    public void setDatabaseServers3(ArrayList al) {
        databaseServers3 = al;
    }

    public void setWebServers1(ArrayList al) {
        webServers1 = al;
    }

    public void setWebServers2(ArrayList al) {
        webServers2 = al;
    }

    public void setWebServers3(ArrayList al) {
        webServers3 = al;
    }

    public void setFirewall(ArrayList al) {
        firewall = al;
    }

    public void setDatabaseLoadbalancer(ArrayList al) {
        databaseLoadbalancer = al;
    }

    public void setResetPanel(boolean reset) {
        resetPanel = reset;
    }

    public ArrayList getdatabaseServers1() {
        return databaseServers1;
    }
}
