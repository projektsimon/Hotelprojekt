package gui;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTable;
import javax.swing.JLabel;
import model.Buchungsanfrage;
import model.Zimmer;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class OptionsDialog extends JDialog {

    private static final long serialVersionUID = 2705165533862574238L;
    private JPanel contentPane;
    private JTable tbZimmer;
    private JLabel lblAnforderungen;
    private JLabel lblBadewanne;
    private JLabel lblTv;
    private JLabel lblMinibar;
    private JLabel lblXBetten;
    private JButton btnAuswahl;

    /**
     * Konstruktor
     */
    public OptionsDialog(ActionListener listener) {
    	setTitle("Zimmer auswählen");
	setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
	setResizable(false);
	setBounds(100, 100, 626, 324);

	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JLabel lblZimmerliste = new JLabel("Zimmerliste:");
	lblZimmerliste.setBounds(10, 61, 89, 14);
	contentPane.add(lblZimmerliste);
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(10, 86, 597, 167);
	contentPane.add(scrollPane);
	
	tbZimmer = new JTable(new ZimmerTableModel());
	scrollPane.setViewportView(tbZimmer);
	
	lblAnforderungen = new JLabel("Anforderungen: ");
	lblAnforderungen.setBounds(10, 11, 98, 14);
	contentPane.add(lblAnforderungen);
	
	lblBadewanne = new JLabel("Badewanne");
	lblBadewanne.setBounds(118, 11, 67, 14);
	lblBadewanne.setVisible(false);
	contentPane.add(lblBadewanne);
	
	lblTv = new JLabel("TV");
	lblTv.setBounds(195, 11, 46, 14);
	lblTv.setVisible(false);
	contentPane.add(lblTv);
	
	lblMinibar = new JLabel("Minibar");
	lblMinibar.setBounds(220, 11, 46, 14);
	lblMinibar.setVisible(false);
	contentPane.add(lblMinibar);
	
	lblXBetten = new JLabel("x Betten");
	lblXBetten.setBounds(276, 11, 123, 14);
	contentPane.add(lblXBetten);
	
	btnAuswahl = new JButton("Auswahl bestätigen");
	btnAuswahl.setEnabled(false);
	btnAuswahl.setBounds(253, 264, 146, 23);
	btnAuswahl.addActionListener(listener);
	contentPane.add(btnAuswahl);
	
	
	DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
	centerRenderer.setHorizontalAlignment(JLabel.CENTER);
	tbZimmer.setDefaultRenderer(String.class, centerRenderer);
	tbZimmer.setDefaultRenderer(Integer.class, centerRenderer);
	tbZimmer.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
	            btnAuswahl.setEnabled(true);
	        }
	    });
    }
    
    public void showData(List<Zimmer> zimmer, Buchungsanfrage anfrage) {
	if(anfrage.willBadewanne()) {
	    lblBadewanne.setVisible(true);
	} else {
	    lblBadewanne.setVisible(false);
	}
	
	if(anfrage.willMinibar()) {
	    lblMinibar.setVisible(true);
	} else {
	    lblMinibar.setVisible(false);
	}
	
	if(anfrage.willTV()) {
	    lblTv.setVisible(true);
	} else {
	    lblTv.setVisible(false);
	}
	
	int betten = anfrage.getAnzahlBetten();
	if(betten > 1) {
	    lblXBetten.setText(Integer.toString(betten) + " Betten");
	} else {
	    lblXBetten.setText("1 Bett");
	}
	
	((ZimmerTableModel)tbZimmer.getModel()).setZimmerList(zimmer);
	setVisible(true);
    }
    
    public int getNummer() {
	return tbZimmer.getSelectedRow();
    }

    public void reset() {
	setVisible(false);
	btnAuswahl.setEnabled(false);
    }
}
