
package DAOutils;

import java.util.ArrayList;
import java.util.Collection;
import kioski.domain.Haettava;
import kioski.domain.Tuote;

public class TuoteDAO implements DAO {
    private CSVKasittelija kasittelija;

    public TuoteDAO() {
        this.kasittelija = new TuoteCSVKasittelija();
    }

    @Override
    public void tallenna(Collection<Haettava> tallennettavat) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void poista(String nimi) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void poista(int tunnus) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Haettava hae(String nimi) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Haettava hae(int tunnus) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Haettava> haeKaikki() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
