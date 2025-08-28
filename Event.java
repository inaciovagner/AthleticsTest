import java.util.ArrayList;
import java.util.Arrays;

public abstract class Event 
{
    private String eventName;    
    private ArrayList<String> competitorNames;
    private ArrayList<Competitor> results;

    public Event(String anEventName) {
        eventName = anEventName;        
        competitorNames = new ArrayList<>();
        results = new ArrayList<>();
        
        populate();
        setUpResults();
        
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public ArrayList<String> getCompetitorNames() {
        return competitorNames;
    }

    public void setCompetitorNames(ArrayList<String> competitorNames) {
        this.competitorNames = competitorNames;
    }

    public ArrayList<Competitor> getResults() {
        return results;
    }

    public void populate() {
        competitorNames.clear();
        competitorNames.addAll(Arrays.asList(
            "James", "Olivia", "Daniel", "Sophia", "David",
            "Mia", "Henry", "Isabella", "Jack", "Lily"
        ));
    }

    public void setUpResults() {
        results.clear();
        for (String name : competitorNames) {
            results.add(new Competitor(name));
        }
    }

    public void recordResult(Competitor competitor, double score) {
        competitor.setScore(score);
    }

    @Override
    public String toString() {
        return String.format("Event name: %s\nNumber of competitors: %d", eventName, results.size());
    }

    public void displayResults() {
        System.out.println(this.toString());
    }

    

    public ArrayList<Competitor> getCompetitors() {
        return results;
    }

    // Abstract method, must be implemented by subclasses
    public abstract void simulateRound();
}


