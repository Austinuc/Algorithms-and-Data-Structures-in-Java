package String_Manipulation;

/**
 * CASE: Replaces the missing character in a string of odd number of characters with an underscore (_)
 *
 * Return: array of strings
 */
public class SplitStrings {
    public static String[] splitStrings(String s) {
        String[] arr = s.length() % 2 == 0 ? new String[s.length()/2] : new String[s.length()/2 + 1];

        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (s.length() % 2 != 0 && i == arr.length - 1) {
                arr[i] = s.charAt(j) + "_";
                break;
            }
            arr[i] = s.substring(j, j+2);
            j +=2;
        }

        return arr;
    }
}
