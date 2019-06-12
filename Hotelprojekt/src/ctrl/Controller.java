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
import java.util.List;

import gui.*;
import model.Buchung;
import model.Buchungsanfrage;
import model.Gast;
import model.Hotel;
import model.Zimmer;

public class Controller implements ActionListener {

    private Hauptoberfläche hauptfenster;
    private ZimmerDialog hinzuzimmer;
    private SmallBuchungsDialog smallBuchung;
    private OptionsDialog optionsDialog;
    private GastDialog gastDialog;
    private GästeListeDialog gaesteListeDialog;

    private List<Zimmer> options;

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
	smallBuchung = new SmallBuchungsDialog(this);
	optionsDialog = new OptionsDialog(this);
	gastDialog = new GastDialog(this, hotel.getGastCount());
	gaesteListeDialog = new GästeListeDialog();

	hauptfenster.showData(hotel.getZimmerList(), hotel.getBuchungsList());
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
	    if (nummer > 0) {
		if (hotel.zimmernummerVergeben(nummer)) {
		    hotel.loescheZimmer(nummer);
		    hauptfenster.showData(hotel.getZimmerList(), hotel.getBuchungsList());
		} else {
		    hinzuzimmer.promptZimmerExistiertNicht();
		}
	    }
	    break;

	case "Zimmer speichern":
	    Zimmer zimmer = hinzuzimmer.getZimmer();
	    if (hotel.zimmernummerVergeben(zimmer.getNummer())) {
		if (!hinzuzimmer.promptUeberschreiben()) {
		    break;
		} else {
		    hotel.loescheZimmer(zimmer.getNummer());
		}
	    }
	    hinzuzimmer.setVisible(false);
	    hotel.addNewZimmer(zimmer);
	    hinzuzimmer.resetDarstellung();
	    hauptfenster.showData(hotel.getZimmerList(), hotel.getBuchungsList());
	    break;

	case "Speichern & Verlassen":
	    hotelZuCSV(hotel, file);
	    System.exit(0);
	    break;

	case "Gespeichertes verwerfen":
	    hotel = new Hotel();
	    hotelZuCSV(hotel, file);
	    hauptfenster.showData(hotel.getZimmerList(), hotel.getBuchungsList());
	    break;

	case "Buchung aufnehmen":
	    smallBuchung.showDialog();
	    break;

	case "Zimmer suchen":
	    Buchungsanfrage anfrage = smallBuchung.getAnfrage();
	    // Suche nach passendem Zimmer
	    options = hotel.getOptionen(anfrage);
	    optionsDialog.reset();
	    optionsDialog.showData(options, anfrage);
	    smallBuchung.setVisible(false);
	    break;

	case "Auswahl bestätigen":
	    gastDialog.setVisible(true);
	    break;

	case "Gast speichern":
	    if (gastDialog.allesAusgefuellt()) {
		hotel.addBuchung(new Buchung(options.get(optionsDialog.getNummer()), gastDialog.getGast(),
			smallBuchung.getAnfrage().getZeitraum()));
		gastDialog.reset();
		optionsDialog.setVisible(false);
		hauptfenster.showData(hotel.getZimmerList(), hotel.getBuchungsList());
	    } else {
		gastDialog.unausgefuellteFelder();
	    }
	    break;

	case "Gästeliste":
	    gaesteListeDialog.setGäste(hotel.getGäste());
	    gaesteListeDialog.setVisible(true);
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
		// System.out.println("Zeile: " + zeile);
		if (zeile.equals("Zimmer: ")) {
		    status = 0;
		    continue;
		} else if (zeile.equals("Gaeste:")) {
		    status = 1;
		    continue;
		} else if (zeile.equals("Buchungen:")) {
		    status = 2;
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
		    }
		    break;
		case 1:
		    // Gäste werden gelesen
		    if (elemente.length == 6) {
			hotel.addGast(new Gast(Integer.parseInt(elemente[0]), elemente[1], elemente[2], elemente[3],
				elemente[4], elemente[5]));
		    }
		    break;

		case 2:
		    // Buchungen werden gelesen
		    if (elemente.length == 4) {
			hotel.addBuchung(Integer.parseInt(elemente[0]), elemente[1], elemente[2],
				Integer.parseInt(elemente[3]));
		    }
		    break;
		}
	    }
	    reader.close();
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
	    writer.println("Gaeste:");
	    for (Gast g : hotel.getGäste()) {
		writer.println(g.toString());
	    }
	    writer.println("Buchungen:");
	    for (Buchung b : hotel.getBuchungsList()) {
		writer.println(b.toString());
	    }
	    writer.flush();
	    writer.close();
	} catch (IOException e) {

	}
    }
}