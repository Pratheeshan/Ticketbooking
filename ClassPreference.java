
public enum ClassPreference {
	FIRST("1"), SECOND("2"), THIRD("3");

	private final String value;

	ClassPreference(String value) {
		this.value = value;
	}

	public static ClassPreference fromString(String value) {
		for (ClassPreference preference : ClassPreference.values()) {
			if (preference.value.equals(value)) {
				return preference;
			}
		}
		throw new IllegalArgumentException("Invalid class preference: " + value);
	}
}
