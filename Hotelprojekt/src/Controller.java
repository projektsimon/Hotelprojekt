import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;



import javax.swing.JFrame;



public class Controller implements ActionListener{

	

	private Buchung buchung;

	private Gaeste gaeste;

	private Hauptoberfläche mainFrame;

	private Zimmer zimmer;

	private JFrame visibleFrame;
	
	private Hinzu_Buchung hinzubuchung;
	
	private Hinzu_Gaeste hinzugaeste;
	
	private Hinzu_Zimmer hinzuzimmer;
	

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
		
		hinzubuchung = new Hinzu_Buchung(this);
		
		hinzugaeste = new Hinzu_Gaeste(this);
		
		hinzuzimmer = new Hinzu_Zimmer(this);
		
		
		
		
		

		

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
			
			case "Buchung Hinzufügen":

				visibleFrame.setVisible(false);

				hinzubuchung.setVisible(true);

				visibleFrame = hinzubuchung;

			break;
			
			case "Gast Hinzufügen":

				visibleFrame.setVisible(false);

				hinzugaeste.setVisible(true);

				visibleFrame = hinzugaeste;

			break;
			
			case "Zimmer Hinzufügen":

				visibleFrame.setVisible(false);

				hinzuzimmer.setVisible(true);

				visibleFrame = hinzuzimmer;

			break;
			
			case "Zurück":

				visibleFrame.setVisible(false);

				mainFrame.setVisible(true);

				visibleFrame = mainFrame;

			break;
			
			

			
			

		}

	}

	

}