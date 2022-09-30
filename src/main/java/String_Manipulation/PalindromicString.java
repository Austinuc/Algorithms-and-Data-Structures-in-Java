package String_Manipulation;

/**
 * CASE: Given a string , print Yes if it is a palindrome, print No otherwise.
 * NB: input string will always be in lowercase
 *
 * Return: true if palindrome. false otherwise.
 */

public class PalindromicString {

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
}
