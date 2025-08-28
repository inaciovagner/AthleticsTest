import java.util.List;
import java.util.Random;
import java.util.Comparator;

/**
 * Represents a track event, extending Event.
 * 
 * @author Vagner de Souza
 * @version 1.0
 */
public class TrackEvent extends Event {

    /**
     * Constructor for TrackEvent.
     * @param name The event name.
     */
    public TrackEvent(String name) {
        super(name);
    }

    /**
     * Displays track event results in a formatted way.
     */
    @Override
    public void displayResults() {
        System.out.println("=== Track Event Results ===");
        super.displayResults();
   
    
            // Display each competitor's results with 2 decimal places
        List<Competitor> competitors = getCompetitors(); // Ensure this method exists in the parent class
        for (Competitor competitor : competitors) {
            System.out.printf("%-20s %.2f metres\n", competitor.getName(), competitor.getScore());
        }
    }
    

    /**
     * Simulates a round of the track event.
     * Assigns random times to competitors and updates their scores.
     * Then sorts the competitors by their scores in increasing order.
     */
    @Override
    public void simulateRound() {
        Random random = new Random();
        List<Competitor> competitors = getCompetitors(); // Ensure this method exists in the parent class

        System.out.println("Simulating a round for track event: " + getEventName());

        for (Competitor competitor : competitors) {
            // Assigning random scores (times) between 10.0 and 25.0 (excluding 25.0)
            double randomTime = 10.0 + (25.0 - 10.0) * random.nextDouble();
            competitor.setScore(randomTime); // Ensure Competitor has a setScore method
            System.out.println(competitor.getName() + " finished in " + String.format("%.2f", randomTime) + " seconds.");
        }

        // Sorting competitors by score in increasing order
        competitors.sort(Comparator.comparingDouble(Competitor::getScore));
        
        System.out.println("Results sorted in increasing order of scores.");
        
    }
}



