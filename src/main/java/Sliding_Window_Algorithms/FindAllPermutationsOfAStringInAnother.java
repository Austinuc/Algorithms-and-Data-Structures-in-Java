package Sliding_Window_Algorithms;

import java.util.*;

public class FindAllPermutationsOfAStringInAnother {

    /**
     * Given a smaller strings and a bigger string b, design an algorithm to find all permutations
     * of the shorter string within the longer one.Print the location of each permutation.
     *
     * @param s: shorter string
     * @param b: longer string
     * @return: number of permutations found
     */
    public static int solution(String s, String b) {
        int count = 0;
        Map<Character, Integer> ms = new HashMap<>();
        Map<Character, Integer> mb = new HashMap<>();

        copyCharsOfStringToMap(ms,s);

        for (int i = 0,j=0; i < b.length(); i++) {
            copyCharsOfStringToMap(mb, b.substring(i,i+1));

            /*
             * If the char is not in s, no permutation of s can exist in the interval of the odd char
             * e.g. given s = "abbc" and b = "cbaba'd'cbbabb";
             */

            if (!ms.containsKey(b.charAt(i))) {
                j = i + 1; //skip window to the next char after the odd character
                mb.clear();
                continue;
            }
            if (i - j == s.length()-1) {
                if (ms.equals(mb)) { //Compare sliding window to the search string
                    count++;
                }
                if (mb.get(b.charAt(j)) > 1) { //remove one char at the end of the sliding window
                    mb.replace(b.charAt(j),mb.get(b.charAt(j))-1);
                } else {
                    mb.remove(b.charAt(j));
                }
                j++;
            }
        }

        return count;
    }

    public static void copyCharsOfStringToMap(Map<Character, Integer> map, String s) {

        for (int i = 0; i<s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.replace(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }

    }

    public static void main(String[] args) {

        System.out.println(solution("abbc","cbabadcbbabbcbabaabccbabc"));
    }
}
