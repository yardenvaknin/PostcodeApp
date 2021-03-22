import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidationTest {
    Validation v1 = new Validation();
    Validation v2 = new Validation();
    Validation v3 = new Validation();

    @Test
    void isValidPostcode() {
        assertTrue(v1.isValidPostcode(new Postcode("CB3 0FA")));
        assertTrue(v2.isValidPostcode(new Postcode("PO16 7GZ")));
        assertFalse(v3.isValidPostcode(new Postcode("f kdn2")));
    }
}