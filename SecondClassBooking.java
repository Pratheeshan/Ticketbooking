
public class SecondClassBooking implements BookingStrategy {

	@Override
	public void book(Passenger p, TicketBooker booker) {
		System.out.println("2nd Class Given");
		// call booking function in the TicketBooker class
		booker.bookTicket(p, (TicketBooker.SecondClassPositions.get(0)), ".Class2");
		// remove the booked position from available positions and also decrease
		// available seats of that
		// particular type
		TicketBooker.SecondClassPositions.remove(0);
		TicketBooker.available2ndClass--;

	}

}
