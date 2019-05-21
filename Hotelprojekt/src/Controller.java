import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class Controller implements ActionListener{
	
	private Buchung buchung;
	private Gaeste gaeste;
	private Hauptoberfl�che mainFrame;
	private Zimmer zimmer;
	private JFrame visibleFrame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Controller control = new Controller();
	}
	
	public Controller() {
		buchung = new Buchung(this);
		gaeste = new Gaeste(this);
		mainFrame = new Hauptoberfl�che(this);
		zimmer = new Zimmer(this);
		
		mainFrame.setVisible(true);
		visibleFrame = mainFrame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
			case "Zimmer": 
				visibleFrame.setVisible(false);
				zimmer.setVisible(true);
				visibleFrame = zimmer;
			break;
			
			case "�bersicht":
				visibleFrame.setVisible(false);
				mainFrame.setVisible(true);
				visibleFrame = mainFrame;
			break;
			
			case "G�ste":
				visibleFrame.setVisible(false);
				gaeste.setVisible(true);
				visibleFrame = gaeste;
			break;
			
			case "Buchung":
				visibleFrame.setVisible(false);
				buchung.setVisible(true);
				visibleFrame = buchung;
			break;
		}
	}
	
}
