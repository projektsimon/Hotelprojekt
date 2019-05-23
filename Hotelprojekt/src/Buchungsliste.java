import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;

public class Buchungsliste extends JFrame {

	private JPanel contentPane;


	public Buchungsliste() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList list = new JList();
		list.setBounds(22, 54, 371, 437);
		contentPane.add(list);
		
		JLabel lblBuchungHinzufgen = new JLabel("Buchung Hinzuf\u00FCgen:");
		lblBuchungHinzufgen.setBounds(31, 13, 138, 16);
		contentPane.add(lblBuchungHinzufgen);
		
		JButton btnBuchungLoeschen = new JButton("Buchung l\u00F6schen");
		btnBuchungLoeschen.setBounds(22, 504, 147, 25);
		contentPane.add(btnBuchungLoeschen);
	}

}
