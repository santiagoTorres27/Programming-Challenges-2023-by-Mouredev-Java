package week_03;

import java.util.ArrayList;
import java.util.Random;

public class PasswordsGenerator {
    /*
     * Escribe un programa que sea capaz de generar contraseñas de forma aleatoria.
     * Podrás configurar generar contraseñas con los siguientes parámetros:
     * - Longitud: Entre 8 y 16.
     * - Con o sin letras mayúsculas.
     * - Con o sin números.
     * - Con o sin símbolos.
     * (Pudiendo combinar todos estos parámetros entre ellos)
     */

    public static void main(String[] args) {
        String password = generatePassword(10, true, true, true);
        System.out.println(password);
    }

    public static String generatePassword(int length, boolean withUpperCases, boolean withNumbers, boolean withSymbols) {
        ArrayList<String> options = setOptions(withUpperCases, withNumbers, withSymbols);

        if (length < 8 || length > 16) {
            return null;
        } else {
            String password = "";
            Random random = new Random();

            for (int i = 0; i < length; i++) {
                String nextCharacter = "";
                int randomIndex = random.nextInt(options.size());
                String randomOption = options.get(randomIndex);
                switch (randomOption) {
                    case "uppercase" -> {
                        nextCharacter = generateRandomLetter(true);
                    }
                    case "number" -> {
                        nextCharacter = String.valueOf(random.nextInt(10));
                    }
                    case "symbol" -> {
                        nextCharacter = generateRandomSymbol();
                    }
                    default -> {
                        nextCharacter = generateRandomLetter(false);
                    }
                }
                password += nextCharacter;
            }
            return password;
        }
    }

    private static String generateRandomSymbol() {
        String[] availableSymbols = new String[]{"!", "#", "·", "@", "%", "&", "/", "(", ")", "=", "*"};
        Random random = new Random();
        return availableSymbols[random.nextInt(availableSymbols.length)];
    }

    private static String generateRandomLetter(boolean uppercase) {
        Random random = new Random();
        String randomLetter = String.valueOf((char) ('A' + random.nextInt(26)));
        return uppercase ? randomLetter : randomLetter.toLowerCase();
    }

    private static ArrayList<String> setOptions(boolean withUpperCases, boolean withNumbers, boolean withSymbols) {
        ArrayList<String> options = new ArrayList<>();
        options.add("lowercase");
        if (withUpperCases) {
            options.add("uppercase");
        }
        if (withNumbers) {
            options.add("number");
        }
        if (withSymbols) {
            options.add("symbol");
        }
        return options;
    }
}
