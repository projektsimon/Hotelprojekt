package gui;
/*
 * Anmerkungen: F�r ein sch�neres Gesamtbild k�nnte man noch ein Icon setzen, bspw. wie hier bei der
 * angehakten Antwort vorgeschlagen
 * (https://stackoverflow.com/questions/1614772/how-to-change-jframe-icon) Die Objektnamen sind im
 * Beispiel nat�rlich anders wie bei euch. Ich habe euch unten auch mal die beiden Befehle
 * auskommentiert eingef�gt.
 * 
 * Nach jeder Zeile ein Leerzeile macht euren Code nur unn�tig lang ;)
 * 
 * Damit euer Code noch sch�ner wird solltet ihr au�erdem dr�ber nachdenken, camelCase zu nutzen.
 * Variablen werden in Java grunds�tzlich mit kleinem Anfangsbuchstaben geschrieben, aber wenn eine
 * Variable aus mehreren W�rtern besteht, so schreibt man ab dem zweiten einfach des
 * Anfangsbuchstaben gro�, sodass es sich leichter lesen l�sst. In Java weniger verbreitet aber auch
 * genutzt w�re als Alternative die Trennung_mittels_underscores.
 * 
 * Ihr k�nntet noch die un�tigen, gelb markierten import Statements entfernen, dann liefert eclipse
 * weniger Warnungen ;)
 * 
 * Ich wei� nicht auf was ihr die euer Encoding gestellt habt, aber bei mir funktioniert die Nutzung
 * von �,� und � wunderbar ohne spezielle Unicode Anweisung.
 */

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class Hauptoberfl�che extends JFrame {

    private JPanel contentPane;
    private static ImageIcon icon;

    /**
     * Konstruktor
     */
    public Hauptoberfl�che(ActionListener listener) {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 450, 300);

	// icon = new ImageIcon("relativer Pfad zum Icon");
	// setIconImage(icon.getImage());

	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);

	JButton btnZimmer = new JButton("Zimmer");
	btnZimmer.setBounds(168, 42, 97, 25);
	btnZimmer.addActionListener(listener);
	contentPane.add(btnZimmer);

	JButton btnGaeste = new JButton("G�ste");
	btnGaeste.setBounds(168, 104, 97, 25);
	btnGaeste.addActionListener(listener);
	contentPane.add(btnGaeste);

	JButton btnBuchung = new JButton("Buchung");
	btnBuchung.setBounds(168, 171, 97, 25);
	btnBuchung.addActionListener(listener);
	contentPane.add(btnBuchung);
    }
}
