package view.panels;

import controller.ApplicationController;
import exception.*;
import model.Disaster;
import view.AllDisastersModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ListingPanel extends JPanel {
    private int selectionType;
    private AllDisastersModel model;
    private JScrollPane scrollPane;
    private JTable disasterTable;
    private ApplicationController controller;
    private JPanel buttonsFrame;
    private JButton modifyButton, deleteButton;
    ListSelectionModel listSelect;

    public ListingPanel(int selectionType) {
        this.selectionType = selectionType;

        setController(new ApplicationController());
        this.setLayout(new BorderLayout());

        try {
            ArrayList<Disaster> disasters = controller.getAllDisaster();
            for(Disaster disaster : disasters){
                disaster.correctDateForDisplay();
            }
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

        scrollPane = new JScrollPane(disasterTable);
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

    public ArrayList<Disaster> getSelectedDisasters() throws SelectionException, DisasterMiscException { // Il faut ajouter une esception si aucune ligne n'est sélectionnée.
        if (selectionType != ListSelectionModel.MULTIPLE_INTERVAL_SELECTION)
            throw new SelectionException(selectionType);

        ArrayList<Disaster> disasters = new ArrayList<>();

        int selectedRows[] = listSelect.getSelectedIndices();
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
            //dateGregorian.add(Calendar.MONTH, 1);

            GregorianCalendar endDateGregorian = null;
            if (endDateString != "") {
                Date endDate = dateFormat.parse(endDateString);
                endDateGregorian = new GregorianCalendar();
                endDateGregorian.setTime(endDate);
                //endDateGregorian.add(Calendar.MONTH, 1);
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

/*    private class ButtonListener implements ActionListener {
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

                Disaster disaster = new Disaster(id, impactedPeople, directCasualties, indirectCasualties,
                        type, description, date, isNatural, new ArrayList<>());
            } catch (ParseException e) { // A modifier
                e.printStackTrace();
            }

        }
    }
*/

}
