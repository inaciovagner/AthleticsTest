import java.util.ArrayList;
import java.util.Random;

/**
 * Represents a field event, extending Event.
 *
 * @author Vagner de Souza
 * @version 1.0
 */
public class FieldEvent extends Event {
    public static final int TRIES = 3; // Added the required constant

    /**
     * Constructor for FieldEvent
     * @param name The event name
     */
    public FieldEvent(String name) {
        super(name);
    }

    /**
     * Displays field event results in a formatted way.
     */
    @Override
    public void displayResults() {
        System.out.println("=== Field Event Results ===");
        super.displayResults();
    }

    /**
     * Simulates a round of the field event.
     * Assigns random scores (distances) to competitors and updates their scores.
     */
    @Override
    public void simulateRound() {
        Random random = new Random();
        ArrayList<Competitor> competitors = getResults(); // Use ArrayList directly

        System.out.println("Simulating a round for field event: " + getEventName());

        for (Competitor competitor : competitors) {
            double bestScore = 0.0; // Initialise the best score to 0.0 for each competitor

            // Give each competitor 3 tries to produce their best score
            for (int i = 0; i < TRIES; i++) {
                double randomDistance = random.nextDouble() * 50.0; // Random score between 0.0 and 50.0
                if (randomDistance > bestScore) {
                    bestScore = randomDistance; // Update the best score if the current try is better
                }
            }

            // Only update thompetitor's score if the new best score is higher
            if (bestScore > competitor.getScore()) {
                competitor.setScore(bestScore);
            }

            // Output the best score achieved by the competitor in this round
            System.out.println(competitor.getName() + "'s best distance: " + String.format("%.2f", bestScore) + " meters.");
        }

        // Sort the competitors in reverse order based on their scores
        competitors.sort((c1, c2) -> Double.compare(c2.getScore(), c1.getScore()));

        // Output sorted results
        System.out.println("Sorted Results: ");
        for (Competitor competitor : competitors) {
            System.out.println(competitor.getName() + ": " + String.format("%.2f", competitor.getScore()) + " meters");
        }
    }
}
