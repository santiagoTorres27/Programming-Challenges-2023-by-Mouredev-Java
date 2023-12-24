package week_16;

public class Ladder {
    /*
     * Crea una función que dibuje una escalera según su número de escalones.
     * - Si el número es positivo, será ascendente de izquiera a derecha.
     * - Si el número es negativo, será descendente de izquiera a derecha.
     * - Si el número es cero, se dibujarán dos guiones bajos (__).
     *
     * Ejemplo: 4
     *         _
     *       _|
     *     _|
     *   _|
     * _|
     *
     */
    public static void main(String[] args) {
        printLadder(0);
    }

    private static void printLadder(int length) {
        String ladder = "";
        if (length > 0) {
            for (int i = length; i >= 0; i--) {
                for (int j = 0; j < i; j++) {
                    System.out.print("  ");
                }
                if (i == length) {
                    System.out.print("__");
                } else {
                    System.out.print("_|");
                }
                System.out.println();
            }

        } else if (length < 0) {
            for (int i = 0; i < Math.abs(length) + 1; i++) {
                for (int j = 0; j <= i; j++) {
                    if (i == 0) {
                        System.out.print("__");
                    } else if (j == i) {
                        System.out.print("|_");
                    } else {
                        System.out.print("  ");
                    }
                }
                System.out.println();
            }
        } else {
            System.out.println("__");
        }
    }
}
