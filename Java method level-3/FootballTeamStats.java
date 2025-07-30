
import java.util.Random;

public class FootballTeamStats {
    public static int[] generateHeights() {
        int[] heights = new int[11];
        Random rand = new Random();
        for (int i = 0; i < heights.length; i++) {
            heights[i] = rand.nextInt(101) + 150;
        }
        return heights;
    }


    public static int findSum(int[] arr) {
        int sum = 0;
        for (int val : arr) {
            sum += val;
        }
        return sum;
    }


    public static double findMean(int[] arr) {
        return (double) findSum(arr) / arr.length;
    }
    public static int findShortest(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int val : arr) {
            if (val < min)
                min = val;
        }
        return min;
    }


    public static int findTallest(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int val : arr) {
            if (val > max)
                max = val;
        }
        return max;
    }
        public static void displayHeights(int[] heights) {
        System.out.println("Heights of players:");
        for (int h : heights) {
            System.out.print(h + " ");
        }
        System.out.println();
        System.out.println("Shortest Height: " + findShortest(heights) + " cm");
        System.out.println("Tallest Height: " + findTallest(heights) + " cm");
        System.out.printf("Mean Height: %.2f cm\n", findMean(heights));
    }


    public static void main(String[] args) {
        int[] heights = generateHeights();
        displayHeights(heights);
    }
}

