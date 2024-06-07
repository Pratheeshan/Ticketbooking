import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TicketCancellationHandlerTest {
	private static Passenger passenger;

	@BeforeAll
    static void setUp() {
        // Initialize the passenger object
        passenger = new Passenger("Kumar", 25, ClassPreference.FIRST);
        
        // Initialize the static state for TicketBooker
        TicketBooker.available1stClass = 1;
        TicketBooker.FirstClassPossitions.clear();
        TicketBooker.FirstClassPossitions.add(1);
        TicketBooker.passengers.clear();
        TicketBooker.bookedTicketList.clear();
    }
	

	@BeforeEach
	void bookticket() {
		try {
			
			TicketBookingHandler.bookTicket(passenger);
			System.out.println("Ticket booked successfully"); // Print message if bookTicket executes successfully
		} catch (Exception e) {
			System.out.println("bookTicket method failed: " + e.getMessage()); // Print error message if bookTicket
																				// fails
			fail("bookTicket method failed");
		}
	}
	@Test
	void cancelTicketHandlerTest() {
		try {
			
			TicketCancellationHandler.cancelTicket(passenger.passengerId);
			System.out.println("Ticket cancel method working");
			// Print message if Ticket cancel executes successfully
			assertFalse(TicketBooker.passengers.containsKey(passenger.passengerId));
            // Verify that the bookedTicketList no longer contains the passenger
            assertFalse(TicketBooker.bookedTicketList.contains(passenger.passengerId));
		} catch (Exception e) {
			System.out.println("Ticket cancel method failed: " + e.getMessage()); // Print error message if Ticket cancel
																				// fails
			fail("bookTicket method failed");
		}
	}
	

}
