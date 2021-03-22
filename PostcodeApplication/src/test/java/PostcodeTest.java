import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PostcodeTest {

    Postcode p1 = new Postcode("CB3 0FA");
    Postcode p2 = new Postcode("PO16 7GZ");

    @Test
    void getPostcode() {
        assertEquals("CB3 0FA",p1.getPostcode());
        assertEquals("PO16 7GZ",p2.getPostcode());
    }

    @Test
    void replaceSpacesInPostcode() {
        assertEquals("CB3%200FA",p1.replaceSpacesInPostcode());
        assertEquals("PO16%207GZ",p2.replaceSpacesInPostcode());
    }
}