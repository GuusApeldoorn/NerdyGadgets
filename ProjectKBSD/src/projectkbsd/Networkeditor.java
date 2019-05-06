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
import javax.swing.*;

/**
 *
 * @author Marc
 */
public class Networkeditor extends JFrame implements ActionListener {
    private Network network;
    private JLabel jlc1; // webserver1
    private JLabel jlc2; // webserver2
    private JLabel jlc3; // webserver3
    private JLabel jlc4; // databaseserver1
    private JLabel jlc5; // databaseserver2
    private JLabel jlc6; // databaseserver3
    private JLabel jlc7; // firewall
    private JLabel jlc8; // databaseloadbalancer
    private JButton jbopti; // optimalistatie (beschikbaarheidspercentage)
    private JButton jbopsl; // opslaan van het ontwerp
    
    public Networkeditor(Network network) {
        this.network = network;
        
        setTitle("Netwerk maken");
        setLayout(new FlowLayout());
        setSize(850, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        jlc1 = new JLabel();
        jlc2 = new JLabel();
        jlc3 = new JLabel();
        jlc4 = new JLabel();
        jlc5 = new JLabel();
        jlc6 = new JLabel();
        jlc7 = new JLabel();
        jlc8 = new JLabel();
        jbopti = new JButton("Optimaliseren");
        jbopsl = new JButton("Opslaan");
        
        add(jlc1);
        add(jlc2);
        add(jlc3);
        add(jlc4);
        add(jlc5);
        add(jlc6);
        add(jlc7);
        add(jlc8);
        add(jbopti);
        add(jbopsl);
        
        MouseListener m1 = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mousePressed(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        
        jlc1.addMouseListener(m1);
        jlc2.addMouseListener(m1);
        jlc3.addMouseListener(m1);
        jlc4.addMouseListener(m1);
        jlc5.addMouseListener(m1);
        jlc6.addMouseListener(m1);
    }

    
    
    
    
    
    
    
    
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
