import view.windows.MainWindow;
import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;


public class Main {
    public static void main(String[] args) throws UnsupportedLookAndFeelException { // On peut pas throws ici je pense
        UIManager.setLookAndFeel(new NimbusLookAndFeel());
        MainWindow mainWindow = new MainWindow();
    }
}

