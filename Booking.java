import java.util.Objects;
/**
 * Represents a booking to a goalkeeper for a specific match.
 * Tracks match date, goalkeeper ID, and booking status.
 * @author Vagner de Souza
 * @version 1.1
 */
public class Booking {
    private int bookingId;
    private int goalkeeperId;
    private String matchDate;
    private String status;

    // Constructor
    public Booking(int bookingId, int goalkeeperId, String matchDate, String status) {
        this.bookingId = bookingId;
        this.goalkeeperId = goalkeeperId;
        this.matchDate = matchDate;
        this.status = status;
    }

    // Getter Methods
    public int getBookingId() {
        return bookingId;
    }

    public int getGoalkeeperId() {
        return goalkeeperId;
    }

    public String getMatchDate() {
        return matchDate;
    }

    public String getStatus() {
        return status;
    }

    // Setter Method for Status
    public void setStatus(String status) {
        this.status = status;
    }

    // Display Method
    public void display() {
        System.out.println("Booking ID: " + bookingId + ", Goalkeeper ID: " + goalkeeperId +
                           ", Match Date: " + matchDate + ", Status: " + status);
    }

    // Equals Method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Booking booking = (Booking) obj;
        return bookingId == booking.bookingId && goalkeeperId == booking.goalkeeperId;
    }

    // HashCode Method
    @Override
    public int hashCode() {
        return Objects.hash(bookingId, goalkeeperId);
    }

    // CompareTo Method for Sorting
    public int compareTo(Booking other) {
        return this.matchDate.compareTo(other.matchDate);
    }
}
