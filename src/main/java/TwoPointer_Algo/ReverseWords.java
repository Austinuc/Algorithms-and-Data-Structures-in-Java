package TwoPointer_Algo;

/**
 * Given a sentence, reverse the order of its words without affecting the order of letters within a given word.
 */
public class ReverseWords {

    public static String reverseWords(String sentence) {
        sentence = sentence.trim();

        StringBuilder revWord = new StringBuilder();
        int start = sentence.length() - 1, end = sentence.length() - 1;

        while (start >= 0) {
            if (sentence.charAt(start) == ' ' || start == 0) {
                if (start != 0) {
                    revWord.append(sentence, start + 1, end+1);
                    revWord.append(" ");
                }
                else revWord.append(sentence, start, end+1);

                while(start > 0 && sentence.charAt(--start) == ' ');
                end = start;
            }
            start--;
        }

        return revWord.toString().trim();
    }
}
