package model;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Zimmer {
    private int nummer;
    private boolean badewanne;
    private int anzahlBetten;
    private boolean fernseher;
    private boolean minibar;
    private int preisWerktag;
    private int preisWochende;
    private List<Zeitraum> belegung;

    public Zimmer(int nummer, int anzahlBetten, boolean badewanne, boolean fernseher, boolean minibar, int preisWerktag,
	    int preisWochenende) {
	this.nummer = nummer;
	this.badewanne = badewanne;
	this.anzahlBetten = anzahlBetten;
	this.fernseher = fernseher;
	this.minibar = minibar;
	this.preisWerktag = preisWerktag;
	this.preisWochende = preisWochenende;
	belegung = new LinkedList<Zeitraum>();
    }

    public int getNummer() {
	return nummer;
    }

    public void setNummer(int nummer) {
	this.nummer = nummer;
    }

    public boolean hatBadewanne() {
	return badewanne;
    }

    public void setBadewanne(boolean badewanne) {
	this.badewanne = badewanne;
    }

    public int getAnzahlBetten() {
	return anzahlBetten;
    }

    public void setAnzahlBetten(int anzahlBetten) {
	this.anzahlBetten = anzahlBetten;
    }

    public boolean hatTV() {
	return fernseher;
    }

    public void setFernseher(boolean fernseher) {
	this.fernseher = fernseher;
    }

    public boolean hatMinibar() {
	return minibar;
    }

    public void setMinibar(boolean minibar) {
	this.minibar = minibar;
    }

    public int getPreisWerktag() {
	return preisWerktag;
    }

    public void setPreisWerktag(int preisWerktag) {
	this.preisWerktag = preisWerktag;
    }

    public int getPreisWochende() {
	return preisWochende;
    }

    public void setPreisWochende(int preisWochende) {
	this.preisWochende = preisWochende;
    }

    @Override
    public String toString() {
	return Integer.toString(nummer) + "," + Integer.toString(anzahlBetten) + "," + Boolean.toString(badewanne) + ","
		+ Boolean.toString(fernseher) + "," + Boolean.toString(minibar) + "," + Integer.toString(preisWerktag)
		+ "," + Integer.toString(preisWochende);
    }

    public boolean matches(Buchungsanfrage anfrage) {
	return false;
    }

    public boolean getSlot(Zeitraum zeitraum) {
	if (belegung.size() == 0) {
	    //keine Belegung
	    return true;
	} else if (zeitraum.getEnde().before(belegung.get(0).getAnfang())) {
	    // kann davor einordnen
	    return true;
	} else if (zeitraum.getAnfang().before(belegung.get(belegung.size() - 1).getEnde())) {
	    return true;
	}

	// Überprüfe, ob Zeitraum in die Lücken passt
	for (int i = 1; i < belegung.size(); i++) {
	    if (zeitraum.getAnfang().after(belegung.get(i - 1).getEnde())
		    && zeitraum.getEnde().before(belegung.get(i).getAnfang())) {
		// Zwischenslot gefunden
		return true;
	    }
	}

	return false;
    }

    public void addBelegung(Zeitraum zeitraum) {
	belegung.add(zeitraum);
	
	Collections.sort(belegung, new Comparator<Zeitraum>() {
	    @Override
	    public int compare(Zeitraum z1, Zeitraum z2) {
		return z1.getAnfang().compareTo(z2.getAnfang());
	    }
	});
    }

}
