package kioski.TempUI;

import java.util.Scanner;
import kioski.logiikka.Sovelluslogiikka;


public class UI {
    private final Scanner lukija;
    private final Sovelluslogiikka logiikka;
    private final LisaysUI lisaysnakyma;
    private final ValintaUI valintanakyma;
    
    public UI() {
        this.lukija = new Scanner(System.in);
        this.logiikka = new Sovelluslogiikka();
        this.lisaysnakyma = new LisaysUI(lukija, logiikka);
        this.valintanakyma = new ValintaUI(lukija);
    }
    
    public void kaynnista() {
        tulostaOtsikko();
        while (true) {
            tulostaKomennot();
            String komento = lukija.nextLine();
            if (komento.equalsIgnoreCase("lopeta")) {
                break;
            } else {
                suoritaKomento(komento);
            }            
        }        
    }
    
    private void tulostaOtsikko() {
        System.out.println("Kioski");
        System.out.println("======");
        System.out.println("");
    }
    
    private void tulostaKomennot(){
        System.out.println("Komennot:");
        System.out.println("haku - hae tuotteita tuoteryhmän, nimen tai tuotetunnuksen perusteella");
        System.out.println("lisää - lisää tuotteita tai tuoteryhmiä");
        System.out.println("poista - poista tuotteita tai tuoteryhmiä");
        System.out.println("muokkaa - muokkaa olemassa olevia tuotteita tai tuoteryhmiä");
        System.out.println("lopeta - lopettaa istunnon");
        System.out.println("");
        System.out.println("Anna komento:");
    }
    
    private void suoritaKomento(String komento) {
        if (komento.equalsIgnoreCase("lisää")) {
            komentoLisaa();
        } else if (komento.equalsIgnoreCase("haku")) {
            System.out.println("Ei vielä toteutettu!");
        } else if (komento.equalsIgnoreCase("poista")) {
            System.out.println("Ei vielä toteutettu!");
        } else if (komento.equalsIgnoreCase("muokkaa")) {
            System.out.println("Ei vielä toteutettu!");
        }
    }
    
    private void komentoLisaa() {
        String valinta = valintanakyma.valitseTuoteTaiTuoteryhma();
        while (true) {
            if (valinta.equals("1")) {
                lisaysnakyma.komentoLisaaTuote();
                break;
            } else if (valinta.equals("2")) {
                lisaysnakyma.komentoLisaaTuoteryhma();
                break;
            } else {
                valinta = valintanakyma.valitseTuoteTaiTuoteryhma();
            }
        }
    }
}
