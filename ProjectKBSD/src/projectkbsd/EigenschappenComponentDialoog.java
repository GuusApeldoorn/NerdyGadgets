/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectkbsd;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author  Mac (donalds) Gerrit en de rest
 */
public class EigenschappenComponentDialoog extends JDialog implements ActionListener {

    
    private JButton jButton1; //OK button
    private JButton jButton2; //Cancel button
    private JLabel jLabel1; //Tekst naam
    private JLabel jLabel2; //Tekst uptime
    private JLabel jLabel3; //Tekst prijs
    private String naam;
    private double uptime;
    private int prijs;
    private String type;
    private static boolean intarray;
    private JTextField jTextField1; //Waarde van naam van het component
    private JTextField jTextField2; //Waarde van prijs van het component
    private JTextField jTextField3; //Waarde van uptime van het component
    private boolean isClosed;
    private EigenschapComponent ec = null;
    

    public EigenschappenComponentDialoog(JFrame frame) {
        super(frame, true);
        initComponents();
        intarray = true;
        
    }

    public boolean getIsClosed() {
        return isClosed;
    }

    public void setNaam(String name) {
        jTextField1.setText(name);
    }

    public void setUptime(double availability) {
        jTextField3.setText(Double.toString(availability));
    }

    public void setPrijs(int price) {
        jTextField2.setText(Integer.toString(price));
    }

    public String getNaam() {
        return naam;
    }

    public double getUptime() {
        return uptime;
    }
    
    public void setec(EigenschapComponent ec) {
        this.ec = ec;
    }
    
    public EigenschapComponent getec() {
        return ec;
    }
    
    public int getPrijs() {
        return prijs;
    }

    public EigenschapComponent getEc() {
        return ec;
    }
    
    
    public void setIsClosed() {
       naam = jTextField1.getText();
            uptime = Double.parseDouble(jTextField3.getText());
            prijs = Integer.parseInt(jTextField2.getText());
            isClosed = false;
            dispose();
            System.out.println("exit ecd");
    }
    
    public void setType(String type) {
        this.type = type;
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jButton1) { //OK button
            naam = jTextField1.getText();
            uptime = Double.parseDouble(jTextField3.getText());
            prijs = Integer.parseInt(jTextField2.getText());
            isClosed = false;
            EigenschapComponent ec = new EigenschapComponent(type, prijs, uptime, naam);
            this.ec = ec;
            if (intarray) { ec.intlist(); intarray = false;}
            this.ec.setlist(this.ec);
            
            dispose();
        }

        if (e.getSource() == jButton2) { //Cancel button
            isClosed = true;
            dispose();
        }
    }
   
    public void initComponents() {
       
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Naam");

        jLabel2.setText("Uptime");

        jLabel3.setText("Prijs");

        jButton1.setText("Ok");
        jButton1.addActionListener(this);

        jButton2.setText("Cancel");
        jButton2.addActionListener(this);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButton1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton2))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jLabel3))
                                                .addGap(24, 24, 24)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                                                        .addComponent(jTextField1)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addGap(18, 18, 18)
                                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton2)
                                        .addComponent(jButton1))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
        setSize(new java.awt.Dimension(245, 167));
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Eigenschappen component");

        pack();
    }// </editor-fold>  

    

}
