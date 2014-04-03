
package DAO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import kioski.domain.Tuote;


public class OmaTuoteCSVKasittelija implements TuoteCSVKasittelija {
    private File tiedosto;

    public OmaTuoteCSVKasittelija(String tiedostonNimi) {
        tiedosto = new File(tiedostonNimi);
    }
        
    @Override
    public void tallenna(HashMap<Integer, Tuote> tallennettavat) throws IOException {
        FileWriter kirjoittaja = new FileWriter(tiedosto);
        StringBuilder tuotteetMerkkijonona = new StringBuilder();
        tuotteetMerkkijonona.append(muunnaTuotteetMerkkijonoksi(this.lataa()));
        tuotteetMerkkijonona.append(muunnaTuotteetMerkkijonoksi(tallennettavat));
        kirjoittaja.write(tuotteetMerkkijonona.toString());
        kirjoittaja.close();
    }

    @Override
    public HashMap<Integer, Tuote> lataa() {
        Scanner lukija;
        try {
            lukija = new Scanner(tiedosto);
        } catch (FileNotFoundException e) {
            return new HashMap<Integer, Tuote>();
        }
        HashMap<Integer, Tuote> tuotteet = new HashMap<Integer, Tuote>();
        while (lukija.hasNextLine()) {
            String[] tiedot = lukija.nextLine().split("§");
            int tunnus = Integer.parseInt(tiedot[0]);
            String nimi = tiedot[1];
            double hinta = Double.parseDouble(tiedot[2]);
            int saldo = Integer.parseInt(tiedot[3]);
            String kuvaus = tiedot[4];
            Tuote tuote = new Tuote(tunnus, nimi, hinta, kuvaus.toString(), saldo);
            tuotteet.put(tunnus, tuote);
        }
        lukija.close();
        return tuotteet;
    }

    public String muunnaTuotteetMerkkijonoksi(HashMap<Integer, Tuote> tuotteet) {
        StringBuilder tuotteetMerkkijonona = new StringBuilder();
        for (Integer tunnus : tuotteet.keySet()) {
            Tuote tuote = tuotteet.get(tunnus);
            String merkkijono = tunnus + "§" + tuote.getNimi() + "§" + tuote.getHinta()
                    + "§" + tuote.getVarastosaldo() + "§" + tuote.getKuvaus();
            tuotteetMerkkijonona.append(merkkijono);
            tuotteetMerkkijonona.append("\n");
        }
        return tuotteetMerkkijonona.toString();
    }
}
