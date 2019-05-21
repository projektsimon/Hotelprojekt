import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextPane;

public class Hinzu_Gaeste extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hinzu_Gaeste frame = new Hinzu_Gaeste();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Hinzu_Gaeste() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(12, 27, 56, 16);
		contentPane.add(lblId);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(12, 56, 56, 16);
		contentPane.add(lblName);
		
		JLabel lblAdresse = new JLabel("Adresse:");
		lblAdresse.setBounds(12, 98, 56, 16);
		contentPane.add(lblAdresse);
		
		JLabel lblGebDatum = new JLabel("Geb. Datum:");
		lblGebDatum.setBounds(12, 142, 85, 16);
		contentPane.add(lblGebDatum);
		
		JLabel lblZahlart = new JLabel("Zahlart:");
		lblZahlart.setBounds(12, 186, 56, 16);
		contentPane.add(lblZahlart);
		
		JTextPane textID = new JTextPane();
		textID.setBounds(105, 21, 77, 22);
		contentPane.add(textID);
		
		JTextPane textName = new JTextPane();
		textName.setBounds(105, 56, 77, 22);
		contentPane.add(textName);
		
		JTextPane textAdresse = new JTextPane();
		textAdresse.setBounds(105, 98, 77, 22);
		contentPane.add(textAdresse);
		
		JTextPane textZahlart = new JTextPane();
		textZahlart.setBounds(105, 186, 77, 22);
		contentPane.add(textZahlart);
		
		JTextPane txtpnDdmmjjjj = new JTextPane();
		txtpnDdmmjjjj.setText("dd.mm.jjjj");
		txtpnDdmmjjjj.setBounds(105, 142, 77, 22);
		contentPane.add(txtpnDdmmjjjj);
	}

}
