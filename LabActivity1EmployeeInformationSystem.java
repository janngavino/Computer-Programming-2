import java.util.Scanner;

public class LabActivity1EmployeeInformationSystem {
    public static void main(String[] args) {
        // To begin execute the code or to start
        Scanner scanner = new Scanner(System.in);
        
        // Coder Inputs: I used string to get the first and last name of the employee
        System.out.print("Enter employee's first name: ");
        String firstName = scanner.nextLine();
        
        System.out.print("Enter employee's last name: ");
        String lastName = scanner.nextLine();
        
        // Coder Input: I used Integer to get the employee's age
        System.out.print("Enter employee's age: ");
        int age = Integer.parseInt(scanner.nextLine());
        
        // Coder Inputs: I used double to get the number of hours worked and hourly wage
        System.out.print("Enter number of hours worked in a day: ");
        double hoursWorked = Double.parseDouble(scanner.nextLine());
        
        System.out.print("Enter hourly wage: ");
        double hourlyWage = Double.parseDouble(scanner.nextLine());
        
        // I used Concatenation to the first and last name to make it a full name
        String fullName = firstName + " " + lastName;
        
        // To get the answer you must multiply the hours worked with hourly wage
        double dailyWage = hoursWorked * hourlyWage;
        
        // Display output with the coder inputs
        System.out.println("\nEmployee Information:");
        System.out.println("Full Name: " + fullName);
        System.out.println("Age: " + age);
        System.out.printf("Daily Wage: %.2f\n", dailyWage);
        
        // To finally execute the codes or to finish
        scanner.close();
    }
}

