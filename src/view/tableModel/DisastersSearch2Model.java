package view.tableModel;

import model.Region;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class DisastersSearch2Model extends AbstractTableModel {
    private ArrayList<String> columnNames;
    private ArrayList<Region> contents;

    public DisastersSearch2Model(ArrayList<Region> regions) {
        columnNames = new ArrayList<>();
        columnNames.add("Region");
        columnNames.add("Population");
        columnNames.add("Est une zone de guerre");
        columnNames.add("Pays");

        setContents(regions);
    }

    private void setContents(ArrayList<Region> regions) {
        this.contents = regions;
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
        Region region = contents.get(row);

        return switch (column) {
            case 0 -> region.getName();
            case 1 -> region.getPopulation();
            case 2 -> region.getWarZone();
            case 3 -> region.getCountry().getName();
            default -> null;
        };
    }

    public Class getColumnClass(int column) {

        return switch (column) {
            case 1 -> Integer.class;
            case 2 -> Boolean.class;
            default -> String.class;
        };
    }
}