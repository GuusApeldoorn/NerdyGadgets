package JDialogs;

import javax.swing.*;

public class JDialogfw extends JDialog {
    private JPanel contentPane;
    private JTabbedPane tabbedPane1;
    private JProgressBar progressBar1;
    private JProgressBar progressBar2;


    public JDialogfw() {
        setTitle("Monitor dialog");
        setContentPane(contentPane);
        setModal(true);

    }

}
