import java.util.Scanner;

public class LabActivity3ConditionalStatement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Employee Input details
        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter your last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        // Employee age validation
        if (age < 18) {
            System.out.println("Minors are not allowed.");
            return;
        } else if (age >= 65) {
            System.out.println("Senior Citizens are not allowed.");
            return;
        }

        System.out.print("Enter hours worked per day: ");
        float hoursWorked = scanner.nextFloat();

        // Employee Work hours validation
        if (hoursWorked > 24) {
            System.out.println("Number of hours worked cannot exceed 24 hours.");
            return;
        } else if (hoursWorked <= 0) {
            System.out.println("Wrong input on daily work hours.");
            return;
        }

        System.out.print("Enter hourly wage: ");
        float hourlyWage = scanner.nextFloat();

        System.out.print("Enter role code (1-Manager, 2-Supervisor, 3-Staff, 4-Intern): ");
        int roleCode = scanner.nextInt();

        // Determine the role using switch-case
        String role;
        switch (roleCode) {
            case 1:
                role = "Manager";
                break;
            case 2:
                role = "Supervisor";
                break;
            case 3:
                role = "Staff";
                break;
            case 4:
                role = "Intern";
                break;
            default:
                role = "Undefined";
        }

        // Employee Salary computations
        float dailySalary = hoursWorked * hourlyWage;
        float weeklySalary = dailySalary * 5;
        float monthlySalary = weeklySalary * 4;
        float grossYearlySalary = monthlySalary * 12;

        // Tax and deductions
        float netYearlySalary;
        if (grossYearlySalary > 250000) {
            netYearlySalary = grossYearlySalary - (grossYearlySalary * 0.32f) - 1500;
        } else {
            netYearlySalary = grossYearlySalary - 1500;
        }

        int yearsToRetirement = 65 - age;

        // Output Employee Informations
        System.out.println("\nEmployee Information");
        System.out.println("--------------------");
        System.out.println("Full Name:        " + lastName.toUpperCase() + ", " + firstName.toUpperCase());
        System.out.println("Age:              " + age + " years old");
        System.out.println("Position:         " + role);
        System.out.println("Years to Retirement: " + yearsToRetirement + " years");
        System.out.println("Daily Salary:     Php " + String.format("%.2f", dailySalary));
        System.out.println("Weekly Salary:    Php " + String.format("%.2f", weeklySalary));
        System.out.println("Monthly Salary:   Php " + String.format("%.2f", monthlySalary));
        System.out.println("Gross Yearly Salary: Php " + String.format("%.2f", grossYearlySalary));
        System.out.println("Net Yearly Salary: Php " + String.format("%.2f", netYearlySalary));

        scanner.close();
    }
}