import static org.junit.Assert.*;

import org.junit.Test;

public class ReflectionUtilsTest {

    @Test
    public void testPrintClassDetails() {

        System.out.println("CancelTicket details:");
        ReflectionUtils.printClassDetails(CancelTicket.class);
        
        System.out.println("--------------------");
        
        System.out.println("Ticketbooker details:");
        ReflectionUtils.printClassDetails(TicketBooker.class);
    }

    @Test
    public void testInvokeStaticMethod() {
        try {
            Passenger passenger = new Passenger("Jane Doe", 28, ClassPreference.SECOND);

            // Test bookTicket method in TicketBookingHandler class
            ReflectionUtils.invokeStaticMethod(
                TicketBookingHandler.class,
                "bookTicket",
                new Class<?>[]{Passenger.class},
                new Object[]{passenger}
            );

            // If no exception is thrown, the method invocation is successful
            assertNotNull(passenger);

        } catch (Exception e) {
            fail("Method invocation failed: " + e.getMessage());
        }
    }
}
