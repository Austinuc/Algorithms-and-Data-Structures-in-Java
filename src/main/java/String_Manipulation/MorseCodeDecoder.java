package String_Manipulation;

/**
 * Code Challenge from Code Wars
 *
 * A morse code decoder: The Morse code encodes every character as a sequence of "dots" and "dashes".
 * For example, the letter A is coded as ·−, letter Q is coded as −−·−, and digit 1 is coded as ·−−−−.
 *
 * NOTE: a single space is used to separate the character codes and 3 spaces are used to separate words.
 *
 * MorseCodeDecoder.decode(".... . -.--   .--- ..- -.. .")
 * //should return "HEY JUDE"
 */
public class MorseCodeDecoder {
    public static String decode(String morseCode) {
        // From the Morse code table library through MorseCode.get(code)

        morseCode = morseCode.trim(); //remove white spaces at both ends
        String result = "";
        String code = "";

        for (int i = 0; i < morseCode.length(); i++) {
            if (morseCode.charAt(i) == ' ') { //check for character separator
                if (morseCode.charAt(i+1) == ' ') { //check for word separator
                /** result += MorseCode.get(code) + " "; */ //uncomment this line
                    code = "";
                    i += 2;

                } else {
                    /**result += (MorseCode.get(code)); *///uncomment this line
                    code = "";
                }

            } else {
                code += String.valueOf(morseCode.charAt(i));
            }
        }
       /** result += MorseCode.get(code); */ //uncomment this line
        return result;
    }
}
