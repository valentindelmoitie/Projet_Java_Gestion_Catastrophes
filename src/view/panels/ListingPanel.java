package view.panels;

import controller.ApplicationController;
import exception.ConnectionException;
import exception.ReadingException;
import view.AllDisastersModel;

import javax.swing.*;
import java.awt.*;

public class ListingPanel extends JPanel {
    AllDisastersModel model;
    JScrollPane scrollPane;
    JTable disasterTable;
    private ApplicationController controller;

    public ListingPanel() {
        setController(new ApplicationController());
        this.setLayout(new BorderLayout());

        try {
            model = new AllDisastersModel(controller.getAllDisaster());
        } catch (ConnectionException e) {
            e.printStackTrace();
        } catch (ReadingException e) {
            e.printStackTrace();
        }
        disasterTable = new JTable(model);
        scrollPane = new JScrollPane(disasterTable);

        scrollPane.setPreferredSize(new Dimension(1150, 400));

        disasterTable.getColumnModel().getColumn(0).setPreferredWidth(5);
        disasterTable.getColumnModel().getColumn(1).setPreferredWidth(200);
        disasterTable.getColumnModel().getColumn(3).setPreferredWidth(200);
        disasterTable.getColumnModel().getColumn(6).setPreferredWidth(5);

        this.add(scrollPane);
    }

    public void setController(ApplicationController controller) {
        this.controller = controller;
    }
}
