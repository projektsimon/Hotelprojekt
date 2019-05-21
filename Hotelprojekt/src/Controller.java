import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class Controller implements ActionListener{
	
	private Buchung buchung;
	private Gaeste gaeste;
	private Hauptoberfläche mainFrame;
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
		mainFrame = new Hauptoberfläche(this);
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
			
			case "Übersicht":
				visibleFrame.setVisible(false);
				mainFrame.setVisible(true);
				visibleFrame = mainFrame;
			break;
			
			case "Gäste":
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
