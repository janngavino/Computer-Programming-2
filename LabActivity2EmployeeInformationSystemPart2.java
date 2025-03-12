import java.util.Scanner;

public class LabActivity2EmployeeInformationSystemPart2.java {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // User inputs for these questions
        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter your last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        System.out.print("Enter hours worked: ");
        double hoursWorked = scanner.nextDouble();

        System.out.print("Enter hourly wage: ");
        double hourlyWage = scanner.nextDouble();

        String fullName = (lastName + ", " + firstName).toUpperCase(); // Your fullname and make it uppercase
        int yearsToRetirement = Math.abs(65 - age); // Compute the years of your retirement
        int dailyWage = (int) Math.round(hoursWorked * hourlyWage); // Your daily wage based on per hour
        int weeklyWage = dailyWage * 5; // Your weekly wage based on your daily wage
        int monthlyWage = weeklyWage * 4; // Your monthly wage based on your weekly wage
        int grossYearlyWage = monthlyWage * 12; // Your yearly wage based on your monthly wage

        double taxDeduction = grossYearlyWage * 0.32; // Your yearly wage is computed to 32% tax
        double netYearlyWage = grossYearlyWage - taxDeduction - 1500; // Your yearly wage is computed for deduction of 1500

        // User Output Results 
        System.out.println("\nEmployee Information");
        System.out.println("-----------------------");
        System.out.printf("Full Name:          %s%n", fullName);
        System.out.printf("Age:                %d years old%n", age);
        System.out.printf("Years to Retirement: %d years%n", yearsToRetirement);
        System.out.printf("Daily Salary:       Php %,d.00%n", dailyWage);
        System.out.printf("Weekly Salary:      Php %,d.00%n", weeklyWage);
        System.out.printf("Monthly Salary:     Php %,d.00%n", monthlyWage);
        System.out.printf("Gross Yearly Salary: Php %,d.00%n", grossYearlyWage);
        System.out.printf("Net Yearly Salary:  Php %,.2f%n", netYearlyWage);

        scanner.close();
    }
}
