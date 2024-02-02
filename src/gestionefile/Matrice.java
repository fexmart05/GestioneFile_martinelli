package gestionefile;

/**
 *
 * @author federico
 */
public class Matrice {
    private char mv[][];
    private String verme;

    public Matrice(String verme) {
        this.mv = new char[26][26];
        this.verme = verme;
        popolaMatrice();
    }

    private void popolaMatrice() {
        int r, c;
        for (r = 0; r < 26; r++) {
            for (c = 0; c < 26; c++) {
                int car = r + c + 65;
                if (car > 90) {
                    car = car - 26;
                }
                this.mv[r][c] = (char) car;
            }
        }
    }

    public void setElemento(int r, int c, int el) {
        this.mv[r][c] = (char) el;
    }

    public char getElemento(int r, int c) {
        return mv[r][c];
    }

    public String cifra(String fch) {
        StringBuilder fcf = new StringBuilder();
        int k = 0;
        for (char ch : fch.toCharArray()) {
            if (k == verme.length()) {
                k = 0;
            }
            if (ch == ' ') {
                fcf.append(" ");
            } else {
                int col = ch - 65;
                int row = verme.charAt(k) - 65;
                fcf.append(mv[row][col]);
            }
            k++;
        }
        return fcf.toString();
    }

    public String deCifra(String fcf) {
        StringBuilder fch = new StringBuilder();
        int k = 0;
        for (char ch : fcf.toCharArray()) {
            if (k == verme.length()) {
                k = 0;
            }
            int row = verme.charAt(k) - 65;
            for (int col = 0; col < 26; col++) {
                if (mv[row][col] == ch) {
                    char car = (char) (col + 65);
                    fch.append(car);
                }
            }
            k++;
        }
        return fch.toString();
    }
}