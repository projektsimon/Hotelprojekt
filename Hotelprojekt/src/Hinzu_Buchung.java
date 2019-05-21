import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JSeparator;

public class Hinzu_Buchung extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Hinzu_Buchung() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGast = new JLabel("Gast:");
		lblGast.setBounds(34, 45, 56, 16);
		contentPane.add(lblGast);
		
		JLabel lblZimmernumer = new JLabel("Zimmernumer:");
		lblZimmernumer.setBounds(34, 88, 110, 16);
		contentPane.add(lblZimmernumer);
		
		JLabel lblAnreise = new JLabel("Anreise:");
		lblAnreise.setBounds(34, 147, 56, 16);
		contentPane.add(lblAnreise);
		
		JLabel lblAbreise = new JLabel("Abreise:");
		lblAbreise.setBounds(34, 176, 56, 16);
		contentPane.add(lblAbreise);
		
		JTextPane textAnreise = new JTextPane();
		textAnreise.setBounds(150, 147, 70, 22);
		contentPane.add(textAnreise);
		
		JTextPane textAbreise = new JTextPane();
		textAbreise.setBounds(150, 181, 70, 22);
		contentPane.add(textAbreise);
		
		JTextPane textZimernumer = new JTextPane();
		textZimernumer.setBounds(150, 88, 70, 22);
		contentPane.add(textZimernumer);
		
		JTextPane textGast = new JTextPane();
		textGast.setBounds(150, 45, 70, 22);
		contentPane.add(textGast);
	}
}
