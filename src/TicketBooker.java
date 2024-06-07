import java.util.*;

public class TicketBooker implements TicketBookingService {
	static int available1stClass = 1;
	static int available2ndClass = 1;
	static int available3rdClass = 1;
	static int availableRacTickets = 1;
	static int availableWaitingList = 1;

	static Queue<Integer> waitingList = new LinkedList<>();// queue of WL passengers
	static Queue<Integer> racList = new LinkedList<>();// queu of RAC passengers
	static List<Integer> bookedTicketList = new ArrayList<>();// list of bookedticket passengers

	static List<Integer> FirstClassPossitions = new ArrayList<>(Arrays.asList(1));
	static List<Integer> SecondClassPositions = new ArrayList<>(Arrays.asList(1));
	static List<Integer> ThirdClassPositions = new ArrayList<>(Arrays.asList(1));
	static List<Integer> racPositions = new ArrayList<>(Arrays.asList(1));
	static List<Integer> waitingListPositions = new ArrayList<>(Arrays.asList(1));	

	static Map<Integer, Passenger> passengers = new HashMap<>();// map of passenger ids to passengers

	// book ticket
	public void bookTicket(Passenger p, int classInfo, String allotedClass) {
		// assign the seat number and type of berth(L,U,M)
		p.number = classInfo;
		p.alloted = allotedClass;
		// add passenger to the map
		passengers.put(p.passengerId, p);
		// add passenger id to the list of booked tickets
		bookedTicketList.add(p.passengerId);
		System.out.println("--------------------------Booked Successfully");
	}

	// adding to RAC
	public void addToRAC(Passenger p, int racInfo, String allotedRAC) {
		// assign seat number and type(RAC)
		p.number = racInfo;
		p.alloted = allotedRAC;
		// add passenger to the map
		passengers.put(p.passengerId, p);
		// add passenger id to the queue of RAC tickets
		racList.add(p.passengerId);
		// decrease available RAC tickets by 1
		availableRacTickets--;
		// remove the position that was alloted to the passenger
		racPositions.remove(0);

		System.out.println("--------------------------added to RAC Successfully");
	}

	// adding to WL
	public void addToWaitingList(Passenger p, int waitingListInfo, String allotedWL) {
		// assign seat number and type(WL)
		p.number = waitingListInfo;
		p.alloted = allotedWL;
		// add passenger to the map
		passengers.put(p.passengerId, p);
		// add passenger id to the queue of WL tickets
		waitingList.add(p.passengerId);
		// decrease available WL tickets by 1
		availableWaitingList--;
		// remove the position that was alloted to the passenger
		waitingListPositions.remove(0);

		System.out.println("-------------------------- added to Waiting List Successfully");
	}

	//Cancel ticket
	public void cancelTicket(int passengerId) {
		CancelTicket cancelTicket = new CancelTicket(passengers, bookedTicketList, available1stClass, available2ndClass,
				available3rdClass, FirstClassPossitions, SecondClassPositions, ThirdClassPositions, racList,
				waitingList, racPositions, waitingListPositions, availableRacTickets, availableWaitingList);
		cancelTicket.cancelTicket(passengerId);
	}

	// print all available seats
	public void printAvailable() {
		AvailableTickets availableTickets = new AvailableTickets();
		availableTickets.printAvailable(available1stClass, available2ndClass, available3rdClass, availableRacTickets,
				availableWaitingList);
	}

	// print all occupied passengers from all types including WL
	public void printPassengers() {
		BookedTickets bookedTickets = new BookedTickets();
		bookedTickets.printPassengers(passengers);
	}

}
