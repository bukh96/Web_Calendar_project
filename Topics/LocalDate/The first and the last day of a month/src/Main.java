import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        YearMonth in = YearMonth.of(year, month);
        System.out.println(in.atDay(1) + " " + in.atEndOfMonth());


    }
}