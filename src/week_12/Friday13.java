package week_12;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Friday13 {
    /*
     * Crea una función que sea capaz de detectar si existe un viernes 13
     * en el mes y el año indicados.
     * - La función recibirá el mes y el año y retornará verdadero o falso.
     */
    public static void main(String[] args) {

        int month = 12;
        int year = 2024;
        boolean isFriday13 = getFriday13s(year, month);
        System.out.println(isFriday13);
    }

    private static boolean getFriday13s(int year, int month) {
        LocalDate date = LocalDate.of(year, month, 1);
        int monthDays = YearMonth.from(date).lengthOfMonth();

        for (int i = 1; i <= monthDays; i++) {
            date = LocalDate.of(year, month, i);
            String dayName = date.getDayOfWeek().name();
            if (dayName.equalsIgnoreCase("FRIDAY") && i == 13) {
                return true;
            }
        }
        return false;
    }
}
