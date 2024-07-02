import java.util.Map;

public class BookedTickets {
	public void printPassengers(Map<Integer, Passenger> passengers) {
	    if (passengers.isEmpty()) {
	        System.out.println("No details of passengers");
	        return;
	    }
	    passengers.values().stream()
	              .map(passenger -> String.format("PASSENGER ID %d\n Name %s\n Age %d\n Status %d%s\n--------------------------",
	                                               passenger.getPassengerId(),
	                                               passenger.getName(),
	                                               passenger.getAge(),
	                                               passenger.getNumber(),
	                                               passenger.getAlloted()))
	              .forEach(System.out::println);
	}

}
