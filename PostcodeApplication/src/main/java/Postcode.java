import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Postcode
{
    private String postcode;

    public Postcode(String postCode){
        this.postcode = postCode;
    }

    public String getPostcode(){
        return postcode;
    }


    public String replaceSpacesInPostcode(){
        return postcode.replaceAll(" ", "%20");
    }
}
