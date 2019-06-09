package gui;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Zimmer;

public class ZimmerTableModel extends AbstractTableModel {
    private static final long serialVersionUID = 1L;
    
    private List<Zimmer> zimmer = new LinkedList<Zimmer>();

    
    public void setZimmerList(List<Zimmer> zimmer) {
	this.zimmer = zimmer;

	fireTableDataChanged();
    }

    @Override
    public int getColumnCount() {
	return 7;
    }

    @Override
    public int getRowCount() {
	return zimmer.size();
    }

    // Die Titel der einzelnen Columns
    public String getColumnName(int column) {
	switch (column) {
	case 0:
	    return "Nummer";
	case 1:
	    return "Bettenanzahl";
	case 2:
	    return "Badewanne";
	case 3:
	    return "Minibar";
	case 4:
	    return "TV";
	case 5:
	    return "Preis Mo-Fr";
	case 6:
	    return "Preis Sa+So";   
	default:
	    return null;
	}
    }

    // Der Wert der Zelle (rowIndex, columnIndex)
    public Object getValueAt(int rowIndex, int columnIndex) {
	Zimmer z = zimmer.get(rowIndex);

	switch (columnIndex) {
	case 0:
	    return z.getNummer();
	case 1:
	    return z.getAnzahlBetten();
	case 2:
	    if(z.hatBadewanne()) {
		return "\u2714";
	    } else {
		return "\u2718";
	    }
	case 3:
	    if(z.hatMinibar()) {
		return "\u2714";
	    } else {
		return "\u2718";
	    }
	    
	case 4:
	    if(z.hatFernseher()) {
		return "\u2714";
	    } else {
		return "\u2718";
	    }
	    
	case 5:
	    return Integer.toString(z.getPreisWerktag()) + "€";
	case 6:
	    return Integer.toString(z.getPreisWochende()) + "€";
	    
	default:
	    return null;
	}
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public Class getColumnClass(int columnIndex) {
	switch (columnIndex) {
	case 0:
	case 1:
	    return Integer.class;
	case 2:
	case 3:
	case 4:
	case 5:
	case 6:
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
