import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookedTicketsTest {
	private static Passenger passenger1;
	private static Passenger passenger2;
	private static Passenger passenger3;

	@BeforeEach
	void setUp() {
		// Initialize the passenger object
		passenger1 = new Passenger("Santhanam", 25, ClassPreference.FIRST);
		passenger2 = new Passenger("Amar", 25, ClassPreference.SECOND);
		passenger3 = new Passenger("Vikram", 25, ClassPreference.THIRD);

		// Initialize the static state for TicketBooker
		TicketBooker.available1stClass = 1;
		TicketBooker.FirstClassPossitions.clear();
		TicketBooker.FirstClassPossitions.add(1);

		// Initialize the static state for TicketBooker
		TicketBooker.available2ndClass = 1;
		TicketBooker.SecondClassPositions.clear();
		TicketBooker.SecondClassPositions.add(1);

		// Initialize the static state for TicketBooker
		TicketBooker.available3rdClass = 1;
		TicketBooker.ThirdClassPositions.clear();
		TicketBooker.ThirdClassPositions.add(1);

		TicketBooker.passengers.clear();
		TicketBooker.bookedTicketList.clear();
	}

	@Test
	void test() {
		Map<Integer, Passenger> passengers = new HashMap<>();
		passengers.put(1, passenger1);
		passengers.put(2, passenger2);
		passengers.put(3, passenger3);

		// Check if the passengers are correctly added to the map
		assertEquals(3, passengers.size());
		assertEquals("Santhanam", passengers.get(1).name);
		assertEquals("Amar", passengers.get(2).name);
		assertEquals("Vikram", passengers.get(3).name);
		
		BookedTickets bookedTickets = new BookedTickets();
		bookedTickets.printPassengers(passengers);
	}

}
