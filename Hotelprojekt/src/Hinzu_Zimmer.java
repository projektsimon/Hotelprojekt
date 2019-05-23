import java.awt.BorderLayout;

import java.awt.EventQueue;



import javax.swing.JFrame;

import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;

import javax.swing.JTextField;

import javax.swing.JCheckBox;

import javax.swing.JLabel;

import javax.swing.JTextPane;

import javax.swing.JEditorPane;

import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import javax.swing.JButton;



public class Hinzu_Zimmer extends JFrame {



	private JPanel contentPane;




	public Hinzu_Zimmer(ActionListener listener) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 450, 330);

		contentPane = new JPanel();

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		contentPane.setLayout(null);

		

		JCheckBox chckbxNewCheckBox = new JCheckBox("Badewanne");

		chckbxNewCheckBox.setBounds(12, 78, 113, 25);

		contentPane.add(chckbxNewCheckBox);

		

		JCheckBox chckbxTv = new JCheckBox("TV");

		chckbxTv.setBounds(12, 108, 113, 25);

		contentPane.add(chckbxTv);

		

		JCheckBox chckbxMinibar = new JCheckBox("Minibar");

		chckbxMinibar.setBounds(12, 138, 113, 25);

		contentPane.add(chckbxMinibar);

		

		JLabel lblZimmernummer = new JLabel("Zimmernummer:");

		lblZimmernummer.setBounds(12, 13, 113, 16);

		contentPane.add(lblZimmernummer);

		

		JLabel lblAnzahlBetten = new JLabel("Anzahl Betten:");

		lblAnzahlBetten.setBounds(12, 42, 113, 16);

		contentPane.add(lblAnzahlBetten);

		

		JLabel lblPreisMofr = new JLabel("Preis Mo-Fr:");

		lblPreisMofr.setBounds(12, 179, 113, 16);

		contentPane.add(lblPreisMofr);

		

		JLabel lblPreisFrmo = new JLabel("Preis Fr-Mo:");

		lblPreisFrmo.setBounds(12, 208, 113, 16);

		contentPane.add(lblPreisFrmo);

		

		JTextPane textZimmernummer = new JTextPane();

		textZimmernummer.setBounds(119, 13, 66, 22);

		contentPane.add(textZimmernummer);

		

		JTextPane textAnzahlBetten = new JTextPane();

		textAnzahlBetten.setBounds(119, 42, 66, 22);

		contentPane.add(textAnzahlBetten);

		

		JTextPane textPreisMoFr = new JTextPane();

		textPreisMoFr.setBounds(119, 179, 66, 22);

		contentPane.add(textPreisMoFr);

		

		JTextPane textPreisFrMo = new JTextPane();

		textPreisFrMo.setBounds(119, 208, 66, 22);

		contentPane.add(textPreisFrMo);
		
		JButton btnZurueck = new JButton("Zur\u00FCck");
		btnZurueck.setBounds(323, 245, 97, 25);
		btnZurueck.addActionListener(listener);
		contentPane.add(btnZurueck);
		
		JButton btnZimmerSpeichern = new JButton("Zimmer Speichern");
		btnZimmerSpeichern.setBounds(12, 245, 162, 25);
		contentPane.add(btnZimmerSpeichern);

	}
}