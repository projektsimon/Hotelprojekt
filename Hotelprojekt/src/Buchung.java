import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class Buchung extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Buchung frame = new Buchung();
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
	public Buchung() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnUebersicht = new JButton("\u00DCbersicht");
		btnUebersicht.setBounds(161, 64, 97, 25);
		contentPane.add(btnUebersicht);
		
		JButton btnHinzufuegen = new JButton("Hinzuf\u00FCgen");
		btnHinzufuegen.setBounds(161, 124, 97, 25);
		contentPane.add(btnHinzufuegen);
	}

}
