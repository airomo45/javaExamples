/**
 * Implements a single Ticket for any event.
 * 
 * @author Brahma Dathan
 *
 */
public class Ticket {
	private int serialNumber;
	private double price;
	private static int counter = 1;
	private Event event;
	private static double PRICE = 10.0;

	/**
	 * Creates a ticket for an event. An exception is thrown if there is no
	 * space.
	 * 
	 * @param event
	 *            the event for which the tickt is being created.
	 * @throws NoSpaceException
	 */
	public Ticket(Event event) throws NoSpaceException {
		if (event.addTicket(this)) {
			this.event = event;
		} else {
			throw new NoSpaceException("no space");
		}
		price = PRICE * event.getPriceFactor();
		serialNumber = computeSerialNumber();
	}

	/**
	 * Returns the price of the ticket
	 * 
	 * @return ticket price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Generates a String representation of the Ticket.
	 */
	@Override
	public String toString() {
		return "Ticket serialNumber= " + serialNumber + ", price = " + price;
	}

	/*
	 * Creates a serial number for the ticket.
	 */
	private static int computeSerialNumber() {
		return counter++;
	}
}
