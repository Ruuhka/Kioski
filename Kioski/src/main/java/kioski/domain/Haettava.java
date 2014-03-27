
package kioski.domain;

public abstract class Haettava implements Comparable {
    private int tunnus;
    private String nimi;

    abstract String getNimi();

    abstract int getTunnus();

    abstract void setNimi(String nimi);

}
