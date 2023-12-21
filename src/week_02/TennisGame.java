package week_02;

public class TennisGame {
    private int player1;
    private int player2;
    private boolean isSetRunning;
    private String winner;

    public TennisGame() {
        player1 = 0;
        player2 = 0;
        isSetRunning = true;
        winner = "";
    }

    public String getWinner() {
        return winner;
    }

    public String score(String player) {
        if (isSetRunning) {
            if (player.equalsIgnoreCase("P1")) {
                player1++;
            } else if (player.equalsIgnoreCase("P2")) {
                player2++;
            }

            if (player1 == 4 && player2 == 4) {
                player1--;
                player2--;
            } else if (player1 == 5 || player2 == 5) {
                isSetRunning = false;
                winner = (player1 == 5) ? "Player 1" : "Player 2";
            }
            return this.printScores();
        } else {
            return "--- Set finished ---";
        }
    }

    public String printPlayerScore(int score) {
        if (score == 0) {
            return "Love";
        } else if (score == 1) {
            return "15";
        } else if (score == 2) {
            return "30";
        } else if (score == 3) {
            return "40";
        } else if (score == 4) {
            return "Advantage";
        }
        return "";
    }

    private String printScores() {
        if (player1 == 3 && player2 == 3) {
            return "Deuce";
        } else if (player1 == 4) {
            return "Advantage 1";
        } else if (player2 == 4) {
            return "Advantage 2";
        } else if (player1 == 5) {
            return "Player 1 wins";
        } else if (player2 == 5) {
            return "Player 2 wins";
        } else {
            return printPlayerScore(player1) + " - " + printPlayerScore(player2);
        }
    }

    @Override
    public String toString() {
        return printPlayerScore(player1) + " - " + printPlayerScore(player2);
    }
}
