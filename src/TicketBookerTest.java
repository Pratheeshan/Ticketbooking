import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.jupiter.api.Test;

class TicketBookerTest {

	@Test
	void test() {
		 // Check the initial values of the static variables
		assertEquals(1, TicketBooker.available1stClass, "Initial available1stClass should be 1");
        assertEquals(1, TicketBooker.available2ndClass, "Initial available2ndClass should be 1");
        assertEquals(1, TicketBooker.available3rdClass, "Initial available3rdClass should be 1");
        assertEquals(1, TicketBooker.availableRacTickets, "Initial availableRacTickets should be 1");
        assertEquals(1, TicketBooker.availableWaitingList, "Initial availableWaitingList should be 1");

        // Check the initial state of the collections
        assertTrue(TicketBooker.waitingList.isEmpty(), "Initial waitingList should be empty");
        assertTrue(TicketBooker.racList.isEmpty(), "Initial racList should be empty");
        assertTrue(TicketBooker.bookedTicketList.isEmpty(), "Initial bookedTicketList should be empty");

        // Check the initial positions in the classes
        assertEquals(Collections.singletonList(1), TicketBooker.FirstClassPossitions, "Initial FirstClassPositions should contain 1");
        assertEquals(Collections.singletonList(1), TicketBooker.SecondClassPositions, "Initial SecondClassPositions should contain 1");
        assertEquals(Collections.singletonList(1), TicketBooker.ThirdClassPositions, "Initial ThirdClassPositions should contain 1");
        assertEquals(Collections.singletonList(1), TicketBooker.racPositions, "Initial racPositions should contain 1");
        assertEquals(Collections.singletonList(1), TicketBooker.waitingListPositions, "Initial waitingListPositions should contain 1");

        // Check the initial state of the passengers map
        assertTrue(TicketBooker.passengers.isEmpty(), "Initial passengers map should be empty");
	}

}
