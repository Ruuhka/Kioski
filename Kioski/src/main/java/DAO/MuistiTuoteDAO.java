
package DAO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import kioski.domain.Tuote;

public class MuistiTuoteDAO implements TuoteDAO {
    private TuoteCSVKasittelija kasittelija;
    private HashMap<Integer, Tuote> tuotteet;

    public MuistiTuoteDAO() {
        this.kasittelija = new OmaTuoteCSVKasittelija("tuotteet.csv");
        this.tuotteet = kasittelija.lataa();
    }

    @Override
    public void tallenna(Tuote tuote) {
        tuotteet.put(tuote.getTunnus(), tuote);
        tallennaTiedostoon();
    }
    
    @Override
    public void tallenna(Collection<Tuote> tallennettavat) {
        for (Tuote tuote : tallennettavat) {
            tuotteet.put(tuote.getTunnus(), tuote);
        }
        tallennaTiedostoon();
    }

    @Override
    public void poista(int tunnus) {
        tuotteet.remove(tunnus);
    }

    @Override
    public Tuote hae(String nimi) {
        for (Integer tunnus : tuotteet.keySet()) {
            Tuote tuote = tuotteet.get(tunnus);
            if (nimi.equalsIgnoreCase(tuote.getNimi())) {
                return tuote;
            }
        }
        return null;
    }

    @Override
    public Tuote hae(int tunnus) {
        return tuotteet.get(tunnus);    
    }

    @Override
    public Collection<Tuote> haeKaikki() {
        ArrayList<Tuote> tuotelista = new ArrayList<>();
        for (Integer tunnus : tuotteet.keySet()) {
            tuotelista.add(tuotteet.get(tunnus));
        }
        return tuotelista;
    }
    
    private void tallennaTiedostoon() {
        try {
            kasittelija.tallenna(tuotteet);
        } catch (IOException e) {
            System.out.println("Tiedoston kirjoittamisessa tapahtui virhe: " + e.getMessage());
        }
    }
    
}
