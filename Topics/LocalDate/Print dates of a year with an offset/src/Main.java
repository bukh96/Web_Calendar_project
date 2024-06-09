import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Scanner;

import static java.time.temporal.ChronoField.DAY_OF_YEAR;
import static java.time.temporal.TemporalAdjusters.firstDayOfNextYear;
import static java.time.temporal.TemporalAdjusters.lastDayOfYear;


class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String in = scanner.next();
        LocalDate date = LocalDate.parse(in);
        int offset = scanner.nextInt();
        /*TemporalAdjuster nextYear = lastDayOfYear();*/
        long lastDay = date.with(lastDayOfYear()).getDayOfYear();
        System.out.println(date);
        for (int i = 1; i <= lastDay; i++) {
            LocalDate plusDate = date.plusDays(i * offset);
            if (plusDate.getYear() == date.getYear()){
                System.out.println(plusDate);
            }
            else {
                break;
            }

        }
    }

}