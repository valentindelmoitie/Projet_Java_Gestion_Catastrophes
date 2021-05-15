package view.tableModel;

import model.DisasterOnDangerousSite;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class DisastersSearch3Model extends AbstractTableModel {
    private ArrayList<String> columnNames;
    private ArrayList<DisasterOnDangerousSite> contents;

    public DisastersSearch3Model(ArrayList<DisasterOnDangerousSite> disasters) {
        columnNames = new ArrayList<>();
        columnNames.add("Id");
        columnNames.add("Type");
        columnNames.add("Date");
        columnNames.add("Intensité");
        columnNames.add("Personnes impactées");
        columnNames.add("Victimes directes");
        columnNames.add("Victimes indirectes");
        columnNames.add("Est naturel ?");

        setContents(disasters);
    }

    public void setContents(ArrayList<DisasterOnDangerousSite> contents) {
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
        DisasterOnDangerousSite disaster = contents.get(row);

        return switch (column) {
            case 0 -> disaster.getId();
            case 1 -> disaster.getType();
            case 2 -> disaster.getDateString();
            case 3 -> disaster.getIntensity();
            case 4 -> disaster.getImpactedPeople();
            case 5 -> disaster.getDirectCasualties();
            case 6 -> disaster.getIndirectCasualties();
            case 7 -> disaster.getNatural();
            default -> null;
        };
    }

    public Class getColumnClass(int column) {

        return switch (column) {
            case 0, 3, 4, 5, 6 -> Integer.class;
            case 2 -> GregorianCalendar.class;
            case 7 -> Boolean.class;
            default -> String.class;
        };
    }
}
