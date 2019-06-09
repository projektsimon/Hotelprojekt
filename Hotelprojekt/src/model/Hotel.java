package model;

import java.util.LinkedList;
import java.util.List;

public class Hotel {
    private int gastZaehler = 0;
    private List<Zimmer> zimmer;
    private List<Gast> gäste;
    
    public Hotel() {
	zimmer = new LinkedList<Zimmer>();
	gäste = new LinkedList<Gast>();
    }
    
    public void addNewZimmer(Zimmer z) {
	zimmer.add(z);
    }
    
    public boolean zimmernummerVergeben(int nummer) {
	for(Zimmer z : zimmer) {
	    if(z.getNummer() == nummer) {
		return true;
	    }
	}
	
	return false;
    }
    
    public List<Zimmer> getZimmerList() {
	return zimmer;
    }
}
