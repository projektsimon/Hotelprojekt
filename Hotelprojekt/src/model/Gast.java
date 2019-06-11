package model;

import java.util.Date;

public class Gast {
    private int id;
    private String name;
    private String vorname;
    private String adresse;
    private Date geburtsdatum;
    private String zahlart;
    
    public Gast(int id, String vorname, String name, String adresse, Date date, String zahlart) {
	this.id = id;
	this.vorname = vorname;
	this.name = name;
	this.adresse = adresse;
	this.geburtsdatum = date;
	this.zahlart = zahlart;
    }

    public int getId() {
	return id;
    }

    public String getName() {
	return name;
    }

    public String getVorname() {
	return vorname;
    }

    public String getAdresse() {
	return adresse;
    }

    public Date getGeburtsdatum() {
	return geburtsdatum;
    }
    
    public String getZahlart() {
	return zahlart;
    }
}
