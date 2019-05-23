import java.awt.BorderLayout;

import java.awt.EventQueue;



import javax.swing.JFrame;

import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;

import javax.swing.JButton;

import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;



public class Hauptoberfläche extends JFrame {



	private JPanel contentPane;



	/**

	 * Create the frame.

	 */

	public Hauptoberfläche(ActionListener listener) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 450, 300);

		contentPane = new JPanel();

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		contentPane.setLayout(null);

		

		JButton btnZimmer = new JButton("Zimmer");

		btnZimmer.setBounds(168, 42, 97, 25);

		btnZimmer.addActionListener(listener);

		contentPane.add(btnZimmer);

		

		JButton btnGaeste = new JButton("G\u00E4ste");

		btnGaeste.setBounds(168, 104, 97, 25);

		btnGaeste.addActionListener(listener);

		contentPane.add(btnGaeste);

		

		JButton btnBuchung = new JButton("Buchung");

		btnBuchung.setBounds(168, 171, 97, 25);

		btnBuchung.addActionListener(listener);

		contentPane.add(btnBuchung);

	}

}