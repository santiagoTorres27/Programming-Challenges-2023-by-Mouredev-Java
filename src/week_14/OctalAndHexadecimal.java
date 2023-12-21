package week_14;

import java.awt.*;

public class OctalAndHexadecimal {
    /*
     * Crea una función que reciba un número decimal y lo trasforme a Octal
     * y Hexadecimal.
     * - No está permitido usar funciones propias del lenguaje de programación que
     * realicen esas operaciones directamente.
     */
    public static void main(String[] args) {
        int number = 3452378;
        long octal = decimalToOctal(number);
        String hex = decimalToHex(number);
        System.out.println("Octal: " + octal);
        System.out.println("Hexadecimal: " + hex);
    }

    private static String decimalToHex(int number) {
        String hex = "";
        while (number > 0) {
            int res = number % 16;
            switch (res) {
                case 10 -> hex = "A" + hex;
                case 11 -> hex = "B" + hex;
                case 12 -> hex = "C" + hex;
                case 13 -> hex = "D" + hex;
                case 14 -> hex = "E" + hex;
                case 15 -> hex = "F" + hex;
                default -> hex = res + hex;
            }
            number = number / 16;
        }
        return hex;
    }

    private static long decimalToOctal(int number) {
        String octalStr = "";
        while (number > 0) {
            int res = number % 8;
            octalStr = res + octalStr;
            number = number / 8;
        }
        return Long.parseLong(octalStr);
    }
}
