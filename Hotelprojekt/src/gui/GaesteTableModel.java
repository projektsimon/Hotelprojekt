package gui;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Gast;

public class GaesteTableModel extends AbstractTableModel {
    private static final long serialVersionUID = 1L;

    private List<Gast> gaeste = new LinkedList<Gast>();

    @Override
    public int getColumnCount() {
	return 3;
    }

    @Override
    public int getRowCount() {
	return gaeste.size();
    }

    // Die Titel der einzelnen Columns
    public String getColumnName(int column) {
	switch (column) {
	case 0:
	    return "ID";
	case 1:
	    return "Name";
	case 2:
	    return "Vorname";
	default:
	    return null;
	}
    }

    // Der Wert der Zelle (rowIndex, columnIndex)
    public Object getValueAt(int rowIndex, int columnIndex) {
	Gast g = gaeste.get(rowIndex);

	switch (columnIndex) {
	case 0:
	    return g.getId();
	case 1:
	    return g.getName();
	case 2:
	    return g.getVorname();
	default:
	    return null;
	}
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public Class getColumnClass(int columnIndex) {
	switch (columnIndex) {
	case 0:
	    return Integer.class;
	case 1:
	case 2:
	    return String.class;
	default:
	    return null;
	}
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
	return false;
    }

    public void setGäste(List<Gast> gäste) {
	this.gaeste = gäste;
	fireTableDataChanged();
    }
}
