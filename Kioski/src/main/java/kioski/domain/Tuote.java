
package kioski.domain;


public class Tuote extends Haettava{
    private int tunnus;
    private String nimi;
    private double hinta;
    private int varastosaldo;
    private StringBuilder kuvaus;

    public Tuote(int tunnus, String nimi, double hinta, StringBuilder kuvaus) {
        this.tunnus = tunnus;
        this.nimi = nimi;
        this.hinta = hinta;
        this.kuvaus = kuvaus;
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
}
