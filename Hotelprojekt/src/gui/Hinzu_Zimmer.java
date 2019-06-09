package gui;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import model.Zimmer;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class Hinzu_Zimmer extends JDialog {
    private static final long serialVersionUID = 1L;
    
    private JPanel contentPane;
    private JCheckBox chckbxBadewanne;
    private JCheckBox chckbxTv;
    private JCheckBox chckbxMinibar;
    private JLabel lblZimmernummer;
    private JLabel lblAnzahlBetten;
    private JLabel lblPreisMofr;
    private JLabel lblPreisFrmo;
    private JButton btnZimmerSpeichern;
    private JSpinner spNummer;
    private JSpinner spBetten;
    private JSpinner spPreisWerktag;
    private JSpinner spPreisWochenende;

    public Hinzu_Zimmer(ActionListener listener) {
	setModal(true);
	setAlwaysOnTop(true);
	setTitle("Zimmer hinzufügen");
	setBounds(100, 100, 450, 330);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);

	chckbxBadewanne = new JCheckBox("Badewanne");
	chckbxBadewanne.setBounds(12, 78, 113, 25);
	contentPane.add(chckbxBadewanne);

	chckbxTv = new JCheckBox("TV");
	chckbxTv.setBounds(12, 108, 113, 25);
	contentPane.add(chckbxTv);

	chckbxMinibar = new JCheckBox("Minibar");
	chckbxMinibar.setBounds(12, 138, 113, 25);
	contentPane.add(chckbxMinibar);

	lblZimmernummer = new JLabel("Zimmernummer:");
	lblZimmernummer.setBounds(12, 13, 113, 16);
	contentPane.add(lblZimmernummer);

	lblAnzahlBetten = new JLabel("Anzahl Betten:");
	lblAnzahlBetten.setBounds(12, 42, 113, 16);
	contentPane.add(lblAnzahlBetten);

	lblPreisMofr = new JLabel("Preis Mo-Fr:");
	lblPreisMofr.setBounds(12, 179, 113, 16);
	contentPane.add(lblPreisMofr);

	lblPreisFrmo = new JLabel("Preis Fr-Mo:");
	lblPreisFrmo.setBounds(12, 208, 113, 16);
	contentPane.add(lblPreisFrmo);

	// btnZurueck = new JButton("Zurück");
	// btnZurueck.setBounds(323, 245, 97, 25);
	// btnZurueck.addActionListener(listener);
	// contentPane.add(btnZurueck);

	btnZimmerSpeichern = new JButton("Zimmer speichern");
	btnZimmerSpeichern.setBounds(12, 245, 162, 25);
	btnZimmerSpeichern.addActionListener(listener);
	contentPane.add(btnZimmerSpeichern);
	
	spNummer = new JSpinner();
	spNummer.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
	spNummer.setBounds(108, 11, 66, 20);
	contentPane.add(spNummer);
	
	spBetten = new JSpinner();
	spBetten.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
	spBetten.setBounds(108, 40, 66, 20);
	contentPane.add(spBetten);
	
	spPreisWerktag = new JSpinner();
	spPreisWerktag.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
	spPreisWerktag.setBounds(108, 177, 66, 20);
	contentPane.add(spPreisWerktag);
	
	spPreisWochenende = new JSpinner();
	spPreisWochenende.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
	spPreisWochenende.setBounds(108, 206, 66, 20);
	contentPane.add(spPreisWochenende);

    }

    public Zimmer getZimmer() {
	int nummer = (Integer)spNummer.getValue();
	int anzahlBetten = (Integer)spBetten.getValue();
	boolean badewanne = chckbxBadewanne.isSelected();
	boolean fernseher = chckbxTv.isSelected();
	boolean minibar = chckbxMinibar.isSelected();
	int preisWerktag = (Integer)spPreisWerktag.getValue();
	int preisWochenende = (Integer)spPreisWochenende.getValue();

	return new Zimmer(nummer, anzahlBetten, badewanne, fernseher, minibar, preisWerktag, preisWochenende, false);
    }
    
    public void promptZimmernummerVergeben() {
	JOptionPane.showMessageDialog(null, "Diese Zimmernummer ist bereits vergeben!", "Fehler", JOptionPane.WARNING_MESSAGE);
    }

    public void resetDarstellung() {
	spNummer.setValue((Integer)spNummer.getValue() + 1);
	spBetten.setValue(1);
	chckbxBadewanne.setSelected(false);
	chckbxMinibar.setSelected(false);
	chckbxTv.setSelected(false);
	spPreisWerktag.setValue(0);
	spPreisWerktag.setValue(0);
    }
}