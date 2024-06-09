import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create a Scanner object to read the user input
        Scanner scanner = new Scanner(System.in);

        // Read an integer from the user
        int n = scanner.nextInt();

        // YOUR CODE HERE: If 'n' is less than 5, output 'LOW'. If 'n' is exactly 5, output 'MID'. If 'n' is greater than 5, output 'HIGH'.
        if (n<5) {
            System.out.println("LOW");
        } else if (n==5) {
            System.out.println("MID");
        }
        else System.out.println("HIGH");

    }
}