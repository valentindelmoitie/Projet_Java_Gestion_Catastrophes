package view;

import model.Region;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class Search2Model extends AbstractTableModel {
    private ArrayList<String> columnNames;
    private ArrayList<Region> contents;

    public Search2Model(ArrayList<Region> regions) {
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

        switch (column) {
            case 0 :
                return region.getName();
            case 1 :
                return region.getPopulation();
            case 2 :
                return region.getWarZone();
            case 3 :
                return region.getCountry().getName();
            default :
                return null;
        }
    }

    public Class getColumnClass(int column) {
        Class c;

        switch (column) {
            case 0 : case 3 :
                c = String.class;
                break;
            case 1 :
                c = Integer.class;
                break;
            case 2 :
                c = Boolean.class;
                break;
            default :
                c = null;
        }

        return c;
    }
}