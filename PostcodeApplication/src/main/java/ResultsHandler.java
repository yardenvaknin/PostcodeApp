import org.json.JSONArray;
import org.json.JSONObject;

public class ResultsHandler{

    private final JSONObject result;

    public ResultsHandler(JSONObject result){
        this.result = result;
    }

    public String getValueByKey(JSONObject result,String key) {
        try {
            return result.get(key).toString();
        }
        catch (Exception e){
            System.out.println(e.toString());
            return e.toString();
        }
    }

    public void printResult(String printName){
        switch (printName) {
            case "LookupPostcode" -> printGetPostcodeResult();
            case "ValidatePostcode" -> printPostcodeValidateResult();
            case "NearestPostcodes" -> printPostcodeNearestResult();
            default -> System.out.println("Request message is invalid!!!!!");
        }
    }

    public void printGetPostcodeResult(){
        try {
            JSONObject resultKey = result.getJSONObject("result");
            System.out.println("Result:");
            System.out.println("Country: " + getValueByKey(resultKey,"country") + ", Region: " + getValueByKey(resultKey,"region") + ".");
            System.out.println("------------------------------------------------------------\n");

        }
        catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public void printPostcodeValidateResult(){
        System.out.println("Result:");
        if (result.get("result").toString().equals("false")){
            System.out.println("Postcode invalid.");
        }
        else {
            System.out.println("Postcode valid.");
        }
        System.out.println("------------------------------------------------------------\n");

    }

    public void printPostcodeNearestResult(){
        JSONArray array2 = result.optJSONArray("result");
        if(array2 != null){
            try{
                System.out.println("Result:");
                for (int i = 0; i < array2.length(); i++) {
                    JSONObject obj = array2.getJSONObject(i);
                    System.out.println("Postcode: " + getValueByKey(obj,"postcode") + ", Country: " + getValueByKey(obj,"country") + ", Region: " + getValueByKey(obj,"region")+".");
                }
                System.out.println("------------------------------------------------------------\n");
            }
            catch (Exception e){
                System.out.println(e.toString());
            }
        }
    }

    }


