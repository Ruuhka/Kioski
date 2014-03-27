
package kioski.domain;

import java.util.ArrayList;

public class Tuoteryhma extends Haettava {
    private int tunnus;
    private String nimi;
    private ArrayList<Tuote> tuotteet;
    private StringBuilder kuvaus;
    
    public Tuoteryhma(int tunnus, String nimi, StringBuilder kuvaus) {
        this.tunnus = tunnus;
        this.nimi = nimi;
        this.kuvaus = kuvaus;
        this.tuotteet = new ArrayList<Tuote>();
    }

    public ArrayList<Tuote> getTuotteet() {
        return tuotteet;
    }

    public StringBuilder getKuvaus() {
        return kuvaus;
    }
    
    public void setKuvaus(StringBuilder kuvaus) {
        this.kuvaus = kuvaus;
    }
    
    public void setTuotteet(ArrayList<Tuote> tuotteet) {
        this.tuotteet = tuotteet;
    }

    @Override
    String getNimi() {
        return nimi;
    }

    @Override
    int getTunnus() {
        return tunnus;
    }

    @Override
    void setNimi(String nimi) {
        this.nimi = nimi;
    }

    @Override
    public int compareTo(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
