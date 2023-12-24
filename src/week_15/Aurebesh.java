package week_15;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

public class Aurebesh {
    /*
     * Crea una función que sea capaz de transformar Español al lenguaje básico
     * del universo Star Wars: el "Aurebesh".
     * - Puedes dejar sin transformar los caracteres que no existan en "Aurebesh".
     * - También tiene que ser capaz de traducir en sentido contrario.
     *
     * ¿Lo has conseguido? Nómbrame en twitter.com/mouredev y escríbeme algo en Aurebesh.
     *
     * ¡Que la fuerza os acompañe!
     */

    public static HashMap<Character, String> textToAurebeshMap;
    public static HashMap<String, Character> aurebeshToTextMap;

    public static void main(String[] args) {
        String text = "hola a todos";
//        String translate = textToAurebesh(text);
        String translate = aurebeshToText("Herf-Osk-Leth-Aurek Aurek Trill-Osk-Dorn-Osk-Senth");
        System.out.println(translate);
    }

    private static String aurebeshToText(String text) {
        String translation = "";
        String[] textArr = text.split(" ");
        for (String i : textArr) {
            translation += aurebeshToWord(i) + " ";
        }
        return translation;
    }

    private static String aurebeshToWord(String word) {
        loadAlphabet();
        String translation = "";
        String[] textArr = word.split("-");
        for (String i : textArr) {
            if (aurebeshToTextMap.containsKey(i)) {
                translation += aurebeshToTextMap.get(i);
            }
        }
        return translation;
    }

    private static String textToAurebesh(String text) {
        String translation = "";
        String[] textArr = text.split(" ");
        for (String i : textArr) {
            translation += wordToAurebesh(i) + " ";
        }
        return translation;
    }


    private static String wordToAurebesh(String word) {
        loadAlphabet();
        String translation = "";
        for (Character i : word.toUpperCase().toCharArray()) {
            if (textToAurebeshMap.containsKey(i)) {
                translation += textToAurebeshMap.get(i) + "-";
            }
        }
        return translation.substring(0, translation.length() - 1);
    }

    private static void loadAlphabet() {
        textToAurebeshMap = new HashMap<>();
        aurebeshToTextMap = new HashMap<>();

        textToAurebeshMap.put('A', "Aurek");
        textToAurebeshMap.put('B', "Besh");
        textToAurebeshMap.put('C', "Cresh");
        textToAurebeshMap.put('D', "Dorn");
        textToAurebeshMap.put('E', "Esk");
        textToAurebeshMap.put('F', "Forn");
        textToAurebeshMap.put('G', "Grekk");
        textToAurebeshMap.put('H', "Herf");
        textToAurebeshMap.put('I', "Isk");
        textToAurebeshMap.put('J', "Jenth");
        textToAurebeshMap.put('K', "Krill");
        textToAurebeshMap.put('L', "Leth");
        textToAurebeshMap.put('M', "Mern");
        textToAurebeshMap.put('N', "Nern");
        textToAurebeshMap.put('O', "Osk");
        textToAurebeshMap.put('P', "Peth");
        textToAurebeshMap.put('Q', "Qek");
        textToAurebeshMap.put('R', "Resh");
        textToAurebeshMap.put('S', "Senth");
        textToAurebeshMap.put('T', "Trill");
        textToAurebeshMap.put('U', "Usk");
        textToAurebeshMap.put('V', "Vev");
        textToAurebeshMap.put('W', "Wesk");
        textToAurebeshMap.put('X', "Xesh");
        textToAurebeshMap.put('Y', "Yirt");
        textToAurebeshMap.put('Z', "Zerek");

        aurebeshToTextMap.put("Aurek", 'A');
        aurebeshToTextMap.put("Besh", 'B');
        aurebeshToTextMap.put("Cresh", 'C');
        aurebeshToTextMap.put("Dorn", 'D');
        aurebeshToTextMap.put("Esk", 'E');
        aurebeshToTextMap.put("Forn", 'F');
        aurebeshToTextMap.put("Grekk", 'G');
        aurebeshToTextMap.put("Herf", 'H');
        aurebeshToTextMap.put("Isk", 'I');
        aurebeshToTextMap.put("Jenth", 'J');
        aurebeshToTextMap.put("Krill", 'K');
        aurebeshToTextMap.put("Leth", 'L');
        aurebeshToTextMap.put("Mern", 'M');
        aurebeshToTextMap.put("Nern", 'N');
        aurebeshToTextMap.put("Osk", 'O');
        aurebeshToTextMap.put("Peth", 'P');
        aurebeshToTextMap.put("Qek", 'Q');
        aurebeshToTextMap.put("Resh", 'R');
        aurebeshToTextMap.put("Senth", 'S');
        aurebeshToTextMap.put("Trill", 'T');
        aurebeshToTextMap.put("Usk", 'U');
        aurebeshToTextMap.put("Vev", 'V');
        aurebeshToTextMap.put("Wesk", 'W');
        aurebeshToTextMap.put("Xesh", 'X');
        aurebeshToTextMap.put("Yirt", 'Y');
        aurebeshToTextMap.put("Zerek", 'Z');
    }
}
