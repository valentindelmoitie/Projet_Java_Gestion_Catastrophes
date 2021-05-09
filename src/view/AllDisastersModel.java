package view;

import model.Disaster;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

public class AllDisastersModel extends AbstractTableModel {
    private ArrayList<String> columnNames;
    private ArrayList<Disaster> contents;

    public AllDisastersModel(ArrayList<Disaster> disasters) {
        columnNames = new ArrayList<>();
        columnNames.add("Id");
        columnNames.add("Nom");
        columnNames.add("Type");
        columnNames.add("Description");
        columnNames.add("Date");
        columnNames.add("Date de fin");
        columnNames.add("Intensité");
        columnNames.add("Personnes impactées");
        columnNames.add("Victimes directes");
        columnNames.add("Victimes indirectes");
        columnNames.add("Est naturel ?");

        setContents(disasters);
    }

    public void setContents(ArrayList<Disaster> disasters) {
        this.contents = disasters;
    }

    public int getColumnCount() {
        return columnNames.size();
    }

    public int getRowCount() {
        return contents.size();
    }

    public String getColumnName(int column) {
        return columnNames.get(column);
    }

    public Object getValueAt(int row, int column) {
        Disaster disaster = contents.get(row);

        switch (column) {
            case 0 :
                return disaster.getId();
            case 1 :
                return disaster.getName();
            case 2 :
                return disaster.getType();
            case 3 :
                return disaster.getDescription();
            case 4 :
                return disaster.getDateString(); // À modifier : il faut ajouter du code pour convertir la date.
            case 5 :
                return disaster.getEndDateString(); // Idem
            case 6 :
                return disaster.getIntensity();
            case 7 :
                return disaster.getImpactedPeople();
            case 8 :
                return disaster.getDirectCasualties();
            case 9 :
                return disaster.getIndirectCasualties();
            case 10 :
                return disaster.getNatural();
            default :
                return null;
        }
    }

    public Class getColumnClass(int column) {
        Class c;

        switch (column) {
            case 0 : case 6 : case 7 : case 8 : case 9 :
                c = Integer.class;

            case 1 : case 2 : case 3 :
                c = String.class;

            case 4 : case 5 :
                c = GregorianCalendar.class;

            case 10 :
                c = Boolean.class;

            default :
                c = String.class;
        }

        return c;
    }
}
