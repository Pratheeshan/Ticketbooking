
public class ThirdClassBooking implements BookingStrategy {

	@Override
	public void book(Passenger p, TicketBooker booker) {
		System.out.println("3rd Class Given");
		// call booking function in the TicketBooker class
		booker.bookTicket(p, (TicketBooker.ThirdClassPositions.get(0)), ".Class3");
		// remove the booked position from available positions and also decrease
		// available seats of that
		// particular type
		TicketBooker.ThirdClassPositions.remove(0);
		TicketBooker.available3rdClass--;
		
	}

}
