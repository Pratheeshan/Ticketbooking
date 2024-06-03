import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		boolean loop = true;
		// loop to get choices from user until he stops
		while (loop) {
			System.out.println(
					" 1. Book Ticket \n 2. Cancel Ticket \n 3. Available Tickets \n 4. Booked Tickets \n 5. Exit");
			int choice = userInput.nextInt();
			switch (choice) {
			// book ticket
			case 1: {
				UserInputHandler userInputHandler = new UserInputHandler(userInput);
				
				userInputHandler.handleUserInput();
				Passenger passenger = userInputHandler.getUserDetails();

				// booking
				TicketBookingHandler ticketBookingHandler = new TicketBookingHandler();
				ticketBookingHandler.bookTicket(passenger);
			}
				break;
			// cancel ticket
			case 2: {
				// get passenger id to cancel
				System.out.println("Enter passenger Id to cancel");
				int id = userInput.nextInt();
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
