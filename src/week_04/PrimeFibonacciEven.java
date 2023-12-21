package week_04;

public class PrimeFibonacciEven {
    /*
     * Escribe un programa que, dado un número, compruebe y muestre si es primo,
     * fibonacci y par.
     * Ejemplos:
     * - Con el número 2, nos dirá: "2 es primo, fibonacci y es par"
     * - Con el número 7, nos dirá: "7 es primo, no es fibonacci y es impar"
     */
    public static void main(String[] args) {
        int number = 34;
        String result = checkNumber(number);
        System.out.println(result);
    }

    private static String checkNumber(int number) {
        boolean isPrimeNumber = isPrimeNumber(number);
        boolean isOdd = isOddNumber(number);
        boolean isFibonacci = isFibonacci(number);
        String prime = (isPrimeNumber) ? "is prime" : "is not prime";
        String fibonacci = (isFibonacci) ? "is fibonacci" : "is not fibonacci";
        String odd = (isOdd) ? "is odd" : "is even" + " ";
        return number + " " + prime + ", " + fibonacci + " and " + odd;
    }

    private static boolean isFibonacci(int number) {
        if (number <= 3) {
            return true;
        } else {
            int n1 = 0;
            int n2 = 1;
            while (n2 < number) {
                int aux = n2;
                n2 = n1 + n2;
                n1 = aux;
            }
            return n2 == number;
        }
    }

    private static boolean isOddNumber(int number) {
        return number % 2 == 0;
    }

    private static boolean isPrimeNumber(int number) {
        for (int i = 2; i < number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
