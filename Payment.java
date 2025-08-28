import java.util.Objects;
/**
 * Represents a payment made to a goalkeeper booking.
 * Stores payment amount, associated booking, and date.
 * @author Vagner de Souza
 * @version 1.1
 */
public class Payment {
    private int paymentId;
    private int bookingId;
    private double amountPaid;
    private String paymentDate;

    // Constructor
    public Payment(int paymentId, int bookingId, double amountPaid, String paymentDate) {
        this.paymentId = paymentId;
        this.bookingId = bookingId;
        this.amountPaid = amountPaid;
        this.paymentDate = paymentDate;
    }

    // Getter Methods
    public int getPaymentId() {
        return paymentId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    // Setter Method for AmountPaid
    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    // Display Method
    public void display() {
        System.out.println("Payment ID: " + paymentId + ", Booking ID: " + bookingId +
                           ", Amount Paid: £" + amountPaid + ", Payment Date: " + paymentDate);
    }

    // Equals Method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Payment payment = (Payment) obj;
        return paymentId == payment.paymentId && bookingId == payment.bookingId;
    }

    // HashCode Method
    @Override
    public int hashCode() {
        return Objects.hash(paymentId, bookingId);
    }

    // CompareTo Method for Sorting
    public int compareTo(Payment other) {
        return this.paymentDate.compareTo(other.paymentDate);
    }
}