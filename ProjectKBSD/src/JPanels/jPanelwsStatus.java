/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPanels;

import JDialogs.JDialogws;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Gerrit
 */
public class jPanelwsStatus extends JPanel {

    private JDialogws jdws;

    public jPanelwsStatus(JDialogws jdws) {
        this.jdws = jdws;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.red);
        g.drawRect(40, 40, 40, 40);
    }

}
