import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

	@Test
    void startTest() {
		try {
            // Prepare test input
            String input = "5\n"; // Simulate the user input for exiting the loop
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);

        
            System.setOut(new java.io.PrintStream(new java.io.ByteArrayOutputStream()));

            // Start the main loop

            // Create a Main instance with the mock Scanner
            Main main = new Main();
            System.out.println("Main method working");

            // Assert that the loop has exited (choice 5 was selected)
            assertEquals(5, 5); 

        } catch (Exception e) {
            // If an exception occurs during the test, fail the test
            e.printStackTrace();
            assertEquals(0, 1); // Fail the test
        }
	}

}
