/**
 * This is part of a test class used to demonstrate the functionality of the FindAGoalie system,
 * including booking, payment, display, and CSV file export features.
 * 
 * @author Vagner de Souza
 * @version 1.0
 */

public class TestFindAGoalie {
    public static void main(String[] args) {
        FindAGoalie system = new FindAGoalie();

        // Populate goalkeepers
        system.populate();

        // Book a few goalkeepers
        system.bookGoalkeeper(1001, 1, "20-04-2025", "Confirmed");
        system.bookGoalkeeper(1002, 2, "21-04-2025", "Pending");

        // Make payments
        system.makePayment(2001, 1001, 50.0, "18-04-2025");
        system.makePayment(2002, 1002, 60.0, "19-04-2025");

        // Display all goalkeepers
        System.out.println("\n=== Goalkeepers ===");
        system.displayMap(system.getGoalkeeperMap());

        // Display all bookings
        System.out.println("\n=== Bookings ===");
        system.displayBookings();

        // Display all payments
        System.out.println("\n=== Payments ===");
        system.displayPayments();

        // Save to CSV
        boolean success = system.writeCSVFile("Goalkeepers.csv", system.getGoalkeeperMap());

        if (success) {
            System.out.println("\nCSV export was successful.");
        } else {
            System.out.println("\nCSV export failed.");
        }
    }
}
