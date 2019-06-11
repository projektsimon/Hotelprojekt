package gui;
/*
 * Anmerkungen: Für ein schöneres Gesamtbild könnte man noch ein Icon setzen, bspw. wie hier bei der
 * angehakten Antwort vorgeschlagen
 * (https://stackoverflow.com/questions/1614772/how-to-change-jframe-icon) Die Objektnamen sind im
 * Beispiel natürlich anders wie bei euch. Ich habe euch unten auch mal die beiden Befehle
 * auskommentiert eingefügt.
 * 
 * Nach jeder Zeile ein Leerzeile macht euren Code nur unnötig lang ;)
 * 
 * Damit euer Code noch schöner wird solltet ihr außerdem drüber nachdenken, camelCase zu nutzen.
 * Variablen werden in Java grundsätzlich mit kleinem Anfangsbuchstaben geschrieben, aber wenn eine
 * Variable aus mehreren Wörtern besteht, so schreibt man ab dem zweiten einfach des
 * Anfangsbuchstaben groß, sodass es sich leichter lesen lässt. In Java weniger verbreitet aber auch
 * genutzt wäre als Alternative die Trennung_mittels_underscores.
 * 
 * Ihr könntet noch die unötigen, gelb markierten import Statements entfernen, dann liefert eclipse
 * weniger Warnungen ;)
 * 
 * Ich weiß nicht auf was ihr die euer Encoding gestellt habt, aber bei mir funktioniert die Nutzung
 * von Ä,Ö und Ü wunderbar ohne spezielle Unicode Anweisung.
 */

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JTable;
import javax.swing.SpinnerDateModel;
import javax.swing.JLabel;

import model.Buchung;
import model.Zimmer;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;

@SuppressWarnings("serial")
public class Hauptoberfläche extends JFrame {

    private JPanel contentPane;
    private JTable tbZimmer;
    private JTable tbBuchungen;
    
    private Calendar calendar;

    /**
     * Konstruktor
     */
    public Hauptoberfläche(ActionListener listener) {
    	setTitle("Hotelmanager");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setResizable(false);
	setBounds(100, 100, 1153, 434);
	
	JMenuBar menuBar = new JMenuBar();
	setJMenuBar(menuBar);
	
	JMenu mnDatei = new JMenu("Datei");
	menuBar.add(mnDatei);
	
	JMenuItem mntmSpeichernVerlassen = new JMenuItem("Speichern & Verlassen");
	mnDatei.add(mntmSpeichernVerlassen);
	mntmSpeichernVerlassen.addActionListener(listener);
	
	JMenuItem mntmGespeichertesverwerfen = new JMenuItem("Gespeichertes verwerfen");
	mnDatei.add(mntmGespeichertesverwerfen);
	mntmGespeichertesverwerfen.addActionListener(listener);
	
	JMenu mnZimmer = new JMenu("Zimmer");
	menuBar.add(mnZimmer);
	
	JMenuItem mntmZimmerHinzufgen = new JMenuItem("Zimmer hinzufügen / ändern");
	mnZimmer.add(mntmZimmerHinzufgen);
	mntmZimmerHinzufgen.addActionListener(listener);
	
	JMenuItem mntmZimmerEntfernen = new JMenuItem("Zimmer entfernen");
	mnZimmer.add(mntmZimmerEntfernen);
	mntmZimmerEntfernen.addActionListener(listener);
	
	JMenu mnGste = new JMenu("Gäste");
	menuBar.add(mnGste);
	
	JMenuItem mntmGsteliste = new JMenuItem("Gästeliste");
	mntmGsteliste.addActionListener(listener);
	mnGste.add(mntmGsteliste);
	
	JMenu mnBuchung = new JMenu("Buchung");
	menuBar.add(mnBuchung);
	
	JMenuItem mntmBuchungAufnehmen = new JMenuItem("Buchung aufnehmen");
	mnBuchung.add(mntmBuchungAufnehmen);
	mntmBuchungAufnehmen.addActionListener(listener);

	// icon = new ImageIcon("relativer Pfad zum Icon");
	// setIconImage(icon.getImage());

	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JLabel lblZimmerliste = new JLabel("Zimmerliste:");
	lblZimmerliste.setBounds(10, 36, 89, 14);
	contentPane.add(lblZimmerliste);
	
	JLabel lblBuchungsliste = new JLabel("Buchungsliste");
	lblBuchungsliste.setBounds(639, 36, 89, 14);
	contentPane.add(lblBuchungsliste);
	
	JScrollPane sPZimmer = new JScrollPane();
	sPZimmer.setBounds(10, 61, 597, 292);
	contentPane.add(sPZimmer);
	
	tbZimmer = new JTable(new ZimmerTableModel());
	sPZimmer.setViewportView(tbZimmer);

	calendar = Calendar.getInstance();
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
	
	SpinnerDateModel dateModel = new SpinnerDateModel();
	JSpinner spDate = new JSpinner(dateModel);
	spDate.setEditor(new JSpinner.DateEditor(spDate, dateFormat.toPattern()));
	spDate.setValue(calendar.getTime());
	spDate.setBounds(95, 11, 98, 20);
	contentPane.add(spDate);
	
	JLabel lblDatum = new JLabel("Datum");
	lblDatum.setBounds(10, 11, 46, 14);
	contentPane.add(lblDatum);
	
	JScrollPane sPBuchungen = new JScrollPane();
	sPBuchungen.setBounds(649, 61, 488, 292);
	contentPane.add(sPBuchungen);
	
	tbBuchungen = new JTable(new BuchungsTableModel());
	sPBuchungen.setViewportView(tbBuchungen);
	
	
	DefaultTableCellRenderer tbZimmerRenderer = new DefaultTableCellRenderer();
	tbZimmerRenderer.setHorizontalAlignment(JLabel.CENTER);
	tbZimmer.setDefaultRenderer(String.class, tbZimmerRenderer);
	tbZimmer.setDefaultRenderer(Integer.class, tbZimmerRenderer);
	
	DateTableCellRenderer tbBuchungsRenderer = new DateTableCellRenderer();
	tbBuchungsRenderer.setHorizontalAlignment(JLabel.CENTER);
	tbBuchungen.setDefaultRenderer(String.class, tbBuchungsRenderer);
	tbBuchungen.setDefaultRenderer(Date.class, tbBuchungsRenderer);
	
	
    }
    
    public void showData(List<Zimmer> zimmer, List<Buchung> buchungen) {
	((ZimmerTableModel)tbZimmer.getModel()).setZimmerList(zimmer);
	((BuchungsTableModel)tbBuchungen.getModel()).setBuchungen(buchungen);
    }
}
