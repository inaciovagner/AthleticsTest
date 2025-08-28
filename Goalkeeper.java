import java.util.Objects;

/**
 * Represents a semi-professional goalkeeper available for hire.
 * Stores basic details like name, availability, and hire rate.
 * @author Vagner de Souza
 * @Version 1.1
 */
public class Goalkeeper implements Comparable<Goalkeeper> {
    private int id;
    private String name;
    private String availability;
    private double hireRate;

    // Constructor
    public Goalkeeper(int id, String name, String availability, double hireRate) {
        this.id = id;
        this.name = name;
        this.availability = availability;
        this.hireRate = hireRate;
    }

    // Getter and Setter Methods
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAvailability() {
        return availability;
    }

    public double getHireRate() {
        return hireRate;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    // toString Method
    @Override
    public String toString() {
        return "Goalkeeper ID: " + id + ", Name: " + name +
               ", Availability: " + availability + ", Hire Rate: £" + hireRate;
    }

    // Equals Method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Goalkeeper)) return false;
        Goalkeeper g = (Goalkeeper) obj;
        return this.id == g.id && this.name.equalsIgnoreCase(g.name);
    }

    // HashCode Method
    @Override
    public int hashCode() {
        return Objects.hash(id, name.toLowerCase());
    }

    // compareTo Method for Sorting
    @Override
    public int compareTo(Goalkeeper other) {
        return this.name.compareToIgnoreCase(other.name);
    }
}
