package model;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import model.Buchung;
import model.Zimmer;

public class Hotel {
    private List<Zimmer> zimmerListe;
    private List<Gast> gaesteListe;
    private List<Buchung> buchungen;

    public Hotel() {
	zimmerListe = new LinkedList<Zimmer>();
	gaesteListe = new LinkedList<Gast>();
	buchungen = new LinkedList<Buchung>();
    }

    public void addNewZimmer(Zimmer z) {
	zimmerListe.add(z);
    }
    
    public void addGast(Gast gast) {
	gaesteListe.add(gast);
    }

    public boolean zimmernummerVergeben(int nummer) {
	for (Zimmer z : zimmerListe) {
	    if (z.getNummer() == nummer) {
		return true;
	    }
	}

	return false;
    }

    public List<Zimmer> getZimmerList() {
	return zimmerListe;
    }

    public void loescheZimmer(int nummer) {
	for (Zimmer z : zimmerListe) {
	    if (z.getNummer() == nummer) {
		zimmerListe.remove(z);
	    }
	}
    }

    @SuppressWarnings("unchecked")
    public List<Zimmer> getOptionen(Buchungsanfrage anfrage) {
	@SuppressWarnings("rawtypes")
	LinkedList<Zimmer> zimmerSortiert = (LinkedList) ((LinkedList<Zimmer>) zimmerListe).clone();

	// Suche auf passende Bettenanzahl und freien Zeitraum einschränken
	zimmerSortiert.removeIf(z -> z.getAnzahlBetten() < anfrage.getAnzahlBetten());
	zimmerSortiert.removeIf(z -> z.getSlot(anfrage.getZeitraum()));

	@SuppressWarnings("rawtypes")
	LinkedList<Zimmer> zimmerSelected = (LinkedList) ((LinkedList<Zimmer>) zimmerSortiert).clone();
	zimmerSelected.removeIf(z -> ((anfrage.willBadewanne() && !z.hatBadewanne())
		|| (anfrage.willMinibar() && !z.hatMinibar()) || (anfrage.willTV() && !z.hatTV())));

	if (zimmerSelected.size() > 0) {
	    Collections.sort(zimmerSelected, new Comparator<Zimmer>() {
		@Override
		public int compare(Zimmer z1, Zimmer z2) {
		    return z1.getAnzahlBetten() - z2.getAnzahlBetten();
		}
	    });
	    return zimmerSelected;
	} else {
	    Collections.sort(zimmerSortiert, new Comparator<Zimmer>() {
		@Override
		public int compare(Zimmer z1, Zimmer z2) {
		    return z1.getAnzahlBetten() - z2.getAnzahlBetten();
		}
	    });
	    return zimmerSortiert;
	}
    }

    public int getGastCount() {
	return gaesteListe.size();
    }

    public void addBuchung(Buchung buchung) {
	buchungen.add(buchung);
	gaesteListe.add(buchung.getGast());
	Zimmer z = buchung.getZimmer();
	z.addBelegung(buchung.getZeitraum());
    }

    public List<Buchung> getBuchungsList() {
	return buchungen;
    }

    public List<Gast> getGäste() {
	return gaesteListe;
    }
}
