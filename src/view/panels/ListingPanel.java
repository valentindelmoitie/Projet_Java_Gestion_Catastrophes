package view.panels;

import controller.ApplicationController;
import exception.ConnectionException;
import exception.ReadingException;
import model.Disaster;
import view.AllDisastersModel;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

public class ListingPanel extends JPanel {
    private AllDisastersModel model;
    private JScrollPane scrollPane;
    private JTable disasterTable;
    private ApplicationController controller;
    private JPanel buttonsFrame;
    private JButton modifyButton, deleteButton;
    ListSelectionModel listSelect;

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
        disasterTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listSelect = disasterTable.getSelectionModel();

        scrollPane = new JScrollPane(disasterTable);
        scrollPane.setPreferredSize(new Dimension(1300, 400));

        disasterTable.getColumnModel().getColumn(0).setPreferredWidth(5);
        disasterTable.getColumnModel().getColumn(1).setPreferredWidth(200);
        disasterTable.getColumnModel().getColumn(3).setPreferredWidth(200);
        disasterTable.getColumnModel().getColumn(6).setPreferredWidth(5);

        this.add(scrollPane);

        createButtons();
    }

    public void setController(ApplicationController controller) {
        this.controller = controller;
    }

    private void createButtons() {
        buttonsFrame = new JPanel();

        modifyButton = new JButton("Modifier");
        modifyButton.addActionListener(new ButtonListener());

        deleteButton = new JButton("Supprimer");

        buttonsFrame.add(modifyButton);
        buttonsFrame.add(deleteButton);

        this.add(buttonsFrame, BorderLayout.SOUTH);
    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) { // IL faudrait rajouter une exception si aucune ligne n'est sélectionnée mais je le ferai quand ce ne sera plus au stade expérimental
            int iSelectedRow = listSelect.getMinSelectionIndex();

            Integer id = (Integer) disasterTable.getModel().getValueAt(iSelectedRow, 0);
            String name = (String) disasterTable.getModel().getValueAt(iSelectedRow, 1);
            String type = (String) disasterTable.getModel().getValueAt(iSelectedRow, 2);
            String description = (String) disasterTable.getModel().getValueAt(iSelectedRow, 3);
            String dateString = (String) disasterTable.getModel().getValueAt(iSelectedRow, 4);
            String endDateString = (String) disasterTable.getModel().getValueAt(iSelectedRow, 5);
            Integer intensity = (Integer) disasterTable.getModel().getValueAt(iSelectedRow, 6);
            Integer impactedPeople = (Integer) disasterTable.getModel().getValueAt(iSelectedRow, 7);
            Integer directCasualties = (Integer) disasterTable.getModel().getValueAt(iSelectedRow, 8);
            Integer indirectCasualties = (Integer) disasterTable.getModel().getValueAt(iSelectedRow, 9);
            Boolean isNatural = (Boolean)  disasterTable.getModel().getValueAt(iSelectedRow, 10);

            try {
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                Date dt = df.parse(dateString);
                GregorianCalendar date = new GregorianCalendar();
                date.setTime(dt);

                Disaster disaster = new Disaster(id, impactedPeople, directCasualties, indirectCasualties, type, description, date, isNatural, new ArrayList<>());

                System.out.println(disaster.getDescription());
            } catch (ParseException e) { // A modifier
                e.printStackTrace();
            }

        }
    }
}
