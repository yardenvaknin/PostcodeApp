import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


class GetRequestHandlerTest {
    Postcode p = new Postcode("CB3 FA");
    GetRequestHandler req1 = new GetRequestHandler(p,"LookupPostcode");
    GetRequestHandler req2 = new GetRequestHandler(p,"");

    @Test
    void getRequestName() {
        assertEquals("LookupPostcode",req1.getRequestName());
    }

    @Test
    void sendGetRequest() {
        assertNull(req2.sendGetRequest(req2.getRequestName()));
    }
}