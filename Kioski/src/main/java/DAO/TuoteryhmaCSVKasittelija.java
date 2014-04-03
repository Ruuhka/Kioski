

package DAO;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import kioski.domain.Tuoteryhma;


public interface TuoteryhmaCSVKasittelija {
    void tallenna(HashMap<Integer, Tuoteryhma> tallennettavat) throws IOException;
    HashMap<Integer, Tuoteryhma> lataa();
}
