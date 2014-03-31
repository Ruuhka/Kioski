
package kioski.domain;

import java.util.ArrayList;

public class Tuoteryhma extends Haettava {
    private int tunnus;
    private String nimi;
    private ArrayList<Tuote> tuotteet;
    private String kuvaus;
    
    public Tuoteryhma(int tunnus, String nimi, String kuvaus) {
        this.tunnus = tunnus;
        this.nimi = nimi;
        this.kuvaus = kuvaus;
        this.tuotteet = new ArrayList<Tuote>();
    }

    public ArrayList<Tuote> getTuotteet() {
        return tuotteet;
    }

    public String getKuvaus() {
        return kuvaus;
    }
    
    public void setKuvaus(String kuvaus) {
        this.kuvaus = kuvaus;
    }
    
    public void setTuotteet(ArrayList<Tuote> tuotteet) {
        this.tuotteet = tuotteet;
    }

    @Override
    public String getNimi() {
        return nimi;
    }

    @Override
    public int getTunnus() {
        return tunnus;
    }

    @Override
    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    @Override
    public void setTunnus(int tunnus) {
        this.tunnus = tunnus;
    }

    @Override
    public int compareTo(Haettava h) {
        return this.tunnus - h.getTunnus();
    }

}
