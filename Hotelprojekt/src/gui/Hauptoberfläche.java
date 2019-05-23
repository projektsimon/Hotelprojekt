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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class Hauptoberfläche extends JFrame {

    private JPanel contentPane;
    private static ImageIcon icon;

    /**
     * Konstruktor
     */
    public Hauptoberfläche(ActionListener listener) {
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

	JButton btnGaeste = new JButton("Gäste");
	btnGaeste.setBounds(168, 104, 97, 25);
	btnGaeste.addActionListener(listener);
	contentPane.add(btnGaeste);

	JButton btnBuchung = new JButton("Buchung");
	btnBuchung.setBounds(168, 171, 97, 25);
	btnBuchung.addActionListener(listener);
	contentPane.add(btnBuchung);
    }
}
