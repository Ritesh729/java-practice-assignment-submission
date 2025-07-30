import java.util.Arrays;
import java.util.Scanner;

public class NumberChecker {

    public static int countDigits(int num) {
        return String.valueOf(num).length();
    }

    public static int[] getDigits(int num) {
        return String.valueOf(num).chars().map(c -> c - '0').toArray();
    }

    public static boolean isDuckNumber(int[] digits) {
        for (int d : digits) {
            if (d == 0) return true;
        }
        return false;
    }

    public static boolean isArmstrongNumber(int num) {
        int[] digits = getDigits(num);
        int sum = 0;
        for (int d : digits) sum += Math.pow(d, digits.length);
        return sum == num;
    }

    public static int[] findTwoLargest(int[] digits) {
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        for (int d : digits) {
            if (d > first) {
                second = first;
                first = d;
            } else if (d > second && d != first) {
                second = d;
            }
        }
        return new int[]{first, second};
    }

    public static int[] findTwoSmallest(int[] digits) {
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (int d : digits) {
            if (d < first) {
                second = first;
                first = d;
            } else if (d < second && d != first) {
                second = d;
            }
        }
        return new int[]{first, second};
    }

    public static int sumOfDigits(int[] digits) {
        return Arrays.stream(digits).sum();
    }

    public static int sumOfSquares(int[] digits) {
        return Arrays.stream(digits).map(d -> (int)Math.pow(d, 2)).sum();
    }

    public static boolean isHarshadNumber(int num) {
        int[] digits = getDigits(num);
        int sum = sumOfDigits(digits);
        return num % sum == 0;
    }

    public static int[][] digitFrequency(int num) {
        int[] freq = new int[10];
        int[] digits = getDigits(num);
        for (int d : digits) freq[d]++;
        int[][] result = new int[10][2];
        for (int i = 0; i < 10; i++) {
            result[i][0] = i;
            result[i][1] = freq[i];
        }
        return result;
    }

    public static int[] reverseDigits(int[] digits) {
        int[] rev = new int[digits.length];
        for (int i = 0; i < digits.length; i++) {
            rev[i] = digits[digits.length - 1 - i];
        }
        return rev;
    }

    public static boolean arraysEqual(int[] a, int[] b) {
        return Arrays.equals(a, b);
    }

    public static boolean isPalindrome(int num) {
        int[] digits = getDigits(num);
        return arraysEqual(digits, reverseDigits(digits));
    }

    public static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static boolean isNeon(int num) {
        int square = num * num;
        int sum = sumOfDigits(getDigits(square));
        return sum == num;
    }

    public static boolean isSpy(int num) {
        int[] digits = getDigits(num);
        int sum = sumOfDigits(digits);
        int product = 1;
        for (int d : digits) product *= d;
        return sum == product;
    }

    public static boolean isAutomorphic(int num) {
        int square = num * num;
        return String.valueOf(square).endsWith(String.valueOf(num));
    }

    public static boolean isBuzz(int num) {
        return num % 7 == 0 || num % 10 == 7;
    }

