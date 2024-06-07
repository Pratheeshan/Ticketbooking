
public class FirstClassBooking implements BookingStrategy {

	@Override
	public void book(Passenger passenger) {
		System.out.println("1st Class Given");
		// call booking function in the TicketBooker class
		TicketBookingService ticketBookingService = new TicketBooker();
		ticketBookingService.bookTicket(passenger, (TicketBooker.FirstClassPossitions.get(0)), ".Class1");
		// remove the booked position from available positions and also decrease
		// available seats of that
		// particular type
		TicketBooker.FirstClassPossitions.remove(0);
		TicketBooker.available1stClass--;
		
		passenger.update("First class ticket has been booked");
	}
}
