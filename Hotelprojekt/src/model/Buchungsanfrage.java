package model;

public class Buchungsanfrage {
    private Zeitraum buchung;
    private boolean willBadewanne;
    private boolean willMinibar;
    private boolean willTV;
    private int anzahlBetten;
    
    public Buchungsanfrage(Zeitraum buchung, boolean badewanne, boolean minibar, boolean tv, int betten) {
	this.buchung = buchung;
	this.willBadewanne = badewanne;
	this.willMinibar = minibar;
	this.willTV = tv;
	this.anzahlBetten = betten;
    }

    public int getAnzahlBetten() {
	return anzahlBetten;
    }
    
    public Zeitraum getZeitraum() {
	return buchung;
    }
    
    public boolean willBadewanne() {
	return willBadewanne;
    }
    
    public boolean willTV() {
	return willTV;
    }
    
    public boolean willMinibar() {
	return willMinibar;
    }
}
