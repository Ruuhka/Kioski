
package kioski.domain;

public class Haettava {
    private int tunnus;
    private String nimi;

    public String getNimi() {
        return nimi;
    }

    public int getTunnus() {
        return tunnus;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }
     
    public int compareTo(Haettava haettava) {
        return this.tunnus - haettava.tunnus;
    }
}
