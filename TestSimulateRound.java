import java.util.*;

class Competitor implements Comparable<Competitor> {
    private String name;
    private double score;

    public Competitor(String name) {
        this.name = name;
        this.score = 0.0; // Default score
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Competitor other) {
        return Double.compare(this.score, other.score);
    }

    @Override
    public String toString() {
        return String.format("Competitor: %s, Score: %.2f", name, score);
    }
}

class TrackEvent {
    private String eventName;
    protected List<Competitor> results;

    public TrackEvent(String eventName) {
        this.eventName = eventName;
        this.results = new ArrayList<>();
    }

    public void addCompetitor(Competitor competitor) {
        results.add(competitor);
    }

    public void simulateRound() {
        Random rand = new Random();
        for (Competitor competitor : results) {
            double score = 10.0 + (rand.nextDouble() * (25.0 - 10.0)); // Random score between 10.0 and 25.0
            competitor.setScore(score);
        }
        results.sort(Comparator.naturalOrder()); // Sort using Comparable
    }

    public void displayResults() {
        System.out.println("Event: " + eventName);
        for (Competitor c : results) {
            System.out.println(c);
        }
    }
}

public class TestSimulateRound {
    public static void main(String[] args) {
        TrackEvent event = new TrackEvent("100m Sprint");
        event.addCompetitor(new Competitor("Ali"));
        event.addCompetitor(new Competitor("Lily"));
        event.addCompetitor(new Competitor("Leo"));

        System.out.println("Before Simulation:");
        event.displayResults();

        event.simulateRound();

        System.out.println("\nAfter Simulation:");
        event.displayResults();
    }
}