import java.util.Map;

public class BookedTickets {
	public void printPassengers(Map<Integer, Passenger> passengers) {
		if (passengers.size() == 0) {
			System.out.println("No details of passengers");
			return;
		}
		for (Passenger passenger : passengers.values()) {
			System.out.println("PASSENGER ID " + passenger.passengerId);
			System.out.println(" Name " + passenger.name);
			System.out.println(" Age " + passenger.age);
			System.out.println(" Status " + passenger.number + passenger.alloted);
			System.out.println("--------------------------");
		}
	}

}
