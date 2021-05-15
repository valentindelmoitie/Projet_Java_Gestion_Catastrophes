package view.panels;

import controller.ApplicationController;
import exception.DisasterMiscException;
import exception.SelectionException;
import model.Disaster;
import view.tableModel.AllDisastersModel;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ListingPanel extends JPanel {
    private int selectionType;
    private AllDisastersModel model;
    private JTable disasterTable;
    private ApplicationController controller;
    ListSelectionModel listSelect;

    public ListingPanel(int selectionType) {
        this.selectionType = selectionType;

        setController(new ApplicationController());
        this.setLayout(new BorderLayout());

        try {
            ArrayList<Disaster> disasters = controller.getAllDisaster();
            model = new AllDisastersModel(disasters);
        } catch (Exception exception){
            JOptionPane.showMessageDialog(null, exception.getMessage(), "Exception levée", JOptionPane.ERROR_MESSAGE);
        }

        disasterTable = new JTable(model);

        if (selectionType == ListSelectionModel.SINGLE_SELECTION)
            disasterTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        else
            disasterTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        listSelect = disasterTable.getSelectionModel();

        JScrollPane scrollPane = new JScrollPane(disasterTable);
        scrollPane.setPreferredSize(new Dimension(1490, 400));

        disasterTable.getColumnModel().getColumn(0).setPreferredWidth(5);
        disasterTable.getColumnModel().getColumn(1).setPreferredWidth(200);
        disasterTable.getColumnModel().getColumn(3).setPreferredWidth(200);
        disasterTable.getColumnModel().getColumn(6).setPreferredWidth(5);

        this.add(scrollPane);
    }

    public void setController(ApplicationController controller) {
        this.controller = controller;
    }

    public ArrayList<Disaster> getSelectedDisasters() throws SelectionException, DisasterMiscException {
        if (selectionType != ListSelectionModel.MULTIPLE_INTERVAL_SELECTION)
            throw new SelectionException(selectionType);

        ArrayList<Disaster> disasters = new ArrayList<>();

        int[] selectedRows = listSelect.getSelectedIndices();
        for (int i : selectedRows) {
            int id = (Integer) disasterTable.getModel().getValueAt(i, 0);
            disasters.add(new Disaster(id));
        }
        return disasters;
    }

    public Disaster getSelectedDisaster() throws SelectionException {
        if (selectionType != ListSelectionModel.SINGLE_SELECTION)
            throw new SelectionException(selectionType);

        int selectedRow = listSelect.getMinSelectionIndex();

        Integer id = (Integer) disasterTable.getModel().getValueAt(selectedRow, 0);
        String name = (String) disasterTable.getModel().getValueAt(selectedRow, 1);
        String type = (String) disasterTable.getModel().getValueAt(selectedRow, 2);
        String description = (String) disasterTable.getModel().getValueAt(selectedRow, 3);
        String dateString = (String) disasterTable.getModel().getValueAt(selectedRow, 4);
        String endDateString = (String) disasterTable.getModel().getValueAt(selectedRow, 5);
        Integer intensity = (Integer) disasterTable.getModel().getValueAt(selectedRow, 6);
        Integer impactedPeople = (Integer) disasterTable.getModel().getValueAt(selectedRow, 7);
        Integer directCasualties = (Integer) disasterTable.getModel().getValueAt(selectedRow, 8);
        Integer indirectCasualties = (Integer) disasterTable.getModel().getValueAt(selectedRow, 9);
        Boolean isNatural = (Boolean)  disasterTable.getModel().getValueAt(selectedRow, 10);

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);

        try {
            Date date = dateFormat.parse(dateString);
            GregorianCalendar dateGregorian = new GregorianCalendar();
            dateGregorian.setTime(date);

            GregorianCalendar endDateGregorian = null;
            if (endDateString != "") {
                Date endDate = dateFormat.parse(endDateString);
                endDateGregorian = new GregorianCalendar();
                endDateGregorian.setTime(endDate);
            }

            Disaster disaster = new Disaster(id, impactedPeople, directCasualties, indirectCasualties, type, description, dateGregorian, isNatural);

            disaster.setName(name);
            disaster.setIntensity(intensity);
            disaster.setEndDate(endDateGregorian);

            return  disaster;
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), "Erreur formulaire", JOptionPane.ERROR_MESSAGE);
        }

        return null;
    }
}
