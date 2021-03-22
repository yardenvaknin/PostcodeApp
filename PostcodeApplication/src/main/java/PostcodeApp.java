
import org.json.*;

public class PostcodeApp {

    private GetRequestHandler handlerGetReq;
    private ResultsHandler resultsHandler;
    private String requestName;

    public PostcodeApp(Postcode p,String requestName){
        this.requestName = requestName;
        handlerGetReq = new GetRequestHandler(p,requestName);
        JSONObject obj = handlerGetReq.sendGetRequest(handlerGetReq.getRequestName());
        if (obj != null) {
            resultsHandler = new ResultsHandler(obj);
        }
    }

    public void runApp(){
            if(resultsHandler != null) {
                resultsHandler.printResult(this.requestName);
            }
        }

    public static void main(String[] args) {

        if (args.length > 0){
            Postcode p = new Postcode(args[0]);
            Validation v = new Validation();
            if (! v.isValidPostcode(p)) {
                System.out.println("ERROR!!!, the postcode is not a valid UK postcode!");
            }
            else {
                PostcodeApp p1 = new PostcodeApp(p, "LookupPostcode");
                p1.runApp();

                PostcodeApp p2 = new PostcodeApp(p,"ValidatePostcode");
                p2.runApp();

                PostcodeApp p3 = new PostcodeApp(p,"NearestPostcodes");
                p3.runApp();
                }
        }
        else {
            System.out.println("There is no postcode argument!");
        }
    }
}
