package String_Manipulation;


import java.util.List;

public class PalindromicString {

    /**
     * CASE: Given a string , print Yes if it is a palindrome, print No otherwise.
     * NB: input string will always be in lowercase
     *
     * Return: true if palindrome. false otherwise.
     */
    public static boolean stringIsAPalindrome(String A) {

        int j = A.length() - 1;
        for (int i = 0; i <= j; i++, j--) {
            if (A.charAt(i) != A.charAt(j)) {
                System.out.println("No");
                return false;
            }

        }
        System.out.println("Yes");
        return true;

    }

    /**
     * Write a function that takes a string as input and checks
     * whether it can be a valid palindrome by removing at most one character from it.
     *
     */

    public static boolean isPalindrome(String s) {
        int start = 0, end = s.length()-1, count = 0;

        while(start <= end) {

            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else if (s.charAt(start) != s.charAt(end)) {
                count++;
                if (count > 1) return false;
                if (s.charAt(start+1) == s.charAt(end)) start++;
                else end--;
            }
        }

        return true;
    }

    /** 3   A function receives a string s amd a series of queries. for each query, there will be a beginning and
    ending index and number of substitutions. A palindrome is a string spelled the same way forward or backward, like a,
    mom or abba. for each substring represented by the beginning and ending index of the string s, determine if it
    is possible to rearrange it to a palindrome after performing up to the given number of substitutions.
    start with an empty result string. After each query, append a 1 or 0 to indicate whether the substring can be
    converted to a palindrome. A 1 represents yes and a 0 represents no. return the results string after all queries
    have been processed.
    Example
    s = cdecd
    startIndex = [0,0,0,0]
    endindex = [0,1,2,3]
    subs = [0,1,1,0]
    */

    public static String isPil(String s, List<Integer> startIndex, List<Integer> endIndex, List<Integer> subs) {
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < startIndex.size(); i++) {
            ans.append(isPalindrome(s.substring(startIndex.get(i), endIndex.get(i)+1), subs.get(i)) ? "1" : "0");
        }

        return ans.toString();

    }

    public static boolean isPalindrome(String s, int num) {
        int start = 0, end = s.length()-1, count = 0;

        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                if (count >= num) return false;
                count++;
            }
            start++;
            end--;
        }

        return true;
    }
}
