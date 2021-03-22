import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

    public boolean isValidPostcode(Postcode p){
        String regex = "^[A-Z]{1,2}[0-9R][0-9A-Z]? [0-9][ABD-HJLNP-UW-Z]{2}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(p.getPostcode());
        return matcher.matches();
    }
}
