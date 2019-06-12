package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Gast {
    private int id;
    private String name;
    private String vorname;
    private String adresse;
    private Date geburtsdatum;
    private String zahlart;
    
    private static SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
    
    public Gast(int id, String vorname, String name, String adresse, Date date, String zahlart) {
	this.id = id;
	this.vorname = vorname;
	this.name = name;
	this.adresse = adresse;
	this.geburtsdatum = date;
	this.zahlart = zahlart;
    }
    
    public Gast(int id, String vorname, String name, String adresse, String dateString, String zahlart) {
   	this.id = id;
   	this.vorname = vorname;
   	this.name = name;
   	this.adresse = adresse;
   	try {
	    this.geburtsdatum = formatter.parse(dateString);
	} catch (ParseException e) {
	    e.printStackTrace();
	}
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
    
    @Override
    public String toString() {
	return Integer.toString(id) + "," + name + "," + vorname + "," + adresse + "," + formatter.format(geburtsdatum) + "," + zahlart;
    }
}
