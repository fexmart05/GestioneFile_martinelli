package gestionefile;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author federico
 */

public class Scrittore implements Runnable{
  
    
    private String nomeFile;
    private String messaggio;

    public Scrittore(String nomeFile, String messaggio) {
        this.nomeFile = nomeFile;
        this.messaggio = messaggio;
    }

    public void scrivi() {
        try (BufferedWriter br = new BufferedWriter(new FileWriter(nomeFile))) {
            br.write(messaggio);
            br.write("\n\r");
            br.flush();
        } catch (IOException ex) {
            System.err.println("Errore in scrittura del file " + nomeFile + ": " + ex.getMessage());
        }
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

