import java.util.Scanner;

public class AthleteRounds {
    public static double calculateRounds(double side1, double side2, double side3) {
        double perimeter = side1 + side2 + side3;
        return 5000 / perimeter; // 5km = 5000 meters
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter 3 sides of triangle (meters): ");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();

        double rounds = calculateRounds(a, b, c);
        System.out.printf("Athlete must complete %.2f rounds.\n", rounds);
    }
}

