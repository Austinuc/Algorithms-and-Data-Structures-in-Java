package BST.binary_search_problems;

public class SwapAdjacentLRString {

    /**
     * In a string composed of 'L', 'R', and 'X' characters, like "RXXLRXRXL",
     * a move consists of either replacing one occurrence of "XL" with "LX",
     * or replacing one occurrence of "RX" with "XR". Given the starting string start and the ending string end,
     * return True if and only if there exists a sequence of moves to transform one string to the other.
     *
     * @param start
     * @param end
     * @return
     */
    public boolean canTransform(String start, String end) {
        if (start.length() != end.length()) return false;


        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) != end.charAt(i)) {
                if (i == start.length() - 1) return false;
                else {
                    if (start.substring(i, i+2).equals(new StringBuilder(end.substring(i, i+2)).reverse().toString())) i++;
                    else return false;
                }
            }
        }

        return true;
    }
}
