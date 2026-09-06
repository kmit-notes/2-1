public class Booking {
    // bookingId,customerName,destination,packageCategory,transportType,travelCost,season,feedback
    String customerName;
    int bookingId;
    String destination;
    String packageCategory;
    String transportType;
    double travelCost;
    String season;
    String feedback;
    String category;

    public Booking(int bookingId, String customerName, String destination, String packageCategory, String transportType,
            double travelCost, String season, String feedback, String category) {
        this.customerName = customerName;
        this.bookingId = bookingId;
        this.transportType = transportType;
        this.packageCategory = packageCategory;
        this.destination = destination;
        this.travelCost = travelCost;
        this.season = season;
        this.feedback = feedback;
        this.category = category;
    }

    public String toString() {
        return "Booking ID: " + bookingId + ", Customer Name: " + customerName + ", Destination: " + destination
                + ", Package Category: " + packageCategory + ", Transport Type: " + transportType + ", Travel Cost: "
                + travelCost + ", Season: " + season + ", Feedback: " + feedback + ", Category: " + category;
    }

    public boolean equals(Object b) {
        if (b instanceof Booking) {
            Booking booking = (Booking) b;
            if (booking.bookingId == this.bookingId) {
                return true;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return bookingId;
    }

}
    

