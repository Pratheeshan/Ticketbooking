import java.util.*;

public class CancelTicket {

    public void cancelTicket(int passengerId) {
        // Remove the passenger from the map and booked tickets list
        Passenger passenger = TicketBooker.passengers.remove(passengerId);
        TicketBooker.bookedTicketList.remove(Integer.valueOf(passengerId));
        int positionBooked = passenger.getNumber();

        System.out.println("---------------cancelled Successfully");

        // Add the freed position back to the corresponding class
        switch (passenger.getAlloted()) {
            case "FIRST":
            	if (TicketBooker.availableRacTickets == 1 && TicketBooker.availableWaitingList == 1) {
            		TicketBooker.available1stClass++;
                    TicketBooker.FirstClassPossitions.add(positionBooked);
            	}
                
                break;
            case "SECOND":
            	if (TicketBooker.availableRacTickets == 1 && TicketBooker.availableWaitingList == 1) {
            		 TicketBooker.available2ndClass++;
                     TicketBooker.SecondClassPositions.add(positionBooked);
            	}
               
                break;
            case "THIRD":
            	if (TicketBooker.availableRacTickets == 1 && TicketBooker.availableWaitingList == 1) {
            		 TicketBooker.available3rdClass++;
                     TicketBooker.ThirdClassPositions.add(positionBooked);
            	}
               
                break;
        }

        // If RAC list is not empty, move the first RAC passenger to the freed position
        if (!TicketBooker.racList.isEmpty()) {
            int racPassengerId = TicketBooker.racList.poll();
            Passenger passengerFromRAC = TicketBooker.passengers.get(racPassengerId);
            passengerFromRAC.setNumber(positionBooked);
            passengerFromRAC.setAlloted(passenger.getAlloted());

            // Free the RAC position and update counts
            int racPosition = passengerFromRAC.getNumber();
            TicketBooker.racPositions.add(racPosition);
            TicketBooker.availableRacTickets++;

            // If waiting list is not empty, move the first waiting list passenger to RAC
            if (!TicketBooker.waitingList.isEmpty()) {
                int wlPassengerId = TicketBooker.waitingList.poll();
                Passenger passengerFromWaitingList = TicketBooker.passengers.get(wlPassengerId);
                passengerFromWaitingList.setNumber(TicketBooker.racPositions.remove(0));
                passengerFromWaitingList.setAlloted("RAC");
                TicketBooker.racList.add(wlPassengerId);
                TicketBooker.availableWaitingList++;
                TicketBooker.availableRacTickets--;
            }
        }
    }
}
