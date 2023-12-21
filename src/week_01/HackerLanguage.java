package week_01;

import java.util.HashMap;

public class HackerLanguage {
    /*
     * Escribe un programa que reciba un texto y transforme lenguaje natural a
     * "lenguaje hacker" (conocido realmente como "leet" o "1337"). Este lenguaje
     *  se caracteriza por sustituir caracteres alfanuméricos.
     * - Utiliza esta tabla (https://www.gamehouse.com/blog/leet-speak-cheat-sheet/)
     *   con el alfabeto y los números en "leet".
     *   (Usa la primera opción de cada transformación. Por ejemplo "4" para la "a")
     */

    public static HashMap<Character, String> hackerLanguageMap;

    public static void main(String[] args) {
        loadData();
        String text = "hola a todos";
        String result = convertText(text);
        System.out.println(result);
    }

    private static void loadData() {
        hackerLanguageMap = new HashMap<>();
        hackerLanguageMap.put('A', "4");
        hackerLanguageMap.put('B', "I3");
        hackerLanguageMap.put('C', "[");
        hackerLanguageMap.put('D', ")");
        hackerLanguageMap.put('E', "3");
        hackerLanguageMap.put('F', "|=");
        hackerLanguageMap.put('G', "&");
        hackerLanguageMap.put('H', "#");
        hackerLanguageMap.put('I', "1");
        hackerLanguageMap.put('J', ",_|");
        hackerLanguageMap.put('K', ">|");
        hackerLanguageMap.put('L', "1");
        hackerLanguageMap.put('M', "/\\/\\");
        hackerLanguageMap.put('N', "^/");
        hackerLanguageMap.put('O', "0");
        hackerLanguageMap.put('P', "|*");
        hackerLanguageMap.put('Q', "(_,)");
        hackerLanguageMap.put('R', "I2");
        hackerLanguageMap.put('S', "5");
        hackerLanguageMap.put('T', "7");
        hackerLanguageMap.put('U', "(_)");
        hackerLanguageMap.put('V', "\\/");
        hackerLanguageMap.put('W', "\\/\\/");
        hackerLanguageMap.put('X', "><");
        hackerLanguageMap.put('Y', "j");
        hackerLanguageMap.put('Z', "2");
        hackerLanguageMap.put('1', "L");
        hackerLanguageMap.put('2', "R");
        hackerLanguageMap.put('3', "E");
        hackerLanguageMap.put('4', "A");
        hackerLanguageMap.put('5', "S");
        hackerLanguageMap.put('6', "b");
        hackerLanguageMap.put('7', "T");
        hackerLanguageMap.put('8', "B");
        hackerLanguageMap.put('9', "g");
        hackerLanguageMap.put('0', "o");
    }

    private static String convertText(String text) {
        char[] textArr = text.toUpperCase().toCharArray();
        String result = "";
        for (Character i : textArr) {
            if (hackerLanguageMap.containsKey(i)) {
                result += hackerLanguageMap.get(i);
            } else if (i == ' ') {
                result += " ";
            }
        }
        return result;
    }
}
