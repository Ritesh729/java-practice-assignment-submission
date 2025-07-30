import java.util.Scanner;

public class NumberAnalysis {
    public static boolean isPositive(int n) { return n > 0; }
    public static boolean isEven(int n) { return n % 2 == 0; }
    public static int compare(int a, int b) {
        return a > b ? 1 : (a < b ? -1 : 0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[5];

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = sc.nextInt();
            if (isPositive(numbers[i])) {
                System.out.println("Positive and " + (isEven(numbers[i]) ? "Even" : "Odd"));
            } else {
                System.out.println("Negative");
            }
        }
        int result = compare(numbers[0], numbers[4]);
        System.out.println("Comparison of first and last element: " +
                (result == 0 ? "Equal" : (result == 1 ? "First is greater" : "Last is greater")));
    }
}
