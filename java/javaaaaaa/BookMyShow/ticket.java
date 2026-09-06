import java.time.*;
import java.util.*;

// ---------------- Event Class ----------------
class Event {
    String name;
    String type; // movie, comedy, tour, workshop
    String venue;
    LocalDate date;
    String slot; // morning/evening/night
    double rating;
    int ratingCount;
    int ticketsAvailable;
    int ticketPrice;

    public Event(String name, String type, String venue, LocalDate date, String slot, int ticketsAvailable, int ticketPrice) {
        this.name = name;
        this.type = type;
        this.venue = venue;
        this.date = date;
        this.slot = slot;
        this.ticketsAvailable = ticketsAvailable;
        this.ticketPrice = ticketPrice;
        this.rating = 0;
        this.ratingCount = 0;
    }

    public boolean bookTickets(int n) {
        if (ticketsAvailable >= n) {
            ticketsAvailable -= n;
            return true;
        } else {
            return false;
        }
    }

    public void rateEvent(double r) {
        rating = (rating * ratingCount + r) / (++ratingCount);
    }
}

// ---------------- User Class ----------------
class User {
    String name;
    Event[] bookedEvents;
    int[] ticketsBooked;
    int eventCount;
    static final int MAX_EVENTS = 10;

    public User(String name) {
        this.name = name;
        bookedEvents = new Event[MAX_EVENTS];
        ticketsBooked = new int[MAX_EVENTS];
        eventCount = 0;
    }

    public void bookEvent(Event e, int n, Admin admin) {
        if (e.bookTickets(n)) {
            if (eventCount < MAX_EVENTS) {
                bookedEvents[eventCount] = e;
                ticketsBooked[eventCount] = n;
                eventCount++;
                int totalCost = n * e.ticketPrice;
                System.out.println(name + " booked " + n + " tickets for " + e.name + ". Total cost: ₹" + totalCost);
                admin.updateSales(n);
            } else {
                System.out.println(name + " cannot book more events.");
            }
        } else {
            System.out.println("Sorry " + name + ", not enough tickets available for " + e.name);
        }
    }

    public void rateEvent(Event e, double r) {
        e.rateEvent(r);
        System.out.println(name + " rated " + e.name + " with " + r + " stars. Current rating: " + e.rating);
    }
}

// ---------------- Admin Class ----------------
class Admin {
    int totalTicketsSold;

    public Admin() {
        totalTicketsSold = 0;
    }

    public void updateSales(int n) {
        totalTicketsSold += n;
    }

    public void showWeeklySales() {
        System.out.println("Total tickets sold this week: " + totalTicketsSold);
    }
}

// ---------------- Main Class ----------------
public class BookMyShowApp {
    public static void main(String[] args) {
        Admin admin = new Admin();

        Event movie1 = new Event("Avengers", "Movie", "PVR", LocalDate.now(), "Evening", 2, 300);
        Event comedy1 = new Event("Laugh Riot", "Comedy", "City Hall", LocalDate.now().plusDays(3), "Night", 50, 200);

        User rama = new User("Rama");
        User shanta = new User("Shanta");
        User priya = new User("Priya");

        // Rama books 2 movie tickets
        rama.bookEvent(movie1, 2, admin);

        // Shanta tries to book 2 tickets but none left
        shanta.bookEvent(movie1, 2, admin);

        // Priya wants 10 comedy tickets, she gets them individually
        for (int i = 0; i < 10; i++) {
            priya.bookEvent(comedy1, 1, admin);
        }

        // Rama rates the movie
        rama.rateEvent(movie1, 5);

        // Admin checks weekly sales
        admin.showWeeklySales();
    }
}