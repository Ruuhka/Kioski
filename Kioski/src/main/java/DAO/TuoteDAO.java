

package DAO;

import java.util.Collection;
import java.util.HashMap;
import kioski.domain.Tuote;

public interface TuoteDAO {
    void tallenna(Tuote tuote);
    void tallenna(Collection<Tuote> tallennettavat);
    void poista(int tunnus);
    Tuote hae(String nimi);
    Tuote hae(int tunnus);
    Collection<Tuote> haeKaikki();
}
