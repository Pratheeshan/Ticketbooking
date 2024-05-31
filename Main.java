import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		boolean loop = true;
		// loop to get choices from user until he stops
		while (loop) {
			System.out.println(
					" 1. Book Ticket \n 2. Cancel Ticket \n 3. Available Tickets \n 4. Booked Tickets \n 5. Exit");
			int choice = s.nextInt();
			switch (choice) {
			// book ticket
			case 1: {
				// get details from Passenger
				System.out.println("Enter Passenger name,age and Class preference (1,2 or 3)");
				String name = s.next();
				int age = s.nextInt();
				// get berth preference (L,U,M)
				String classPreferenceInput = s.next();

				ClassPreference classPreference = ClassPreference.fromString(classPreferenceInput);
				// create a passenger object
				Passenger passenger = new Passenger(name, age, classPreference);
				// booking
				TicketBookingHandler ticketBookingHandler = new TicketBookingHandler();
				ticketBookingHandler.bookTicket(passenger);
			}
				break;
			// cancel ticket
			case 2: {
				// get passenger id to cancel
				System.out.println("Enter passenger Id to cancel");
				int id = s.nextInt();
				TicketCancellationHandler ticketCancellationHandler = new TicketCancellationHandler();
				ticketCancellationHandler.cancelTicket(id);
			}
				break;
			// available tickets print
			case 3: {
				TicketBooker booker = new TicketBooker();
				booker.printAvailable();
			}
				break;
			// occupied tickets print
			case 4: {
				TicketBooker booker = new TicketBooker();
				booker.printPassengers();
			}
				break;
			// exit
			case 5: {
				loop = false;
			}
				break;
			default:
				break;
			}
		}
	}
}
