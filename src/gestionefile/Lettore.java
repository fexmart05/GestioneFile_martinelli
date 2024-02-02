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
    private String nomeFile;

    public Lettore(String nomeFile) {
        this.nomeFile = nomeFile;
    }

    public String leggi() {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(nomeFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            System.out.print("\n\r");
        } catch (IOException ex) {
            System.err.println("Errore in lettura del file " + nomeFile + ": " + ex.getMessage());
        }
        return sb.toString();
    }
}