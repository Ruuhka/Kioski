
package DAOutils;

import java.util.Collection;
import java.util.Map;
import kioski.domain.Haettava;

public interface CSVKasittelija {
    void tallenna(Collection<Haettava> tallennettavat);
    Map<Integer, Haettava> lataa();
}
