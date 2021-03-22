import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GetRequestHandler {

    private final Postcode postcode;
    private final String postcodeUrl;
    private final String validateUrl;
    private final String nearestUrl;
    private final String apiUrl = "https://api.postcodes.io/postcodes/";
    private final String requestName;

    public GetRequestHandler(Postcode postcode,String requestName){
        this.postcode = postcode;
        this.requestName = requestName;
        this.postcodeUrl = apiUrl + postcode.replaceSpacesInPostcode() ;
        this.validateUrl = apiUrl +  postcode.replaceSpacesInPostcode() + "/validate";
        this.nearestUrl = apiUrl +  postcode.replaceSpacesInPostcode()+ "/nearest";
    }
    public String getRequestName(){
        return this.requestName;
    }

   public String getUriValByRequestName(String requestName){
       switch (requestName) {
           case "LookupPostcode" ->   {return postcodeUrl;}
           case "ValidatePostcode" -> {return validateUrl;}
           case "NearestPostcodes" -> {return nearestUrl;}
           default -> {
               System.out.println("Request message is invalid!!!!!");
               return "";
           }
       }
   }

   public void printRequest(String uri){
       if (!uri.isEmpty()) {
           System.out.println("------------------------------------------------------------");
           System.out.println("Get Request:\n" + uri);
       }
   }

   public JSONObject getReq(String uri){
       if (!uri.isEmpty()){
           try {
               HttpClient client = HttpClient.newHttpClient();
               HttpRequest request = HttpRequest.newBuilder()
                       .uri(URI.create(uri))
                       .build();

               HttpResponse<String> response =
                       client.send(request, HttpResponse.BodyHandlers.ofString());

               String res = response.body();
               return new JSONObject(res);
           }
           catch(Exception e){
               System.out.println(e.toString());
           }
       }
       return null;
   }

   public JSONObject sendGetRequest(String requestName){
        String uri = getUriValByRequestName(requestName);
        printRequest(uri);
        return getReq(uri);

    }
}
