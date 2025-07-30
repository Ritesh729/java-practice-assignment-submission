
import java.util.*;

public class RandomStats {
    public static int[] generate4DigitRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++)
            arr[i] = 1000 + rand.nextInt(9000);
        return arr;
    }

    public static double[] findAverageMinMax(int[] numbers) {
        int min = numbers[0], max = numbers[0], sum = 0;
        for (int n : numbers) {
            sum += n;
            if (n < min) min = n;
            if (n > max) max = n;
        }
        return new double[]{(double) sum / numbers.length, min, max};
    }
        public static void main(String[] args) {
        int[] arr = generate4DigitRandomArray(5);
        System.out.println("Generated numbers: " + Arrays.toString(arr));
        double[] result = findAverageMinMax(arr);
        System.out.printf("Average: %.2f, Min: %.0f, Max: %.0f\n", result[0], result[1], result[2]);
    }
}


