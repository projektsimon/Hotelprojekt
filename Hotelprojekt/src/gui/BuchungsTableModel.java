package gui;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Buchung;

public class BuchungsTableModel extends AbstractTableModel {
    private static final long serialVersionUID = 1L;

    private List<Buchung> buchungen = new LinkedList<Buchung>();

    public void setBuchungen(List<Buchung> buchungen) {
	this.buchungen = buchungen;

	fireTableDataChanged();
    }

    @Override
    public int getColumnCount() {
	return 4;
    }

    @Override
    public int getRowCount() {
	return buchungen.size();
    }

    // Die Titel der einzelnen Columns
    public String getColumnName(int column) {
	switch (column) {
	case 0:
	    return "Zimmernummer";
	case 1:
	    return "Von";
	case 2:
	    return "Bis";
	case 3:
	    return "Gast";
	default:
	    return null;
	}
    }

    // Der Wert der Zelle (rowIndex, columnIndex)
    public Object getValueAt(int rowIndex, int columnIndex) {
	Buchung b = buchungen.get(rowIndex);

	switch (columnIndex) {
	case 0:
	    return b.getZimmer().getNummer();
	case 1:
	    return b.getZeitraum().getAnfang();
	case 2:
	    return b.getZeitraum().getEnde();
	case 3:
	    return b.getGast().getName() + ", " + b.getGast().getVorname();
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
	    return Date.class;
	case 3:
	    return String.class;
	default:
	    return null;
	}
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
	return false;
    }
}
