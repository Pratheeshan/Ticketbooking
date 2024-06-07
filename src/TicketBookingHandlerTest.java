import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TicketBookingHandlerTest {

	@BeforeEach
	void setUp() {
		TicketBooker.available1stClass = 5;
		TicketBooker.available2ndClass = 5;
		TicketBooker.available3rdClass = 5;
		TicketBooker.availableRacTickets = 5;
		TicketBooker.availableWaitingList = 1; // Set available waiting list to 1
	}

	@Test
	public void bookTicketTest() {
		TicketBookingHandler main = new TicketBookingHandler();
		Passenger passenger = new Passenger("Kumar", 25, ClassPreference.FIRST);
		try {
			TicketBookingHandler.bookTicket(passenger);
			System.out.println("bookTicket method working"); // Print message if bookTicket executes successfully
		} catch (Exception e) {
			System.out.println("bookTicket method failed: " + e.getMessage()); // Print error message if bookTicket
																				// fails
			fail("bookTicket method failed"); // Fail the test if bookTicket fails
		}
	}
	
}
