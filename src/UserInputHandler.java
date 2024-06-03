import java.util.Scanner;

public class UserInputHandler {
	private String name;
	private int age;
	private ClassPreference classPreference;
	private Scanner userInput;
	
	public UserInputHandler (Scanner userInput) {
		this.userInput = userInput;
	}

	public void handleUserInput() {
		// get details from Passenger
		System.out.println("Enter Passenger name,age and Class preference (1,2 or 3)");
		name = userInput.next();
		age = userInput.nextInt();
		// get berth preference (L,U,M)
		String classPreferenceInput = userInput.next();

		classPreference = ClassPreference.fromString(classPreferenceInput);
	}

	public Passenger getUserDetails() {
		Passenger passenger = new Passenger(name, age, classPreference);
		return passenger;
	}
}
