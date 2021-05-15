package view.tableModel;

import model.Disaster;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class DisastersSearch1Model extends AbstractTableModel {

    private ArrayList<String> columnNames;
    private ArrayList<Disaster> contents;

    public DisastersSearch1Model(ArrayList<Disaster> contents) {
        columnNames = new ArrayList<>();
        columnNames.add("Id");
        columnNames.add("Type");
        columnNames.add("Date");
        columnNames.add("Intensité");
        columnNames.add("Personnes impactées");
        columnNames.add("Naturel ?");

        setContents(contents);
    }

    public void setContents(ArrayList<Disaster> contents) {
        this.contents = contents;
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
        return switch (column) {
            case 0 -> disaster.getId();
            case 1 -> disaster.getType();
            case 2 -> disaster.getDateString();
            case 3 -> disaster.getIntensity();
            case 4 -> disaster.getImpactedPeople();
            case 5 -> disaster.getNatural();
            default -> null;
        };
    }

    public Class getColumnClass(int column) {
        return switch (column) {
            case 0, 3, 4 -> Integer.class;
            case 2 -> GregorianCalendar.class;
            case 5 -> Boolean.class;
            default -> String.class;
        };
    }
}
