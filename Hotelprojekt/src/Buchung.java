import java.awt.event.ActionListener;



import javax.swing.JFrame;

import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;

import javax.swing.JButton;



public class Buchung extends JFrame {



	private JPanel contentPane;



	/**

	 * Create the frame.

	 */

	public Buchung(ActionListener listener) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setTitle("Hotelmanager");

		setBounds(100, 100, 450, 300);

		contentPane = new JPanel();

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		contentPane.setLayout(null);

		

		JButton btnUebersicht = new JButton("Zur\u00FCck");

		btnUebersicht.setBounds(323, 215, 97, 25);

		btnUebersicht.addActionListener(listener);

		contentPane.add(btnUebersicht);

		

		JButton btnHinzufuegen = new JButton("Buchung Hinzuf\u00FCgen");

		btnHinzufuegen.setBounds(129, 124, 179, 25);

		btnHinzufuegen.addActionListener(listener);

		contentPane.add(btnHinzufuegen);
		
		JButton btnBuchungsliste = new JButton("Buchungsliste");
		btnBuchungsliste.setBounds(129, 86, 179, 25);
		contentPane.add(btnBuchungsliste);

	}



}