
package DAO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import kioski.domain.Tuote;
import kioski.domain.Tuoteryhma;

public class OmaTuoteryhmaCSVKasittelija implements TuoteryhmaCSVKasittelija {
    private File tiedosto;
    private MuistiTuoteDAO tuoteDAO;

    public OmaTuoteryhmaCSVKasittelija(String tiedostonNimi) {
        this.tiedosto = new File(tiedostonNimi);
        tuoteDAO = new MuistiTuoteDAO();
    }
    
    
    
    @Override
    public void tallenna(HashMap<Integer, Tuoteryhma> tallennettavat) throws IOException {
        FileWriter kirjoittaja = new FileWriter(tiedosto);
        StringBuilder tuoteryhmatMerkkijonona = new StringBuilder();
        tuoteryhmatMerkkijonona.append(muunnaTuoteryhmatMerkkijonoksi(tallennettavat));
        kirjoittaja.write(tuoteryhmatMerkkijonona.toString());
        kirjoittaja.close();
        
    }

    @Override
    public HashMap<Integer, Tuoteryhma> lataa() {
        Scanner lukija;
        try {
            lukija = new Scanner(tiedosto);
        } catch (FileNotFoundException e) {
            return new HashMap<Integer, Tuoteryhma>();
        }
        HashMap<Integer, Tuoteryhma> tuoteryhmat = new HashMap<Integer, Tuoteryhma>();
        while (lukija.hasNextLine()) {
            String[] tiedot = lukija.nextLine().split("§");
            int tunnus = Integer.parseInt(tiedot[0]);
            String nimi = tiedot[1];
            ArrayList<Tuote> tuotelista = muunnaTuotetunnuksetTuotelistaksi(tiedot[2]);
            String kuvaus = tiedot[3];
            Tuoteryhma tuoteryhma = new Tuoteryhma(tunnus, nimi, tuotelista, kuvaus);
            tuoteryhmat.put(tunnus, tuoteryhma);
        }
        lukija.close();
        return tuoteryhmat;
    }
    
    private String muunnaTuoteryhmatMerkkijonoksi(HashMap<Integer, Tuoteryhma> tuoteryhmat) {
        StringBuilder tuoteryhmatMerkkijonona = new StringBuilder();
        for (Integer tunnus : tuoteryhmat.keySet()) {
            Tuoteryhma tuoteryhma = tuoteryhmat.get(tunnus);
            StringBuilder tuotelista = new StringBuilder();
            for (Tuote tuote : tuoteryhma.getTuotteet()) {
                tuotelista.append(tuote.getTunnus());
                tuotelista.append("_");
            }
            String merkkijono = tunnus + "§" + tuoteryhma.getNimi() + "§" + tuotelista.toString() + "§" + 
                    tuoteryhma.getKuvaus();
            tuoteryhmatMerkkijonona.append(merkkijono);
            tuoteryhmatMerkkijonona.append("\n");
        }
        return tuoteryhmatMerkkijonona.toString();
    }
    
    private ArrayList<Tuote> muunnaTuotetunnuksetTuotelistaksi(String tuotetunnuksetMerkkijononona) {
        ArrayList<Tuote> tuotelista = new ArrayList<>();
        String[] tuotetunnukset = tuotetunnuksetMerkkijononona.split("_");
        int i = 0;
        while (i < tuotetunnukset.length) {
            int tunnus = Integer.parseInt(tuotetunnukset[i]);
            tuotelista.add(tuoteDAO.hae(tunnus));
            i++;
        }    
        return tuotelista;
    }
    
}
