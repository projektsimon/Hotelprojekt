package ctrl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import gui.*;
import model.Hotel;
import model.Zimmer;

public class Controller implements ActionListener {

    private Hauptoberfläche hauptfenster;
    private ZimmerDialog hinzuzimmer;

    private Hotel hotel;

    private final String file = "Hotel.csv";

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	@SuppressWarnings("unused")
	Controller control = new Controller();
    }

    public Controller() {
	// Datenmodell
	hotel = hotelAusCSV(file);

	// GUI
	hauptfenster = new Hauptoberfläche(this);
	hinzuzimmer = new ZimmerDialog(this);
	hauptfenster.showData(hotel.getZimmerList());
	hauptfenster.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	switch (e.getActionCommand()) {
	case "Zimmer hinzufügen / ändern":
	    hinzuzimmer.setVisible(true);
	    break;
	    
	case "Zimmer entfernen":
	    int nummer = hinzuzimmer.entferneZimmer();
	    System.out.println("Nummer: " + nummer);
	    if(nummer > 0) {
		if(hotel.zimmernummerVergeben(nummer)) {
		    hotel.loescheZimmer(nummer);
		    hauptfenster.showData(hotel.getZimmerList());
		} else {
		    hinzuzimmer.promptZimmerExistiertNicht();
		}
	    }
	    break;

	case "Zimmer speichern":
	    Zimmer zimmer = hinzuzimmer.getZimmer();
	    if (hotel.zimmernummerVergeben(zimmer.getNummer())) {
		if(!hinzuzimmer.promptUeberschreiben()) {
		    break;
		} else {
		    hotel.loescheZimmer(zimmer.getNummer());
		}
	    }
	    hinzuzimmer.setVisible(false);
	    hotel.addNewZimmer(zimmer);
	    hinzuzimmer.resetDarstellung();
	    hauptfenster.showData(hotel.getZimmerList());
	    break;

	case "Speichern & Verlassen":
	    hotelZuCSV(hotel, file);
	    System.exit(0);
	    break;

	case "Gespeichertes verwerfen":
	    hotel = new Hotel();
	    hotelZuCSV(hotel, file);
	    hauptfenster.showData(hotel.getZimmerList());
	    break;

	default:
	    System.out.println(e.getActionCommand());
	    break;
	}
    }

    public Hotel hotelAusCSV(String dateiname) {
	Hotel hotel = new Hotel();
	File file = new File(dateiname);
	if (!file.exists()) {
	    System.out.println("File doesn't exist!");
	    return hotel;
	}

	try {
	    BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
	    String zeile;
	    int status = 0;
	    while ((zeile = reader.readLine()) != null) {
		//System.out.println("Zeile: " + zeile);
		if (zeile.equals("Zimmer: ")) {
		    status = 0;
		    continue;
		} else if (zeile.equals("Buchungen")) {
		    status = 1;
		    continue;
		}

		String[] elemente = zeile.split(",");
		switch (status) {
		case 0:
		    // Zimmer werden gelesen
		    if (elemente.length == 7) {
			hotel.addNewZimmer(new Zimmer(Integer.parseInt(elemente[0]), Integer.parseInt(elemente[1]),
				Boolean.parseBoolean(elemente[2]), Boolean.parseBoolean(elemente[3]),
				Boolean.parseBoolean(elemente[4]), Integer.parseInt(elemente[5]),
				Integer.parseInt(elemente[6])));
			//System.out.println("Gelesen:");
		    }
		}
	    }
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	    return new Hotel();
	} catch (IOException e) {
	    e.printStackTrace();
	    return new Hotel();
	}

	return hotel;
    }

    public void hotelZuCSV(Hotel hotel, String dateiname) {
	try {
	    PrintWriter writer = new PrintWriter(new FileWriter(dateiname));
	    writer.println("Zimmer:");
	    for (Zimmer z : hotel.getZimmerList()) {
		writer.println(z.toString());
	    }
	    writer.flush();
	    writer.close();
	} catch (IOException e) {

	}
    }
}