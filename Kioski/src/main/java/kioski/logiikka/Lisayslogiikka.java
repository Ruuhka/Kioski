

package kioski.logiikka;

import DAO.*;
import java.util.ArrayList;
import kioski.domain.Tuote;
import kioski.domain.Tuoteryhma;


public class Lisayslogiikka {
    private TuoteDAO tuoteDAO;
    private TuoteryhmaDAO tuoteryhmaDAO;

    public Lisayslogiikka(TuoteDAO tuoteDAO, TuoteryhmaDAO tuoteryhmaDAO) {
        this.tuoteDAO = tuoteDAO;
        this.tuoteryhmaDAO = tuoteryhmaDAO;
    }
    
    public void lisaaTuote(int tunnus, String nimi, double hinta, String kuvaus, int saldo) {
        tuoteDAO.tallenna(new Tuote(tunnus, nimi, hinta, kuvaus, saldo));
    }
    
    public void lisaaTuoteryhma(int tunnus, String nimi, String kuvaus) {
        tuoteryhmaDAO.tallenna(new Tuoteryhma(tunnus, nimi, kuvaus));
    }
    
    public void lisaaTuoteTuoteryhmaan(Tuote tuote, Tuoteryhma tuoteryhma) {
        tuoteryhma.lisaaTuote(tuote);
        tuoteryhmaDAO.tallenna(new ArrayList<Tuoteryhma>());
    }
    
}
