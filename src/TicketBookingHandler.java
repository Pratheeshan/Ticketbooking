
public class TicketBookingHandler {
	public static void bookTicket(Passenger passenger) {
		TicketBooker booker = new TicketBooker();

		// if no WL is available , means all tickets are filled.. so no tickets
		// available
		if (TicketBooker.availableWaitingList == 0) {
			System.out.println("No Tickets Available");
			return;
		}
		// check if preferred berth is available
		if ((passenger.classPreference.equals(ClassPreference.FIRST) && TicketBooker.available1stClass > 0)
				|| (passenger.classPreference.equals(ClassPreference.SECOND) && TicketBooker.available2ndClass > 0)
				|| (passenger.classPreference.equals(ClassPreference.THIRD) && TicketBooker.available3rdClass > 0)) {
			System.out.println("Preferred Berth Available");
			if (passenger.classPreference.equals(ClassPreference.FIRST)) {
				BookingStrategy bookingStrategy = new FirstClassBooking();
				bookingStrategy.book(passenger);
			}

			else if (passenger.classPreference.equals(ClassPreference.SECOND)) {
				BookingStrategy bookingStrategy = new SecondClassBooking();
				bookingStrategy.book(passenger);
			}

			else if (passenger.classPreference.equals(ClassPreference.THIRD)) {
				BookingStrategy bookingStrategy = new ThirdClassBooking();
				bookingStrategy.book(passenger);
			}

		}
		// preference not available -> book the available berth

		else if (TicketBooker.available1stClass > 0) {
			BookingStrategy bookingStrategy = new FirstClassBooking();
			bookingStrategy.book(passenger);
		} else if (TicketBooker.available2ndClass > 0) {
			BookingStrategy bookingStrategy = new SecondClassBooking();
			bookingStrategy.book(passenger);
		} else if (TicketBooker.available3rdClass > 0) {
			BookingStrategy bookingStrategy = new ThirdClassBooking();
			bookingStrategy.book(passenger);
		} else if (TicketBooker.availableRacTickets > 0) {
			System.out.println("RAC available");
			booker.addToRAC(passenger, (TicketBooker.racPositions.get(0)), "RAC");
		}
		// if no RAC available go to WL
		else if (TicketBooker.availableWaitingList > 0) {
			System.out.println("Added to Waiting List");
			booker.addToWaitingList(passenger, (TicketBooker.waitingListPositions.get(0)), "WL");

		}

	}

}
