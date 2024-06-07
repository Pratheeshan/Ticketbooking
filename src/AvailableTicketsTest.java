import org.junit.jupiter.api.Test;

import static org.junit.Assert.fail;

class AvailableTicketsTest {
	

	@Test
	void printAvailableTickets() {
		try {
			AvailableTickets availableTickets = new AvailableTickets();
			availableTickets.printAvailable(1, 2, 4, 0, 0);
			System.out.println("available tickets printed"); // Print message if bookTicket executes successfully
		} catch (Exception e) {
			System.out.println("bookTicket method failed: " + e.getMessage()); // Print error message if bookTicket
																				// fails
			fail("bookTicket method failed"); // Fail the test if bookTicket fails
		}
		
	}

}
