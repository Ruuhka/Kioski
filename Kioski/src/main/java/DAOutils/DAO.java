

package DAOutils;

import java.util.Collection;
import java.util.Map;
import kioski.domain.Haettava;

public interface DAO {
    void tallenna(Collection<Haettava> tallennettavat);
    void poista(String nimi);
    void poista(int tunnus);
    Haettava hae(String nimi);
    Haettava hae(int tunnus);
    Collection<Haettava> haeKaikki();
}
