/**
 * Write a description of class AtheticsTest here.
 *
 * @author Vagner de Souza
 * @version 1.0
 */
public class AthleticsTest {
    public static void main(String[] args) {
        // Create a track event
        TrackEvent sprint100m = new TrackEvent("100m Sprint");
        sprint100m.recordResult(sprint100m.getResults().get(0), 9.85);
        sprint100m.recordResult(sprint100m.getResults().get(1), 10.02);
        sprint100m.displayResults();

        // Create a field event
        FieldEvent longJump = new FieldEvent("Long Jump");
        longJump.recordResult(longJump.getResults().get(0), 7.8);
        longJump.recordResult(longJump.getResults().get(1), 8.1);
        longJump.displayResults();
    }
}

