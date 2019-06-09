package model;

public class Zimmer {
    private int nummer;
    private boolean badewanne;
    private int anzahlBetten;
    private boolean fernseher;
    private boolean minibar;
    private int preisWerktag;
    private int preisWochende;

    public Zimmer(int nummer, int anzahlBetten, boolean badewanne, boolean fernseher, boolean minibar, int preisWerktag,
	    int preisWochenende) {
	this.nummer = nummer;
	this.badewanne = badewanne;
	this.anzahlBetten = anzahlBetten;
	this.fernseher = fernseher;
	this.minibar = minibar;
	this.preisWerktag = preisWerktag;
	this.preisWochende = preisWochenende;
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

    public boolean hatFernseher() {
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

}
