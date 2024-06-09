import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int H = scanner.nextInt();
        if (H < A && A <= B ) {
        System.out.println("Deficiency");
        } else if ( H > B && A <= B) {
        System.out.println("Excess");
        }
        else {
            System.out.println("Normal");
        }
    }
}
