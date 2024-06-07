import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

class UserInputHandlerTest {


	@Test
	void testHandleUserInput() {
		 // Simulate user input
        String input = "John\n30\n1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);

        // Create a UserInputHandler instance with the simulated input
        UserInputHandler userInputHandler = new UserInputHandler(scanner);

        // Handle user input
        userInputHandler.handleUserInput();

        // Get user details and verify the values
        Passenger passenger = userInputHandler.getUserDetails();
        assertEquals("John", passenger.name);
        assertEquals(30, passenger.age);
        assertEquals(ClassPreference.FIRST, passenger.classPreference);
	}

}
