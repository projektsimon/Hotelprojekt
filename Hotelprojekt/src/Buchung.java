import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class Buchung extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Buchung(ActionListener listener) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Hotelmanager");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnUebersicht = new JButton("\u00DCbersicht");
		btnUebersicht.setBounds(161, 64, 97, 25);
		btnUebersicht.addActionListener(listener);
		contentPane.add(btnUebersicht);
		
		JButton btnHinzufuegen = new JButton("Hinzuf\u00FCgen");
		btnHinzufuegen.setBounds(161, 124, 97, 25);
		btnHinzufuegen.addActionListener(listener);
		contentPane.add(btnHinzufuegen);
	}

}
