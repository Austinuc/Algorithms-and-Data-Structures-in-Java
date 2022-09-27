package StringManipulation;

public class GetSmallestAndLargest {
    public static String getSmallestAndLargest(String s, int k) {

        String smallest = "";
        String largest = "";
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'
        smallest = s;
        for (int i = 0; i <= s.length() - k; i++) {
            if (s.substring(i, i + k).compareTo(largest) >= 0) {
                largest = s.substring(i, i + k);

            } else if (s.substring(i, i + k).compareTo(smallest) < 0) {
                smallest = s.substring(i, i + k);
            }
        }

        return smallest + "\n" + largest;
    }
    public static void main(String[] args) {

        System.out.println(getSmallestAndLargest("welcometojava", 3));
    }
}
