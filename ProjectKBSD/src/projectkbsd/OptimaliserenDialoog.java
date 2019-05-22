/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectkbsd;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author Gerrit
 */
public class OptimaliserenDialoog extends JDialog implements ActionListener {

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1, jLabelError;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    private Algorithm a;
    private int antwoord1;
    private double beschikbaarheidsPercentage;
    private int[] mogelijkhedenGoedOntwerp = new int[6];
    private boolean cancelGedrukt = false;

    public OptimaliserenDialoog(JFrame frame) {
        super(frame, true);
        initComponents();
        setVisible(true);
    }

    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabelError = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Optimaliseren Dialoog");
        setResizable(false);

        jButton1.setText("Ok");
        jButton1.addActionListener(this);

        jButton2.setText("Cancel");
        jButton2.addActionListener(this);

        jLabel1.setText("Beschikbaarheidspercentage:");
        

        jTextField1.setText("voorbeeld: 99.95");

        jLabel2.setText("%");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2)
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton2)
                                        .addComponent(jButton1))
                                .addContainerGap())
        );

        setSize(new java.awt.Dimension(387, 157));
        setLocationRelativeTo(null);
        pack();
    }// </editor-fold>     

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == jButton1) {
            try {
                double antwoord = Double.parseDouble(jTextField1.getText());
                if (antwoord >= 99.999) {

                } else {
                    a = new Algorithm(); //jTextField1 aan meegeven
                    a.calculateAvailabilityPercentage(antwoord);
                    antwoord1 = a.getPrijs();
                    beschikbaarheidsPercentage = a.getAvailabilityPercentage();
                    mogelijkhedenGoedOntwerp = a.getMogelijkhedenGoedOntwerp();
                    dispose();
                }
            } catch (NumberFormatException nfe) {
                System.out.print(nfe);
            }
        } else {
            cancelGedrukt = true;
            dispose();
        }
    }

    public boolean getCancelIngedrukt() {
        return cancelGedrukt;
    }

    public int getPrijs() {
        return this.antwoord1;
    }

    public double getAvailabilityPercentage() {
        return this.beschikbaarheidsPercentage;
    }

    public int[] getMogelijkhedenGoedOntwerp() {
        return mogelijkhedenGoedOntwerp;
    }

    public Algorithm getA() {
        return a;
    }

    
}
