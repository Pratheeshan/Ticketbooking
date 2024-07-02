public class Passenger implements BookingObserver{
	
	private static int id = 1;// static variable to give id for every new passenger
	private final String name;
	private final int age;
	private ClassPreference classPreference;// 1,2,3
	private final int passengerId;// id of passenger created automatically
	private String alloted;// alloted type 1,2,3,rac,wl
	private int number;// seat number

	public Passenger(String name, int age, ClassPreference classPreference) {
		this.name = name;
		this.age = age;
		this.setClassPreference(classPreference);
		this.passengerId = id++;
		setAlloted("");
		setNumber(-1);
	}
	
	@Override
    public void update(String message) {
        System.out.println(name + " received notification: " + message);
    }
	//Reflectiontest to get passenger id
	public int getPassengerId() {
        return passengerId;
    }

	public ClassPreference getClassPreference() {
		return classPreference;
	}

	public void setClassPreference(ClassPreference classPreference) {
		this.classPreference = classPreference;
	}

	public int getAge() {
		return age;
	}

	public String getAlloted() {
		return alloted;
	}

	public void setAlloted(String alloted) {
		this.alloted = alloted;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	public String getName() {
		return name;
	}
	
	
}
