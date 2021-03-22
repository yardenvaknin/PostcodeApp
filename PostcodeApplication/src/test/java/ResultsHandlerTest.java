import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResultsHandlerTest {
    JSONObject obj =
            new JSONObject(
            "{\"status\":200,\"result\":{\"postcode\":\"CB3 0FA\",\"quality\":1,\"eastings\":542975,\"northings\":258918,\"country\":\"England\",\"nhs_ha\":\"East of England\",\"longitude\":0.091115,\"latitude\":52.209953,\"european_electoral_region\":\"Eastern\",\"primary_care_trust\":\"Cambridgeshire\",\"region\":\"East of England\",\"lsoa\":\"Cambridge 007D\",\"msoa\":\"Cambridge 007\",\"incode\":\"0FA\",\"outcode\":\"CB3\",\"parliamentary_constituency\":\"Cambridge\",\"admin_district\":\"Cambridge\",\"parish\":\"Cambridge, unparished area\",\"admin_county\":\"Cambridgeshire\",\"admin_ward\":\"Newnham\",\"ced\":\"Newnham\",\"ccg\":\"NHS Cambridgeshire and Peterborough\",\"nuts\":\"Cambridgeshire CC\",\"codes\":{\"admin_district\":\"E07000008\",\"admin_county\":\"E10000003\",\"admin_ward\":\"E05002710\",\"parish\":\"E43000042\",\"parliamentary_constituency\":\"E14000617\",\"ccg\":\"E38000026\",\"ccg_id\":\"06H\",\"ced\":\"E58000080\",\"nuts\":\"UKH12\",\"lsoa\":\"E01017984\",\"msoa\":\"E02003725\",\"lau2\":\"E05002710\"}}}");
    JSONObject resultKey = obj.getJSONObject("result");

    ResultsHandler resultsHandler = new ResultsHandler(obj);
    @Test
    void getValueByKey() {
        assertEquals("England",resultsHandler.getValueByKey(resultKey,"country"));
        assertEquals("East of England",resultsHandler.getValueByKey(resultKey,"region"));
    }
}