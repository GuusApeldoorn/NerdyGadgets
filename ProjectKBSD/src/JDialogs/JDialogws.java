package JDialogs;

import JPanels.jPanelwsStatus;
import projectkbsdmonitor.Node;
import projectkbsdmonitor.connectjson;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDialogws extends JDialog {

    private JPanel contentPane;
    private JTabbedPane tabbedPane1;
    private JProgressBar progressBar1;
    private JProgressBar progressBar2;
    private JLabel JLabel1;
    private JLabel JLabel2;
    private JLabel JLabel3;
    private JLabel JLabel4;
    private JLabel JLabel5;
    private JLabel label5;
    private JLabel label16; //beschikbaarheid webserver2
    private JLabel label15; //uptime webserver2
    private JLabel label14; //cpu load webserver2
    private JLabel label13; //disk space webserver2
    private JLabel label12; //einde van progress bar (x gb)
    private JLabel label11; //hoeveel gb van de hoeveel gb
    private JProgressBar progressBar3, progressBar4;
//    private ArrayList<Node> test123;

    public JDialogws() {
        setContentPane(contentPane);
        setModal(true);

        connectjson MonitorS = new connectjson();
        String response = MonitorS.getConnection();
        MonitorS.setTesttest123(MonitorS.parse(response));

        System.out.println(MonitorS.getTesttest123());

        //webserver1
        if (MonitorS.getTesttest123().get(0).getUptime() > 0) {
            JLabel1.setText("Beschikbaar");
        } else {
            JLabel1.setText("Offline");
        }
        JLabel2.setText(Float.toString(MonitorS.getTesttest123().get(0).getUptime()) + " Minuten");
        JLabel3.setText(Double.toString(MonitorS.getTesttest123().get(0).getCpu()) + "%");
        JLabel4.setText(Integer.toString(MonitorS.getTesttest123().get(0).getDiksfree() + MonitorS.getTesttest123().get(0).getDiskused()) + " GB");
        JLabel5.setText(Integer.toString(MonitorS.getTesttest123().get(0).getDiksfree() + MonitorS.getTesttest123().get(0).getDiskused()) + " GB");
        label5.setText("Nog " + Integer.toString(MonitorS.getTesttest123().get(0).getDiksfree()) + " GB van de " + Integer.toString(MonitorS.getTesttest123().get(0).getDiksfree() + MonitorS.getTesttest123().get(0).getDiskused()) + " GB vrij");
        progressBar1.setForeground(Color.BLUE);
        progressBar1.setValue((int) MonitorS.getTesttest123().get(0).getCpu());
        progressBar2.setForeground(Color.BLUE);
        progressBar2.setValue(MonitorS.getTesttest123().get(0).getDiskused() * 11);

        //webserver2
        if (MonitorS.getTesttest123().get(1).getUptime() > 0) {
            label16.setText("Beschikbaar");
        } else {
            label16.setText("Offline");
        }
        label15.setText(Float.toString(MonitorS.getTesttest123().get(1).getUptime()) + " Minuten");
        label14.setText(Double.toString(MonitorS.getTesttest123().get(1).getCpu()) + "%");
        label13.setText(Integer.toString(MonitorS.getTesttest123().get(1).getDiksfree() + MonitorS.getTesttest123().get(1).getDiskused()) + " GB");
        label12.setText(Integer.toString(MonitorS.getTesttest123().get(1).getDiksfree() + MonitorS.getTesttest123().get(1).getDiskused()) + " GB");
        label11.setText("Nog " + Integer.toString(MonitorS.getTesttest123().get(1).getDiksfree()) + " GB van de " + Integer.toString(MonitorS.getTesttest123().get(1).getDiksfree() + MonitorS.getTesttest123().get(1).getDiskused()) + " GB vrij");
        progressBar3.setForeground(Color.BLUE);
        progressBar3.setValue((int) MonitorS.getTesttest123().get(1).getCpu());
        progressBar4.setForeground(Color.BLUE);
        progressBar4.setValue(MonitorS.getTesttest123().get(1).getDiskused() * 11);

        ScheduledExecutorService e = Executors.newSingleThreadScheduledExecutor();
        e.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                // do stuff
                connectjson MonitorS = new connectjson();
                String response = MonitorS.getConnection();
                MonitorS.setTesttest123(MonitorS.parse(response));

                SwingUtilities.invokeLater(new Runnable() {
                    // of course, you could improve this by moving dateformat variable elsewhere

                    @Override
                    public void run() {
                        //webserver1
                        if (MonitorS.getTesttest123().get(0).getUptime() > 0) {
                            JLabel1.setText("Beschikbaar");
                        } else {
                            JLabel1.setText("Offline");
                        }
                        JLabel2.setText(Float.toString(MonitorS.getTesttest123().get(0).getUptime()) + " Minuten");
                        JLabel3.setText(Double.toString(MonitorS.getTesttest123().get(0).getCpu()) + "%");
                        JLabel4.setText(Integer.toString(MonitorS.getTesttest123().get(0).getDiksfree() + MonitorS.getTesttest123().get(0).getDiskused()) + " GB");
                        JLabel5.setText(Integer.toString(MonitorS.getTesttest123().get(0).getDiksfree() + MonitorS.getTesttest123().get(0).getDiskused()) + " GB");
                        label5.setText("Nog " + Integer.toString(MonitorS.getTesttest123().get(0).getDiksfree()) + " GB van de " + Integer.toString(MonitorS.getTesttest123().get(0).getDiksfree() + MonitorS.getTesttest123().get(0).getDiskused()) + " GB vrij");
                        progressBar1.setForeground(Color.BLUE);
                        progressBar1.setValue((int) MonitorS.getTesttest123().get(0).getCpu());
                        progressBar2.setForeground(Color.BLUE);
                        progressBar2.setValue(MonitorS.getTesttest123().get(0).getDiskused() * 11);

                        //webserver2
                        if (MonitorS.getTesttest123().get(1).getUptime() > 0) {
                            label16.setText("Beschikbaar");
                        } else {
                            label16.setText("Offline");
                        }
                        label15.setText(Float.toString(MonitorS.getTesttest123().get(1).getUptime()) + " Minuten");
                        label14.setText(Double.toString(MonitorS.getTesttest123().get(1).getCpu()) + "%");
                        label13.setText(Integer.toString(MonitorS.getTesttest123().get(1).getDiksfree() + MonitorS.getTesttest123().get(1).getDiskused()) + " GB");
                        label12.setText(Integer.toString(MonitorS.getTesttest123().get(1).getDiksfree() + MonitorS.getTesttest123().get(1).getDiskused()) + " GB");
                        label11.setText("Nog " + Integer.toString(MonitorS.getTesttest123().get(1).getDiksfree()) + " GB van de " + Integer.toString(MonitorS.getTesttest123().get(1).getDiksfree() + MonitorS.getTesttest123().get(1).getDiskused()) + " GB vrij");
                        progressBar3.setForeground(Color.BLUE);
                        progressBar3.setValue((int) MonitorS.getTesttest123().get(1).getCpu());
                        progressBar4.setForeground(Color.BLUE);
                        progressBar4.setValue(MonitorS.getTesttest123().get(1).getDiskused() * 11);
                    }
                });
            }
        }, 0, 1, TimeUnit.SECONDS);
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        contentPane = new JPanel();
        contentPane.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(10, 10, 10, 10), -1, -1));
        tabbedPane1 = new JTabbedPane();
        contentPane.add(tabbedPane1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(200, 200), null, 0, false));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        tabbedPane1.addTab("Server 1", panel1);
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(5, 5, new Insets(0, 0, 0, 0), -1, -1));
        panel1.add(panel2, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("Disc space:");
        panel2.add(label1, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("CPU usage: ");
        panel2.add(label2, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("Uptime:");
        panel2.add(label3, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label4 = new JLabel();
        label4.setText("Status:");
        panel2.add(label4, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        progressBar1 = new JProgressBar();
        panel2.add(progressBar1, new com.intellij.uiDesigner.core.GridConstraints(2, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        progressBar2 = new JProgressBar();
        panel2.add(progressBar2, new com.intellij.uiDesigner.core.GridConstraints(3, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        label5 = new JLabel();
        label5.setText("Nog 190GB van de 1TB vrij");
        panel2.add(label5, new com.intellij.uiDesigner.core.GridConstraints(4, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        JLabel5 = new JLabel();
        JLabel5.setText("1 tb");
        panel2.add(JLabel5, new com.intellij.uiDesigner.core.GridConstraints(3, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        JLabel4 = new JLabel();
        JLabel4.setText("0");
        panel2.add(JLabel4, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        JLabel3 = new JLabel();
        JLabel3.setText("85%");
        panel2.add(JLabel3, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        JLabel2 = new JLabel();
        JLabel2.setText("40");
        panel2.add(JLabel2, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        JLabel1 = new JLabel();
        JLabel1.setText("Beschikbaar");
        panel2.add(JLabel1, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label6 = new JLabel();
        label6.setText("Dagen");
        panel2.add(label6, new com.intellij.uiDesigner.core.GridConstraints(1, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        tabbedPane1.addTab("Server 2 ", panel3);
        final JPanel panel4 = new JPanel();
        panel4.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(5, 4, new Insets(0, 0, 0, 0), -1, -1));
        panel3.add(panel4, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label7 = new JLabel();
        label7.setText("Disc space:");
        panel4.add(label7, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label8 = new JLabel();
        label8.setText("CPU usage: ");
        panel4.add(label8, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label9 = new JLabel();
        label9.setText("Uptime:");
        panel4.add(label9, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label10 = new JLabel();
        label10.setText("Status:");
        panel4.add(label10, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JProgressBar progressBar5 = new JProgressBar();
        panel4.add(progressBar5, new com.intellij.uiDesigner.core.GridConstraints(2, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JProgressBar progressBar6 = new JProgressBar();
        panel4.add(progressBar6, new com.intellij.uiDesigner.core.GridConstraints(3, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        label11 = new JLabel();
        label11.setText("Nog 190GB van de 1TB vrij");
        panel4.add(label11, new com.intellij.uiDesigner.core.GridConstraints(4, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        label12 = new JLabel();
        label12.setText("1 tb");
        panel4.add(label12, new com.intellij.uiDesigner.core.GridConstraints(3, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        label13 = new JLabel();
        label13.setText("0");
        panel4.add(label13, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        label14 = new JLabel();
        label14.setText("80%");
        panel4.add(label14, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        label15 = new JLabel();
        label15.setText("100%");
        panel4.add(label15, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        label16 = new JLabel();
        label16.setText("Beschikbaar");
        panel4.add(label16, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return contentPane;
    }

}
