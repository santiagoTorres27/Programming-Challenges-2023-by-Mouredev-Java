package week_06;

import java.util.Arrays;

public class RockPaperScissorsLizardSpock {
    /*
     * Crea un programa que calcule quien gana más partidas al piedra,
     * papel, tijera, lagarto, spock.
     * - El resultado puede ser: "Player 1", "Player 2", "Tie" (empate)
     * - La función recibe un listado que contiene pares, representando cada jugada.
     * - El par puede contener combinaciones de "🗿" (piedra), "📄" (papel),
     *   "✂️" (tijera), "🦎" (lagarto) o "🖖" (spock).
     * - Ejemplo. Entrada: [("🗿","✂️"), ("✂️","🗿"), ("📄","✂️")]. Resultado: "Player 2".
     * - Debes buscar información sobre cómo se juega con estas 5 posibilidades.
     */
    public static void main(String[] args) {
        String[][] gameMovements = {{"🗿", "✂️"}, {"✂️", "🗿"}, {"📄", "✂️"}, {"🦎", "🖖"}, {"🖖", "🖖"}};
        initGame(gameMovements);
    }

    private static void initGame(String[][] movements) {
        int tieGames = 0;
        int player1 = 0;
        int player2 = 0;
        for (String[] i : movements) {
            System.out.println("Player 1: " + i[0] + " - Player 2: " + i[1]);
            String winner = checkMovementWinner(i);
            switch (winner) {
                case "player 1" -> player1++;
                case "player 2" -> player2++;
                default -> tieGames++;
            }
            System.out.println(winner);
        }

        System.out.println("\nPlayer 1 wins: " + player1);
        System.out.println("Player 2 wins: " + player2);
        System.out.println("Tied games: " + tieGames);

        if ((tieGames > player1 && tieGames > player2) || tieGames == player1 || tieGames == player2 || player2 == player1) {
            System.out.println("\nTied games");
        } else if (player1 > player2 && player1 > tieGames) {
            System.out.println("\nPlayer 1 wins!");
        } else {
            System.out.println("\nPlayer 2 wins!");
        }
    }

    private static String checkMovementWinner(String[] movements) {
        String player1 = movements[0];
        String player2 = movements[1];
        if (player1.equals(player2)) {
            return "tie";
        } else if (player1.equalsIgnoreCase("🗿")) {
            if (player2.equals("✂️") || player2.equals("🦎")) {
                return "player 1";
            } else {
                return "player 2";
            }
        } else if (player1.equals("📄")) {
            if (player2.equals("🗿") || player2.equals("🖖")) {
                return "player 1";
            } else {
                return "player 2";
            }
        } else if (player1.equals("✂️")) {
            if (player2.equals("📄") || player2.equals("🦎")) {
                return "player 1";
            } else {
                return "player 2";
            }
        } else if (player1.equals("🦎")) {
            if (player2.equals("📄") || player2.equals("🖖")) {
                return "player 1";
            } else {
                return "player 2";
            }
        } else {
            if (player2.equals("✂️") || player2.equals("🗿")) {
                return "player 1";
            } else {
                return "player 2";
            }
        }
    }
}
