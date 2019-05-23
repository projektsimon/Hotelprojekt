import java.awt.BorderLayout;

import java.awt.EventQueue;

import java.awt.event.ActionListener;



import javax.swing.JFrame;

import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;

import javax.swing.JButton;



public class Gaeste extends JFrame {



	private JPanel contentPane;



	/**

	 * Create the frame.

	 */

	public Gaeste(ActionListener listener) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 450, 300);

		contentPane = new JPanel();

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		contentPane.setLayout(null);

		

		JButton btnZurueck = new JButton("Zur\u00FCck");

		btnZurueck.setBounds(323, 215, 97, 25);

		btnZurueck.addActionListener(listener);

		contentPane.add(btnZurueck);

		

		JButton btnHinzufuegen = new JButton("Gast Hinzuf\u00FCgen");

		btnHinzufuegen.setBounds(134, 124, 140, 25);

		btnHinzufuegen.addActionListener(listener);

		contentPane.add(btnHinzufuegen);
		
		JButton btnGaesteliste = new JButton("G\u00E4steliste");
		btnGaesteliste.setBounds(134, 86, 140, 25);
		contentPane.add(btnGaesteliste);

	}



}