    public static int[] getFactors(int num) {
        int count = 0;
        for (int i = 1; i <= num; i++) if (num % i == 0) count++;
        int[] factors = new int[count];
        int idx = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) factors[idx++] = i;
        }
        return factors;
    }

    public static int greatestFactor(int[] factors) {
        int max = Integer.MIN_VALUE;
        for (int f : factors) if (f != factors[factors.length - 1]) max = Math.max(max, f);
        return max;
    }

    public static int sumFactors(int[] factors) {
        return Arrays.stream(factors).sum();
    }

    public static int productFactors(int[] factors) {
        int prod = 1;
        for (int f : factors) prod *= f;
        return prod;
    }

    public static double productCubeFactors(int[] factors) {
        double prod = 1;
        for (int f : factors) prod *= Math.pow(f, 3);
        return prod;
    }

    public static boolean isPerfect(int num) {
        int[] factors = getFactors(num);
        int sum = 0;
        for (int f : factors) if (f != num) sum += f;
        return sum == num;
    }

    public static boolean isAbundant(int num) {
        int[] factors = getFactors(num);
        int sum = 0;
        for (int f : factors) if (f != num) sum += f;
        return sum > num;
    }

    public static boolean isDeficient(int num) {
        int[] factors = getFactors(num);
        int sum = 0;
        for (int f : factors) if (f != num) sum += f;
        return sum < num;
    }

    public static boolean isStrong(int num) {
        int[] digits = getDigits(num);
        int sum = 0;
        for (int d : digits) sum += factorial(d);
        return sum == num;
    }

    public static int factorial(int n) {
        int fact = 1;
        for (int i = 2; i <= n; i++) fact *= i;
        return fact;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask user for a number to analyze
        System.out.print("Enter a number to analyze: ");
        int number = scanner.nextInt();

        int[] digits = NumberChecker.getDigits(number);
        int[] reversed = NumberChecker.reverseDigits(digits);
        int[] twoLargest = NumberChecker.findTwoLargest(digits);
        int[] twoSmallest = NumberChecker.findTwoSmallest(digits);
        int[][] freq = NumberChecker.digitFrequency(number);
        int[] factors = NumberChecker.getFactors(number);

        System.out.println("\n--- Number Analysis ---");
        System.out.println("Digits: " + Arrays.toString(digits));
        System.out.println("Reversed Digits: " + Arrays.toString(reversed));
        System.out.println("Digit Count: " + NumberChecker.countDigits(number));
        System.out.println("Sum of Digits: " + NumberChecker.sumOfDigits(digits));
        System.out.println("Sum of Squares of Digits: " + NumberChecker.sumOfSquares(digits));

        System.out.println("\n--- Checks ---");
        System.out.println("Is Duck Number: " + NumberChecker.isDuckNumber(digits));
        System.out.println("Is Armstrong Number: " + NumberChecker.isArmstrongNumber(number));
        System.out.println("Is Harshad Number: " + NumberChecker.isHarshadNumber(number));
        System.out.println("Is Palindrome: " + NumberChecker.isPalindrome(number));
        System.out.println("Is Prime: " + NumberChecker.isPrime(number));
        System.out.println("Is Neon Number: " + NumberChecker.isNeon(number));
        System.out.println("Is Spy Number: " + NumberChecker.isSpy(number));
        System.out.println("Is Automorphic Number: " + NumberChecker.isAutomorphic(number));
        System.out.println("Is Buzz Number: " + NumberChecker.isBuzz(number));
        System.out.println("Is Strong Number: " + NumberChecker.isStrong(number));

        System.out.println("\n--- Digit Statistics ---");
        System.out.println("Two Largest Digits: " + Arrays.toString(twoLargest));
        System.out.println("Two Smallest Digits: " + Arrays.toString(twoSmallest));

        System.out.println("\n--- Digit Frequency ---");
        for (int[] row : freq) {
            if (row[1] > 0)
                System.out.println("Digit " + row[0] + ": " + row[1] + " time(s)");
        }

        System.out.println("\n--- Factor Analysis ---");
        System.out.println("Factors: " + Arrays.toString(factors));
        System.out.println("Greatest Proper Factor: " + NumberChecker.greatestFactor(factors));
        System.out.println("Sum of Factors: " + NumberChecker.sumFactors(factors));
        System.out.println("Product of Factors: " + NumberChecker.productFactors(factors));
        System.out.println("Product of Cubes of Factors: " + NumberChecker.productCubeFactors(factors));
        System.out.println("Is Perfect Number: " + NumberChecker.isPerfect(number));
        System.out.println("Is Abundant Number: " + NumberChecker.isAbundant(number));
        System.out.println("Is Deficient Number: " + NumberChecker.isDeficient(number));

        scanner.close();
    }
}
