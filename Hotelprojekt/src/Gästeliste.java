import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Gästeliste extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gästeliste frame = new Gästeliste();
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
	public Gästeliste() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList list = new JList();
		list.setBounds(31, 45, 350, 456);
		contentPane.add(list);
		
		JLabel lblGsteliste = new JLabel("G\u00E4steliste:");
		lblGsteliste.setBounds(31, 13, 112, 16);
		contentPane.add(lblGsteliste);
		
		JButton btnGastLoeschen = new JButton("Gast L\u00F6schen");
		btnGastLoeschen.setBounds(31, 514, 148, 25);
		contentPane.add(btnGastLoeschen);
	}

}
