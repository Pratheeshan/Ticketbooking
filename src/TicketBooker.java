import java.util.*;

public class TicketBooker implements TicketBookingService{
	// 63 berths(upper ,lower , middle) + ( 18 RAC passengers)
	// 10 waiting list tickets ->21 L, 21 M, 21U , 18RAC, 10WL
	static int available1stClass = 1;// normally 21
	static int available2ndClass = 1;// normally 21
	static int available3rdClass = 1;// normally 21
	static int availableRacTickets = 1;// normally 18
	static int availableWaitingList = 1;// normally 10

	static Queue<Integer> waitingList = new LinkedList<>();// queue of WL passengers
	static Queue<Integer> racList = new LinkedList<>();// queu of RAC passengers
	static List<Integer> bookedTicketList = new ArrayList<>();// list of bookedticket passengers

	static List<Integer> FirstClassPossitions = new ArrayList<>(Arrays.asList(1));// normally 1,2,...21
	static List<Integer> SecondClassPositions = new ArrayList<>(Arrays.asList(1));// normally 1,2,...21
	static List<Integer> ThirdClassPositions = new ArrayList<>(Arrays.asList(1));// normally 1,2,...21
	static List<Integer> racPositions = new ArrayList<>(Arrays.asList(1));// normally 1,2,...18
	static List<Integer> waitingListPositions = new ArrayList<>(Arrays.asList(1));// normally 1,2,...10

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

	// cancel ticket
	public void cancelTicket(int passengerId) {
		// remove the passenger from the map
		Passenger passenger = passengers.get(passengerId);
		passengers.remove(Integer.valueOf(passengerId));
		// remove the booked ticket from the list
		bookedTicketList.remove(Integer.valueOf(passengerId));

		// take the booked position which is now free
		int positionBooked = passenger.number;

		System.out.println("---------------cancelled Successfully");

		// add the free position to the correspoding type of list (either L,M,U)
		if (passenger.alloted.equals(ClassPreference.FIRST)) {
			available1stClass++;
			FirstClassPossitions.add(positionBooked);
		} else if (passenger.alloted.equals(ClassPreference.SECOND)) {
			available2ndClass++;
			SecondClassPositions.add(positionBooked);
		} else if (passenger.alloted.equals(ClassPreference.THIRD)) {
			available3rdClass++;
			ThirdClassPositions.add(positionBooked);
		}

		// check if any RAC is there
		if (racList.size() > 0) {
			// take passenger from RAC and increase the free space in RAC list and increase
			// available RAC tickets
			Passenger passengerFromRAC = passengers.get(racList.poll());
			int positionRac = passengerFromRAC.number;
			racPositions.add(positionRac);
			racList.remove(Integer.valueOf(passengerFromRAC.passengerId));
			availableRacTickets++;

			// check if any WL is there
			if (waitingList.size() > 0) {
				// take the passenger from WL and add them to RAC , increase the free space in
				// waiting list and
				// increase available WL and decrease available RAC by 1
				Passenger passengerFromWaitingList = passengers.get(waitingList.poll());
				int positionWL = passengerFromWaitingList.number;
				waitingListPositions.add(positionWL);
				waitingList.remove(Integer.valueOf(passengerFromWaitingList.passengerId));

				passengerFromWaitingList.number = racPositions.get(0);
				passengerFromWaitingList.alloted = "RAC";
				racPositions.remove(0);
				racList.add(passengerFromWaitingList.passengerId);

				availableWaitingList++;
				availableRacTickets--;
			}
			// now we have a passenger from RAc to whom we can book a ticket,
			// so book the cancelled ticket to the RAC passenger
			TicketBookingHandler ticketBookingHandler = new TicketBookingHandler();
			ticketBookingHandler.bookTicket(passengerFromRAC);
		}

	}

	// print all available seats
	public void printAvailable() {
		AvailableTickets availableTickets = new AvailableTickets();
		availableTickets.printAvailable(available1stClass, available2ndClass, available3rdClass, availableRacTickets, availableWaitingList);
	}

	// print all occupied passengers from all types including WL
	public void printPassengers() {
		if (passengers.size() == 0) {
			System.out.println("No details of passengers");
			return;
		}
		for (Passenger p : passengers.values()) {
			System.out.println("PASSENGER ID " + p.passengerId);
			System.out.println(" Name " + p.name);
			System.out.println(" Age " + p.age);
			System.out.println(" Status " + p.number + p.alloted);
			System.out.println("--------------------------");
		}
	}
}
