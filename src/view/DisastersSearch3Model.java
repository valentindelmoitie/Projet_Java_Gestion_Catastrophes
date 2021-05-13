package view;

import model.Disaster;
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

        switch (column) {
            case 0:
                return disaster.getId();
            case 1:
                return disaster.getType();
            case 2:
                return disaster.getDateString();
            case 3:
                return disaster.getIntensity();
            case 4:
                return disaster.getImpactedPeople();
            case 5:
                return disaster.getDirectCasualties();
            case 6:
                return disaster.getIndirectCasualties();
            case 7:
                return disaster.getNatural();
            default:
                return null;
        }
    }

    public Class getColumnClass(int column) {
        Class c;

        switch (column) {
            case 0 : case 3 : case 4 : case 5 :  case 6 :
                c = Integer.class;
                break;
            case 1 :
                c = String.class;
                break;
            case 2 :
                c = GregorianCalendar.class;
                break;
            case 7 :
                c = Boolean.class;
                break;
            default :
                c = String.class;
        }
        return c;
    }

}
