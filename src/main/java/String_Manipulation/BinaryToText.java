package String_Manipulation;

/**
 * takes in a binary string and returns the equivalent decoded text (the text is ASCII encoded).
 */
public class BinaryToText {

    public static String binaryToText(String binary) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < binary.length(); i = i + 8) {
            int a = Integer.valueOf(binary.substring(i,i+8),2);
            s.append((char) a);
        }
        return s.toString();
    }
}
