public class Passenger implements BookingObserver{
	
	static int id = 1;// static variable to give id for every new passenger
	String name;
	int age;
	ClassPreference classPreference;// 1,2,3
	int passengerId;// id of passenger created automatically
	String alloted;// alloted type 1,2,3,rac,wl
	int number;// seat number

	public Passenger(String name, int age, ClassPreference classPreference) {
		this.name = name;
		this.age = age;
		this.classPreference = classPreference;
		this.passengerId = id++;
		alloted = "";
		number = -1;
	}
	
	@Override
    public void update(String message) {
        System.out.println(name + " received notification: " + message);
    }
}
