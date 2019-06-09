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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JTable;
import javax.swing.JLabel;
import model.Zimmer;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class Hauptoberfläche extends JFrame {

    private JPanel contentPane;
    private static ImageIcon icon;
    private JTable tbZimmer;
    private JTable tbBuchungen;

    /**
     * Konstruktor
     */
    public Hauptoberfläche(ActionListener listener) {
    	setTitle("Hotelmanager");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setResizable(false);
	setBounds(100, 100, 970, 434);
	
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
	
	JMenuItem mntmZimmerHinzufgen = new JMenuItem("Zimmer hinzufügen");
	mnZimmer.add(mntmZimmerHinzufgen);
	mntmZimmerHinzufgen.addActionListener(listener);
	
	JMenu mnGste = new JMenu("Gäste");
	menuBar.add(mnGste);
	
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
	
	JLabel lblGstezhler = new JLabel("Gästezähler:");
	lblGstezhler.setBounds(10, 11, 89, 14);
	contentPane.add(lblGstezhler);
	
	JLabel lblZaehler = new JLabel("");
	lblZaehler.setBounds(85, 11, 46, 14);
	contentPane.add(lblZaehler);
	
	JLabel lblBuchungsliste = new JLabel("Buchungsliste");
	lblBuchungsliste.setBounds(639, 36, 89, 14);
	contentPane.add(lblBuchungsliste);
	
	tbBuchungen = new JTable();
	tbBuchungen.setBounds(639, 61, 259, 274);
	contentPane.add(tbBuchungen);
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(10, 61, 597, 292);
	contentPane.add(scrollPane);
	
	tbZimmer = new JTable(new ZimmerTableModel());
	scrollPane.setViewportView(tbZimmer);
	DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
	centerRenderer.setHorizontalAlignment(JLabel.CENTER);
	tbZimmer.setDefaultRenderer(String.class, centerRenderer);
	tbZimmer.setDefaultRenderer(Integer.class, centerRenderer);
    }
    
    public void showData(List<Zimmer> zimmer) {
	((ZimmerTableModel)tbZimmer.getModel()).setZimmerList(zimmer);
    }
}
