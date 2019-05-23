import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JButton;


public class Zimmerliste extends JFrame {

	private JPanel contentPane;

	
	public Zimmerliste() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList list = new JList();
		list.setBounds(12, 39, 299, 465);
		contentPane.add(list);
		
		JLabel lblZimmerliste = new JLabel("Zimmerliste:");
		lblZimmerliste.setBounds(22, 13, 102, 16);
		contentPane.add(lblZimmerliste);
		
		JButton btnZimmerLoeschen = new JButton("Zimmer L\u00F6schen");
		btnZimmerLoeschen.setBounds(12, 517, 183, 25);
		contentPane.add(btnZimmerLoeschen);
	}
}
