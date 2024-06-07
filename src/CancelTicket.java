import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CancelTicket {
	static Map<Integer, Passenger> passengers;
	static List<Integer> bookedTicketList ;
	static int available1stClass;
	static int available2ndClass;
	static int available3rdClass;
	static List<Integer> FirstClassPossitions;
	static List<Integer> SecondClassPositions;
	static List<Integer> ThirdClassPositions;
	static Queue<Integer> racList;
	static Queue<Integer> waitingList;
	static List<Integer> racPositions;
	static List<Integer> waitingListPositions;
	static int availableRacTickets;// normally 18
	static int availableWaitingList;
	
	public CancelTicket(Map<Integer, Passenger> passengers, List<Integer> bookedTicketList, int available1stClass,
			int available2ndClass, int available3rdClass, List<Integer> FirstClassPossitions,
			List<Integer> SecondClassPositions,
			List<Integer> ThirdClassPositions,
			Queue<Integer> racList,
			Queue<Integer> waitingList,
			List<Integer> racPositions,
			List<Integer> waitingListPositions,
			int availableRacTickets,
			int availableWaitingList) {
		this.passengers = passengers;
		this.bookedTicketList = bookedTicketList;
		this.available1stClass = available1stClass;
		this.available2ndClass = available2ndClass;
		this.available3rdClass = available3rdClass;
		this.FirstClassPossitions = FirstClassPossitions;
		this.SecondClassPositions = SecondClassPositions;
		this.ThirdClassPositions = ThirdClassPositions;
		this.racList = racList;
		this.waitingList = waitingList;
		this.racPositions = racPositions;
		this.waitingListPositions = waitingListPositions;
		this.availableRacTickets = availableRacTickets;
		this.availableWaitingList = availableWaitingList;
	}
	
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
			
			//passenger.update(" Status updated" + passenger.number + passenger.alloted);
		}

	}

}
