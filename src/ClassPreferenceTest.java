import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ClassPreferenceTest {

	@Test
    void testFromStringValidValues() {
        assertEquals(ClassPreference.FIRST, ClassPreference.fromString("1"), "Should return FIRST for input '1'");
        assertEquals(ClassPreference.SECOND, ClassPreference.fromString("2"), "Should return SECOND for input '2'");
        assertEquals(ClassPreference.THIRD, ClassPreference.fromString("3"), "Should return THIRD for input '3'");
    }

    @Test
    void testFromStringInvalidValue() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ClassPreference.fromString("4");
        });
        assertEquals("Invalid class preference: 4", exception.getMessage());
    }

    @Test
    void testFromStringNullValue() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ClassPreference.fromString(null);
        });
        assertEquals("Invalid class preference: null", exception.getMessage());
    }

    @Test
    void testFromStringEmptyValue() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ClassPreference.fromString("");
        });
        assertEquals("Invalid class preference: ", exception.getMessage());
    }

}
