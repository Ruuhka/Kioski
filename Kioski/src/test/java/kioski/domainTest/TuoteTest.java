package kioski.domainTest;

import kioski.domain.Tuote;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TuoteTest {
    
    public TuoteTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    Tuote tuote;
    
    @Before
    public void setUp() {
        tuote = new Tuote(11, "Kahvi", 1, "lämmin kupillinen", 30);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void kasvataSaldoaKasvattaaSaldoaOikein() {
        tuote.kasvataSaldoa(8);
        assertEquals(38, tuote.getVarastosaldo());
    }
    
    @Test
    public void vahennaSaldoaVahentaaOikeanMaaran() {
        tuote.vahennaSaldoa(4);
        assertEquals(26, tuote.getVarastosaldo());
    }
    
    @Test
    public void vahennaSaldoaEiVahennaAlle0() {
        tuote.vahennaSaldoa(33);
        assertEquals(0, tuote.getVarastosaldo());
    }
    
    @Test
    public void konstruktoriEiSalliNegatiivistaSaldoa() {
        try {
            tuote = new Tuote(11, "Kahvi", 1, "lämmin kupillinen", -30);
            assert false;
        } catch (IllegalArgumentException e) {
            assert true;
        }
    }
    
    @Test
    public void compareToJarjestaaTuotteetTunnuksenMukaanOikeaanJarjestykseen() {
        Tuote tuote2 = new Tuote(12, "pulla", 2);
        assertEquals(-1, tuote.compareTo(tuote2));
    }
}
