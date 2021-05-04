import dataAccess.DisasterDBAccess;
import dataAccess.SingletonConnection;
import exception.ConnectionException;
import exception.ReadingException;
import model.Disaster;
import model.Region;
import view.windows.MainWindow;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) throws UnsupportedLookAndFeelException, ConnectionException, ReadingException {
        System.out.println("Hello world");
        UIManager.setLookAndFeel(new NimbusLookAndFeel());

        MainWindow mainWindow = new MainWindow();

        ArrayList<Disaster> allDisasters = new ArrayList<Disaster>();

        allDisasters = DisasterDBAccess.getAllDisaster();

        for (Disaster disaster : allDisasters) {
            System.out.println("Région numéro : " + disaster.getId());
            System.out.println(disaster.getImpactedPeople());
            System.out.println(disaster.getDirectCasualties());
            System.out.println(disaster.getIndirectCasualties());
            System.out.println(disaster.getType());
            System.out.println(disaster.getDescription());
            System.out.println(disaster.getDate());
            System.out.println(disaster.getNatural());
            System.out.println(disaster.getEndDate());
            System.out.println(disaster.getName());
            System.out.println(disaster.getIntensity());

            for (Region region : disaster.getRegions())
                System.out.println(region.getName());

            System.out.println("");
            System.out.println("");
        }
    }
}
