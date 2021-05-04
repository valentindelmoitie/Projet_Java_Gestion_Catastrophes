import dataAccess.SingletonConnection;
import exception.ConnectionException;
import view.windows.MainWindow;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        System.out.println("Hello world");
        UIManager.setLookAndFeel(new NimbusLookAndFeel());

        MainWindow mainWindow = new MainWindow();
    }
}
