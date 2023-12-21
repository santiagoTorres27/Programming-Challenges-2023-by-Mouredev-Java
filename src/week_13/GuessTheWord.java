package week_13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GuessTheWord {
    /*
     * Crea un pequeño juego que consista en adivinar palabras en un número máximo de intentos:
     * - El juego comienza proponiendo una palabra aleatoria incompleta
     *   - Por ejemplo "m_ur_d_v", y el número de intentos que le quedan
     * - El usuario puede introducir únicamente una letra o una palabra (de la misma longitud que
     *   la palabra a adivinar)
     *   - Si escribe una letra y acierta, se muestra esa letra en la palabra. Si falla, se resta
     *     uno al número de intentos
     *   - Si escribe una resolución y acierta, finaliza el juego, en caso contrario, se resta uno
     *     al número de intentos
     *   - Si el contador de intentos llega a 0, el jugador pierde
     * - La palabra debe ocultar de forma aleatoria letras, y nunca puede comenzar
     *   ocultando más del 60%
     * - Puedes utilizar las palabras que quieras y el número de intentos que consideres
     */
    public static void main(String[] args) {
        initGame();
    }

    private static void initGame() {
        Scanner sc = new Scanner(System.in);
        String word = generateWord();
        ArrayList<Character> hiddenLetters = hideLetters(word);
        int lifes = 5;
        boolean isWin = false;

        while (lifes > 0 && !isWin) {
            String currentWord = showCurrentWord(word, hiddenLetters);

            System.out.println("\n" + currentWord);
            System.out.println("Enter a new letter: ");
            System.out.println("Restant lifes: " + lifes);
            String input = sc.nextLine();
            char inputChar = input.charAt(0);

            if (hiddenLetters.contains(inputChar)) {
                hiddenLetters.remove(Character.valueOf(inputChar));
                if (hiddenLetters.isEmpty()) {
                    isWin = true;
                }
            } else {
                lifes--;
            }
        }

        if (isWin) {
            System.out.println("\nCongratulations!!! the secret word was " + word);
        } else {
            System.out.println("\nGame over :( the secret word was " + word);
        }
    }

    private static String showCurrentWord(String word, ArrayList<Character> hiddenLetters) {
        String result = "";
        char[] wordArr = word.toCharArray();

        for (Character c : wordArr) {
            if (hiddenLetters.contains(c)) {
                result += "_";
            } else {
                result += c;
            }
        }

        return result;
    }

    private static ArrayList<Character> hideLetters(String word) {
        int emptySpaces = (int) (word.length() * 0.6);
        ArrayList<Character> lostLetters = new ArrayList<>();

        for (int i = 0; i < emptySpaces; i++) {
            while (lostLetters.size() < emptySpaces) {
                Random random = new Random();
                int newIndex = random.nextInt(word.length());
                if (!lostLetters.contains(word.charAt(newIndex))) {
                    lostLetters.add(word.charAt(newIndex));
                }
            }
        }

        System.out.println("EMpty spaces: " + emptySpaces);
        return lostLetters;
    }

    private static String generateWord() {
        Random random = new Random();
        String[] words = new String[]{"mouredev", "programming", "unemployment", "desolation", "despair", "regret"};
        return words[random.nextInt(words.length)];
    }
}
