import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class Gaeste extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Gaeste(ActionListener listener) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnUebersicht = new JButton("\u00DCbersicht");
		btnUebersicht.setBounds(158, 47, 97, 25);
		btnUebersicht.addActionListener(listener);
		contentPane.add(btnUebersicht);
		
		JButton btnHinzufuegen = new JButton("Hinzuf\u00FCgen");
		btnHinzufuegen.setBounds(158, 111, 97, 25);
		btnHinzufuegen.addActionListener(listener);
		contentPane.add(btnHinzufuegen);
	}

}
