
package DAO;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import kioski.domain.Tuote;

public interface TuoteCSVKasittelija {
    void tallenna(HashMap<Integer, Tuote> tallennettavat) throws IOException;
    HashMap<Integer, Tuote> lataa();
}
