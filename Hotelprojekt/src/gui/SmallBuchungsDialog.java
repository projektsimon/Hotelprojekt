package gui;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Zeitraum;
import model.Buchungsanfrage;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.JCheckBox;
import javax.swing.SpinnerNumberModel;

public class SmallBuchungsDialog extends JDialog {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JCheckBox chckbxBadewanne;
    private JCheckBox chckbxTv;
    private JCheckBox chckbxMinibar;
    private JSpinner spBetten;
    private JSpinner spDateAnfang;
    private JSpinner spDateEnde;
    
    private Calendar calendar;

    public SmallBuchungsDialog(ActionListener listener) {
    	setTitle("Passendes Zimmer suchen");
	setBounds(100, 100, 450, 245);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	calendar = Calendar.getInstance();
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
	
	SpinnerDateModel dateModelAnfang = new SpinnerDateModel();
	SpinnerDateModel dateModelEnde = new SpinnerDateModel();
	
	JButton btnGastSpeichern = new JButton("Zimmer suchen");
	btnGastSpeichern.setBounds(12, 178, 170, 25);
	contentPane.add(btnGastSpeichern);
	btnGastSpeichern.addActionListener(listener);

	JLabel lblVon = new JLabel("Von: ");
	lblVon.setBounds(12, 11, 46, 14);
	contentPane.add(lblVon);

	spDateEnde = new JSpinner(dateModelEnde);
	spDateEnde.setEditor(new JSpinner.DateEditor(spDateEnde, dateFormat.toPattern()));
	spDateEnde.setBounds(49, 8, 103, 20);
	contentPane.add(spDateEnde);

	JLabel lblBis = new JLabel("bis (einschlieﬂlich):");
	lblBis.setBounds(171, 11, 97, 14);
	contentPane.add(lblBis);

	spDateAnfang = new JSpinner(dateModelAnfang);
	spDateAnfang.setEditor(new JSpinner.DateEditor(spDateAnfang, dateFormat.toPattern()));
	spDateAnfang.setBounds(266, 8, 103, 20);
	contentPane.add(spDateAnfang);
	
	chckbxBadewanne = new JCheckBox("Badewanne");
	chckbxBadewanne.setBounds(12, 74, 97, 23);
	contentPane.add(chckbxBadewanne);
	
	JLabel lblAnforderungen = new JLabel("Anforderungen:");
	lblAnforderungen.setBounds(12, 53, 101, 14);
	contentPane.add(lblAnforderungen);
	
	chckbxMinibar = new JCheckBox("Minibar");
	chckbxMinibar.setBounds(12, 126, 97, 23);
	contentPane.add(chckbxMinibar);
	
	chckbxTv = new JCheckBox("TV");
	chckbxTv.setBounds(12, 100, 97, 23);
	contentPane.add(chckbxTv);
	
	JLabel lblAnzahlBetten = new JLabel("Anzahl Betten:");
	lblAnzahlBetten.setBounds(234, 53, 97, 14);
	contentPane.add(lblAnzahlBetten);
	
	spBetten = new JSpinner();
	spBetten.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
	spBetten.setBounds(320, 50, 72, 20);
	contentPane.add(spBetten);
    }
    
    public void showDialog() {
	Date anfang = calendar.getTime();
	Date ende = calendar.getTime();
	
	spDateAnfang.setValue(anfang);
	spDateEnde.setValue(ende);
	
	setVisible(true);
    }

    public Buchungsanfrage getAnfrage() {
	Date anfang = (Date) spDateAnfang.getValue();
	Date ende = (Date) spDateEnde.getValue();
	
	if(ende.before(anfang)) {
	    Date buf = ende;
	    ende = anfang;
	    anfang = buf;
	}
	
	int betten = (Integer) spBetten.getValue();
	boolean tv = chckbxTv.isSelected();
	boolean minibar = chckbxMinibar.isSelected();
	boolean badewanne = chckbxBadewanne.isSelected();
	
	return new Buchungsanfrage(new Zeitraum(anfang, ende), badewanne, minibar, tv, betten);
    }
}