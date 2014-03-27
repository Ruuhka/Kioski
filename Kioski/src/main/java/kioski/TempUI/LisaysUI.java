
package kioski.TempUI;

import java.util.Scanner;
import kioski.logiikka.Sovelluslogiikka;


public class LisaysUI {
    private final Scanner lukija;
    private final Sovelluslogiikka logiikka;

    public LisaysUI(Scanner lukija, Sovelluslogiikka logiikka) {
        this.lukija = lukija;
        this.logiikka = logiikka;
    }
    
    public void komentoLisaaTuote() {
         System.out.println("Anna tuotteen tiedot:");
         System.out.println("Nimi:");
         String nimi = lukija.nextLine();
         System.out.println("");
         System.out.println("Tuotetunnus:");
         int tunnus = lueKokonaisluku();
         System.out.println("");
         System.out.println("Hinta:");
         double hinta = lueDesimaaliluku();
         System.out.println("");
         StringBuilder kuvaus = pyydaKuvaus();
         logiikka.lisaaTuote(tunnus, nimi, hinta, kuvaus);
         //Tähän vielä tuoteryhmän valinta juuri lisätylle tuotteelle
    }

    public void komentoLisaaTuoteryhma() {
        System.out.println("Anna tuoteryhmän tiedot:");
        System.out.println("Nimi:");
        String nimi = lukija.nextLine();
        System.out.println("");
        System.out.println("Tunnus:");
        int tunnus = lueKokonaisluku();
        System.out.println("");
        StringBuilder kuvaus = pyydaKuvaus();
        logiikka.lisaaTuoteryhma(tunnus, nimi, kuvaus);
    }
    
    public StringBuilder pyydaKuvaus() {
        System.out.println("Kuvaus (paina enteriä rivien välissä ja kun olet valmis):");
        StringBuilder kuvaus = new StringBuilder();
        while (!lukija.nextLine().equals("")) {
             kuvaus.append(lukija.nextLine());
        }
        return kuvaus;
    }
    
    private int lueKokonaisluku() {
        while (true) {
            try {
                int luku = Integer.parseInt(lukija.nextLine());
                return luku;
            } catch (Exception e) {
                System.out.println("Et syöttänyt kokonaislukua. Tietue vaatii kokonaislukuarvon.");
            }
        }
    }
    
    private double lueDesimaaliluku() {
        while (true) {
            try {
                double luku = Double.parseDouble(lukija.nextLine());
                return luku;
            } catch (Exception e) {
                System.out.println("En tunnista desimaalilukua. Anna arvo desimaalilukumuodossa käyttäen"
                        + " pistettä . pilkun , sijaan.");
                //Toteuta niin että lopullisessa versiossa osaa lukea myös pilkkumuodossa.
            }
        }
    }
}
