package gui;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Gast;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.SpinnerDateModel;

import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class GastDialog extends JDialog {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private Calendar calendar;
    private JTextPane textName;
    private JTextPane textAdresse;
    private JComboBox<String> cBZahlart;
    private JSpinner spDate;
    private JTextPane textVorname;
    
    private int gastCount;
    
    private static final String[] zahlarten = { "PayPal", "Bar", "Kreditkarte" };
    /**
     * Create the frame.
     * @param gastCount 
     */
    public GastDialog(ActionListener listener, int gastCount) {
	setTitle("Information zum Gast");
	setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
	setBounds(100, 100, 230, 260);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	JLabel lblName = new JLabel("Name:");
	lblName.setBounds(12, 9, 56, 16);
	contentPane.add(lblName);
	JLabel lblAdresse = new JLabel("Adresse:");
	lblAdresse.setBounds(12, 69, 56, 16);
	contentPane.add(lblAdresse);
	JLabel lblGebDatum = new JLabel("Geb. Datum:");
	lblGebDatum.setBounds(12, 96, 85, 16);
	contentPane.add(lblGebDatum);
	JLabel lblZahlart = new JLabel("Zahlart:");
	lblZahlart.setBounds(12, 123, 56, 16);
	contentPane.add(lblZahlart);
	textName = new JTextPane();
	textName.setBounds(105, 9, 77, 22);
	contentPane.add(textName);
	textAdresse = new JTextPane();
	textAdresse.setBounds(105, 63, 77, 22);
	contentPane.add(textAdresse);

	JButton btnGastSpeichern = new JButton("Gast speichern");
	btnGastSpeichern.setBounds(12, 185, 170, 25);
	btnGastSpeichern.addActionListener(listener);
	contentPane.add(btnGastSpeichern);

	cBZahlart = new JComboBox<String>();
	cBZahlart.setModel(new DefaultComboBoxModel<String>(zahlarten));
	cBZahlart.setBounds(105, 121, 77, 20);
	contentPane.add(cBZahlart);

	calendar = Calendar.getInstance();
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
	
	SpinnerDateModel dateModel = new SpinnerDateModel();
	
	spDate = new JSpinner(dateModel);
	spDate.setEditor(new JSpinner.DateEditor(spDate, dateFormat.toPattern()));
	spDate.setBounds(107, 94, 75, 20);
	spDate.setValue(calendar.getTime());
	contentPane.add(spDate);
	
	JLabel lblVorname = new JLabel("Vorname:");
	lblVorname.setBounds(12, 36, 75, 14);
	contentPane.add(lblVorname);
	
	textVorname = new JTextPane();
	textVorname.setBounds(105, 36, 77, 22);
	contentPane.add(textVorname);
    }
    
    public boolean allesAusgefuellt() {
	if(textName.getText().isEmpty() || textVorname.getText().isEmpty() || textAdresse.getText().isEmpty()) {
	    return false;
	}
	
	return true;
    }
    
    public Gast getGast() {
	Gast gast = new Gast(gastCount, textVorname.getText(), textName.getText(), textAdresse.getText(), (Date)spDate.getValue(), (String)cBZahlart.getSelectedItem());
	gastCount += 1;
	return gast;
    }
    
    public void reset() {
	setVisible(false);
	spDate.setValue(calendar.getTime());
	cBZahlart.setSelectedIndex(0);
	textName.setText("");
	textAdresse.setText("");
	textVorname.setText("");
	
    }

    public void unausgefuellteFelder() {
	JOptionPane.showMessageDialog(null, "Sie haben noch unausgefüllte Felder!", "Fehler", JOptionPane.WARNING_MESSAGE);
    }
}