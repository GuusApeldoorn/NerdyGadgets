/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPanels;

import java.awt.Color;
import java.awt.Graphics;
import projectkbsdmonitor.*;
import javax.swing.JPanel;


/**
 *
 * @author Marc
 */
public class JPaneldbl extends JPanel {
    private Monitor m;
    public JPaneldbl(Monitor m) {
        this.m = m;

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int i = 0;
        int y = 0;
        for (Component cp : m.getDatabaseloadbalancerList()) {
            y = m.getSizedbl();
            if (cp.getStatus() == true) {
                i++;
            } else {

            }
        }
        if (i == y) {
            g.setColor(Color.green);
            g.drawOval(0, 0, 27, 27);
            g.fillOval(0, 0, 27, 27);
        } else if ((i > 0) && (i < y)) {
            g.setColor(Color.orange);
            g.drawOval(0, 0, 27, 27);
            g.fillOval(0, 0, 27, 27);
        } else {
            g.setColor(Color.red);
            g.drawOval(0, 0, 27, 27);
            g.fillOval(0, 0, 27, 27);
        }
    }
}

