package gestionefile;

/**
 *
 * @author federico
 */
public class Copia extends Thread {
    String nomeFileDaCopiare;
    String nomeFileFinale;
   
    
    public Copia(String nomeFileDaCopiare,String nomeFileFinale){
         this.nomeFileDaCopiare=nomeFileDaCopiare;
       this.nomeFileFinale=nomeFileFinale;
    }

    /**
     * Legge il file senza tener conto del tipo di file
     * e lo mostra in output
     */

   public void copia(String outputcsv, String copiacsv) {
    // 1) Leggo il contenuto del file da copiare
    Lettore lettore = new Lettore(nomeFileDaCopiare);
    String contenuto = lettore.leggi();

    // 2) Scrivo il contenuto del file copiato
    Scrittore scrittore = new Scrittore(nomeFileFinale, contenuto);
    Thread threadScrittore = new Thread(scrittore);
    threadScrittore.start();

    try {
        threadScrittore.join();
    } catch (InterruptedException ex) {
        System.err.println("Errore nel metodo join()");
    }
}
    
    @Override
    public void run(){
        copia("output.csv", "copia.csv");
    }
}
