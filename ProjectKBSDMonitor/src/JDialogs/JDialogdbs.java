package JDialogs;

import javax.swing.*;

public class JDialogdbs extends JDialog {
    private JPanel contentPane;
    private JTabbedPane tabbedPane1;
    private JProgressBar progressBar1;
    private JProgressBar progressBar2;


    public JDialogdbs() {
        setTitle("Monitor dialog");
        setContentPane(contentPane);
        setModal(true);
    }
}
