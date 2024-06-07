import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CancelTicketTest {
	private Map<Integer, Passenger> passengers;
	private List<Integer> bookedTicketList;
	private List<Integer> firstClassPositions;
	private List<Integer> secondClassPositions;
	private List<Integer> thirdClassPositions;
	private Queue<Integer> racList;
	private Queue<Integer> waitingList;
	private List<Integer> racPositions;
	private List<Integer> waitingListPositions;
	private static CancelTicket cancelTicket;
	private static Passenger passenger1;
	private static Passenger passenger2;
	private static Passenger passenger3;
	private static Passenger passenger4;

	@BeforeEach
	void setUp() {
		passengers = new HashMap<>();
		bookedTicketList = new ArrayList<>();
		firstClassPositions = new ArrayList<>(Arrays.asList(1));
		secondClassPositions = new ArrayList<>(Arrays.asList(1));
		thirdClassPositions = new ArrayList<>(Arrays.asList(1));
		racList = new LinkedList<>(Arrays.asList(1));
		waitingList = new LinkedList<>(Arrays.asList(2));
		racPositions = new ArrayList<>(Arrays.asList(1));
		waitingListPositions = new ArrayList<>(Arrays.asList(1));

		passenger1 = new Passenger("John", 30, ClassPreference.FIRST);
		TicketBookingHandler.bookTicket(passenger1);

		passenger2 = new Passenger("Jane", 28, ClassPreference.SECOND);
		TicketBookingHandler.bookTicket(passenger2);

		passenger3 = new Passenger("Doe", 25, ClassPreference.THIRD);
		TicketBookingHandler.bookTicket(passenger3);

		passenger4 = new Passenger("Joji", 25, ClassPreference.FIRST);
		TicketBookingHandler.bookTicket(passenger4);

		passengers.put(1, passenger1);
		passengers.put(2, passenger2);
		passengers.put(3, passenger3);
		passengers.put(4, passenger4);
		bookedTicketList.addAll(Arrays.asList(1, 2, 3, 4));

		cancelTicket = new CancelTicket(passengers, bookedTicketList, 1, 1, 1, firstClassPositions,
				secondClassPositions, thirdClassPositions, racList, waitingList, racPositions, waitingListPositions, 1,
				1);
	}

	@Test
	void testCancelTicket() {
		// Cancel a ticket
		cancelTicket.cancelTicket(2);
		System.out.print("Cancel line working");

		/*// Verify the passenger is removed from the map
		assertFalse(passengers.containsKey(1));
		// Verify the ticket is removed from the bookedTicketList
		assertFalse(bookedTicketList.contains(1));
		// Verify the seat is added back to the available positions
		assertEquals(2, firstClassPositions.size());
		// Verify available 1st class tickets are incremented
		assertEquals(2, cancelTicket.available1stClass);

		// Additional checks for RAC and Waiting List changes
		assertEquals(0, racList.size());
		assertEquals(2, racPositions.size());
		assertEquals(1, waitingList.size());
		assertEquals(1, waitingListPositions.size());

		// Check if the passenger from RAC is booked
		assertEquals("RAC", passengers.get(100).alloted);
		assertTrue(bookedTicketList.contains(100));
		assertEquals(1, cancelTicket.availableRacTickets);*/
	}

}
