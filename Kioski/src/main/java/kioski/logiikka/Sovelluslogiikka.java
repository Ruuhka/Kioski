
package kioski.logiikka;

import java.util.Scanner;
import kioski.domain.Tuote;
import kioski.domain.Tuoteryhma;

public class Sovelluslogiikka {
       
    public void lisaaTuote(int tunnus, String nimi, double hinta, String kuvaus) {
        Tuote tuote = new Tuote(tunnus, nimi, hinta, kuvaus);
        
        System.out.println("lisätty!");
    }
    
    public void lisaaTuoteryhma(int tunnus, String nimi, String kuvaus) {
        Tuoteryhma tuoteryhma = new Tuoteryhma(tunnus, nimi, kuvaus);
        
        System.out.println("lisätty!");
    } 
    
}
