package gestionefile;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

/**
 *
 * @author federico
 * @ 12/01/23
 */

public class Lettore extends Thread{
    String nomeFile;
    
    public Lettore(String nomeFile){
        this.nomeFile = nomeFile;
    }
    
    /**
     * Legge il file senza tener conto del tipo di file
     * e lo mostra in output
     */
    public String read() {
        StringBuilder content = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(nomeFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException ex) {
            System.err.println("Errore in lettura!");
            ex.printStackTrace();
        }

        return content.toString();
    }
    

    public void run(){
       String fileContent = read();
        // Puoi fare qualcosa con il contenuto del file qui
        System.out.println("Contenuto del file letto:\n" + fileContent);
    }
}
