import java.io.*;
import java.util.*;
/**
 * This class provides functionality to manage a system for hiring goalkeepers,
 * recording bookings and payments. It supports loading/saving data to files
 * and exporting data to a CSV file.
 * 
 * This class addresses various parts of TMA03 Question 3.
 * 
 * @author Vagner de Souza
 * @version 1.0
 */
/**
 * Manages goalkeepers, bookings, and payments.
 */
public class FindAGoalie {
    private Map<Integer, Goalkeeper> goalkeeperMap = new HashMap<>();
    private List<Booking> bookingList = new ArrayList<>();
    private List<Payment> paymentList = new ArrayList<>();
    private final double DEFAULT_HIRE_RATE = 50.0;

    // Constructor
    public FindAGoalie() {
        // Load data from files during initialisation
        loadGoalkeepers();
        loadBookings();
        loadPayments();
    }

    // (b)(i) Add a new Goalkeeper
    public boolean addGoalkeeper(int id, String name, String availability, double hireRate) {
        if (goalkeeperMap.containsKey(id)) {
            System.out.println("Goalkeeper with this ID already exists.");
            return false;  // Error: Goalkeeper already exists
        }
        Goalkeeper gk = new Goalkeeper(id, name, availability, hireRate);
        goalkeeperMap.put(id, gk);
        System.out.println("Goalkeeper added: " + name);
        return true;  // Success
    }

    // (b)(ii) Clear all entries from the Map
    public void clear() {
        goalkeeperMap.clear();
        System.out.println("All goalkeepers have been removed.");
    }

    // (b)(iii) Populate the Map with test data
    public void populate() {
        clear();  // Clears the map first
        addGoalkeeper(1, "Felipe Dom", "Available", 50.0);
        addGoalkeeper(2, "Janene Smith", "Unavailable", 60.0);
        addGoalkeeper(3, "Jeff Brown", "Available", 55.0);
        System.out.println("Map populated with test data.");
    }

    // (b)(iv) Remove a Goalkeeper from the Map
    public boolean removeGoalkeeper(int id) {
        if (goalkeeperMap.containsKey(id)) {
            goalkeeperMap.remove(id);
            System.out.println("Goalkeeper with ID " + id + " removed.");
            return true;  // Success
        } else {
            System.out.println("Goalkeeper not found.");
            return false;  // Error: Goalkeeper not found
        }
    }

    // (b)(v) Update a Goalkeeper's Field (e.g. Availability)
    public boolean updateGoalkeeperAvailability(int id, String newAvailability) {
        Goalkeeper gk = goalkeeperMap.get(id);
        if (gk != null) {
            gk.setAvailability(newAvailability);
            System.out.println("Goalkeeper availability updated.");
            return true;  // Success
        } else {
            System.out.println("Goalkeeper not found.");
            return false;  // Error: Goalkeeper not found
        }
    }

    // (b)(vi) Get Goalkeepers by Availability
    public List<Goalkeeper> getGoalkeepersByAvailability(String availability) {
        List<Goalkeeper> availableGoalkeepers = new ArrayList<>();
        for (Goalkeeper gk : goalkeeperMap.values()) {
            if (gk.getAvailability().equalsIgnoreCase(availability)) {
                availableGoalkeepers.add(gk);
            }
        }
        return availableGoalkeepers;
    }

    // (b)(vii) Total Hire Rate
    public double getTotalHireRate() {
        double totalHireRate = 0.0;
        for (Goalkeeper gk : goalkeeperMap.values()) {
            totalHireRate += gk.getHireRate();
        }
        return totalHireRate;
    }

    // (b)(viii) Display Map of Goalkeepers
    public void displayMap(Map<Integer, Goalkeeper> map) {
        if (map.isEmpty()) {
            System.out.println("The map is empty.");
            return;
        }
        for (Map.Entry<Integer, Goalkeeper> entry : map.entrySet()) {
            System.out.println("ID: " + entry.getKey() + " - " + entry.getValue());
        }
    }

