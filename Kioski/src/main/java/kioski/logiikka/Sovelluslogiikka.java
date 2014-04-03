
package kioski.logiikka;

import DAO.*;
import java.util.Scanner;
import kioski.domain.*;

public class Sovelluslogiikka {
    private Lisayslogiikka lisayslogiikka;
    private Muokkauslogiikka muokkauslogiikka;
    private Hakulogiikka hakulogiikka;
    private Ostoskorilogiikka ostoskorilogiikka;
    private Poistologiikka poistologiikka;
    private TuoteDAO tuoteDAO;
    private TuoteryhmaDAO tuoteryhmaDAO;

    public Sovelluslogiikka() {
        this.tuoteDAO = new MuistiTuoteDAO();
        this.tuoteryhmaDAO = new MuistiTuoteryhmaDAO();
        this.lisayslogiikka = new Lisayslogiikka(tuoteDAO, tuoteryhmaDAO);
        
    }
    
    
    
       
    public void lisaaTuote(int tunnus, String nimi, double hinta, String kuvaus, int saldo) {
        lisayslogiikka.lisaaTuote(tunnus, nimi, hinta, kuvaus, saldo);
    }
    
    public void lisaaTuoteryhma(int tunnus, String nimi, String kuvaus) {
        Tuoteryhma tuoteryhma = new Tuoteryhma(tunnus, nimi, kuvaus);
        
        System.out.println("lisätty!");
    } 
    
}
