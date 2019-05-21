import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;

public class Hinzu_Zimmer extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hinzu_Zimmer frame = new Hinzu_Zimmer();
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
	public Hinzu_Zimmer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Badewanne");
		chckbxNewCheckBox.setBounds(12, 78, 113, 25);
		contentPane.add(chckbxNewCheckBox);
		
		JCheckBox chckbxTv = new JCheckBox("TV");
		chckbxTv.setBounds(12, 108, 113, 25);
		contentPane.add(chckbxTv);
		
		JCheckBox chckbxMinibar = new JCheckBox("Minibar");
		chckbxMinibar.setBounds(12, 138, 113, 25);
		contentPane.add(chckbxMinibar);
		
		JLabel lblZimmernummer = new JLabel("Zimmernummer:");
		lblZimmernummer.setBounds(12, 13, 113, 16);
		contentPane.add(lblZimmernummer);
		
		JLabel lblAnzahlBetten = new JLabel("Anzahl Betten:");
		lblAnzahlBetten.setBounds(12, 42, 113, 16);
		contentPane.add(lblAnzahlBetten);
		
		JLabel lblPreisMofr = new JLabel("Preis Mo-Fr:");
		lblPreisMofr.setBounds(12, 179, 113, 16);
		contentPane.add(lblPreisMofr);
		
		JLabel lblPreisFrmo = new JLabel("Preis Fr-Mo:");
		lblPreisFrmo.setBounds(12, 208, 113, 16);
		contentPane.add(lblPreisFrmo);
		
		JTextPane textZimmernummer = new JTextPane();
		textZimmernummer.setBounds(119, 13, 66, 22);
		contentPane.add(textZimmernummer);
		
		JTextPane textAnzahlBetten = new JTextPane();
		textAnzahlBetten.setBounds(119, 42, 66, 22);
		contentPane.add(textAnzahlBetten);
		
		JTextPane textPreisMoFr = new JTextPane();
		textPreisMoFr.setBounds(119, 179, 66, 22);
		contentPane.add(textPreisMoFr);
		
		JTextPane textPreisFrMo = new JTextPane();
		textPreisFrMo.setBounds(119, 208, 66, 22);
		contentPane.add(textPreisFrMo);
	}
}
