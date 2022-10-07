package Regular_Expressions;
import java.io.*;
import java.util.regex.*;

public class RegexTestHarness {

    public static void main(String[] args) {
        Console console = System.console();
        if (console == null) {
            System.err.println("No console!");
            System.exit(1);
        }
        while (true) {
            Pattern pattern = Pattern.compile(console.readLine("%nEnter your regex: "));
            Matcher matcher = pattern.matcher(console.readLine("Enter input string to search: "));
            boolean found = false;

            while (matcher.find()) {
                console.format("%nWe found [%s] starting at" +
                        "index [%d] to index [%d]%n",
                        matcher.group(),
                        matcher.start(),
                        matcher.end()
                        );
                found = true;
            }
            if (!found) {
                console.format("No match found%n");
            }
        }


    }
}
