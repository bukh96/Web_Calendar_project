import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int input = scanner.radix();
        LocalDate in = LocalDate.ofYearDay(scanner.nextInt(),scanner.nextInt());
        int day = in.getDayOfMonth();
        int month = in.lengthOfMonth();
        if (day == month) {
            System.out.println(true);
        }
        else System.out.println(false);
    }
}