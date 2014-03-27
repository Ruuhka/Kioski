
package kioski.TempUI;

import java.util.Scanner;

public class ValintaUI {
    private final Scanner lukija;

    public ValintaUI(Scanner lukija) {
        this.lukija = lukija;
    }
    
    public String valitseTuoteTaiTuoteryhma() {
        while (true) {
            System.out.println("Valitse tuote tai tuoteryhmä:");
            System.out.println("1 - Tuote");
            System.out.println("2 - Tuoteryhmä");
            String valinta = lukija.nextLine();
            if (valinta.equals("1") || valinta.equals("2")) {
                return valinta;
            } 
        }
    }
}