    // Add a new booking
    public boolean bookGoalkeeper(int bookingId, int goalkeeperId, String matchDate, String status) {
        if (!goalkeeperMap.containsKey(goalkeeperId)) {
            System.out.println("Goalkeeper not found.");
            return false;  // Error: Goalkeeper does not exist
        }
        Booking b = new Booking(bookingId, goalkeeperId, matchDate, status);
        bookingList.add(b);
        System.out.println("Booking created for goalkeeper ID: " + goalkeeperId);
        return true;  // Success
    }

    // Display all bookings
    public void displayBookings() {
        if (bookingList.isEmpty()) {
            System.out.println("No bookings to display.");
            return;
        }
        for (Booking b : bookingList) {
            b.display();
        }
    }

    // Make a payment for a booking
    public boolean makePayment(int paymentId, int bookingId, double amount, String date) {
        boolean bookingExists = false;
        for (Booking b : bookingList) {
            if (b.getBookingId() == bookingId) {
                bookingExists = true;
                break;
            }
        }
        if (!bookingExists) {
            System.out.println("Booking not found.");
            return false;  // Error: Booking does not exist
        }
        Payment p = new Payment(paymentId, bookingId, amount, date);
        paymentList.add(p);
        System.out.println("Payment recorded.");
        return true;  // Success
    }

    // Display all payments
    public void displayPayments() {
        if (paymentList.isEmpty()) {
            System.out.println("No payments to display.");
            return;
        }
        for (Payment p : paymentList) {
            p.display();
        }
    }

    // Load goalkeepers from file
    private void loadGoalkeepers() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("goalkeepers.dat"))) {
            goalkeeperMap = (Map<Integer, Goalkeeper>) ois.readObject();
            System.out.println("Goalkeepers loaded from file.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No goalkeepers file found, starting with an empty list.");
        }
    }

    // Save goalkeepers to file
    public void saveGoalkeepers() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("goalkeepers.dat"))) {
            oos.writeObject(goalkeeperMap);
            System.out.println("Goalkeepers saved to file.");
        } catch (IOException e) {
            System.out.println("Error saving goalkeepers.");
        }
    }

    // Load bookings from file
    private void loadBookings() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("bookings.dat"))) {
            bookingList = (List<Booking>) ois.readObject();
            System.out.println("Bookings loaded from file.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No bookings file found, starting with an empty list.");
        }
    }

    // Save bookings to file
    public void saveBookings() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("bookings.dat"))) {
            oos.writeObject(bookingList);
            System.out.println("Bookings saved to file.");
        } catch (IOException e) {
            System.out.println("Error saving bookings.");
        }
    }

    // Load payments from file
    private void loadPayments() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("payments.dat"))) {
            paymentList = (List<Payment>) ois.readObject();
            System.out.println("Payments loaded from file.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No payments file found, starting with an empty list.");
        }
    }

    // Save payments to file
    public void savePayments() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("payments.dat"))) {
            oos.writeObject(paymentList);
            System.out.println("Payments saved to file.");
        } catch (IOException e) {
            System.out.println("Error saving payments.");
        }
    }

    // Write goalkeepers to CSV file
public boolean writeCSVFile(String fileName, Map<Integer, Goalkeeper> goalkeeperMap) {
    // Sort the map by goalkeeper ID (ascending order)
    TreeMap<Integer, Goalkeeper> sortedMap = new TreeMap<>(goalkeeperMap);

    // Try-with-resources to automatically close the BufferedWriter
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
        // Write header line
        writer.write("ID,Name,Availability,HireRate");
        writer.newLine();  // Add a line break after the header

        // Write each goalkeeper's data to the CSV file
        for (Map.Entry<Integer, Goalkeeper> entry : sortedMap.entrySet()) {
            Goalkeeper gk = entry.getValue();
            String line = entry.getKey() + "," + gk.getName() + "," + gk.getAvailability() + "," + gk.getHireRate();
            writer.write(line);
            writer.newLine();  // Add a new line after each entry
        }
        System.out.println("File written successfully.");
        return true;  // Successfully wrote to the file
    } catch (IOException e) {
        System.out.println("Error writing to file: " + e.getMessage());
        return false;  // Error occurred during writing
    }
}


    // Getter methods for collections
    public Map<Integer, Goalkeeper> getGoalkeeperMap() {
        return goalkeeperMap;
    }

    public List<Booking> getBookingList() {
        return bookingList;
    }

    public List<Payment> getPaymentList() {
        return paymentList;
    }
}
