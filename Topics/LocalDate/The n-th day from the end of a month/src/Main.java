import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(LocalDate.of(sc.nextInt(), sc.nextInt(), 1)
                .plusMonths(1)
                .minusDays(sc.nextInt()));
    }
}
