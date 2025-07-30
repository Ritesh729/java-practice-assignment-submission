import java.util.Scanner;

public class CalendarDisplay {

    // Array to hold month names
    static String[] months = { "January", "February", "March", "April", "May", "June",
                               "July", "August", "September", "October", "November", "December" };

    // Days in each month (non-leap year)
    static int[] daysInMonth = { 31, 28, 31, 30, 31, 30,
                                 31, 31, 30, 31, 30, 31 };

    // Check if a year is leap year
    public static boolean isLeapYear(int year) {
        if (year % 400 == 0) return true;
        if (year % 100 == 0) return false;
        return year % 4 == 0;
    }

    // Get number of days in a month considering leap year for February
    public static int getNumberOfDays(int month, int year) {
        if (month == 2) {  // February
            return isLeapYear(year) ? 29 : 28;
        } else {
            return daysInMonth[month - 1];
        }
    }

    // Get the first day of the month (0 = Sunday, 1 = Monday, ... 6 = Saturday)
    // Using Gregorian calendar algorithm
    public static int getFirstDay(int month, int year) {
        int y0 = year - (14 - month) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = month + 12 * ((14 - month) / 12) - 2;
        int d0 = (1 + x + (31 * m0) / 12) % 7;
        return d0;
    }

    // Display the calendar
    public static void displayCalendar(int month, int year) {
        System.out.println("     " + months[month - 1] + " " + year);
        System.out.println("Su  Mo  Tu  We  Th  Fr  Sa");

        int firstDay = getFirstDay(month, year);
        int numberOfDays = getNumberOfDays(month, year);

        // Print spaces for days before the first day
        for (int i = 0; i < firstDay; i++) {
            System.out.print("    ");  // 4 spaces for alignment
        }

        // Print all days of the month
        for (int day = 1; day <= numberOfDays; day++) {
            System.out.printf("%3d ", day);

            // Move to next line after Saturday
            if ((day + firstDay) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println(); // final newline after calendar
    }

    // Main method to take input and display calendar
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter month (1-12): ");
        int month = scanner.nextInt();

        System.out.print("Enter year: ");
        int year = scanner.nextInt();

        if (month < 1 || month > 12) {
            System.out.println("Invalid month. Please enter a value between 1 and 12.");
            return;
        }

        displayCalendar(month, year);
    }
}
