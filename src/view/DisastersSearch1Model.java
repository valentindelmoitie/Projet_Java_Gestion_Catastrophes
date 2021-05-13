package view;

import model.Disaster;
import model.Region;

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

        switch (column) {
            case 0 :
                return disaster.getId();
            case 1 :
                return disaster.getType();
            case 2 :
                return disaster.getDateString();
            case 3 :
                return disaster.getIntensity();
            case 4 :
                return disaster.getImpactedPeople();
            case 5 :
                return disaster.getNatural();
            default :
                return null;
        }
    }

    public Class getColumnClass(int column) {
        Class c;

        switch (column) {
            case 0 : case 3 : case 4 :
                c = Integer.class;
                break;
            case 1 :
                c = String.class;
                break;
            case 2 :
                c = GregorianCalendar.class;
                break;
            case 5 :
                c = Boolean.class;
                break;
            default :
                c = String.class;
        }
        return c;
    }

}
