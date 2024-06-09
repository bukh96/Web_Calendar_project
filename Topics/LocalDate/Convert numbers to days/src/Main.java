import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        int firstDay = scanner.nextInt();
        int secondDay = scanner.nextInt();
        int thirtyDay = scanner.nextInt();

        LocalDate date = LocalDate.ofYearDay(year,1);

        LocalDate date1 = date.withDayOfYear(firstDay);
        LocalDate date2 = date.withDayOfYear(secondDay);
        LocalDate date3 = date.withDayOfYear(thirtyDay);
        System.out.println(date1);
        System.out.println(date2);
        System.out.println(date3);
    }
}