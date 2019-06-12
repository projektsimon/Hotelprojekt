package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Buchung {
    private Zimmer zimmer;
    private Gast gast;
    private Zeitraum zeitraum;
    private static SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
    
    public Buchung(Zimmer zimmer, Gast gast, Zeitraum zeitraum) {
	this.zimmer = zimmer;
	this.gast = gast;
	this.zeitraum = zeitraum;
    }

    public Buchung(Zimmer zimmer, String anfang, String ende, Gast gast) {
	this.zimmer = zimmer;
	this.gast = gast;
	Date dateAnfang = null, dateEnde = null;
	try {
	    dateAnfang = formatter.parse(anfang);
	    dateEnde = formatter.parse(ende);
	} catch (ParseException e) {
	    e.printStackTrace();
	}
	
	this.zeitraum = new Zeitraum(dateAnfang, dateEnde);
    }

    public Zimmer getZimmer() {
        return zimmer;
    }

    public Gast getGast() {
        return gast;
    }

    public Zeitraum getZeitraum() {
        return zeitraum;
    }
    
    @Override 
    public String toString() {
	return Integer.toString(zimmer.getNummer()) + "," + formatter.format(zeitraum.getAnfang()) + "," + formatter.format(zeitraum.getEnde()) + "," + Integer.toString(gast.getId()); 
    }
}
