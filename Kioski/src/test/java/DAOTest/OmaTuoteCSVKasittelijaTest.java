

package DAOTest;

import DAO.OmaTuoteCSVKasittelija;
import DAO.TuoteCSVKasittelija;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kioski.domain.Tuote;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class OmaTuoteCSVKasittelijaTest {
    
    public OmaTuoteCSVKasittelijaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    TuoteCSVKasittelija kasittelija;
    HashMap<Integer, Tuote> tallennettavat;
    Tuote tuote1 = new Tuote(11, "Kahvi", 1, "lämmin kupillinen", 30);
    Tuote tuote2 = new Tuote(12, "Pulla", 2.50, "pieneen, tai suurempaankin makean nälkään", 15);
    
    @Before
    public void setUp() {
        kasittelija = new OmaTuoteCSVKasittelija("tuotteet.csv");
        tallennettavat = new HashMap<Integer, Tuote>();
    }
    
    @After
    public void tearDown() {
    }

    private void tallenna(HashMap<Integer, Tuote> tallennettavat) {
        try {
            kasittelija.tallenna(tallennettavat);
        } catch (IOException e) {
            System.out.println("Tiedoston kirjoittamisessa tapahtui virhe: " + e.getMessage());
        }
    }
    
    private HashMap<Integer, Tuote> lisaaTuotteetTallennetavaksi(HashMap<Integer, Tuote> tallennettavat) {
        tallennettavat.put(tuote1.getTunnus(), tuote1);
        tallennettavat.put(tuote2.getTunnus(), tuote2);
        return tallennettavat;
    }
    
    @Test
    public void lataaPalauttaaTyhjanHashMapinJosTiedostoaEiLoydy() {
        kasittelija = new OmaTuoteCSVKasittelija("testi.csv");
        assertEquals(new HashMap<Integer, Tuote>(), kasittelija.lataa());    
    }
    
    @Test
    public void lataaLukeeJaLuoTuotteetOikeassaMuodossa() {
        lisaaTuotteetTallennetavaksi(tallennettavat);
        tallenna(tallennettavat);
        Tuote tuoteX = kasittelija.lataa().get(12);
        assertEquals(tuote2.toString(), tuoteX.toString());
    }
    
    @Test
    public void lataaPalauttaaTallennetutTuoteet() {
        lisaaTuotteetTallennetavaksi(tallennettavat);
        tallenna(tallennettavat);
        HashMap<Integer, Tuote> tallennetut = new HashMap<Integer, Tuote>();
        tallennetut.put(tuote1.getTunnus(), tuote1);
        tallennetut.put(tuote2.getTunnus(), tuote2);
        Map<Integer, Tuote> ladatut = kasittelija.lataa();
        
        
    }
    
    @Test
    public void tallennaTallentaaTallennettavatTuotteet() {
        lisaaTuotteetTallennetavaksi(tallennettavat);
        tallenna(tallennettavat);
        HashMap<Integer, Tuote> tallennetut = kasittelija.lataa();
            assertEquals(tallennettavat.toString(), tallennetut.toString());
    }
    
}
