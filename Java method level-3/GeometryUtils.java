import java.util.Scanner;

public class GeometryUtils {

    // Method to calculate Euclidean distance
    public static double calculateDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }

    // Method to calculate slope and intercept of a line (y = mx + b)
    public static double[] getLineEquation(double x1, double y1, double x2, double y2) {
        double m = (y2 - y1) / (x2 - x1);       // slope
        double b = y1 - m * x1;                // y-intercept
        return new double[]{m, b};             // return as array
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for point 1
        System.out.print("Enter x1: ");
        double x1 = scanner.nextDouble();
        System.out.print("Enter y1: ");
        double y1 = scanner.nextDouble();

        // Input for point 2
        System.out.print("Enter x2: ");
        double x2 = scanner.nextDouble();
        System.out.print("Enter y2: ");
        double y2 = scanner.nextDouble();

        // Calculate Euclidean distance
        double distance = calculateDistance(x1, y1, x2, y2);
        System.out.printf("\nEuclidean Distance: %.4f\n", distance);

        // Check if x1 == x2 (vertical line case)
        if (x1 == x2) {
            System.out.println("The line is vertical. Slope is undefined.");
            System.out.println("Equation: x = " + x1);
        } else {
            double[] lineEq = getLineEquation(x1, y1, x2, y2);
            double m = lineEq[0];
            double b = lineEq[1];

            System.out.printf("Line Equation: y = %.2fx + %.2f\n", m, b);
        }

        scanner.close();
    }
}
