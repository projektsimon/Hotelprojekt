package gui;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class Zimmer extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */

	public Zimmer(ActionListener listener) {
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

		JButton btnHinzufuegen = new JButton("Zimmer Hinzuf\u00FCgen");
		btnHinzufuegen.setBounds(124, 130, 181, 25);
		btnHinzufuegen.addActionListener(listener);
		contentPane.add(btnHinzufuegen);
		
		JButton btnZimmerliste = new JButton("Zimmerliste");
		btnZimmerliste.setBounds(124, 92, 181, 25);
		btnZimmerliste.addActionListener(listener);
		contentPane.add(btnZimmerliste);

	}



}