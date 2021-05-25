import view.windows.MainWindow;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;


public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
            MainWindow mainWindow = new MainWindow();
        } catch (UnsupportedLookAndFeelException exception){
            JOptionPane.showMessageDialog(null, "Look and Feel non pris en charge", "Exception levée", JOptionPane.ERROR_MESSAGE);
        }
    }
}

