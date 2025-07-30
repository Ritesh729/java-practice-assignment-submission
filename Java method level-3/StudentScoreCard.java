import java.util.Random;
import java.util.Scanner;

public class StudentScoreCard {

    // Generate random scores for Physics, Chemistry, Maths
    public static int[][] generateScores(int numStudents) {
        int[][] scores = new int[numStudents][3];
        Random rand = new Random();

        for (int i = 0; i < numStudents; i++) {
            scores[i][0] = 50 + rand.nextInt(51); // Physics (50–100)
            scores[i][1] = 50 + rand.nextInt(51); // Chemistry
            scores[i][2] = 50 + rand.nextInt(51); // Maths
        }
        return scores;
    }

    // Calculate total, average and percentage
    public static double[][] calculateResults(int[][] scores) {
        int numStudents = scores.length;
        double[][] results = new double[numStudents][3]; // total, average, percentage

        for (int i = 0; i < numStudents; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double avg = total / 3.0;
            double percent = (total / 300.0) * 100;

            results[i][0] = total;
            results[i][1] = Math.round(avg * 100.0) / 100.0;
            results[i][2] = Math.round(percent * 100.0) / 100.0;
        }

        return results;
    }

    // Display the scorecard
    public static void displayScoreCard(int[][] scores, double[][] results) {
        System.out.println("ID\tPhysics\tChemistry\tMaths\tTotal\tAverage\tPercentage");

        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%d\t%d\t%d\t\t%d\t%d\t%.2f\t%.2f%%\n",
                    i + 1,
                    scores[i][0],
                    scores[i][1],
                    scores[i][2],
                    (int) results[i][0],
                    results[i][1],
                    results[i][2]);
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int numStudents = scanner.nextInt();

        int[][] scores = generateScores(numStudents);
        double[][] results = calculateResults(scores);

        System.out.println("\nStudent Scorecard:");
        displayScoreCard(scores, results);
    }
}
