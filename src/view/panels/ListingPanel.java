package view.panels;

import dataAccess.DisasterDBAccess;
import exception.ConnectionException;
import exception.ReadingException;
import view.AllDisastersModel;

import javax.swing.*;
import java.awt.*;

public class ListingPanel extends JPanel {
    AllDisastersModel model;
    JScrollPane scrollPane;
    JTable disasterTable;

    public ListingPanel() {
        this.setLayout(new BorderLayout());

        try {
            model = new AllDisastersModel(new DisasterDBAccess().getAllDisaster()); // À adapter au DAO, ceci a été fait en guise de test.
        } catch (ConnectionException e) {
            e.printStackTrace();
        } catch (ReadingException e) {
            e.printStackTrace();
        }
        disasterTable = new JTable(model);
        scrollPane = new JScrollPane(disasterTable);

        scrollPane.setPreferredSize(new Dimension(1150, 600));

        disasterTable.getColumnModel().getColumn(0).setPreferredWidth(5);
        disasterTable.getColumnModel().getColumn(1).setPreferredWidth(200);
        disasterTable.getColumnModel().getColumn(3).setPreferredWidth(200);
        disasterTable.getColumnModel().getColumn(6).setPreferredWidth(5);

        this.add(scrollPane, BorderLayout.CENTER);
        this.add(new JButton("test"), BorderLayout.SOUTH); // Boutton de test pour voir comment ça fit avec la table
    }
}
