package week_08;

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
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        String num = sc.nextLine();
        System.out.println(num);
    }
}
