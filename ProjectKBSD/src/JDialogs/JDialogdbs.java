package JDialogs;

import projectkbsdmonitor.connectjson;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class JDialogdbs extends JDialog {

    private JPanel contentPane;
    private JProgressBar progressBar1;
    private JProgressBar progressBar2;
    private JLabel JLabel1;
    private JLabel JLabel2;
    private JLabel JLabel3;
    private JLabel JLabel4;
    private JLabel JLabel5;
    private JLabel JLabel6;
    private JLabel JLabel7; // beschikbaarheid database server 2
    private JLabel JLabel8; //uptime database server 2
    private JLabel JLabel9; //cpu load database server 2
    private JLabel JLabel10; //disk space database server 2
    private JLabel JLabel11; //einde van progress bar (x gb)
    private JLabel JLabel12; //hoeveel gb van de hoeveel gb
    private JProgressBar progressBar3;
    private JProgressBar progressBar4;
    private JTabbedPane tabbedPane1;
    private String stringDb1, stringDb2;
    private boolean isGevonden = false, isGevonden1 = false;

    public JDialogdbs() {
        setTitle("Monitor dialog");
        setContentPane(contentPane);
        setModal(true);

        connectjson MonitorS = new connectjson();
        String response = MonitorS.getConnection();
        MonitorS.setTesttest123(MonitorS.parse(response));

        System.out.println(MonitorS.getTesttest123());

        //db1
        for (int i = 0; i < MonitorS.getTesttest123().size(); i++) {
            stringDb1 = MonitorS.getTesttest123().get(i).getName();
            if (stringDb1.equals("db1")) {
                JLabel1.setText("Beschikbaar");
                isGevonden = true;
                JLabel2.setText(Float.toString(MonitorS.getTesttest123().get(2).getUptime()) + " Minuten");
                JLabel3.setText(Double.toString(MonitorS.getTesttest123().get(2).getCpu()) + "%");
                JLabel4.setText(Integer.toString(MonitorS.getTesttest123().get(2).getDiksfree() + MonitorS.getTesttest123().get(2).getDiskused()) + " GB");
                JLabel5.setText(Integer.toString(MonitorS.getTesttest123().get(2).getDiksfree() + MonitorS.getTesttest123().get(2).getDiskused()) + " GB");
                JLabel6.setText("Nog " + Integer.toString(MonitorS.getTesttest123().get(2).getDiksfree()) + " GB van de " + Integer.toString(MonitorS.getTesttest123().get(2).getDiksfree() + MonitorS.getTesttest123().get(2).getDiskused()) + " GB vrij");
                progressBar1.setForeground(Color.BLUE);
                progressBar1.setValue((int) MonitorS.getTesttest123().get(2).getCpu());
                progressBar2.setForeground(Color.BLUE);
                progressBar2.setValue(MonitorS.getTesttest123().get(2).getDiskused() * 11);
            }

            if (isGevonden == false) {
                JLabel1.setText("Offline");
                JLabel2.setText("");
                JLabel3.setText("");
                JLabel4.setText("");
                JLabel5.setText("");
                JLabel6.setText("");
            }
        }

        //db2
        for (int i = 0; i < MonitorS.getTesttest123().size(); i++) {
            stringDb2 = MonitorS.getTesttest123().get(i).getName();
            if (stringDb2.equals("db2")) {
                JLabel7.setText("Beschikbaar");
                isGevonden1 = true;
                JLabel8.setText(Float.toString(MonitorS.getTesttest123().get(3).getUptime()) + " Minuten");
                JLabel9.setText(Double.toString(MonitorS.getTesttest123().get(3).getCpu()) + "%");
                JLabel10.setText(Integer.toString(MonitorS.getTesttest123().get(3).getDiksfree() + MonitorS.getTesttest123().get(1).getDiskused()) + " GB");
                JLabel11.setText(Integer.toString(MonitorS.getTesttest123().get(3).getDiksfree() + MonitorS.getTesttest123().get(1).getDiskused()) + " GB");
                JLabel12.setText("Nog " + Integer.toString(MonitorS.getTesttest123().get(3).getDiksfree()) + " GB van de " + Integer.toString(MonitorS.getTesttest123().get(3).getDiksfree() + MonitorS.getTesttest123().get(3).getDiskused()) + " GB vrij");
                progressBar3.setForeground(Color.BLUE);
                progressBar3.setValue((int) MonitorS.getTesttest123().get(3).getCpu());
                progressBar4.setForeground(Color.BLUE);
                progressBar4.setValue(MonitorS.getTesttest123().get(3).getDiskused() * 11);
            }

            if (isGevonden1 == false) {
                JLabel7.setText("Offline");
                JLabel8.setText("");
                JLabel9.setText("");
                JLabel10.setText("");
                JLabel11.setText("");
                JLabel12.setText("");
            }
        }

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
                        //db1
                        for (int i = 0; i < MonitorS.getTesttest123().size(); i++) {
                            stringDb1 = MonitorS.getTesttest123().get(i).getName();
                            if (stringDb1.equals("db1")) {
                                JLabel1.setText("Beschikbaar");
                                isGevonden = true;
                                JLabel2.setText(Float.toString(MonitorS.getTesttest123().get(2).getUptime()) + " Minuten");
                                JLabel3.setText(Double.toString(MonitorS.getTesttest123().get(2).getCpu()) + "%");
                                JLabel4.setText(Integer.toString(MonitorS.getTesttest123().get(2).getDiksfree() + MonitorS.getTesttest123().get(2).getDiskused()) + " GB");
                                JLabel5.setText(Integer.toString(MonitorS.getTesttest123().get(2).getDiksfree() + MonitorS.getTesttest123().get(2).getDiskused()) + " GB");
                                JLabel6.setText("Nog " + Integer.toString(MonitorS.getTesttest123().get(2).getDiksfree()) + " GB van de " + Integer.toString(MonitorS.getTesttest123().get(2).getDiksfree() + MonitorS.getTesttest123().get(2).getDiskused()) + " GB vrij");
                                progressBar1.setForeground(Color.BLUE);
                                progressBar1.setValue((int) MonitorS.getTesttest123().get(2).getCpu());
                                progressBar2.setForeground(Color.BLUE);
                                progressBar2.setValue(MonitorS.getTesttest123().get(2).getDiskused() * 11);
                            }

                            if (isGevonden == false) {
                                JLabel1.setText("Offline");
                                JLabel2.setText("");
                                JLabel3.setText("");
                                JLabel4.setText("");
                                JLabel5.setText("");
                                JLabel6.setText("");
                            }
                        }

                        //db2
                        for (int i = 0; i < MonitorS.getTesttest123().size(); i++) {
                            stringDb2 = MonitorS.getTesttest123().get(i).getName();
                            if (stringDb2.equals("db2")) {
                                JLabel7.setText("Beschikbaar");
                                isGevonden1 = true;
                                JLabel8.setText(Float.toString(MonitorS.getTesttest123().get(3).getUptime()) + " Minuten");
                                JLabel9.setText(Double.toString(MonitorS.getTesttest123().get(3).getCpu()) + "%");
                                JLabel10.setText(Integer.toString(MonitorS.getTesttest123().get(3).getDiksfree() + MonitorS.getTesttest123().get(3).getDiskused()) + " GB");
                                JLabel11.setText(Integer.toString(MonitorS.getTesttest123().get(3).getDiksfree() + MonitorS.getTesttest123().get(3).getDiskused()) + " GB");
                                JLabel12.setText("Nog " + Integer.toString(MonitorS.getTesttest123().get(3).getDiksfree()) + " GB van de " + Integer.toString(MonitorS.getTesttest123().get(3).getDiksfree() + MonitorS.getTesttest123().get(3).getDiskused()) + " GB vrij");
                                progressBar3.setForeground(Color.BLUE);
                                progressBar3.setValue((int) MonitorS.getTesttest123().get(3).getCpu());
                                progressBar4.setForeground(Color.BLUE);
                                progressBar4.setValue(MonitorS.getTesttest123().get(3).getDiskused() * 11);
                            }

                            if (isGevonden1 == false) {
                                JLabel7.setText("Offline");
                                JLabel8.setText("");
                                JLabel9.setText("");
                                JLabel10.setText("");
                                JLabel11.setText("");
                                JLabel12.setText("");
                            }
                        }
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
     * Method generated by IntelliJ IDEA GUI Designer >>> IMPORTANT!! <<< DO NOT
     * edit this method OR call it in your code!
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
        panel2.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(5, 4, new Insets(0, 0, 0, 0), -1, -1));
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
        panel2.add(progressBar1, new com.intellij.uiDesigner.core.GridConstraints(2, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        progressBar2 = new JProgressBar();
        panel2.add(progressBar2, new com.intellij.uiDesigner.core.GridConstraints(3, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        JLabel6 = new JLabel();
        JLabel6.setText("Nog 190GB van de 1TB vrij");
        panel2.add(JLabel6, new com.intellij.uiDesigner.core.GridConstraints(4, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        JLabel5 = new JLabel();
        JLabel5.setText("1 tb");
        panel2.add(JLabel5, new com.intellij.uiDesigner.core.GridConstraints(3, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        JLabel4 = new JLabel();
        JLabel4.setText("0");
        panel2.add(JLabel4, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        JLabel3 = new JLabel();
        JLabel3.setText("85%");
        panel2.add(JLabel3, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        JLabel2 = new JLabel();
        JLabel2.setText("40");
        panel2.add(JLabel2, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        JLabel1 = new JLabel();
        JLabel1.setText("Beschikbaar");
        panel2.add(JLabel1, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        tabbedPane1.addTab("Server 2 ", panel3);
        final JPanel panel4 = new JPanel();
        panel4.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(5, 4, new Insets(0, 0, 0, 0), -1, -1));
        panel3.add(panel4, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label5 = new JLabel();
        label5.setText("Disc space:");
        panel4.add(label5, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label6 = new JLabel();
        label6.setText("CPU usage: ");
        panel4.add(label6, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label7 = new JLabel();
        label7.setText("Uptime:");
        panel4.add(label7, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label8 = new JLabel();
        label8.setText("Status:");
        panel4.add(label8, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        progressBar3 = new JProgressBar();
        panel4.add(progressBar3, new com.intellij.uiDesigner.core.GridConstraints(2, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        progressBar4 = new JProgressBar();
        panel4.add(progressBar4, new com.intellij.uiDesigner.core.GridConstraints(3, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        JLabel12 = new JLabel();
        JLabel12.setText("Nog 190GB van de 1TB vrij");
        panel4.add(JLabel12, new com.intellij.uiDesigner.core.GridConstraints(4, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        JLabel11 = new JLabel();
        JLabel11.setText("1 tb");
        panel4.add(JLabel11, new com.intellij.uiDesigner.core.GridConstraints(3, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        JLabel10 = new JLabel();
        JLabel10.setText("0");
        panel4.add(JLabel10, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        JLabel9 = new JLabel();
        JLabel9.setText("80%");
        panel4.add(JLabel9, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        JLabel8 = new JLabel();
        JLabel8.setText("100%");
        panel4.add(JLabel8, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        JLabel7 = new JLabel();
        JLabel7.setText("Beschikbaar");
        panel4.add(JLabel7, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
            setResizable(false);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return contentPane;
    }

}
