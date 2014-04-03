
package DAO;

import java.util.Collection;
import kioski.domain.Tuoteryhma;


public interface TuoteryhmaDAO {
    void tallenna(Tuoteryhma tuoteryhma);
    void tallenna(Collection<Tuoteryhma> tallennettavat);
    void poista(int tunnus);
    Tuoteryhma hae(String nimi);
    Tuoteryhma hae(int tunnus);
    Collection<Tuoteryhma> haeKaikki();
}
