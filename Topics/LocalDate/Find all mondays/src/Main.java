import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        LocalDate date = LocalDate.of(year,month,1);

        for (int i = 1; i < date.lengthOfMonth(); i++) {
            date = date.plusDays(1);
            if (date.getDayOfWeek() == DayOfWeek.MONDAY) {
                System.out.println(date);
            }

        }
    }
}