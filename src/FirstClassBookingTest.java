import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FirstClassBookingTest {

    private Passenger passenger;
    private FirstClassBooking firstClassBooking;

    @BeforeEach
    void setUp() {
        passenger = new Passenger("Kumar", 25, ClassPreference.FIRST);
        firstClassBooking = new FirstClassBooking();
        
        // Initialize the static state for TicketBooker
        TicketBooker.available1stClass = 1;
        TicketBooker.FirstClassPossitions.clear();
        TicketBooker.FirstClassPossitions.add(1);
    }

    @Test
    void testBook() {
        // Call the book method
        firstClassBooking.book(passenger);

        // Verify the changes in TicketBooker static state
        assertEquals(0, TicketBooker.available1stClass, "Available 1st Class should be decremented");
        assertTrue(TicketBooker.FirstClassPossitions.isEmpty(), "FirstClassPossitions should be empty after booking");

        // Verify the console output (optional, but good for debugging)
        // Note: Normally, you don't test console output, but you can capture System.out for testing if needed.
    }
}