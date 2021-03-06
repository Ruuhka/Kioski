
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
         String kuvaus = pyydaKuvaus();
         System.out.println("Anna varastosaldo:");
         System.out.println("");
         int saldo = lueKokonaisluku();
         logiikka.lisaaTuote(tunnus, nimi, hinta, kuvaus, saldo);
         System.out.println("Valitse tuoteryhmä:");
         
    }

    public void komentoLisaaTuoteryhma() {
        System.out.println("Anna tuoteryhmän tiedot:");
        System.out.println("Nimi:");
        String nimi = lukija.nextLine();
        System.out.println("");
        System.out.println("Tunnus:");
        int tunnus = lueKokonaisluku();
        System.out.println("");
        String kuvaus = pyydaKuvaus();
        logiikka.lisaaTuoteryhma(tunnus, nimi, kuvaus);
    }
    
    public String pyydaKuvaus() {
        System.out.println("Kuvaus (paina enteriä rivien välissä ja kun olet valmis):");
        StringBuilder kuvaus = new StringBuilder();
        while (!lukija.nextLine().equals("")) {
            kuvaus.append(lukija.nextLine());
        }
        return kuvaus.toString();
    }
    
    private int lueKokonaisluku() {
        while (true) {
            try {
                int luku = Integer.parseInt(lukija.nextLine());
                return luku;
            } catch (Exception e) {
                System.out.println("Et syöttänyt kokonaislukua. Vaaditaan kokonaislukuarvo.");
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
