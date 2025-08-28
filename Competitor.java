
/**
 * Write a description of class Competitor here.
 *
 * @author Vagner de Souza  
 * @version V1
 */
public class Competitor {
    private String name;

    public Competitor(String name) {
        this.name = name;
    }

    // Equals method that compares objects based on their class type and name
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        // Check if the object is an instance of Competitor
        if (obj == null || getClass() != obj.getClass()) {
            return false;  // Return false if the objects are of different classes
        }

        // Cast the object to Competitor and compare names
        Competitor competitor = (Competitor) obj;
        return name.equals(competitor.name);  // Compare names
    }

    public String getName() {
        return name;
    }
}