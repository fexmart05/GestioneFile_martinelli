package gestionefile;

import java.util.ArrayList;
/**
 *
 * @author federico
 */
public class Cifrario {
    private Matrice matrice;

    public Cifrario(String verme) {
        this.matrice = new Matrice(verme);
    }

    public String cifra(String messaggio) {
        return matrice.cifra(messaggio);
    }
}

class Copia {
    public static void copia(String nomeFileDaCopiare, String nomeFileFinale) {
        Lettore lettore = new Lettore(nomeFileDaCopiare);
        String contenuto = lettore.leggi();

        Scrittore scrittore = new Scrittore(nomeFileFinale, contenuto);
        scrittore.scrivi();
    }
}
