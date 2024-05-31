
public class FirstClassBooking implements BookingStrategy {
	public void book(Passenger p, TicketBooker booker) {
		System.out.println("1st Class Given");
		// call booking function in the TicketBooker class
		booker.bookTicket(p, (TicketBooker.FirstClassPossitions.get(0)), ".Class1");
		// remove the booked position from available positions and also decrease
		// available seats of that
		// particular type
		TicketBooker.FirstClassPossitions.remove(0);
		TicketBooker.available1stClass--;
	}
}
