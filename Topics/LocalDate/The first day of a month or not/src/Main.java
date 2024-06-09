import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        LocalDate date = LocalDate.ofYearDay(scanner.nextInt(),scanner.nextInt());
        LocalDate dateMin = date.minusDays(1);

        if (date.getMonth() == dateMin.getMonth()) {
            System.out.println(false);
        }
        else System.out.println(true);
    }
}