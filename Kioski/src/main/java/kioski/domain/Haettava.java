
package kioski.domain;

public abstract class Haettava implements Comparable<Haettava> {
    private int tunnus;
    private String nimi;

    abstract public String getNimi();

    abstract public int getTunnus();

    abstract public void setNimi(String nimi);
    
    abstract public void setTunnus(int tunnus);

}
