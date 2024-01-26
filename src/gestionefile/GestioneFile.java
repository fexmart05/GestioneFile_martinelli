package gestionefile;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
/**
 *
 * @author federico
 * @version 12/01/23
 */
public class GestioneFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Lettura da user.json
        Lettore lettore = new Lettore("user.json");
        String userData = lettore.read();

        // Richiesta all'utente di username e password
        String username = leggiInput("Inserisci username: ");
        String password = leggiInput("Inserisci password: ");


        // Scrittura nel file output.csv
        Scrittore scrittore = new Scrittore("output.csv");
     

      
    }

  

    // Funzione per leggere l'input dalla console
    private static String leggiInput(String prompt) {
        System.out.print(prompt);
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            return br.readLine();
        } catch (IOException ex) {
            System.err.println("Errore durante la lettura dell'input.");
            ex.printStackTrace();
            return null;
        }
    }

}
