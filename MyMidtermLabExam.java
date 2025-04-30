import java.util.Scanner;

public class MyMidtermLabExam {
    // Max choices of tickets
    private static final int MAX_TICKETS = 5;
    
    // Ticket structure of my experience in real estate buyers
    private static class Ticket {
        String description;
        String urgency; // Low, Medium, High
        String status; // Pending, In Progress, Resolved

        Ticket(String description, String urgency) {
            this.description = description;
            this.urgency = urgency;
            this.status = "Pending";
        }
    }

    // Ticket arrays
    private static Ticket[] tickets = new Ticket[MAX_TICKETS];
    private static int ticketCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            displayMainMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addTicket(scanner);
                    break;
                case 2:
                    updateTicketStatus(scanner);
                    break;
                case 3:
                    showTickets();
                    break;
                case 4:
                    generateReport();
                    break;
                case 5:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice, please select again.");
            }
        } while (choice != 5);

        scanner.close();
    }

    private static void displayMainMenu() {
        System.out.println("Main Menu:");
        System.out.println("1. Add a New Ticket");
        System.out.println("2. Update Ticket Status");
        System.out.println("3. Display All Tickets");
        System.out.println("4. Generate Report");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addTicket(Scanner scanner) {
        if (ticketCount >= MAX_TICKETS) {
            System.out.println("Ticket limit reached. Cannot add new ticket.");
            return;
        }

        System.out.print("Enter issue description: ");
        String description = scanner.nextLine();
        System.out.print("Enter urgency level (Low, Medium, High): ");
        String urgency = scanner.nextLine();

        tickets[ticketCount] = new Ticket(description, urgency);
        ticketCount++;
        System.out.println("Ticket added successfully.");
    }

    private static void updateTicketStatus(Scanner scanner) {
        System.out.print("Enter ticket number to update (0 to " + (ticketCount - 1) + "): ");
        int ticketNumber = scanner.nextInt();

        if (ticketNumber < 0 || ticketNumber >= ticketCount) {
            System.out.println("Invalid ticket number.");
            return;
        }

        System.out.print("Enter new status (In Progress or Resolved): ");
        String newStatus = scanner.nextLine();

        if (!newStatus.equals("In Progress") && !newStatus.equals("Resolved")) {
            System.out.println("Invalid status. Ticket can only be updated to 'In Progress' or 'Resolved'.");
            return;
        }

        tickets[ticketNumber].status = newStatus;
        System.out.println("Ticket status updated successfully.");
    }

    private static void showTickets() {
        System.out.println("All Tickets:");
        for (int i = 0; i < ticketCount; i++) {
            System.out.println("Ticket #" + i + ": " + tickets[i].description + " | Urgency: " + tickets[i].urgency + " | Status: " + tickets[i].status);
        }
    }

    private static void generateReport() {
        int totalTickets = ticketCount;
        int pendingCount = 0;
        int resolvedCount = 0;

        for (int i = 0; i < ticketCount; i++) {
            if (tickets[i].status.equals("Pending")) pendingCount++;
            if (tickets[i].status.equals("Resolved")) resolvedCount++;
        }

        System.out.println("Ticket Report:");
        System.out.println("Total Tickets: " + totalTickets);
        System.out.println("Pending Tickets: " + pendingCount);
        System.out.println("Resolved Tickets: " + resolvedCount);
    }
}