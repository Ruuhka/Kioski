
package kioski.domain;


public class Tuote extends Haettava{
    private int tunnus;
    private String nimi;
    private double hinta;
    private int varastosaldo;
    private String kuvaus;

    public Tuote(int tunnus, String nimi, double hinta, String kuvaus, int saldo) {
        this.tunnus = tunnus;
        this.nimi = nimi;
        this.hinta = hinta;
        this.kuvaus = kuvaus;
        if (saldo < 0) {
            throw new IllegalArgumentException("Varastosaldo ei voi olla negatiivinen. ");
        } else {
            this.varastosaldo = saldo;
        }
    }
    
    public Tuote(int tunnus, String nimi, double hinta, String kuvaus) {
        this(tunnus, nimi, hinta, kuvaus, 0);
    }
    
    public Tuote(int tunnus, String nimi, double hinta) {
        this(tunnus, nimi, hinta, "", 0);
    }

    public double getHinta() {
        return hinta;
    }

    public String getKuvaus() {
        return kuvaus;
    }

    public void setHinta(double hinta) {
        this.hinta = hinta;
    }

    public void setKuvaus(String kuvaus) {
        this.kuvaus = kuvaus;
    }

    public int getVarastosaldo() {
        return varastosaldo;
    }

    public void setVarastosaldo(int varastosaldo) {
        this.varastosaldo = varastosaldo;
    }
    
    public void kasvataSaldoa(int n) {
        while (n > 0) {
            kasvataSaldoaYhdella();
            n--;
        }
    }
    
    public void kasvataSaldoaYhdella() {
        this.varastosaldo++;
    }
    
    public void vahennaSaldoa(int n) {
        while (n > 0) {
            if (this.varastosaldo <= 0) {
                break;
            } else {
                vahennaSaldoaYhdella();
                n--;
            }
        }
    }
    
    public void vahennaSaldoaYhdella() {
        this.varastosaldo--;
    }
    
    @Override
    public void setTunnus(int tunnus) {
        this.tunnus = tunnus;
    }    

    @Override
    public String getNimi() {
        return this.nimi;
    }

    @Override
    public int getTunnus() {
        return this.tunnus;
    }

    @Override
    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    @Override
    public int compareTo(Haettava h) {
        return this.tunnus - h.getTunnus();
    }
}
