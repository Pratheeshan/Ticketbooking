import java.util.Arrays;

public enum ClassPreference {
	FIRST("1"), SECOND("2"), THIRD("3");

	private final String value;

	ClassPreference(String value) {
		this.value = value;
	}

	public static ClassPreference fromString(String value) {
	    return Arrays.stream(ClassPreference.values())
	                 .filter(preference -> preference.value.equals(value))
	                 .findFirst()
	                 .orElseThrow(() -> new IllegalArgumentException("Invalid class preference: " + value));
	}
	}
