
package kioski.domain;


public class Tuote extends Haettava{
    private int tunnus;
    private String nimi;
    private double hinta;
    private int varastosaldo;
    private StringBuilder kuvaus;

    public Tuote(int tunnus, String nimi, double hinta, StringBuilder kuvaus, int saldo) {
        this.tunnus = tunnus;
        this.nimi = nimi;
        this.hinta = hinta;
        this.kuvaus = kuvaus;
        this.varastosaldo = saldo;
    }
    
    public Tuote(int tunnus, String nimi, double hinta, StringBuilder kuvaus) {
        this(tunnus, nimi, hinta, kuvaus, 0);
    }

    public double getHinta() {
        return hinta;
    }

    public StringBuilder getKuvaus() {
        return kuvaus;
    }

    public void setHinta(double hinta) {
        this.hinta = hinta;
    }

    public void setKuvaus(StringBuilder kuvaus) {
        this.kuvaus = kuvaus;
    }

    public void setTunnus(int tunnus) {
        this.tunnus = tunnus;
    }    

    @Override
    String getNimi() {
        return this.nimi;
    }

    @Override
    int getTunnus() {
        return this.tunnus;
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
