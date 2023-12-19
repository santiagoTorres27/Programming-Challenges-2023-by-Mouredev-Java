package week_09;

import java.util.*;

public class HeterogramIsogramPangram {
    /*
     * Crea 3 funciones, cada una encargada de detectar si una cadena de
     * texto es un heterograma, un isograma o un pangrama.
     * - Debes buscar la definición de cada uno de estos términos.
     */
    public static void main(String[] args) {
        String text = "The quick brown fox jumps over a lazy dog.";
        System.out.println("\n" + text);
        System.out.println("Heterogram: " + isHeterogram(text));
        System.out.println("Isogram: " + isIsogram(text));
        System.out.println("Pangram: " + isPangram(text));
    }

    private static boolean isPangram(String text) {
        char[] textArr = text.toLowerCase().toCharArray();
        ArrayList<Character> alphabet = new ArrayList<>();
        alphabet.add('a');
        alphabet.add('b');
        alphabet.add('c');
        alphabet.add('d');
        alphabet.add('e');
        alphabet.add('f');
        alphabet.add('g');
        alphabet.add('h');
        alphabet.add('i');
        alphabet.add('j');
        alphabet.add('k');
        alphabet.add('l');
        alphabet.add('m');
        alphabet.add('n');
        alphabet.add('o');
        alphabet.add('p');
        alphabet.add('q');
        alphabet.add('r');
        alphabet.add('s');
        alphabet.add('t');
        alphabet.add('u');
        alphabet.add('v');
        alphabet.add('w');
        alphabet.add('x');
        alphabet.add('y');
        alphabet.add('z');

        ArrayList<Character> textArrList = new ArrayList<>();
        for (Character c : textArr) {
            textArrList.add(c);
        }

        for (Character c : alphabet) {
            if (!textArrList.contains(c)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isIsogram(String text) {
        HashMap<Character, Integer> textMap = textToHashmap(text);
        Set<Integer> repetitions = new HashSet<>();
        for (Map.Entry<Character, Integer> entry : textMap.entrySet()) {
            repetitions.add(entry.getValue());
        }
        return repetitions.size() == 1;
    }

    private static boolean isHeterogram(String text) {
        HashMap<Character, Integer> textMap = textToHashmap(text);
        int maxRepetition = 1;
        for (Map.Entry<Character, Integer> entry : textMap.entrySet()) {
            if (entry.getValue() != maxRepetition) {
                return false;
            }
        }
        return true;
    }

    private static HashMap<Character, Integer> textToHashmap(String text) {
        char[] textArr = text.toLowerCase().toCharArray();
        HashMap<Character, Integer> repetitions = new HashMap<>();
        for (char i : textArr) {
            if (!repetitions.containsKey(i)) {
                repetitions.put(i, 1);
            } else {
                repetitions.put(i, repetitions.get(i) + 1);
            }
        }
        return repetitions;
    }
}
