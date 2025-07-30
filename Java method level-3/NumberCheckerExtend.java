import java.util.Arrays;
import java.util.Scanner;

public class NumberCheckerExtend {

    // Count the digits in the number
    public static int countDigits(int num) {
        return String.valueOf(Math.abs(num)).length();
    }

    // Convert number to array of digits
    public static int[] getDigits(int num) {
        return String.valueOf(Math.abs(num)).chars().map(c -> c - '0').toArray();
    }

    // Sum of digits
    public static int sumOfDigits(int[] digits) {
        return Arrays.stream(digits).sum();
    }

    // Sum of squares of digits
    public static int sumOfSquares(int[] digits) {
        return Arrays.stream(digits).map(d -> (int) Math.pow(d, 2)).sum();
    }

    // Check Harshad number
    public static boolean isHarshadNumber(int num) {
        int[] digits = getDigits(num);
        int sum = sumOfDigits(digits);
        return sum != 0 && num % sum == 0;
    }

    // Digit frequency (2D array)
    public static int[][] digitFrequency(int num) {
        int[] frequency = new int[10];
        int[] digits = getDigits(num);
        for (int d : digits) frequency[d]++;

        int[][] result = new int[10][2];
        for (int i = 0; i < 10; i++) {
            result[i][0] = i;         // digit
            result[i][1] = frequency[i]; // frequency
        }
        return result;
    }
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // User input
        System.out.print("Enter a number to analyze: ");
        int number = scanner.nextInt();

        // Call utility methods
        int digitCount = NumberChecker.countDigits(number);
        int[] digits = NumberChecker.getDigits(number);
        int sum = NumberChecker.sumOfDigits(digits);
        int squareSum = NumberChecker.sumOfSquares(digits);
        boolean isHarshad = NumberChecker.isHarshadNumber(number);
        int[][] freq = NumberChecker.digitFrequency(number);

        // Display results
        System.out.println("\n--- Number Analysis ---");
        System.out.println("Number: " + number);
        System.out.println("Digits: " + Arrays.toString(digits));
        System.out.println("Count of Digits: " + digitCount);
        System.out.println("Sum of Digits: " + sum);
        System.out.println("Sum of Squares of Digits: " + squareSum);
        System.out.println("Is Harshad Number: " + isHarshad);

        System.out.println("\nDigit Frequencies:");
        for (int[] row : freq) {
            if (row[1] > 0) {
                System.out.println("Digit " + row[0] + ": " + row[1] + " time(s)");
            }
        }

        scanner.close();
    }
}
