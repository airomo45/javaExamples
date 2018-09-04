import java.util.Arrays;

/**
 * Represents a single event. It stores a description of the play, a unique id,
 * and the tickets sold for the play.
 * 
 * @author Brahma Dathan
 *
 */
public class Event {
    private String description;
    public static final int CAPACITY = 5;
    protected int ticketsSold;
    private int eventId;
    private double priceFactor;
    private static int counter = 1;
    private Ticket[] tickets;

    /**
     * Stores the description and price factor and assigns a unique id to the
     * event. The constructor also allocates the array tickets.
     * 
     * @param description
     *            a description of this Play
     * @param priceFactor
     *            the price factor for this Play
     * 
     */
    public Event(String description, double priceFactor) {
        this.description = description;
        this.priceFactor = priceFactor;
        this.tickets = new Ticket[CAPACITY];
        this.eventId = computeSerialNumber();
    }

    /**
     * Receives the description and stores that and a price factor of 1.0.
     * Besides, it assigns a unique id to the event. The constructor also
     * allocates the array tickets.
     * 
     * @param description
     *            a description of this Play
     * 
     */
    public Event(String description) {
        this(description, 1.0);
    }

    /**
     * Returns the unique id of the play
     * 
     * @return id of the play
     * 
     */
    public int getEventId() {
        return eventId;
    }

    /**
     * Returns the tickets list
     * 
     * @return the tickets list
     */
    public Ticket[] getTickets() {
        return Arrays.copyOf(tickets, ticketsSold);
    }

    /**
     * Sets the price factor for the event.
     * 
     * @param priceFactor
     *            the new price factor
     */
    public void setPriceFactor(double priceFactor) {
        this.priceFactor = priceFactor;
    }

    /**
     * Computes and returns the total proceeds for thos event.
     * 
     * @return total proceeds
     */

    public double getProceeds() {
        double total = 0;
        for (int index = 0; index < ticketsSold; index++) {
            total = total + tickets[index].getPrice();
        }
        return total;
    }

    /**
     * Compares this Play with object. Follows the semantics of the equals
     * method in Object.
     * 
     */
    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (getClass() != object.getClass()) {
            return false;
        }
        Event other = (Event) object;
        if (eventId != other.eventId)
            return false;
        return true;
    }

    /**
     * Returns the description of the Play object
     * 
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the price factor
     * 
     * @return price factor
     */
    public double getPriceFactor() {
        return priceFactor;
    }

    /**
     * Setter for description
     * 
     * @param description
     *            the new description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns a unique serial number. This is a helper method.
     * 
     * @return serial number
     */
    private int computeSerialNumber() {
        return counter++;
    }

    /**
     * Adds a ticket to the list of tickets sold for this Play object.
     * 
     * @param ticket
     *            the Ticket object to be added
     * @return true iff the Ticket object could be added.
     */

    public boolean addTicket(Ticket ticket) {
        if (ticketsSold < CAPACITY) {
            tickets[ticketsSold] = ticket;
            ticketsSold++;
            return true;
        }
        return false;
    }

    /**
     * Returns a String representation of this Event object
     */
    @Override
    public String toString() {
        String string = eventId + " " + description + " " + priceFactor + " ";
        return string;
    }

}
