package week_08;

import java.util.Date;
import java.util.Scanner;

public class RandomNumber {
    /*
     * Crea un generador de números pseudoaleatorios entre 0 y 100.
     * - No puedes usar ninguna función "random" (o semejante) del
     *   lenguaje de programación seleccionado.
     *
     * Es más complicado de lo que parece...
     */
    public static void main(String[] args) {
        int minNumber = 10;
        int maxNumber = 15;
        int randomValue = generateRandomNumber(minNumber, maxNumber);
        System.out.println(randomValue);
    }

    private static int generateRandomNumber(int min, int max) {
        Date today = new Date();
        long millis = today.getTime();
        int range = max - min + 1;
        long adjustedMillis = millis % range;
        int random = (int) adjustedMillis + min;
        return random;
    }

//    private static int generateRandomNumber2(int min, int max) {
//        Date today = new Date();
//        long millis = today.getTime();
//        int maxDigits = String.valueOf(max).length();
//        int millisLength = String.valueOf(millis).length();
//        int randomNumber = Integer.parseInt(String.valueOf(millis).substring(millisLength - maxDigits, millisLength));
//
//        while (randomNumber >= max || randomNumber <= min) {
//            randomNumber = randomNumber / 2;
//        }
//
//        return randomNumber;
//    }
}
