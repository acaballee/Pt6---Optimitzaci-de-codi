package org.entdes;

public class TaulerService {

    private String[][] caselles;
    private boolean esTornX = true;
    private boolean gameOver = false;

    private String guanyador = "";

    public TaulerService() {
        this.caselles = new String[][]{
            {"", "", ""},
            {"", "", ""},
            {"", "", ""}
        };
    }

    public String tractarClicCasella(int fila, int columna) {
        if (!gameOver && caselles[fila][columna].isEmpty()) {
            if (esTornX) {
                caselles[fila][columna] = "X";
            } else {
                caselles[fila][columna] = "O";
            }
            esTornX = !esTornX;
            for (int i = 0; i < 3; i++) {

                if (caselles[i][0].equals(caselles[i][1])
                        && caselles[i][1].equals(caselles[i][2])
                        && !caselles[i][0].isEmpty()) {
                    guanyador = caselles[i][0];
                }

                if (caselles[0][i].equals(caselles[1][i])
                        && caselles[1][i].equals(caselles[2][i])
                        && !caselles[0][i].isEmpty()) {
                    guanyador = caselles[0][i];
                }

            }

            if (caselles[2][0].equals(caselles[1][1])
                    && caselles[1][1].equals(caselles[0][2])
                    && !caselles[2][0].isEmpty()) {
                guanyador = caselles[2][0];
            }

            if (caselles[0][0].equals(caselles[1][1])
                    && caselles[1][1].equals(caselles[2][2])
                    && !caselles[0][0].isEmpty()) {
                guanyador = caselles[0][0];
            }

            if (!guanyador.isEmpty()) {
                gameOver = true;
            }

            boolean taulerPle = true;
            for (int fila1 = 0; fila1 < 3; fila1++) {
                for (int columna1 = 0; columna1 < 3; columna1++) {
                    if (caselles[fila1][columna1].isEmpty()) {
                        taulerPle = false;
                        break;
                    }
                }
            }
            if (taulerPle && !gameOver) {
                gameOver = true;
            }
        }
        return caselles[fila][columna];
    }


    public String getGuanyador() {
        return guanyador;
    }

    public boolean isGameOver() {
        return gameOver;
    }
}
