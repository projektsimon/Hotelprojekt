import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;



import javax.swing.JFrame;



public class Controller implements ActionListener{

	

	private Buchung buchung;

	private Gaeste gaeste;

	private Hauptoberfl�che mainFrame;

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

		mainFrame = new Hauptoberfl�che(this);

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
			
			case "Buchung Hinzuf�gen":

				visibleFrame.setVisible(false);

				hinzubuchung.setVisible(true);

				visibleFrame = hinzubuchung;

			break;
			
			case "Gast Hinzuf�gen":

				visibleFrame.setVisible(false);

				hinzugaeste.setVisible(true);

				visibleFrame = hinzugaeste;

			break;
			
			case "Zimmer Hinzuf�gen":

				visibleFrame.setVisible(false);

				hinzuzimmer.setVisible(true);

				visibleFrame = hinzuzimmer;

			break;
			
			case "Zur�ck":

				visibleFrame.setVisible(false);

				mainFrame.setVisible(true);

				visibleFrame = mainFrame;

			break;
			
			

			
			

		}

	}

	

}