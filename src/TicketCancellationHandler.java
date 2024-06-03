
public class TicketCancellationHandler {
	public static void cancelTicket(int id) {
		TicketBooker booker = new TicketBooker();
		// check if passenger id is valid
		if (!booker.passengers.containsKey(id)) {
			System.out.println("Passenger detail Unknown");
		} else
			booker.cancelTicket(id);
	}

}
