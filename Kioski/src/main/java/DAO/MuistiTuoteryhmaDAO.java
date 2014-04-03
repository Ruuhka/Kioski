
package DAO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import kioski.domain.Tuoteryhma;

public class MuistiTuoteryhmaDAO implements TuoteryhmaDAO {
    private TuoteryhmaCSVKasittelija kasittelija;
    private HashMap<Integer, Tuoteryhma> tuoteryhmat;

    public MuistiTuoteryhmaDAO() {
        this.kasittelija = new OmaTuoteryhmaCSVKasittelija("tuoteryhmat.csv");
        this.tuoteryhmat = kasittelija.lataa();
    }
    
    @Override
    public void tallenna(Tuoteryhma tuoteryhma) {
        tuoteryhmat.put(tuoteryhma.getTunnus(), tuoteryhma);
        tallennaTiedostoon();
    }
    
    
    @Override
    public void tallenna(Collection<Tuoteryhma> tallennettavat) {
        for (Tuoteryhma tuoteryhma : tallennettavat) {
            tuoteryhmat.put(tuoteryhma.getTunnus(), tuoteryhma);            
        }
        tallennaTiedostoon();
    }

    @Override
    public void poista(int tunnus) {
        tuoteryhmat.remove(tunnus);
    }

    @Override
    public Tuoteryhma hae(String nimi) {
        for (Integer tunnus : tuoteryhmat.keySet()) {
            Tuoteryhma tuoteryhma = tuoteryhmat.get(tunnus);
            if (tuoteryhma.getNimi().equalsIgnoreCase(nimi)) {
                return tuoteryhma;
            }
        }
        return null;
    }

    @Override
    public Tuoteryhma hae(int tunnus) {
        return tuoteryhmat.get(tunnus);
    }

    @Override
    public Collection<Tuoteryhma> haeKaikki() {
        ArrayList<Tuoteryhma> tuoteryhmat = new ArrayList<>();
        for (Integer tunnus : this.tuoteryhmat.keySet()) {
            tuoteryhmat.add(this.tuoteryhmat.get(tunnus));
        }
        return tuoteryhmat;
    }

    private void tallennaTiedostoon() {
        try {
            kasittelija.tallenna(tuoteryhmat);
        } catch (IOException e) {
            System.out.println("Tiedoston kirjoittamisessa tapahtui virhe: " + e.getMessage());
        }
    }   
}
