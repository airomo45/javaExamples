public class Meeting extends Event {
    private double fee;

    /**
     * Creates a meeting with a given description and fee
     * 
     * @param description
     *            meeting description
     * @param fee
     *            the fee charged
     */
    // TODO CREATE CONSTRUCTOR

    /**
     * To disable the price factor
     */
    @Override
    public void setPriceFactor(double priceFactor) {
        throw new UnsupportedOperationException("Pricefactor not supported");
    }

    @Override
    public double getProceeds() {
        // TODO
    }

    /**
     * Not supported. Throws UnsupportedOperationException.
     * 
     * @return nothing
     */
    public double getPriceFactor() {
        // TODO
    }

    /**
     * Not supported. Throws UnsupportedOperationException.
     * 
     * @param ticket
     *            the Ticket object to be added
     * @return true iff the Ticket object could be added.
     */
    @Override
    public boolean addTicket(Ticket ticket) throws UnsupportedOperationException {
        // TODO
    }

    /**
     * Get tickets is not supported. Throws UnsupportedOperationException.
     */
    @Override
    public Ticket[] getTickets() {
        // TODO
    }

    /**
     * Returns the fee
     * 
     * @return the fee
     */
    public double getFee() {
        return fee;
    }

    /**
     * Returns a String representation of this Event object
     */
    @Override
    public String toString() {
        return "Meeting " + super.toString();
    }

}
