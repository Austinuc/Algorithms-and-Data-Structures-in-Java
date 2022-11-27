package Regular_Expressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ValidDateFormat {

    Pattern pattern;

    public ValidDateFormat(String regex) {
        pattern = Pattern.compile(regex);
    }

    public Matcher match(String text) {
        return pattern.matcher(text);
    }

    public static void main(String[] args) {
        //mm dd yy
        String regex = "[01][012][ \\.-/]([012]\\d|3[01])[ \\.-/]\\d\\d";

        ValidDateFormat validDateFormat = new ValidDateFormat(regex);

        Matcher matcher = validDateFormat.match("12/31/99");

        System.out.println(matcher.find());
    }
}

class LeadingAndTrailingWhiteSpaces {

    Pattern pattern;

    LeadingAndTrailingWhiteSpaces(String regex) {
        pattern = Pattern.compile(regex);
    }

    public Matcher remove(String text) {
        return pattern.matcher(text);
    }

    public static void main(String[] args) {
        String regex = "^[^\\s]+$";

        LeadingAndTrailingWhiteSpaces leadingAndTrailingWhiteSpaces = new LeadingAndTrailingWhiteSpaces(regex);
        Matcher matcher = leadingAndTrailingWhiteSpaces.remove("   Yes, Removed   ");

        System.out.println(matcher.results().collect(Collectors.toList()));
    }
}
