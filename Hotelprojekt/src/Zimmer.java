import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class Zimmer extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Zimmer frame = new Zimmer();
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
	public Zimmer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnUebersicht = new JButton("\u00DCbersicht");
		btnUebersicht.setBounds(169, 62, 97, 25);
		contentPane.add(btnUebersicht);
		
		JButton btnHinzufuegen = new JButton("Hinzuf\u00FCgen");
		btnHinzufuegen.setBounds(169, 122, 97, 25);
		contentPane.add(btnHinzufuegen);
	}

}
