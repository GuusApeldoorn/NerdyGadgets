package JDialogs;

import projectkbsdmonitor.connectjson;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class JDialogdbl extends JDialog {

    private JPanel contentPane;
    private JTabbedPane tabbedPane1;
    private JProgressBar progressBar1;
    private JProgressBar progressBar2;
    private JLabel JLabel6;
    private JLabel JLabel5;
    private JLabel JLabel4;
    private JLabel JLabel3;
    private JLabel JLabel2;
    private JLabel JLabel1;
    private String stringdbl;
    private boolean isGevonden = false;

    public JDialogdbl() {
        setTitle("Monitoring loadbalancer");
        setContentPane(contentPane);
        setModal(true);

        connectjson MonitorS = new connectjson();
        String response = MonitorS.getConnection();
        MonitorS.setTesttest123(MonitorS.parse(response));

        System.out.println(MonitorS.getTesttest123());

        //db1
        for (int i = 0; i < MonitorS.getTesttest123().size(); i++) {
            stringdbl = MonitorS.getTesttest123().get(i).getName();
            if (stringdbl.equals("loadbalancer")) {
                JLabel1.setText("Beschikbaar");
                isGevonden = true;
                JLabel2.setText(Float.toString(MonitorS.getTesttest123().get(4).getUptime()) + " Minuten");
                JLabel3.setText(Double.toString(MonitorS.getTesttest123().get(4).getCpu()) + "%");
                JLabel4.setText(Integer.toString(MonitorS.getTesttest123().get(4).getDiksfree() + MonitorS.getTesttest123().get(4).getDiskused()) + " GB");
                JLabel5.setText(Integer.toString(MonitorS.getTesttest123().get(4).getDiksfree() + MonitorS.getTesttest123().get(4).getDiskused()) + " GB");
                JLabel6.setText("Nog " + Integer.toString(MonitorS.getTesttest123().get(4).getDiksfree()) + " GB van de " + Integer.toString(MonitorS.getTesttest123().get(4).getDiksfree() + MonitorS.getTesttest123().get(4).getDiskused()) + " GB vrij");
                progressBar1.setForeground(Color.BLUE);
                progressBar1.setValue((int) MonitorS.getTesttest123().get(4).getCpu());
                progressBar2.setForeground(Color.BLUE);
                progressBar2.setValue(MonitorS.getTesttest123().get(4).getDiskused() * 11);
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
                            stringdbl = MonitorS.getTesttest123().get(i).getName();
                            if (stringdbl.equals("loadbalancer")) {
                                JLabel1.setText("Beschikbaar");
                                isGevonden = true;
                                JLabel2.setText(Float.toString(MonitorS.getTesttest123().get(4).getUptime()) + " Minuten");
                                JLabel3.setText(Double.toString(MonitorS.getTesttest123().get(4).getCpu()) + "%");
                                JLabel4.setText(Integer.toString(MonitorS.getTesttest123().get(4).getDiksfree() + MonitorS.getTesttest123().get(4).getDiskused()) + " GB");
                                JLabel5.setText(Integer.toString(MonitorS.getTesttest123().get(4).getDiksfree() + MonitorS.getTesttest123().get(4).getDiskused()) + " GB");
                                JLabel6.setText("Nog " + Integer.toString(MonitorS.getTesttest123().get(4).getDiksfree()) + " GB van de " + Integer.toString(MonitorS.getTesttest123().get(4).getDiksfree() + MonitorS.getTesttest123().get(4).getDiskused()) + " GB vrij");
                                progressBar1.setForeground(Color.BLUE);
                                progressBar1.setValue((int) MonitorS.getTesttest123().get(4).getCpu());
                                progressBar2.setForeground(Color.BLUE);
                                progressBar2.setValue(MonitorS.getTesttest123().get(4).getDiskused() * 11);
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
        setResizable(false);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return contentPane;
    }

}
