package org.entdes;

public class TaulerService {

    private static final int MIDA_TAULER = 3;
    private String[][] caselles;
    private boolean esTornX = true;
    private boolean gameOver = false;
    private String guanyador = "";

    public TaulerService() {
        this.caselles = new String[MIDA_TAULER][MIDA_TAULER];
        inicialitzarTauler();
    }

    private void inicialitzarTauler() {
        for (int i = 0; i < MIDA_TAULER; i++) {
            for (int j = 0; j < MIDA_TAULER; j++) {
                caselles[i][j] = "";
            }
        }
    }

    public String tractarClicCasella(int fila, int columna) {
        if (!gameOver && caselles[fila][columna].isEmpty()) {
            actualitzarCasella(fila, columna);
            guanyador = verificarGuanyador();
            if (!guanyador.isEmpty()) { 
                gameOver = true;
            }
            if (!gameOver && esTaulerPle()) {
                gameOver = true;
            }
        }
        return caselles[fila][columna];
    }

    private void actualitzarCasella(int fila, int columna) {
        if (esTornX) {
            caselles[fila][columna] = "X";
        } else {
            caselles[fila][columna] = "O";
        }
        esTornX = !esTornX;
    }

    private String verificarGuanyador() {
        for (int i = 0; i < MIDA_TAULER; i++) {
            if (caselles[i][0].equals(caselles[i][1]) && caselles[i][1].equals(caselles[i][2]) && !caselles[i][0].isEmpty()) {
                return caselles[i][0];
            }
            if (caselles[0][i].equals(caselles[1][i]) && caselles[1][i].equals(caselles[2][i]) && !caselles[0][i].isEmpty()) {
                return caselles[0][i];
            }
        }

        if (caselles[0][0].equals(caselles[1][1]) && caselles[1][1].equals(caselles[2][2]) && !caselles[0][0].isEmpty()) {
            return caselles[0][0];
        }
        if (caselles[0][2].equals(caselles[1][1]) && caselles[1][1].equals(caselles[2][0]) && !caselles[0][2].isEmpty()) {
            return caselles[0][2];
        }

        return "";
    }

    private boolean esTaulerPle() {
        for (int i = 0; i < MIDA_TAULER; i++) {
            for (int j = 0; j < MIDA_TAULER; j++) {
                if (caselles[i][j].isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    public String getGuanyador() {
        return guanyador;
    }

    public boolean isGameOver() {
        return gameOver;
    }
}
