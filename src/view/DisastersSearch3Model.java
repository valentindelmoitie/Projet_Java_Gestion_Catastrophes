package view;

import model.Disaster;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class DisastersSearch3Model extends AbstractTableModel {
    private ArrayList<String> columnNames;
    private ArrayList<Disaster> contents;

    public DisastersSearch3Model(ArrayList<Disaster> disasters) {
        columnNames = new ArrayList<>();
        columnNames.add("Id");
        columnNames.add("Type");
        columnNames.add("Description");
        columnNames.add("Date");
        columnNames.add("Intensité");
        columnNames.add("Personnes impactées");
        columnNames.add("Victimes directes");
        columnNames.add("Victimes indirectes");
        columnNames.add("Est naturel ?");

        setContents(disasters);
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
            case 0:
                return disaster.getId();
            case 1:
                return disaster.getType();
            case 2:
                return disaster.getDescription();
            case 3:
                return disaster.getDateString();
            case 4:
                return disaster.getIntensity();
            case 5:
                return disaster.getImpactedPeople();
            case 6:
                return disaster.getDirectCasualties();
            case 7:
                return disaster.getIndirectCasualties();
            case 8:
                return disaster.getNatural();
            default:
                return null;
        }
    }

    public Class getColumnClass(int column) {
        Class c;

        switch (column) {
            case 0 : case 4 : case 5 :  case 6 :  case 7 :
                c = Integer.class;
                break;
            case 1 : case 2 :
                c = String.class;
                break;
            case 3 :
                c = GregorianCalendar.class;
                break;
            case 8 :
                c = Boolean.class;
                break;
            default :
                c = String.class;
        }
        return c;
    }

}
