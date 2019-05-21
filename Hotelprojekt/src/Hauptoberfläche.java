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
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hauptoberfläche frame = new Hauptoberfläche();
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
	public Hauptoberfläche() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnZimmer = new JButton("Zimmer");
		btnZimmer.setBounds(168, 42, 97, 25);
		contentPane.add(btnZimmer);
		
		JButton btnGaeste = new JButton("G\u00E4ste");
		btnGaeste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnGaeste.setBounds(168, 104, 97, 25);
		contentPane.add(btnGaeste);
		
		JButton btnBuchung = new JButton("Buchung");
		btnBuchung.setBounds(168, 171, 97, 25);
		contentPane.add(btnBuchung);
	}
}
