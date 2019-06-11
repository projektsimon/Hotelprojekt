package model;

import java.util.Date;

public class Zeitraum {
    private Date anfang;
    private Date ende;
    
    public Zeitraum(Date anfang, Date ende) {
	this.anfang = anfang;
	this.ende = ende;
    }
    
    public Date getAnfang() {
	return anfang;
    }
    
    public Date getEnde() {
	return ende;
    }
}
