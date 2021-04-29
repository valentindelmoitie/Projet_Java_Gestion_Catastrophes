import view.windows.MainWindow;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class Main {
    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        System.out.println("Hello world");
        UIManager.setLookAndFeel(new NimbusLookAndFeel());

        MainWindow mainWindow = new MainWindow();
    }
}
