import java.util.Arrays;

/**
 * Collection of all events
 * 
 * @author Brahma Dathan
 *
 */
public class Events {
    private Event[] events = new Event[10];
    private int numberOfEvents;

    /**
     * Adds an event to the list of events.
     * 
     * @param event
     *            the new event
     */
    public void add(Event event) {
        events[numberOfEvents++] = event;
    }

    /**
     * Getter for the events
     * 
     * @return getter
     */
    public Event[] getEvents() {
        return Arrays.copyOf(events, numberOfEvents);
    }

    /**
     * Computes and returns the total number of tickets sold for the events.
     * 
     * @return number of tickets sold
     */
    public double getTotalProceeds() {
        double proceeds = 0;
        return proceeds;
    }

    /**
     * Generates a String representation of the object
     */
    @Override
    public String toString() {
        return "Events events=" + events;
    }
}
