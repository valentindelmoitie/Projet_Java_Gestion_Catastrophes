package view.tableModel;

import model.Disaster;
import model.Region;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
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
        columnNames.add("Régions");

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
                return disaster.getDateString();
            case 5 :
                return disaster.getEndDateString();
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
            case 11 :
                StringBuilder regions = new StringBuilder();
                for (Region region : disaster.getRegions())
                    regions.append(region.getName()).append(" ");
                return regions.toString();
            default :
                return null;
        }
    }

    public Class getColumnClass(int column) {
        return switch (column) {
            case 0, 6, 7, 8, 9 -> Integer.class;
            case 4, 5 -> GregorianCalendar.class;
            case 10 -> Boolean.class;
            default -> String.class;
        };
    }
}
