import java.util.Random;

public class ZaraBonusCalculator {

    // Generate random salaries and years of service
    public static double[][] generateEmployeeData(int numberOfEmployees) {
        double[][] employeeData = new double[numberOfEmployees][2]; // [][0]=salary, [][1]=yearsOfService
        Random rand = new Random();

        for (int i = 0; i < numberOfEmployees; i++) {
            int salary = 10000 + rand.nextInt(90000);  // 5-digit salary
            int years = rand.nextInt(11);              // 0–10 years of service
            employeeData[i][0] = salary;
            employeeData[i][1] = years;
        }

        return employeeData;
    }

    // Calculate bonus and new salary
    public static double[][] calculateBonusAndNewSalary(double[][] employeeData) {
        double[][] result = new double[employeeData.length][3]; // [][0]=oldSalary, [][1]=bonus, [][2]=newSalary

        for (int i = 0; i < employeeData.length; i++) {
            double oldSalary = employeeData[i][0];
            double years = employeeData[i][1];

            double bonusPercentage = years > 5 ? 0.05 : 0.02;
            double bonus = oldSalary * bonusPercentage;
            double newSalary = oldSalary + bonus;

            result[i][0] = oldSalary;
            result[i][1] = bonus;
            result[i][2] = newSalary;
        }

        return result;
    }

    // Display employee data and totals
    public static void displaySummary(double[][] employeeData, double[][] newSalaryData) {
        double totalOldSalary = 0;
        double totalNewSalary = 0;
        double totalBonus = 0;

        System.out.printf("%-10s %-12s %-10s %-12s %-12s %-12s\n", "Emp ID", "Old Salary", "Years", "Bonus", "New Salary", "Bonus %");

        for (int i = 0; i < employeeData.length; i++) {
            double oldSalary = newSalaryData[i][0];
            double bonus = newSalaryData[i][1];
            double newSalary = newSalaryData[i][2];
            double years = employeeData[i][1];
            double bonusPercent = (years > 5) ? 5 : 2;

            System.out.printf("%-10d %-12.2f %-10.0f %-12.2f %-12.2f %-12s\n",
                    (i + 1), oldSalary, years, bonus, newSalary, bonusPercent + "%");

            totalOldSalary += oldSalary;
            totalNewSalary += newSalary;
            totalBonus += bonus;
        }

        System.out.println("\n-------------------------------------------------------------");
        System.out.printf("Total Old Salary : %.2f\n", totalOldSalary);
        System.out.printf("Total Bonus Paid : %.2f\n", totalBonus);
        System.out.printf("Total New Salary : %.2f\n", totalNewSalary);
    }

    public static void main(String[] args) {
        int numEmployees = 10;

        double[][] employeeData = generateEmployeeData(numEmployees);
        double[][] newSalaryData = calculateBonusAndNewSalary(employeeData);
        displaySummary(employeeData, newSalaryData);
    }
}
