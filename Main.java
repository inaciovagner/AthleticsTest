import java.util.ArrayList;
import java.util.List;

// Competitor class (for testing)
class Competitor {
    private String name;
    private double score;

    public Competitor(String name, double score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public double getScore() {
        return score;
    }
}

// Event superclass
class Event {
    private String eventName;
    private List<Competitor> competitors;

    public Event(String eventName) {
        this.eventName = eventName;
        this.competitors = new ArrayList<>();
    }

    public void addCompetitor(Competitor competitor) {
        competitors.add(competitor);
    }

    public List<Competitor> getCompetitors() {
        return competitors;
    }

    public void displayResults() {
        System.out.println("Event name: " + eventName);
        System.out.println("Number of competitors: " + competitors.size());
    }
}

// TrackEvent subclass (Overriding displayResults)
class TrackEvent extends Event {
    public TrackEvent(String eventName) {
        super(eventName);
    }

    @Override
    public void displayResults() {
        super.displayResults(); // Call superclass method
        
        // Print each competitor's name (20 characters wide) and score (2 decimal places)
        for (Competitor competitor : getCompetitors()) {
            System.out.printf("%-20s %.2f seconds\n", competitor.getName(), competitor.getScore());
        }
    }
}

// Main class for testing
public class Main {
    public static void main(String[] args) {
        // Create a TrackEvent
        TrackEvent race = new TrackEvent("100 metres");

        // Add 20 competitors with unique names and scores
        race.addCompetitor(new Competitor("Imogen Iguana", 16.35));
        race.addCompetitor(new Competitor("Hatty Horse", 16.71));
        race.addCompetitor(new Competitor("Jennifer Jackdaw", 18.12));
        race.addCompetitor(new Competitor("Tommy Tiger", 16.50));
        race.addCompetitor(new Competitor("Lily Leopard", 17.85));
        race.addCompetitor(new Competitor("Dip Daniel", 15.95));
        race.addCompetitor(new Competitor("Pool Party", 17.40));
        race.addCompetitor(new Competitor("Sotas Pepis", 17.00));
        race.addCompetitor(new Competitor("Randoan Clip", 16.90));
        race.addCompetitor(new Competitor("Chris Crecks", 18.00));
        race.addCompetitor(new Competitor("Fiona Tiles", 16.25));
        race.addCompetitor(new Competitor("Ghary Jiji ", 17.10));
        race.addCompetitor(new Competitor("Ella Prayer", 19.50));
        race.addCompetitor(new Competitor("Bobby Bear", 17.80));
        race.addCompetitor(new Competitor("Mag Ley", 18.20));
        race.addCompetitor(new Competitor("Nancy Lover", 16.60));
        race.addCompetitor(new Competitor("Penny Penguin", 17.15));
        race.addCompetitor(new Competitor("Jr Jackson", 18.35));
        race.addCompetitor(new Competitor("Paul James", 17.90));
        race.addCompetitor(new Competitor("Carles Puyol", 17.91));

        // Display the results
        race.displayResults();
    }
}
