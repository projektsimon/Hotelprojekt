package model;

public class Buchung {
    private Zimmer zimmer;
    private Gast gast;
    private Zeitraum zeitraum;
    
    public Buchung(Zimmer zimmer, Gast gast, Zeitraum zeitraum) {
	this.zimmer = zimmer;
	this.gast = gast;
	this.zeitraum = zeitraum;
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
}
